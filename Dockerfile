# Use the official OpenJDK image as the base image
FROM openjdk:21-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Maven project file
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

# Copy the source code
COPY src ./src

# Install Maven
RUN apt-get update && apt-get install -y maven

# Build the application
RUN ./mvnw clean package -DskipTests

# Expose the port the app runs on
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "/app/target/CallDropAnalyzer-0.0.1-SNAPSHOT.jar"]