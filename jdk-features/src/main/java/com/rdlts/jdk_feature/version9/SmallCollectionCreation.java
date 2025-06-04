package com.rdlts.jdk_feature.version9;

import java.util.*;

/**
 * JDK 9 (2017年9月)：模块化与API增强
 * <p>
 * 小集合创建demo
 */
public class SmallCollectionCreation {

    @SuppressWarnings({"unused"})
    public static void demo() {
        // 旧方式
        List<String> list = Collections.unmodifiableList(Arrays.asList("Java", "Kotlin", "Scala"));
        Map<String, Integer> map = Collections.unmodifiableMap(new HashMap<>() {{
            put("Java", 1995);
            put("Kotlin", 2011);
            put("Scala", 2004);
        }});


        // JDK 9的方式
        List<String> list9 = List.of("Java", "Kotlin", "Scala");
        Set<String> set9 = Set.of("Java", "Kotlin", "Scala");
        Map<String, Integer> map9 = Map.of(
                "Java", 1995,
                "Kotlin", 2001,
                "Scala", 2004
        );

        Map<String, Integer> mapEntries = Map.ofEntries(
                Map.entry("Java", 1995),
                Map.entry("Kotlin", 2001),
                Map.entry("Scala", 2004)
        );
        System.out.println("小集合创建方法");
    }
}
