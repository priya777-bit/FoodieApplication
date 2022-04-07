FROM openjdk
WORKDIR apigateway/src
EXPOSE 9000
ADD ./target/apiGatewayService-0.0.1-SNAPSHOT.jar /apigateway/src/apiGatewayService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","apiGatewayService-0.0.1-SNAPSHOT.jar"]