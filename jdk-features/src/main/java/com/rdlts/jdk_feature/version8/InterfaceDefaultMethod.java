package com.rdlts.jdk_feature.version8;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class InterfaceDefaultMethod {

    public static void demo() {
        MyInterface instance = new MyInterfaceImpl();

        // Call default method
        log.info("Default method result: {}", instance.defaultMethod());

        // Call static method
        log.info("Static method result: {}", MyInterface.staticMethod());
    }

    interface MyInterface {
        // Default method
        default String defaultMethod() {
            return "This is a default method.";
        }

        // Static method
        static String staticMethod() {
            return "This is a static method.";
        }
    }

    static class MyInterfaceImpl implements MyInterface {
        // No need to override defaultMethod unless customization is required
    }


}
