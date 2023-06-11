FROM eclipse-temurin:17

WORKDIR /app

COPY ./target/SpringDataJPA-0.0.1-SNAPSHOT.jar /app

ENTRYPOINT [ "java", "-jar", "/app/SpringDataJPA-0.0.1-SNAPSHOT.jar" ]