package com.rdlts.jdk_feature.version14;

public class NPEFriendlyMessage {

    public static void demo() {
        // JDK14特性演示：NPE友好的消息
        String str = null;
        try {
            // before jdk14 : Exception in thread "main" java.lang.NullPointerException
            //    at Main.main(Main.java:5)
            // after jdk14  : Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.length()" because "str" is null
            System.out.println(str.length());
        } catch (NullPointerException e) {
            // JDK13开始，NPE会提供更友好的错误信息
            System.err.println("Caught NullPointerException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        demo();
    }
}
