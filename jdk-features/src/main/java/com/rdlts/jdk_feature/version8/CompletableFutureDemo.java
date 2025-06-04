package com.rdlts.jdk_feature.version8;

public class CompletableFutureDemo {


    public static void demo() {
        // 示例：使用 CompletableFuture 来异步执行任务
        java.util.concurrent.CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000); // 模拟耗时操作
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "Hello, CompletableFuture!";
        }).thenAccept(result -> System.out.println("Result: " + result));

        // 保持主线程活着，等待异步任务完成
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
