package com.rdlts.jdk_feature.jdk11;

import lombok.SneakyThrows;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FilesMethod {

    @SneakyThrows
    @SuppressWarnings("unused")
    public static void demo() {
        // 读取文件String
        String content = Files.readString(Path.of("config.json"));

        // 写入String到文件
        Files.writeString(Path.of("output.txt"), "Hello Java 11");

        // 使用指定编码
//        content = Files.readString(Path.of("data.txt"), StandardCharsets.UTF_8);
        Files.writeString(Path.of("output.txt"), "Hello Java 11", StandardCharsets.UTF_8);

        // 写入字符串集合
        List<String> lines = List.of("Line 1", "Line 2", "Line 3");
        Files.write(Path.of("lines.txt"), lines);
    }

    public static void main(String[] args) {
        demo();
    }
}
