FROM openjdk:17-jdk-slim

# 设置工作目录
WORKDIR /app

# 复制 jar 包
COPY target/Games-0.0.1-SNAPSHOT.jar app.jar

# 启动应用
ENTRYPOINT ["java","-jar","app.jar"]
