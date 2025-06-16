# 使用官方JDK 21基础镜像
FROM openjdk:21-jdk-slim

# 设置工作目录
WORKDIR /app

# 复制编译好的JAR文件（假设Maven打包后的JAR在target目录下）
COPY target/*.jar app.jar

EXPOSE 8080

# 启动应用
CMD ["java", "-jar", "app.jar"]

