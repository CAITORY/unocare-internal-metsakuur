FROM eclipse-temurin:21
WORKDIR /app
COPY app.jar app.jar
USER 1000
ENTRYPOINT ["java", "-jar", "app.jar"]