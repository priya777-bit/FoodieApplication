FROM openjdk:11-jre-slim
WORKDIR order/src
ENV MONGO_URI=mongodb://localhost:27017/orderdb
ADD ./target/OrderService-0.0.1-SNAPSHOT.jar /order/src/OrderService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","OrderService-0.0.1-SNAPSHOT.jar"]