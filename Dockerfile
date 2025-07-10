#Information that will run the package
FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD target/d387-advanced-java.jar d387-advanced-java.app.jar
ENTRYPOINT ["sh", "-c", "java - jar /d387-advanced-java.jar"]

