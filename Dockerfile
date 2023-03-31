FROM openjdk

COPY target/consulta-cep-demo-0.0.1-SNAPSHOT.jar consulta-cep.jar

ENTRYPOINT ["java", "-jar", "consulta-cep.jar"]