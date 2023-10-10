package net.yiyuan.common.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.*;

public class SkuUtil {

    /**
     * 注释的是转成List<List<String>形式
     *
     * @return 转换为大写的字符串
     */
//    public static List<List<String>> generateSkuCombinations(List<String> attrKeys, List<List<String>> attrValues) {
//        List<List<String>> combinations = new ArrayList<>();
//        generateCombinations(attrKeys, attrValues, 0, new ArrayList<>(), combinations);
//        return combinations;
//    }
//
//    private static void generateCombinations(List<String> attrKeys, List<List<String>> attrValues, int index,
//                                             List<String> currentCombination, List<List<String>> combinations) {
//        if (index == attrKeys.size()) {
//            combinations.add(new ArrayList<>(currentCombination));
//            return;
//        }
//
//        List<String> values = attrValues.get(index);
//        for (String value : values) {
//            currentCombination.add(attrKeys.get(index) + ":" + value);
//            generateCombinations(attrKeys, attrValues, index + 1, currentCombination, combinations);
//            currentCombination.remove(currentCombination.size() - 1);
//        }
//    }
//public static Map<String, Set<String>> reverseParseSkuList(List<List<String>> skuList) {
//    Map<String, Set<String>> attributes = new HashMap<>();
//
//    for (List<String> sku : skuList) {
//        for (String attribute : sku) {
//            String[] keyValue = attribute.split(":");
//            if (keyValue.length == 2) {
//                String key = keyValue[0];
//                String value = keyValue[1];
//                attributes.computeIfAbsent(key, k -> new HashSet<>()).add(value);
//            }
//        }
//    }
//
//    return attributes;
//}


    /**
     * 这个是转成List<Map<String, String>>形式
     *
     * @return 转换为大写的字符串
     */
    public static List<Map<String, String>> generateCombinations(List<String> attrKeys, List<List<String>> attrValues) {
        List<Map<String, String>> combinations = new ArrayList<>();

        generateCombinationsHelper(attrKeys, attrValues, new HashMap<>(), 0, combinations);

        return combinations;
    }

    private static void generateCombinationsHelper(List<String> attrKeys, List<List<String>> attrValues, Map<String, String> combination, int index, List<Map<String, String>> combinations) {
        if (index == attrKeys.size()) {
            combinations.add(new HashMap<>(combination));
            return;
        }

        String key = attrKeys.get(index);
        List<String> values = attrValues.get(index);

        for (String value : values) {
            combination.put(key, value);
            generateCombinationsHelper(attrKeys, attrValues, combination, index + 1, combinations);
            combination.remove(key);
        }
    }


    public static Map<String, List<String>> reverseParseCombinations(List<Map<String, String>> combinations) {
        Map<String, Set<String>> attributes = new HashMap<>();

        for (Map<String, String> combination : combinations) {
            for (Map.Entry<String, String> entry : combination.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                attributes.computeIfAbsent(key, k -> new HashSet<>()).add(value);
            }
        }

        // 转换为List
        Map<String, List<String>> result = new HashMap<>();
        for (Map.Entry<String, Set<String>> entry : attributes.entrySet()) {
            String key = entry.getKey();
            Set<String> values = entry.getValue();
            List<String> valueList = new ArrayList<>(values);
            result.put(key, valueList);
        }

        return result;
    }

    public static Map<String, Object> getAttrKeysAndAttrValues(String str) {
        // 使用Fastjson库解析字符串
//        Map<String, List<String>> attributesMap = JSON.parseObject(str, new TypeReference<Map<String, List<String>>>() {
//        });
        Map<String, Object> resultMap = new HashMap<>();
        try {
            // 解析JSON字符串为JSONObject
            JSONObject jsonObject = JSONObject.parseObject(str);

            // 提取属性键和属性值列表
            List<String> attrKeys = new ArrayList<>(jsonObject.keySet());
            List<List<String>> attrValues = new ArrayList<>();

            for (String key : attrKeys) {
                JSONArray jsonArray = jsonObject.getJSONArray(key);
                List<String> values = new ArrayList<>();

                for (int i = 0; i < jsonArray.size(); i++) {
                    values.add(jsonArray.getString(i));
                }
                attrValues.add(values);
            }

            // 打印结果
            System.out.println("属性键: " + attrKeys);
            System.out.println("属性值列表: " + attrValues);


            resultMap.put("key", attrKeys);
            resultMap.put("val", attrKeys);
        } catch (Exception e) {
            e.printStackTrace();
        }


//        // 提取属性键和属性值列表
//        List<String> attrKeys = new ArrayList<>(attributesMap.keySet());
//        List<List<String>> attrValues = new ArrayList<>(attributesMap.values());
//
//        // 打印结果
//        System.out.println("属性键: " + attrKeys);
//        System.out.println("属性值列表: " + attrValues);

        return resultMap;
    }


    public static void main(String[] args) {
        // 示例用法
//        List<String> skuList = List.of(
//                "Color=Red:Size=S:Material=Cotton",
//                "Color=Red:Size=S:Material=Polyester",
//                "Color=Red:Size=M:Material=Cotton"
//        );
        List<String> attrKeys = Arrays.asList("颜色", "尺寸", "版型");
        List<List<String>> attrValues = Arrays.asList(
                Arrays.asList("红色", "蓝色", "绿色"),
                Arrays.asList("S", "M", "L"),
                Arrays.asList("修身", "直桶")
        );

//        List<List<String>> skuList = generateSkuCombinations(attrKeys, attrValues);
        List<Map<String, String>> skuList = generateCombinations(attrKeys, attrValues);
        System.out.println(skuList);
        Map<String, List<String>> stringListMap = reverseParseCombinations(skuList);
        System.out.println(stringListMap);

        String input = "{\"颜色\":[\"蓝色\", \"绿色\", \"红色\"], \"尺寸\":[\"S\", \"L\", \"M\"], \"版型\":[\"修身\", \"直桶\"]}";
        Map<String, Object> attrKeysAndAttrValues = getAttrKeysAndAttrValues(input);
        System.out.println(attrKeysAndAttrValues);
    }

//    public static void main(String[] args) {
//        // 示例用法
//        List<String> attrKeys = Arrays.asList("Color", "Size", "Material");
//        List<List<String>> attrValues = Arrays.asList(
//                Arrays.asList("Red", "Blue", "Green"),
//                Arrays.asList("S", "M", "L"),
//                Arrays.asList("Cotton", "Polyester")
//        );
//
//        List<List<String>> combinations = generateSkuCombinations(attrKeys, attrValues);
//        for (List<String> combination : combinations) {
//            System.out.println(combination);
//        }
//    }
}