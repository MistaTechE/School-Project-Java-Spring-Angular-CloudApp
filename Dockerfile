#Information that will run the package
FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD target/D387_sample_code-0.0.2-SNAPSHOT.jar D387_sample_code-0.0.2-SNAPSHOT.app.jar
ENTRYPOINT ["sh", "-c", "java - jar /D387_sample_code-0.0.2-SNAPSHOT.app.jar"]


