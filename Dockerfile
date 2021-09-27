FROM openjdk:17-jdk-alpine
MAINTAINER "Benaya Trabelsi"
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]