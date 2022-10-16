FROM openjdk:11
ADD target/springboot-mysql-docker.jar springboot-mysql-docker.jar
EXPOSE 8181
ENTRYPOINT ["java", "-jar", "springboot-app.jar"]