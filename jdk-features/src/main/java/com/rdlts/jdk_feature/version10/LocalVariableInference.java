package com.rdlts.jdk_feature.version10;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 不建议使用，除非在对待不确定泛型的过程中，才可以用。
 * Java最大的优点就是类型确定，可以保证编程的稳定性。
 */
public class LocalVariableInference {

    @SuppressWarnings({"unused", "deprecated"})
    public static void demo() throws Exception {
//        JDK10引入了局部变量类型推断，使用var关键字让编译器推断变量类型：
        // 旧方式 - 类型重复且冗长
//        HashMap<String, List<Customer>> customersByCity = new HashMap<>();
//        BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
//        URLConnection connection = new URL("https://example.com").openConnection();

        // JDK10方式 - 简洁明了
        var customersByCity = new HashMap<String, List<String>>();
        var reader = new BufferedReader(new FileReader("data.txt"));
//        var connection = new URL("https://example.com").openConnection();

        // 在for循环中特别有用
        customersByCity.put("New York", List.of("Alice", "Bob"));
        for (var entry : customersByCity.entrySet()) {
            var city = entry.getKey();
            var customers = entry.getValue();
            System.out.println("City: " + city + ", Customers: " + customers.size());
            // ...
        }

        // 好的用法 - 类型明确
        var customers = new ArrayList<String>();
        var entry = Map.entry("key", "value");

        // 避免的用法 - 类型不明确
        var result = getResult(); // 返回类型不明显
        var x = 1; // 基本类型推荐显式声明
    }

    public static String getResult() {
        return StringUtils.EMPTY;
    }
}
