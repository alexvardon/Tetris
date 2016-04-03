# PROJET TETRIS

#### Groupe :
+ Alexandre MARTINI (TCSI1)
+ Sylvain TORCHIN (TCSI1)
+ Alexandre VARDON (TCSI1)

Commande pour builder le projet : ``` mvn package ```

#### Les features faites :
* Le joueur peut déplacer les pièces du tetris.
* Generation des pièces de façon aléatoire
* Affichage du score et du niveau du joueur
* Au bout d'un certain nombre de points, le niveau augmente

#### Comment jouer au Tetris :
* Règles :
Tetris met le joueur au défi de réaliser des lignes complètes en déplaçant des pièces de formes différentes,
les tétriminos, qui défilent depuis le haut jusqu'au bas de l'écran.
Les lignes complétées disparaissent tout en rapportant des points et le joueur peut de nouveau remplir les cases libérées.
Le jeu n'a pas de fin : le joueur perd la partie lorsqu'un tétrimino reste bloqué en haut.
Il doit donc résister le plus longtemps à la chute continue des tétriminos, afin de réaliser le meilleur score.

* Commande :

  | Description                              |  Commande                    |
  | ---------------------------------------- |:----------------------------:|
  | Bouger le tetrimino actif vers la gauche | ```<-``` (flèche de gauche)  |
  | Bouger le tetrimino actif vers la droite | ```->``` (flèche de droite)  |
  | Faire tourner le tetrimino               | ```[SPACE]``` (barre espace) |
  | Faire tomber le tetrimino en bas         | ```[MAJ]``` (touche maj)     |

#### L'architecture :
En ce qui concene l'architecture de notre Tetris, nous sommes partis sur du MVC (Modèle Vue Controleur) car ce style architectural est adapté à des programmes "interactifs" comme les jeux.

Design Pattern et SOLID :
Nous utilisons pour notre Tetris des singleton afin davoir une seule et unique instance de notre tableau de jeu.
Nous utilisons aussi une interface qui nous a permis de dÈinir le contrat des diffÈrentes classe de Tetrimino.


!!! IMPORTANT !!!
Nous n'avons qu'un seul et unique depot sur notre Git car nous n'avons pas travaillé avec cet outil mais avec quelque chose qui nous est propre.
Comme l'indique les consignes, nous vous avons donc envoyé le lien vers ce repository avec ce qu'on pourrait appeler le "produit final".
Malheureusement, nous ne retrouvons pas dessus les précédents commit de mes camarades et de moi même.
