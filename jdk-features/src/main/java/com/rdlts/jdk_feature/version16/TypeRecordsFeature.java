package com.rdlts.jdk_feature.version16;

public class TypeRecordsFeature {

    public static void demo() {
        // JDK16特性演示：类型记录（Record）
        // 定义一个记录类型
        record Person(String name, int age) {}

        // 创建记录实例
        Person person = new Person("Alice", 30);

        // 使用记录类型
        System.out.println("Name: " + person.name());
        System.out.println("Age: " + person.age());

        // 记录类型自动生成的toString方法
        System.out.println(person);
    }

}
