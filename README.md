⚽ Mini Football Management System
Ce projet est une application Java utilisant JDBC pour gérer une base de données de football (équipes et joueurs) stockée sur PostgreSQL. Il démontre la gestion de la persistance, le mapping objet-relationnel (ORM) manuel et la gestion des exceptions personnalisées.

 Prérequis
Java JDK (version 17 ou plus)

PostgreSQL (installé et configuré sur le port 5433)

Pilote JDBC PostgreSQL (inclus via Maven ou ajouté au classpath)

 Configuration de la Base de Données
Connectez-vous à votre instance PostgreSQL :

Bash

psql -U postgres -p 5433
Exécutez les scripts suivants pour préparer l'environnement :

SQL

-- 1. Création de la base
CREATE DATABASE mini_football_db;
\c mini_football_db;

-- 2. Création de l'utilisateur dédié
CREATE USER mini_football_db_manager WITH PASSWORD 'password123';
GRANT ALL PRIVILEGES ON DATABASE mini_football_db TO mini_football_db_manager;

-- 3. Création des types ENUM
CREATE TYPE continent_enum AS ENUM ('AFRICA', 'EUROPA', 'ASIA', 'AMERICA');
CREATE TYPE position_enum AS ENUM ('GK', 'DEF', 'MIDF', 'STR');

-- 4. Création des tables
CREATE TABLE team (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    continent continent_enum
);

CREATE TABLE player (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    age INT,
    position position_enum,
    id_team INT REFERENCES team(id)
);

-- 5. Attribution des droits
GRANT ALL ON ALL TABLES IN SCHEMA public TO mini_football_db_manager;
GRANT ALL ON ALL SEQUENCES IN SCHEMA public TO mini_football_db_manager;
 Lancement de l'Application
Vérifiez la configuration de la connexion dans la classe DBConnection.java :

URL : jdbc:postgresql://localhost:5433/mini_football_db

User : mini_football_db_manager

Password : password123

Exécutez la classe Main.java.

 Tests effectués
Le programme exécute deux tests majeurs :

1. Récupération et calcul (Question 4.1)
Récupération d'une équipe par son ID.

Calcul du total des buts des joueurs.

Gestion d'exception : Si un joueur possède un nombre de buts NULL, une RuntimeException est levée et interceptée avec un message explicatif.

2. Sauvegarde et Mise à jour (Question 4.2)
Insertion : Si l'équipe n'existe pas (ex: FC Porto), elle est créée.

Update : Si l'équipe existe déjà, son nom est mis à jour (ex: "FC Porto Officiel").

 Structure du projet
Le projet est organisé selon une structure Maven standard :

src/main/java/org.example :

Main : Point d'entrée de l'application gérant les tests de flux.

DataRetriever : Classe responsable de l'extraction et de la manipulation des données (DAO).

DBConnection : Gestionnaire de connexion Singleton pour la base de données.

Team & Player : Classes modèles (POJO) représentant les entités du système.

src/main/resources :

db.sql : Contient les scripts d'initialisation de la base de données et des utilisateurs.

schema.sql : Définit la structure des tables (team, player) et les types ENUM.

DBConnection.java : Gestionnaire de connexion Singleton.

Main.java : Point d'entrée pour les tests.
