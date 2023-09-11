package net.yiyuan.common.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeUtils {
  public static List<Map<String, Object>> convertListToTree(
      List<?> list,
      String topLevelParentId,
      String idFieldName,
      String parentIdFieldName,
      String childrenFieldName) {
    Map<Object, Map<String, Object>> map = new HashMap<>();
    List<Map<String, Object>> tree = new ArrayList<>();

    // Build node mappings
    for (Object item : list) {
      Map<String, Object> nodeMap = new HashMap<>();
      nodeMap.put(childrenFieldName, new ArrayList<>());

      // Convert node fields to key-value pairs in the map
      nodeMap.put(idFieldName, invokeGetter(item, idFieldName));
      nodeMap.put(parentIdFieldName, invokeGetter(item, parentIdFieldName));

      // Get all fields of the item's class
      Field[] fields = item.getClass().getDeclaredFields();
      for (Field field : fields) {
        String fieldName = field.getName();
        if (!fieldName.equals("serialVersionUID")) {
          Object fieldValue = invokeGetter(item, fieldName);
          nodeMap.put(fieldName, fieldValue);
        }
      }

      map.put(invokeGetter(item, idFieldName), nodeMap);
    }

    // Build the tree structure
    for (Object item : list) {
      Object parentId = invokeGetter(item, parentIdFieldName);
      if (parentId == null || parentId.equals(topLevelParentId)) {
        tree.add(map.get(invokeGetter(item, idFieldName)));
      } else {
        Map<String, Object> nodeMap = map.get(invokeGetter(item, idFieldName));
        List<Map<String, Object>> children =
            (List<Map<String, Object>>) map.get(parentId).get(childrenFieldName);
        children.add(nodeMap);
      }
    }

    return tree;
  }

  private static Object invokeGetter(Object object, String fieldName) {
    try {
      return object.getClass().getMethod(getGetterMethodName(fieldName)).invoke(object);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  private static String getGetterMethodName(String fieldName) {
    return "get" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
  }
}
