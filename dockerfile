# Start with base image
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="Progressive Coder"

# Add a temporary volume
VOLUME /tmp

# Expose Port 8080
EXPOSE 8080

# Application Jar File
ARG JAR_FILE=target/fizz-buzz-0.0.1-SNAPSHOT.jar

# Run the JAR file
ENTRYPOINT ["java", "-jar", "/fizz-buzz.jar"]