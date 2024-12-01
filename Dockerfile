FROM openjdk:22-jdk-oracle

WORKDIR .

COPY ./target/todoapi-0.0.1-SNAPSHOT.jar ./todoapi-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","todoapi-0.0.1-SNAPSHOT.jar"]