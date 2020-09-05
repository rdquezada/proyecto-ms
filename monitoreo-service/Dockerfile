FROM maven:3.6.3-jdk-8
ADD /target/admin-service-0.0.1-SNAPSHOT.jar admin-service-0.0.1-SNAPSHOT.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "admin-service-0.0.1-SNAPSHOT.jar"]
