# ------------ Stage 1: Build the application ------------
FROM maven:3.9.4-eclipse-temurin-17 AS build

WORKDIR /app

# Copy pom.xml and download dependencies (cache layer)
COPY pom.xml .
COPY .mvn .mvn
COPY mvnw .
RUN ./mvnw dependency:go-offline

# Copy rest of the source
COPY src ./src

# Build the app
RUN ./mvnw clean package -DskipTests

# ------------ Stage 2: Package the application ------------
FROM openjdk:17-jdk-alpine

WORKDIR /app

# Copy the built jar from the previous stage
COPY --from=build /app/target/book-service-0.0.1-SNAPSHOT.jar app.jar

# Expose port if desired
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
