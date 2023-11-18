# Используем образ OpenJDK
FROM openjdk:17

# Устанавливаем директорию приложения
WORKDIR /app

# Копируем JAR-файл в директорию /app
COPY target/second-service.jar /app/
COPY src/main/resources/keystore/orgdirectory.jks /app/certs/orgdirectory.jks
COPY src/main/resources/keystore/2service.jks /app/certs/2service.jks

# Команда для запуска приложения при старте контейнера
CMD ["java", "-jar", "-Dspring.profiles.active=docker", "second-service.jar"]


# TODO: выносить jar файл сразу отсюда новым, то есть производить сборку из этого файла