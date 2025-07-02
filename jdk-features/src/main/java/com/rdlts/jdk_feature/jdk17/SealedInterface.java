package com.rdlts.jdk_feature.jdk17;

public class SealedInterface {

    public static void demo() {
        Shape circle = new Circle(5);
        System.out.println("Circle area: " + circle.area());

        Shape rectangle = new Rectangle(4, 6);
        System.out.println("Rectangle area: " + rectangle.area());
    }

    public static void main(String[] args) {
        demo();
    }

}

sealed interface Shape permits Circle, Rectangle, Triangle {
    double area();
}

final class Circle implements Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

final class Rectangle implements Shape {
    private final double length;
    private final double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }
}

sealed class Triangle implements Shape permits EquilateralTriangle, IsoscelesTriangle {
    private final double base;
    private final double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        return 0.5 * base * height;
    }
}

/**
 * 等边三角形类，继承自 Triangle。
 */
final class EquilateralTriangle extends Triangle {
    public EquilateralTriangle(double sideLength) {
        super(sideLength, sideLength);
    }
}

/**
 * 等腰三角形类，继承自 Triangle。
 */
final class IsoscelesTriangle extends Triangle {
    public IsoscelesTriangle(double base, double height) {
        super(base, height);
    }
}