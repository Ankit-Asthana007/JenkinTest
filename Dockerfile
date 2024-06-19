# Use an official Gradle image to build the application
FROM gradle:7.4.2-jdk17 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the Gradle wrapper and build files
COPY gradlew gradlew
COPY gradle gradle
COPY build.gradle build.gradle
COPY settings.gradle settings.gradle

# Copy the source code
COPY src src

# Ensure gradlew has execute permission
RUN chmod +x gradlew

# Run the Gradle build
RUN ./gradlew clean build

# Use an OpenJDK image to run the application
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/build/libs/*.jar app.jar

# Expose port 8000
EXPOSE 8000

# Command to run the application
CMD ["java", "-jar", "app.jar"]
