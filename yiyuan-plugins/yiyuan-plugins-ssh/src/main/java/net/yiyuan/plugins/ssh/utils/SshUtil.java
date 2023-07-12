package net.yiyuan.plugins.ssh.utils;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * ssh工具类
 *
 * @author 一源团队-花和尚
 * @date 2023/07/12
 */
public class SshUtil {

  /**
   * 执行脚本
   *
   * @param host 主机
   * @param port 港口
   * @param username 用户名
   * @param password 密码
   * @param command 命令
   * @return {@link String }
   * @author 一源团队-花和尚
   * @date 2023/07/12
   */
  public static String executeScript(
      String host, int port, String username, String password, String command) throws Exception {
    JSch jsch = new JSch();
    Session session = jsch.getSession(username, host, port);
    session.setPassword(password);
    session.setConfig("StrictHostKeyChecking", "no");
    session.connect();

    ChannelExec channel = (ChannelExec) session.openChannel("exec");
    channel.setCommand(command);

    BufferedReader reader = new BufferedReader(new InputStreamReader(channel.getInputStream()));
    channel.connect();

    String result = "";
    String line;
    while ((line = reader.readLine()) != null) {
      result += line + "\n";
    }

    channel.disconnect();
    session.disconnect();
    System.out.println("ssh执行结果" + result);
    return result;
  }
}
