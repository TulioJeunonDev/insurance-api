FROM maven:3.8.6-amazoncorretto-17 as build
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
ADD . /usr/src/app
RUN mvn package

FROM eclipse-temurin:17-jdk
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
COPY --from=build /usr/src/app/target/insurance-api-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]