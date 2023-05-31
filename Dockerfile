FROM adoptopenjdk/maven-openjdk11
COPY ./ ./
RUN mvn clean install
ENTRYPOINT ["java","-jar","target/languagestranslation.jar"]