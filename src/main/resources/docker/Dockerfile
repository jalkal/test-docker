FROM java:8
VOLUME /tmp
ADD test-docker-0.0.1-SNAPSHOT.jar test-docker.jar
ENV SPRING_PROFILES_ACTIVE docker
EXPOSE 8080
ENTRYPOINT ["java","-jar","/test-docker.jar"]