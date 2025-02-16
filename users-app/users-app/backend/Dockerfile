FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/users-app-0.0.1-SNAPSHOT.jar users-app.jar

EXPOSE 8080

ENV SPRING_APPLICATION_JSON='{"server.address":"0.0.0.0"}'

CMD ["java", "-jar", "users-app.jar"]
