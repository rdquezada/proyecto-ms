FROM maven:3.6.3-jdk-8
ADD /target/monitoreo-service-0.0.1-SNAPSHOT.jar monitoreo-service-0.0.1-SNAPSHOT.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "monitoreo-service-0.0.1-SNAPSHOT.jar"]
