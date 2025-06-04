package com.rdlts.jdk_feature.version8;

/**
 * 方法引用
 * 简化 Lambda 表达式的写法，直接引用现有的方法。
 * 语法：ClassName::methodName 或 instance::methodName。
 */
public class MethodReference {

    public static void demo() {
        // 示例：使用方法引用来创建一个函数式接口的实例
        Runnable runnable = MethodReference::staticMethod;
        runnable.run();

        // 示例：使用实例方法引用
        MethodReference instance = new MethodReference();
        Runnable instanceRunnable = instance::instanceMethod;
        instanceRunnable.run();
    }

    public static void staticMethod() {
        System.out.println("Static method called");
    }

    public void instanceMethod() {
        System.out.println("Instance method called");
    }
}
