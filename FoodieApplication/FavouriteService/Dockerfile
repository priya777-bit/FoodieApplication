FROM openjdk:11-jre-slim
WORKDIR fav/src
ENV MONGO_URI=mongodb://localhost:27017/favdb
ADD ./target/FavouriteService-0.0.1-SNAPSHOT.jar /fav/src/FavouriteService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","FavouriteService-0.0.1-SNAPSHOT.jar"]