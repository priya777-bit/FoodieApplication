FROM openjdk
WORKDIR auth/src
EXPOSE 8086
ADD .target/UserAuthenticationService-0.0.1-SNAPSHOT.jar /auth/src/UserAuthenticationService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","UserAuthenticationService-0.0.1-SNAPSHOT.jar"]