FROM openjdk:11-jre-slim
WORKDIR add/src
ENV MONGO_URI=mongodb://localhost:27017/sendrejectrestdb
ADD ./target/addRestuarantService-0.0.1-SNAPSHOT.jar /add/src/addRestuarantService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","addRestuarantService-0.0.1-SNAPSHOT.jar"]