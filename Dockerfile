#Information that will run the package
FROM openjdk:8-jdk-alpine
ADD target/d387-advanced-java.jar d387-advanced-java.jar
ENTRYPOINT ["sh", "-c", "java - jar /d387-advanced-java.jar"]

