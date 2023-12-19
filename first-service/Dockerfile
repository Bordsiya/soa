# Используем образ OpenJDK
FROM openjdk:17

# Устанавливаем директорию приложения
WORKDIR /app

# Копируем JAR-файл в директорию /app
COPY target/first-service.jar /app/
COPY src/main/resources/keystore/orgdirectory.jks /app/certs/orgdirectory.jks

# Команда для запуска приложения при старте контейнера
CMD ["java", "-jar", "-Dspring.profiles.active=docker", "first-service.jar"]


# TODO: выносить jar файл сразу отсюда новым, то есть производить сборку из этого файла