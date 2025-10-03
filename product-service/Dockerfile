# Базовый образ с JDK
FROM eclipse-temurin:17-jdk-alpine

# Папка для приложения
WORKDIR /app

# Копируем jar (предварительно mvn clean package)
COPY target/product-service-0.0.1-SNAPSHOT.jar app.jar

# Экспонируем порт
EXPOSE 8080

# Запуск приложения
ENTRYPOINT ["java","-jar","app.jar"]