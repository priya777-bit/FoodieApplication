FROM openjdk:11-jre-slim
WORKDIR rest/src
ENV MONGO_URI=mongodb://localhost:27017/restaurantdb
ADD ./target/RestuarantManagementService-0.0.1-SNAPSHOT.jar /rest/src/RestuarantManagementService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","RestuarantManagementService-0.0.1-SNAPSHOT.jar"]