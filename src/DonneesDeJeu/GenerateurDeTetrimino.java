package DonneesDeJeu;

import java.util.Random;

import Tetrimino.Tetrimino_I;
import Tetrimino.Tetrimino_J;
import Tetrimino.Tetrimino_L;
import Tetrimino.Tetrimino_O;
import Tetrimino.Tetrimino_S;
import Tetrimino.Tetrimino_T;
import Tetrimino.Tetrimino_Z;
import Tetrimino.Tetrimino;

public class GenerateurDeTetrimino
{
   private int[] numbers; // Tableau d'entier qui correspond � des Tetriminos
   private Random random; // Nombre aleatoir
   private int index; // L'index 
   private int nombre;

   
   public GenerateurDeTetrimino()
   {
      numbers = new int[7]; // On cree notre tableau d'entier de 7 case (chaque case correspond � une piece)
      random = new Random(); // On choisi un nombre au hasard
      index = 0; // On fixe notre index � 0
      nombre = 0; // On fixe notre nombre � 0

      tabRandomValeur();

   }

   
   /** METHODE QUI PERMET DE REMPLIR LE TABLEAU DE NOMBRE ALEATOIRS **/
   public void tabRandomValeur() {
	   
      nettoyage(); // On "nettoie" notre tableau
      index = 0; // On reprend de 0 (l'index est de nouveau � 0)

      // On parcours notre tableau de nombres random
      for (int i = 0; i < 6; i++)
      {
         nombre = random.nextInt(7); // On dit que nmb est un nombre au hasard compris entre 0 et 7 (7 exclu)

         while (valeurDejaPresente(nombre)) //Temps que le nombre est deja sorti et stock� dans le tableau
         {
            nombre = random.nextInt(7); // On relance le nombre aleatoire afin de remplir notre tableau par toutes les valeurs de piece
         }

         numbers[i] = nombre; // On stock le nombre pris dans la case du tableau d'index i
      }
   }

   
   /** METHOD QUI VERIFIE SI UN TABLEAU POSSEDE DEJA UN NOMBRE IDENTIQUE DEDANS **/
   public boolean valeurDejaPresente(int numero)
   {
      for (int i = 0; i < numbers.length; i++) //On parcours notre tableau de numbers
      {
         if (numero == numbers[i]) // Si le numero est le m�me que la case du tableau d'index i
         {
            return true; //On retourne "TRUE"
         }
      }

      return false; //Sinon on retorun "FALSE"
   }

   
   /** METHODE QUI PERMET DE NETTOYER NOTRE TABLEAU DE NOMBRE ALEATOIRS **/
   public void nettoyage() {
      for (int i = 0; i < 6; i++){
         numbers[i] = -1;
      }
   }

   
   
   /** METHODE QUI PERMET D'ATTRIBUER UN TETRIMINO AU NNUMERO CHOISI AU HASARD DANS LE TABLEAU **/
   public Tetrimino giveRandomTetrimino()
   {
      if (index > 6)
      {
         tabRandomValeur();
      }

      nombre = numbers[index];
      index++;

      if (nombre == 0)
      {
         return new Tetrimino_I();
      }
      if (nombre == 1)
      {
         return new Tetrimino_J();
      }
      if (nombre == 2)
      {
         return new Tetrimino_L();
      }
      if (nombre == 3)
      {
         return new Tetrimino_O();
      }
      if (nombre == 4)
      {
         return new Tetrimino_S();
      }
      if (nombre == 5)
      {
         return new Tetrimino_T();
      }
      if (nombre == 6)
      {
         return new Tetrimino_Z();
      }

      return null;
   }

}