#Information that will run the package
FROM
ADD target/d387-advanced-java.jar d387-advanced-java.jar
ENTRYPOINT ["sh", "-c", "java - jar /d387-advanced-java.jar"]

