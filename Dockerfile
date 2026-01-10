#utilisation d'une image de base avec java (openjdk)
FROM eclipse-temurin:17-jre

WORKDIR /app
COPY build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
