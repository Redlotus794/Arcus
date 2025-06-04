package com.rdlts.jdk_feature;

import com.rdlts.jdk_feature.version10.CopyOfDemo;
import com.rdlts.jdk_feature.version10.LocalVariableInference;
import com.rdlts.jdk_feature.version11.FilesMethod;
import com.rdlts.jdk_feature.version11.HttpClientDemo;
import com.rdlts.jdk_feature.version11.StringMethod;
import com.rdlts.jdk_feature.version8.*;
import com.rdlts.jdk_feature.version9.InterfacePrivateDefaultMethod;
import com.rdlts.jdk_feature.version9.ProcessAPI9;
import com.rdlts.jdk_feature.version9.SmallCollectionCreation;
import com.rdlts.jdk_feature.version9.StreamAPI9;

/**
 * <a href="https://mp.weixin.qq.com/s/Ihm1KwjYtiuMU8whjqCY6Q">JDK9~JDK21的29个实用特性</a>
 */
public class AllDemo {

    public static void main(String[] args) throws Exception {
        version8();
        version9();
        version10();
        version11();
    }

    private static void version11() {
        // JDK11特性演示
        StringMethod.demo();
        HttpClientDemo.demo();
        FilesMethod.demo();
    }

    /**
     * JDK10特性演示：
     * 局部变量类型推断（var）
     * CopyOf方法简化数组复制
     * @throws Exception e
     */
    private static void version10() throws Exception {
        // JDK10特性演示
        LocalVariableInference.demo();
        CopyOfDemo.demo();

    }

    /**
     * java 8 特性：
     * 函数式接口
     * Lambda表达式
     * Optional的使用
     * 方法引用（双冒号)
     * 并发增强 CompletableFuture
     * 接口默认方法
     */
    public static void version8() {
        FunctionalInterfaceDemo.demo();
        LambdaExpression.demo();
        OptionalUsage.demo();
        MethodReference.demo();
        CompletableFutureDemo.demo();
        InterfaceDefaultMethod.demo();
    }

    /**
     * java 9 特性:
     * 小集合初始化优化
     * 接口私有方法
     * Stream API 增强: takeWhile, dropWhile, iterator limit
     */
    public static void version9() {
        SmallCollectionCreation.demo();
        InterfacePrivateDefaultMethod.demo();
        StreamAPI9.demo();
        ProcessAPI9.demo();
    }
}
