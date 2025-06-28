# Use Maven image to build the app
FROM maven:3.8.5-eclipse-temurin-17 AS build

WORKDIR /app

# Copy the full project
COPY . .

# Download dependencies (optional)
RUN mvn dependency:go-offline

# Build the project
RUN mvn clean package -DskipTests

# Use a minimal JDK image to run the app
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
