FROM maven:3.6-jdk-11 as maven
COPY pom.xml /
RUN mvn dependency:go-offline -B
COPY ./src ./src
RUN mvn clean package -DskipTests  && cp target/*.jar application.jar

FROM openjdk:11.0.7-jre-slim
WORKDIR /application
COPY --from=maven /application.jar ./application.jar
USER docker
CMD java -jar application.jar
