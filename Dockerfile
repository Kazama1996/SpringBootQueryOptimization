# Dockerfile

# Stage 1: 構建應用
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app

# 只複製 pom.xml 以利用 Docker 的緩存機制
COPY pom.xml .
COPY src ./src

# 構建應用並跳過測試
RUN mvn clean package -DskipTests

# Stage 2: 運行應用
FROM openjdk:17-jdk-slim
WORKDIR /app

# 使用通配符複製 JAR 文件並重新命名為 app.jar
COPY --from=build /app/target/*.jar /app/app.jar

# 啟動 Spring Boot 應用
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

# Dockerfile

# # Stage 1: 構建應用
# FROM maven:3.8.4-openjdk-17 AS build
# WORKDIR /app

# # 只複製 pom.xml 以利用 Docker 的緩存機制
# COPY pom.xml .
# COPY src ./src

# # 構建應用並跳過測試
# RUN mvn clean package -DskipTests

# # Stage 2: 運行應用
# FROM openjdk:17-jdk-slim
# WORKDIR /app

# # 使用通配符複製 JAR 文件並重新命名為 app.jar
# COPY --from=build /app/target/*.jar /app/app.jar

# # 添加啟動延遲的指令，然後啟動 Spring Boot 應用
# ENTRYPOINT ["sh", "-c", "sleep 30 && java -jar /app/app.jar"]