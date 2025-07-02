package com.rdlts.jdk_feature.jdk12;

public class StringTransform {

    public static void demo() {
        // JDK12 String Transform 示例
        String original = "hello, world!";
        String result = original.toUpperCase();
        result = result.substring(0, 5);
        result = result + "...";

        // 使用transform方式
        result = "hello, world!"
                .transform(String::toUpperCase)
                .transform(s -> s.substring(0, 5))
                .transform(s -> s + "...");
        System.out.println(result); // HELLO...

        // 复杂转换
        String parsed = "{ \"name\": \"John\", \"age\": 30 }"
                .transform(json -> {
                    // 解析JSON
                    // 此处简化，实际应使用Jackson等
                    return json.substring(json.indexOf("name") + 7, json.indexOf("age") - 3);
                })
                .transform(String::trim)
                .transform(String::toUpperCase);

        System.out.println(parsed); // JOHN
    }
}
