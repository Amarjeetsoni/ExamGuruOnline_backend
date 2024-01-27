FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar ExamGuruOnline.jar
ENTRYPOINT ["java","-jar","/ExamGuruOnline.jar"]
EXPOSE 8080