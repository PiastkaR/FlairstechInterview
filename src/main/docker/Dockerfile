FROM openjdk:8-jdk-alpine
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} Interview-1.0.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","Interview-1.0.jar"]