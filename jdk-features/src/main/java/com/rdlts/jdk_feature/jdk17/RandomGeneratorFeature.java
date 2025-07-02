package com.rdlts.jdk_feature.jdk17;

import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;
import java.util.stream.DoubleStream;

public class RandomGeneratorFeature {

    public static void demo() {
        // 获取默认的随机数生成器
        RandomGenerator random = RandomGenerator.getDefault();
        System.out.println(random.nextInt(100)); // 0-99之间的随机数

        // 使用特定算法的生成器
        RandomGenerator xoroshiro = RandomGenerator.of("Xoroshiro128PlusPlus");
        System.out.println(xoroshiro.nextLong());

        // 使用L32X64MixRandom - 平衡了速度和质量的算法
        System.out.println("L32X64MixRandom 算法:");
        RandomGenerator fastRandom = RandomGenerator.of("L32X64MixRandom");
        for (int i = 0; i < 5; i++) {
            System.out.println(fastRandom.nextInt(1000));
        }

        // 创建可复现的随机数序列 (使用相同的种子)
        System.out.println("可复现的随机数序列:");
        RandomGenerator repeatableRandom = RandomGeneratorFactory.of("L32X64MixRandom").create(12345L);
        for (int i = 0; i < 5; i++) {
            System.out.println(repeatableRandom.nextInt(1000));
        }

        // 生成随机流
        System.out.println("生成随机流:");
        DoubleStream randomDoubles = RandomGenerator.getDefault().doubles(1000);
        randomDoubles.forEach(System.out::println);


        System.out.println("=====================");
        System.out.println("所有可用的算法:");
        // 查看所有可用的算法
        RandomGeneratorFactory.all()
                .map(RandomGeneratorFactory::name)
                .sorted()
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        demo();
    }
}
