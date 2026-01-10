#utilisation d'une image de base avec java (openjdk)
FROM openjdk:17-jdk-alpine

WORKDIR /app
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
