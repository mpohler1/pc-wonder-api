FROM openjdk:8
ARG PC_WONDER_BACKEND=target/*.jar
COPY ${PC_WONDER_BACKEND} backend.jar
ENTRYPOINT ["java", "-jar", "./backend.jar"]
