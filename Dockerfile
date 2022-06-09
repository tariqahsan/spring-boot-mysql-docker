FROM openjdk:8
ADD target/springboot-app.jar springboot-app.jar
EXPOSE 8181
ENTRYPOINT ["java", "-jar", "springboot-app.jar"]