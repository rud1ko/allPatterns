FROM openjdk:21-jdk-oracle
RUN mkdir /usr/app
COPY docker/prac9Gradle-1.0-SNAPSHOT.jar /usr/app
WORKDIR /usr/app
CMD ["java", "-jar", "prac9Gradle-1.0-SNAPSHOT.jar"]
