package com.rdlts.jdk_feature;

import com.rdlts.jdk_feature.jdk10.CopyOfDemo;
import com.rdlts.jdk_feature.jdk10.LocalVariableInference;
import com.rdlts.jdk_feature.jdk11.FilesMethod;
import com.rdlts.jdk_feature.jdk11.HttpClientDemo;
import com.rdlts.jdk_feature.jdk11.StringMethod;
import com.rdlts.jdk_feature.jdk12.NumberFormatDemo;
import com.rdlts.jdk_feature.jdk12.StringTransform;
import com.rdlts.jdk_feature.jdk14.NPEFriendlyMessage;
import com.rdlts.jdk_feature.jdk14.SwitchExpression;
import com.rdlts.jdk_feature.jdk15.TextBlockFeature;
import com.rdlts.jdk_feature.jdk16.TypeRecordsFeature;
import com.rdlts.jdk_feature.jdk17.SealedInterface;
import com.rdlts.jdk_feature.jdk8.*;
import com.rdlts.jdk_feature.jdk9.InterfacePrivateDefaultMethod;
import com.rdlts.jdk_feature.jdk9.ProcessAPI9;
import com.rdlts.jdk_feature.jdk9.SmallCollectionCreation;
import com.rdlts.jdk_feature.jdk9.StreamAPI9;

/**
 * <a href="https://mp.weixin.qq.com/s/Ihm1KwjYtiuMU8whjqCY6Q">JDK9~JDK21的29个实用特性</a>
 */
public class AllDemo {

    public static void main(String[] args) throws Exception {
        jdk8();
        jdk9();
        jdk10();
        jdk11();
        jdk12();
        jdk14();
        jdk15();
        jdk16();
        jdk17();
    }

    public static void jdk17() {
        // JDK17特性演示：密封接口
        SealedInterface.demo();
    }

    public static void jdk16() {
        // JDK16特性演示：类型记录（Record）
        TypeRecordsFeature.demo();
    }

    /**
     * JDK15特性演示：
     * Text Blocks
     */
    public static void jdk15() {
        TextBlockFeature.demo();
    }

    /**
     * JDK14特性演示：
     * NPE友好的消息
     * Switch表达式
     */
    private static void jdk14() {
        // JDK14特性演示
        NPEFriendlyMessage.demo();
        SwitchExpression.demo();
    }

    /**
     * JDK12特性演示：
     * String Transform
     * NumberFormat的简短格式化
     */
    private static void jdk12() {
        // JDK12特性演示
        StringTransform.demo();
        NumberFormatDemo.demo();
    }

    /**
     * JDK11特性演示：
     * String方法增强
     * HttpClient API
     * Files方法增强
     */
    private static void jdk11() {
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
    private static void jdk10() throws Exception {
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
    public static void jdk8() {
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
    public static void jdk9() {
        SmallCollectionCreation.demo();
        InterfacePrivateDefaultMethod.demo();
        StreamAPI9.demo();
        ProcessAPI9.demo();
    }
}
