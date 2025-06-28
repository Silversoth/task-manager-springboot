# Use an official JDK base image
FROM eclipse-temurin:17-jdk-alpine

# Add a volume to store temporary files
VOLUME /tmp

# Copy the JAR file into the container
COPY target/task-manager.jar app.jar


# Run the jar file
ENTRYPOINT ["java", "-jar", "/app.jar"]
