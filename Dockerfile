# Étape 1 : Utiliser une image Java JRE légère
FROM openjdk:17-jdk-slim

# Étape 2 : Ajouter un répertoire pour l'application
WORKDIR /app

# Étape 3 : Copier le JAR dans l'image Docker
COPY target/SmsProjectCRC-0.0.1-SNAPSHOT.jar /app/sms_backend.jar
COPY src/main/resources/application.properties /app/application.properties
# Étape 4 : Exposer le port 8080
EXPOSE 8080

# Étape 5 : Commande d'exécution avec un paramètre passé lors du `docker run`
ENTRYPOINT ["java", "-jar", "/app/sms_backend.jar", "--spring.config.location=/app/application.properties"]

