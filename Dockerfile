FROM maven:3.8.5-openjdk-17 AS build
copy . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/ExamGuruOnline-0.0.1-SNAPSHOT.jar ExamGuruOnline.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","ExamGuruOnline.jar"]