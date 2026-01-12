 Présentation
 
Ce dépôt constitue l'archive finale de l'examen partiel 1 réalisé pour l'unité PROG3. Suite à la présentation de l'épreuve pratique et orale en classe, ce travail est conservé ici comme version de référence soumise pour évaluation, témoignant de la mise en œuvre des compétences en Java JDBC et en gestion de bases de données relationnelles.

 Organisation du Code
 
Le projet est structuré pour répondre aux exigences techniques de l'examen :

DataRetriever.java : Centralise la logique d'accès aux données et les requêtes SQL (CRUD).

schema.sql : Documente l'intégralité du cycle de vie de la base de données, incluant la création, la migration et l'initialisation.

Main.java : Point d'entrée exécutant les tests de robustesse et la validation de la gestion des exceptions.

 Évolution du Schéma (DDL)
Ce projet démontre la capacité à faire évoluer une base de données existante sans perte de données, une compétence clé validée lors de cet examen :

Structure Initiale : Création des tables Team et Player.

Migration : Ajout de la colonne de statistiques goal_nb via la commande ALTER TABLE pour répondre aux nouveaux besoins métiers formulés durant l'épreuve.

 Scénarios de Test
Les données de test ont été configurées pour valider la gestion des types optionnels (NULL) en Java :

Cas standards : Calcul des buts pour les joueurs Thibaut Courtois (0), Dani Carvajal (2) et Jude Bellingham (5).

Cas d'exception : Gestion des valeurs manquantes pour Lewandowski et Griezmann, déclenchant une RuntimeException personnalisée comme attendu dans le sujet.

 Configuration Technique
Base de données : mini_football_db; PostgreSQL (Port 5433).

Utilisateur : football_manager.

mot de passe : password123 .

Dépôt distant :https://github.com/Ben0992002/Exam1PROG3janvier2026.git.

Rappel des commandes Git pour la soumission finale :
git add .

git commit -m "Examen Partiel 1 - PROG3 session janvier 2026"

git push -u origin master.
