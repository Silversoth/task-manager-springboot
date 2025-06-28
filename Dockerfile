# Use Maven to build the app
FROM maven:3.8.5-eclipse-temurin-17 AS build

WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the rest of the project files
COPY src ./src

# Build the project
RUN mvn clean package -DskipTests

# Use a minimal JDK image to run the app
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY --from=build /app/target/task-manager.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
