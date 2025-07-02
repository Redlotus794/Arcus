package com.rdlts.jdk_feature.jdk14;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class SwitchExpression {

    public static void demo() {
        // 传统switch
//        String result;
        DayOfWeek day = LocalDate.now().getDayOfWeek();
//        switch (day) {
//            case MONDAY:
//            case TUESDAY:
//            case WEDNESDAY:
//            case THURSDAY:
//            case FRIDAY:
//                result = "Weekday";
//                break;
//            case SATURDAY:
//            case SUNDAY:
//                result = "Weekend";
//                break;
//            default:
//                result = "Invalid day";
//                break;
//        }

        // JDK14特性演示：Switch表达式
        String type = switch (day) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> "Weekday";
            case SATURDAY, SUNDAY -> "Weekend";
            default -> "Invalid day";
        };
        System.out.println(day + " is a " + type);

        // 复杂表达式，带代码块
        int numLetters = switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> {
                System.out.println("Six letters day");
                yield 6;
            }
            case TUESDAY -> {
                System.out.println("Seven letters day");
                yield 7;
            }
            case THURSDAY, SATURDAY -> {
                System.out.println("Eight letters day");
                yield 8;
            }
            case WEDNESDAY -> {
                System.out.println("Nine letters day");
                yield 9;
            }
            default -> {
                throw new IllegalStateException("Invalid day: " + day);
            }
        };
    }

    public static void main(String[] args) {
        demo();
    }
}
