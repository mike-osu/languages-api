FROM maven:3.8.2-jdk-8

WORKDIR /app

COPY . .

RUN mvn package -Dmaven.test.skip

EXPOSE 8080

ENTRYPOINT ["java","-jar","target/languages-api.jar", "--spring.profiles.active=docker"]
