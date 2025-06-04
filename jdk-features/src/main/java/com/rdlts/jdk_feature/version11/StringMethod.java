package com.rdlts.jdk_feature.version11;

public class StringMethod {

    public static void demo() {
        // 1. lines() - 按行分割字符串
        String multilineString = "Hello\nWorld\nJava";
        multilineString.lines().forEach(System.out::println);

        // 2. strip(), stripLeading(), stripTrailing() - 去除空白字符
        String paddedString = "   Hello World   ";
        System.out.println("Original: '" + paddedString + "'");
        System.out.println("Strip: '" + paddedString.strip() + "'");
        System.out.println("Strip Leading: '" + paddedString.stripLeading() + "'");
        System.out.println("Strip Trailing: '" + paddedString.stripTrailing() + "'");

        // strip() 与trim()的区别：strip()识别更多的unicode空白字符串
        String unicodeString = "\u2005Hello World\u2005";
        System.out.println("Unicode Strip: '" + unicodeString.strip() + "'");
        System.out.println("Unicode Trim: '" + unicodeString.trim() + "'");

        // 3. isBlank() - 检查字符串是否为空或仅包含空白字符
        String emptyString = "   ";
        System.out.println("Is empty string blank? " + emptyString.isBlank());
        String nonEmptyString = "Hello";
        System.out.println("Is non-empty string blank? " + nonEmptyString.isBlank());

        // 4. repeat(int count) - 重复字符串
        String repeatString = "Java ";
        System.out.println("Repeated String: " + repeatString.repeat(3));
    }
}
