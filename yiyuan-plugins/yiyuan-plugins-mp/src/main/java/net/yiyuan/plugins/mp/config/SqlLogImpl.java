package net.yiyuan.plugins.mp.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.logging.Log;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class SqlLogImpl implements Log {

  private static final String BATCH_D = ";_;";
  private static final int PRE_SQL_LEN = 7;
  private static final int TIME_LEN = 13;
  private static Map<Long, String> sqlMap = new ConcurrentHashMap<>();
  private Boolean openParseSql = true;
  private Map<String, Integer> typeMap =
      new HashMap<String, Integer>() {
        private static final long serialVersionUID = -5772881989251971824L;

        {
          // (String) (Timestamp) (LocalDateTime) (Integer) (BigDecimal) (Float) (Double)
          // (Boolean)(Long)(byte[])(byte)
          put("String", 1);
          put("Timestamp", 1);
          put("LocalDateTime", 1);
          put("BigDecimal", 1);
          put("Integer", 0);
          put("Float", 0);
          put("Double", 0);
          put("Boolean", 0);
          put("Long", 0);
          put("byte[]", 0);
          put("byte", 0);
        }
      };

  public SqlLogImpl(String arg) {}

  private static void printSql(
      long beginTime,
      long execTime,
      long total,
      String table,
      String type,
      String prepareSql,
      String params,
      String realSql) {
    log.info(
        "\n------------------------\nbegin  : {}\nprepare: {}\nparams : {}\nsql    : {}\nexec   : {}ms\ntotal  : {}\ntable  : {}\ntype   : {}\n------------------------\n",
        new Date(beginTime),
        prepareSql,
        params,
        realSql,
        execTime,
        total,
        table,
        type);
  }

  @Override
  public boolean isDebugEnabled() {
    return true;
  }

  @Override
  public boolean isTraceEnabled() {
    return true;
  }

  @Override
  public void error(String s, Throwable e) {
    log.warn(s, e);
  }

  @Override
  public void error(String s) {
    log.warn(s);
  }

  @Override
  public void warn(String s) {
    log.warn(s);
  }

  @Override
  public void trace(String s) {
    if (!openParseSql) {
      log.warn(s);
    }
    Long threadId = Thread.currentThread().getId();
    if (!sqlMap.containsKey(threadId)) {
      return;
    }
    String sql = sqlMap.get(threadId).toLowerCase();
    if (sql.contains(" count(") && !sql.contains("group by")) {
      if (s.substring(11, 14).equals("Row")) {
        dealSql(threadId, "1");
      }
    }
  }

  @Override
  public void debug(String s) {
    if (!openParseSql) {
      log.warn(s);
    }
    String[] sqlArr = StringUtils.split(s, ":", 2);
    Long threadId = Thread.currentThread().getId();
    dealRetentionSql(threadId);
    if (sqlArr.length < 2) {
      log.warn(s);
      return;
    }
    String sqlStep = sqlArr[0];
    // Preparing,Parameters,Total
    String last = sqlStep.substring(sqlStep.length() - 5);
    if ("aring".equals(last)) {
      String saveSql = System.currentTimeMillis() + sqlArr[1].trim();
      if (sqlMap.containsKey(threadId)) {
        // batch update
        dealSql(threadId, "1");
      }
      sqlMap.put(threadId, String.format("%0" + PRE_SQL_LEN + "d", saveSql.length()) + saveSql);
      return;
    }
    if ("eters".equals(last)) {
      if (!sqlMap.containsKey(threadId)) {
        return;
      }
      String sql = sqlMap.get(threadId);
      if (StringUtils.isBlank(sqlArr[1])) {
        return;
      }
      sqlMap.put(threadId, sql + BATCH_D + sqlArr[1]);
      return;
    }
    if ("Total".equals(last) || "dates".equals(last)) {
      if (!sqlMap.containsKey(threadId)) {
        return;
      }
      dealSql(threadId, sqlArr[1]);
      return;
    }
    // 不打印解析多租户的sql
    //    log.warn("sql_not_match:{}", s);
  }

  private void dealRetentionSql(Long threadId) {
    if (sqlMap.size() < 1) {
      return;
    }
    sqlMap.forEach(
        (key, value) -> {
          if (threadId.equals(key)) {
            return;
          }
          dealSql(key, "1");
          return;
        });
  }

  private void dealSql(Long threadId, String rowNum) {
    String sql = sqlMap.get(threadId);
    sqlMap.remove(threadId);
    int sqlLen = Integer.parseInt(sql.substring(0, PRE_SQL_LEN));
    int sqlWithTimeLen = PRE_SQL_LEN + TIME_LEN;
    long time = Long.parseLong(sql.substring(PRE_SQL_LEN, sqlWithTimeLen));
    // select insert update, delete
    String type = sql.substring(sqlWithTimeLen, 26).toLowerCase();
    long pass = System.currentTimeMillis() - time;
    long total = Long.parseLong(rowNum.trim());
    String prepareSql = sql.substring(sqlWithTimeLen, PRE_SQL_LEN + sqlLen);
    String table = parseTable(type, sql);
    int beforeParamLen = PRE_SQL_LEN + BATCH_D.length() + sqlLen;
    if (sql.length() < beforeParamLen) {
      printSql(time, pass, total, table, type, prepareSql, "", "");
      return;
    }
    String params = sql.substring(beforeParamLen);
    int batchIndex = params.indexOf(BATCH_D);
    if (batchIndex == -1) {
      String realSql = parseSql(prepareSql, params);
      printSql(time, pass, total, table, type, prepareSql, params, realSql);
      return;
    }
    String realSql = "";
    total = 0;
    // batch insert
    String batchParams = params;
    while (batchIndex >= 0) {
      String left = batchParams.substring(0, batchIndex);
      batchParams = batchParams.substring(batchIndex + BATCH_D.length());
      batchIndex = batchParams.indexOf(BATCH_D);
      realSql += parseSql(prepareSql, left) + ";";
      if (batchIndex == -1) {
        realSql = realSql + "\n" + parseSql(prepareSql, batchParams) + ";";
        total++;
      }
      total++;
    }
    if (total > 1) {
      // unsure exec time for batch insert
      pass = 1;
    }
    printSql(time, pass, total, table, type, prepareSql, params, realSql);
  }

  private String parseSql(String sql, String params) {
    List<String> paramsArr = parseParams(params);
    int firstCharIndex = sql.indexOf("?");
    if (firstCharIndex == -1) {
      return "";
    }
    List<Integer> sqlIndex = new ArrayList<>();
    sqlIndex.add(firstCharIndex);
    while (true) {
      int nextIndex = sql.indexOf("?", firstCharIndex + 1);
      if (nextIndex == -1) {
        break;
      }
      firstCharIndex = nextIndex;
      sqlIndex.add(firstCharIndex);
    }
    String tmpSql = "";
    int len = sqlIndex.size();
    if (len == paramsArr.size()) {
      for (int i = len - 1; i >= 0; i--) {
        if (tmpSql.length() < 1) {
          tmpSql =
              sql.substring(0, sqlIndex.get(i))
                  + paramsArr.get(i)
                  + sql.substring(sqlIndex.get(i) + 1);
        } else {
          tmpSql =
              tmpSql.substring(0, sqlIndex.get(i))
                  + paramsArr.get(i)
                  + tmpSql.substring(sqlIndex.get(i) + 1);
        }
      }
    } else {
      log.error("parseSql_err:{},{}", sql, params);
    }
    // printSql(tmpSql);
    return tmpSql;
  }

  private List<String> parseParams(String params) {
    List<String> paramsArr = new ArrayList<>();
    int len = params.length();
    char[] val = params.toCharArray();
    int start = 1;
    int nextStart = 1;
    char left = 40;
    char right = 41;
    for (int i = 1; i < len; i++) {
      if (left == val[i]) {
        start = i;
      } else if (right == val[i] && start != 1) {
        String type = params.substring(start + 1, i);
        if (typeMap.containsKey(type)) {
          String data = params.substring(nextStart, start);
          if (typeMap.get(type) == 1) {
            paramsArr.add("'" + data + "'");
          } else {
            paramsArr.add(data);
          }
        } else {
          log.warn("type_not_exist:{},{}", type, params);
        }
        nextStart = i + 3;
        start = 1;
      }
    }
    return paramsArr;
  }

  private String parseTable(String type, String sql) {
    sql = sql.toLowerCase();
    if ("select".equals(type)) {
      String table = "";
      if (sql.contains("`from`")) {
        sql = sql.replace("`from`", "`FROM`");
      }
      int index = sql.indexOf("from");
      String right = sql.substring(index + 4).trim();
      String[] arr = StringUtils.split(right, " ", 2);
      table = arr[0];
      int otherIndex = right.indexOf("from");
      while (otherIndex != -1) {
        String tmp = right.substring(otherIndex + 4).trim();
        String[] tmpArr = StringUtils.split(tmp, " ", 2);
        otherIndex = tmp.indexOf("from");
        table += "," + tmpArr[0].replace(")", "");
      }
      index = right.indexOf("join");
      while (index != -1) {
        right = right.substring(index + 4).trim();
        String[] arrs = StringUtils.split(right, " ", 2);
        table = table + "," + arrs[0];
        index = right.indexOf("join");
      }
      return table.replace("`", "");
    }
    sql = sql.replace("`", "");
    if ("update".equals(type)) {
      String[] arr = StringUtils.split(sql, " ", 3);
      return arr[1];
    }
    if ("delete".equals(type)) {
      String[] arr = StringUtils.split(sql, " ", 4);
      return arr[2];
    }
    if ("insert".equals(type)) {
      String[] arr = StringUtils.split(sql, " ", 4);
      int index = arr[2].indexOf("(");
      if (index == -1) {
        return arr[2];
      }
      return arr[2].substring(0, index);
    }
    log.error("parseTable_err2:{}", sql);
    return "";
  }
}
