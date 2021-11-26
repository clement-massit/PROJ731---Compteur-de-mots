# PROJ731---Compteur-de-mots  

## Description du projet  
L'objectif du projet est de compter les différentes occurences des mots présents dans un fichier texte. 


## Grandes étapes du projet  
1. Découpage du texte, on va découper le texte en fonction du nombre de threads à créer et en fonction du nombre total de mots. 
2. On associe ensuite chaque thread à chaque partie du texte, chaque thread va exécuter une fonction de mappage, qui comptera le nombre d'occurence de chaque mots.
3. On obtient ainsi, pour chaque partie de texte le nombre d'occurence de chaque mots.
4. Il faut ensuite additionner chaque partie afin d'avoir les occurences totales (phase de reduce) et écrire le résultat dans un fichier texte.

## 


