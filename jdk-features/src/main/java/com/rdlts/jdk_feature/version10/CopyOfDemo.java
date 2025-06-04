package com.rdlts.jdk_feature.version10;

public class CopyOfDemo {

    public static void demo() {
        // JDK10引入了CopyOf方法，简化数组复制操作
        // 旧方式 - 使用Arrays.copyOf
        // int[] original = {1, 2, 3};
        // int[] copy = Arrays.copyOf(original, original.length);

        // JDK10方式 - 使用copyOf方法
        int[] original = {1, 2, 3};
        int[] copy = java.util.Arrays.copyOf(original, original.length);

        // 输出结果
        System.out.println("Original: " + java.util.Arrays.toString(original));
        System.out.println("Copy: " + java.util.Arrays.toString(copy));
    }
}
