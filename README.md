[![forthebadge](https://forthebadge.com/images/badges/made-with-java.svg)](https://forthebadge.com)

# PROJ731---Compteur-de-mots  

## Description du projet  
L'objectif du projet est de compter les différentes occurences des mots présents dans un fichier texte. La map sera stockée dans un fichier texte pour une meilleure visualisation.


## Grandes étapes du projet  
* Découpage du texte, on va découper le texte en fonction du nombre de threads à créer et en fonction du nombre total de mots. 
* On associe ensuite chaque thread à chaque partie du texte, chaque thread va exécuter une fonction de mappage, qui comptera le nombre d'occurence de chaque mots.
* On obtient ainsi, pour chaque partie de texte le nombre d'occurence de chaque mots.
* Il faut ensuite additionner chaque partie afin d'avoir les occurences totales (phase de reduce) et écrire le résultat dans un fichier texte.

## Détail de la fonction Map  
On utilise une librairie de tokenizer, qui nous permet de parcourir l'ensemble du fichier en prenant les mots et sans prendre en compte les caractères spéciaux. Ainsi on parcours le fichier, si on reconnait un mot déjà présent dans la map, on incrémente la valeur. Si le mot n'est jamais apparu dans la map, on l'ajoute. On applique cette fonction pour chaque thread.

