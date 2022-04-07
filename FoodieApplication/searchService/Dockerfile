FROM openjdk:11-jre-slim
WORKDIR search/src
ENV MONGO_URI=mongodb://localhost:27017/searchdb
ADD .target/searchService-0.0.1-SNAPSHOT.jar /search/src/searchService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","searchService-0.0.1-SNAPSHOT.jar"]