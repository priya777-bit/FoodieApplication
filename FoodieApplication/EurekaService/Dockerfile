FROM openjdk
WORKDIR eureka/src
ADD ./target/EurekaService-0.0.1-SNAPSHOT.jar /eureka/src/EurekaService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","EurekaService-0.0.1-SNAPSHOT.jar"]