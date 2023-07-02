FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
COPY env.yaml env.yaml
ENTRYPOINT ["java","-jar","/app.jar"]