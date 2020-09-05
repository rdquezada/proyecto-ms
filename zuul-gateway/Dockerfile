FROM maven:3.6.3-jdk-8
ADD /target/zuul-gateway-0.0.1-SNAPSHOT.jar zuul-gateway-0.0.1-SNAPSHOT.jar
EXPOSE 3333
ENTRYPOINT ["java", "-jar", "zuul-gateway-0.0.1-SNAPSHOT.jar"]