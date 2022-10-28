FROM openjdk:11.0.15-jre
ADD target/codesafe-1.0-SNAPSHOT-jar-with-dependencies.jar codesafe-1.0-SNAPSHOT-jar-with-dependencies.jar
EXPOSE 8080
ENTRYPOINT [ "bash", "-c", "java -jar codesafe-1.0-SNAPSHOT-jar-with-dependencies.jar" ]