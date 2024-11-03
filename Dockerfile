FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY . /app
WORKDIR /app
RUN chmod +x ./mvnw
RUN mkdir /secrets
RUN --mount=type=secret,id=credentials_json,dst=/etc/secrets/credentials.json cp /etc/secrets/credentials.json /secrets/credentials.json
RUN ./mvnw clean package -DskipTests
ENTRYPOINT ["java","-jar","/app/target/youtube_video_archive-0.0.1-SNAPSHOT.jar"]
