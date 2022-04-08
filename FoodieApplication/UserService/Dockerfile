FROM openjdk:11-jre-slim
WORKDIR usr/src
ENV MONGO_URI=mongodb://localhost:27017/foodiedb
ADD ./target/UserService-0.0.1-SNAPSHOT.jar /usr/src/UserService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","UserService-0.0.1-SNAPSHOT.jar"]