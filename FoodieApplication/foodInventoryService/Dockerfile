FROM openjdk:11-jre-slim
WORKDIR inventory/src
ENV MONGO_URI=mongodb://localhost:27017/restaurantandcuisine
ADD ./target/foodInventoryService-0.0.1-SNAPSHOT.jar /inventory/src/foodInventoryService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","foodInventoryService-0.0.1-SNAPSHOT.jar"]