package com.rdlts.jdk_feature.version12;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatDemo {

    public static void demo() {
        // 创建简短格式的格式化器
        NumberFormat shortFormatter = NumberFormat.getCompactNumberInstance(
                Locale.US, NumberFormat.Style.SHORT);

        // 格式化数字
        System.out.println(shortFormatter.format(1000));       // 1K
        System.out.println(shortFormatter.format(1500));       // 2K (四舍五入)
        System.out.println(shortFormatter.format(1000000));    // 1M
        System.out.println(shortFormatter.format(1000000000)); // 1B

        // 长格式
        NumberFormat longFormatter = NumberFormat.getCompactNumberInstance(
                Locale.US, NumberFormat.Style.LONG);
        System.out.println(longFormatter.format(1000));        // 1 thousand
        System.out.println(longFormatter.format(1000000));     // 1 million


        // 其他语言的格式化
        NumberFormat germanFormatter = NumberFormat.getCompactNumberInstance(
                Locale.GERMANY, NumberFormat.Style.SHORT);
        System.out.println(germanFormatter.format(1000));      // 1.000

        NumberFormat chineseFormatter = NumberFormat.getCompactNumberInstance(
                Locale.CHINA, NumberFormat.Style.SHORT);
        System.out.println(chineseFormatter.format(1000));     // 1千
        System.out.println(chineseFormatter.format(1000000));  // 100万

        // 自定义精度
        shortFormatter.setMaximumFractionDigits(1);
        System.out.println(shortFormatter.format(1234));       // 1.2K
        System.out.println(shortFormatter.format(1500));       // 1.5K
    }

    public static void main(String[] args) {
        demo();
    }
}
