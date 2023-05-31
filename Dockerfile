FROM adoptopenjdk/maven-openjdk11
COPY ./ ./
RUN mvn clean package
ENTRYPOINT ["java","-jar","target/languagestranslation.jar"]
EXPOSE 8080