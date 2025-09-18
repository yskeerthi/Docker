# Spring Boot Dockerized Todo App

What you get:
- Spring Boot (Java 17) web app with Thymeleaf UI and REST API for CRUD on `Todo`.
- JPA repository (works with H2 in-memory by default).
- Dockerfile and docker-compose.yml (includes Postgres service).
- You can just change DB URL/username/password via environment variables.

Quick start (local, no docker):
1. Build: `mvn clean package`
2. Run: `java -jar target/todoapp-0.0.1-SNAPSHOT.jar`
3. Open: http://localhost:8080

With Docker:
1. Build image: `mvn clean package` (or let docker build copy the jar if you have it)
2. Run compose: `SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/todo SPRING_DATASOURCE_USERNAME=todo SPRING_DATASOURCE_PASSWORD=todo docker-compose up --build`

Notes:
- By default the app uses H2 (in-memory) so it runs out-of-the-box without a DB.
- To connect to your own DB, set the environment variables `SPRING_DATASOURCE_URL`, `SPRING_DATASOURCE_USERNAME`, `SPRING_DATASOURCE_PASSWORD`.
