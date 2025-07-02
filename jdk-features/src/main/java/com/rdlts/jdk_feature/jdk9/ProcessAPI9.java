package com.rdlts.jdk_feature.jdk9;

import java.io.IOException;
import java.util.Optional;

public class ProcessAPI9 {

    public static void demo() {
        // 获取当前进程
        ProcessHandle current = ProcessHandle.current();
        System.out.println("Current PID: " + current.pid());

        // 获取进程信息
        System.out.println("Process Information:");
        Optional<String> user = current.info().user();
        user.ifPresent(u -> System.out.println("User: " + u));

        Optional<String> commandLine = current.info().commandLine();
        commandLine.ifPresent(cmd -> System.out.println("Command: " + cmd));

        Optional<java.time.Instant> startInstant = current.info().startInstant();
        startInstant.ifPresent(start -> System.out.println("Start time: " + start));

        Optional<java.time.Duration> totalCpuDuration = current.info().totalCpuDuration();
        totalCpuDuration.ifPresent(cpu -> System.out.println("CPU time: " + cpu));

        // 列出所有子进程
        System.out.println("Child Processes:");
        current.children().forEach(child -> System.out.println("Child PID: " + child.pid()));

        // 列出所有进程
        System.out.println("All Processes:");
        ProcessHandle.allProcesses()
                .filter(ph -> ph.info().command().isPresent())
                .forEach(ph -> System.out.println(ph.pid() + ": " + ph.info().command().orElseThrow(() -> new RuntimeException("Command not found"))));

        // 启动并等待进程完成
        try {
            ProcessBuilder pb = new ProcessBuilder("ls", "-l");
            Process process = pb.start();
            ProcessHandle handle = process.toHandle();

            handle.onExit().thenAccept(p -> System.out.println("Process " + p.pid() + " terminated")).join();
        } catch (IOException e) {
            System.err.println("Error starting process: " + e.getMessage());
        }
    }
}