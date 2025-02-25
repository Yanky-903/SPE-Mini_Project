# Use a lightweight OpenJDK image
FROM openjdk:17

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled JAR file
COPY target/*.jar app.jar

# Command to run the application
CMD ["java", "-jar", "app.jar"]

