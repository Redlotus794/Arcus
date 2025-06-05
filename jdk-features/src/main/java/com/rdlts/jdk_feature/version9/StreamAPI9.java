package com.rdlts.jdk_feature.version9;

import java.util.stream.Stream;

public class StreamAPI9 {

    public static void demo() {
        // 1. takeWhile - 从头开始获取元素，直到条件不满足
        System.out.println("takeWhile:");
        // 结果: [2, 4, 6, 8]
        Stream.of(2, 4, 6, 8, 9, 10, 12)
                .takeWhile(n -> n % 2 == 0)
                .forEach(System.out::println);

        // 2. dropWhile - 从头开始丢弃元素，直到条件不满足
        // 结果: [9, 10, 12]
        System.out.println("dropWhile:");
        Stream.of(2, 4, 6, 8, 9, 10, 12)
                .dropWhile(n -> n % 2 == 0)
                .forEach(System.out::println);

        // 3. ofNullable - 安全创建单元素流，处理null值
        System.out.println("ofNullable:");
        // 0
        System.out.println("Count for null: " + Stream.ofNullable(null).count());
        // 1
        System.out.println("Count for 'Java': " + Stream.ofNullable("Java").count());

        // 4. iterate方法重载 - 带终止条件的迭代
        System.out.println("Old iterate with limit:");
        Stream.iterate(1, n -> n * 2)
                .limit(5)
                .forEach(System.out::println);

        System.out.println("New iterate with termination condition:");
        // 1, 2, 4, 8, 16, 32, 64
        Stream.iterate(1, n -> n < 100, n -> n * 2)
                .forEach(System.out::println);
    }
}