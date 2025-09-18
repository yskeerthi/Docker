FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/student-app-0.0.1-SNAPSHOT.jar student-app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "student-app.jar"]
