# Gestion des commandes — projet Scala

Petit exercice d'introduction à Scala et à la programmation fonctionnelle. Les fonctions sont dans le package `commandes`.

## Prérequis et installation

1. **Installer un JDK** compatible avec la version de Scala utilisée (JDK 8 ou plus récent recommandé). Téléchargez un JDK depuis [Eclipse Adoptium](https://adoptium.net/) et vérifiez l'installation dans un terminal avec `java -version`.
2. **Installer sbt** en suivant les instructions officielles pour votre système : [scala-sbt.org/download](https://www.scala-sbt.org/download.html). Vérifiez avec `sbt --version`.
3. **Installer Visual Studio Code** depuis [code.visualstudio.com](https://code.visualstudio.com/).
4. Dans VS Code, ouvrez l'onglet Extensions, recherchez **Scala (Metals)** et installez l'extension. Ouvrez ensuite le dossier du projet et acceptez l'importation du projet sbt proposée par Metals.

## Lancer les tests

À la racine du projet, dans un terminal :

```bash
sbt test
```

Les tests couvrent le calcul d'une commande vide ou avec plusieurs articles, les taux de réduction 0, 0,5 et 1, les taux invalides, ainsi que les codes de réduction valides, inconnus ou absents.

## Règle de validation des réductions

`applyDiscount` accepte uniquement un taux compris entre 0 et 1 inclus. Sinon, la fonction lève une `IllegalArgumentException` avec un message explicite. La réduction crée une nouvelle commande et de nouveaux articles ; la commande d'origine reste inchangée.

## Éléments à soumettre

Soumettez le dossier complet du projet (ou son archive ZIP), notamment `build.sbt`, `project/build.properties`, les sources Scala de `src/main` et `src/test`, ainsi que ce `README.md`. Joignez si demandé une preuve de l'exécution réussie de `sbt test`.
