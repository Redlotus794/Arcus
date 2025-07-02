package com.rdlts.jdk_feature.jdk15;

import com.alibaba.nacos.shaded.com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

public class TextBlockFeature {

    public static void demo() {
        // JDK15特性演示：Text Blocks
        String textBlock = """
                This is a text block.
                It can span multiple lines.
                """;
        System.out.println(textBlock);

        // 使用文本块创建JSON字符串
        String json = """
                {
                    "name": "John",
                    "age": 30,
                    "city": "New York"
                }
                """;
        System.out.println(json);

        Person person = new Gson().fromJson(json, Person.class);
        System.out.println(person);
    }

    public static void main(String[] args) {
        demo();
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    static class Person {
        String name;
        int age;
        String city;
    }
}
