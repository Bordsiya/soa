FROM openjdk:17

# Устанавливаем директорию приложения
WORKDIR /app

# Копируем JAR-файл в директорию /app
COPY target/second-service-soap.jar /app/
COPY src/main/resources/keystore/2service.jks /app/certs/2service.jks

# Команда для запуска приложения при старте контейнера
CMD ["java", "-jar", "second-service-soap.jar"]