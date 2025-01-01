# CallDropAnalyzer: Détection et Analyse des Appels Interrompus

CallDropAnalyzer est une application innovante pour analyser les causes des interruptions d’appels dans les réseaux mobiles. Elle fournit des outils puissants pour visualiser les appels interrompus sur une carte, identifier les zones problématiques, et générer des rapports détaillés pour les opérateurs téléphoniques.

## Table des Matières

- [Architecture Logicielle](#architecture-logicielle)
- [Configuration Docker](#configuration-docker)
- [Frontend](#frontend)
- [Backend](#backend)
- [Structure du Projet Backend](#structure-du-projet-backend)
- [Démarrage](#démarrage)
- [Utilisation](#utilisation)
- [Contributions](#contributions)

---

## Architecture Logicielle

L'application repose sur une architecture Spring Boot pour le backend, avec une base de données MySQL, et une interface frontend qui pourra être développée dans un futur proche. Le projet utilise des conteneurs Docker pour une déploiement simple et efficace.

## Configuration Docker

### Dockerfile
Voici un extrait du Dockerfile configuré pour le projet :

```dockerfile
# Use the official OpenJDK image as the base image
FROM openjdk:21-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Maven project file
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

# Copy the source code
COPY src ./src

# Install Maven
RUN apt-get update && apt-get install -y maven

# Build the application
RUN ./mvnw clean package -DskipTests

# Expose the port the app runs on
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "/app/target/CallDropAnalyzer-0.0.1-SNAPSHOT.jar"]


```

### docker-compose.yml
Voici un extrait du fichier docker-compose.yml pour orchestrer les conteneurs :

```yaml
version: '3.8'
services:
  mysqldb:
    image: mysql:8.0-debian
    environment:
      MYSQL_ALLOW_EMPTY_PASSWORD: 'yes'
      MYSQL_DATABASE: calldropanalyzer
    ports:
      - "3307:3306"
    volumes:
      - mysql-data:/var/lib/mysql

  app:
    build: .
    ports:
      - "8080:8080"
    depends_on:
      - mysqldb
    environment:
      SPRING_DATASOURCE_URL: jdbc:mysql://mysqldb:3306/calldropanalyzer
      SPRING_DATASOURCE_USERNAME: root
      SPRING_DATASOURCE_PASSWORD: password

volumes:
  mysql-data:
```


## Backend

### Technologies Utilisées
- *Java 21*
- *Spring Boot*
- *MySQL*
- *Docker*
- *IntelliJ IDEA*

## Structure du Projet Backend

1. *com.example.application*
   - Classe principale pour lancer l'application Spring Boot.

2. *com.example.controller*
   - Gère les requêtes HTTP REST pour différentes fonctionnalités.

3. *com.example.model*
   - Contient les entités représentant les tables de la base de données.

4. *com.example.repository*
   - Fournit des interfaces pour les opérations CRUD sur les entités.

5. *com.example.service*
   - Contient la logique métier du projet.

## Démarrage

### Prérequis
1. *Git* : Installez [Git](https://git-scm.com/).
2. *Docker* : Installez [Docker Desktop](https://www.docker.com/products/docker-desktop/).
3. *Java 21* : Installez [OpenJDK 21](https://jdk.java.net/21/).
4. *Maven* : Installez Apache Maven.
5. *MySQL* : Activez votre serveur MySQL via Docker ou XAMPP.

### Instructions

1. Clonez le projet :
 
Voici les commandes Bash pour cloner le dépôt et accéder au répertoire du projet :

```bash
git clone <repository_url>
cd CallDropAnalyzer
```

   

2. Construisez et démarrez les conteneurs Docker :
 
Voici la commande Bash pour construire et démarrer les conteneurs avec Docker Compose :

```bash
docker-compose up --build
```
   

3. Accédez à l'application :

   - Backend : [http://localhost:8080](http://localhost:8080)


4. Assurez-vous que la base de données est correctement configurée dans application.properties.
## Video Demonstration


https://github.com/user-attachments/assets/c62bd298-2440-4236-b06f-bf2db63f99cb


## Test avec Docker


https://github.com/user-attachments/assets/248cc382-ab2d-40b9-9e92-6f6bf65f719b


## Utilisation

Une fois l'application lancée :
1. Chargez les données d'appels via les endpoints REST.
2. Analysez les rapports générés pour identifier les zones problématiques.
3. Exportez les rapports pour les opérateurs télécoms.

## Auteurs
- *[ABDERRAZAK Kawtar]* ([GitHub](https://github.com/kawtarabderrazak))
- *[GRIMA Fatimazahra]* ([GitHub](https://github.com/fatimazahraGrima))

