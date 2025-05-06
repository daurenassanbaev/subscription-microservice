FROM openjdk:17
WORKDIR /app
COPY /target/tech_project-0.0.1-SNAPSHOT.jar tech_task.jar
ENTRYPOINT ["java", "-jar", "tech_task.jar"]