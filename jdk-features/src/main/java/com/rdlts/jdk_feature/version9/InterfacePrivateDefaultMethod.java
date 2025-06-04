package com.rdlts.jdk_feature.version9;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class InterfacePrivateDefaultMethod {

    public static void demo() {
        MyInterface instance = new MyInterfaceImpl();
        log.info("Default method result: {}", instance.defaultMethod());
        log.info("Static method result: {}", MyInterface.staticMethod());
    }

    interface MyInterface {
        // Default method using private method
        default String defaultMethod() {
            return "Default Method: " + privateMethod();
        }

        // Private method
        private String privateMethod() {
            return "Private Method";
        }

        // Static method using private static method
        static String staticMethod() {
            return "Static Method: " + privateStaticMethod();
        }

        // Private static method
        private static String privateStaticMethod() {
            return "Private Static Method";
        }
    }

    static class MyInterfaceImpl implements MyInterface {
        // No need to override defaultMethod unless customization is required
    }
}