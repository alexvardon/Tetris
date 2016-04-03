package GUI_Tetris;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Plateau extends JPanel
{
   /**
    * 
    */
   private static final long serialVersionUID = 1L;

   private JPanel[][] plateau;

   
   private static Color[] colorTetrimino; // On cree notre tableau de couleur (couleur des differents Tetrimino en jeu)
   
   public Plateau()
   {        
      GridLayout layout = new GridLayout(20, 10);      
      setLayout(layout);

      plateau = new JPanel[20][10];
      initializePlateau();
      addPlateau();

      // Definition des couleurs de Tetriminos
      colorTetrimino = new Color[7];
      colorTetrimino[0] = Color.ORANGE; //Couleur du tetrimino I
      colorTetrimino[1] = Color.WHITE; // Couleur du Tetrimino J
      colorTetrimino[2] = Color.GREEN; // Couleur du Tetrimino L
      colorTetrimino[3] = Color.MAGENTA; // Couleur du Tetrimino O
      colorTetrimino[4] = Color.ORANGE; // Couleur du Tetrimino S
      colorTetrimino[5] = Color.BLUE; // Couleur du Tetrimino T
      colorTetrimino[6] = Color.PINK; //Couleur du Tetrimino Z
   }

   
   /** AJOUT DU PLATEAU DE JEU **/
   private void addPlateau()
   {
      for (int i = 0; i < 20; i++)
      {
         for (int j = 0; j < 10; j++)
         {
            add(plateau[i][j]);
         }
      }
   }
   
   
   
  /** INITIALISATION DU PLATEAU DE JEU **/
   private void initializePlateau()
   {
      for (int i = 0; i < 20; i++)
      {
         for (int j = 0; j < 10; j++)
         {
        	//On parcours notre tableau (plateau) et on l'initialise avec des Panels
            plateau[i][j] = new JPanel() {
				private static final long serialVersionUID = 1L;

				@Override
            	public Dimension getPreferredSize(){
            		return new Dimension(45, 45); // Definition de la taille des cases
            	}
            };
            plateau[i][j].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY)); // Definition de la couleur des bords des cases (delimiteur)
         }
      }
   }

   
   
   /** METHODE QUI COLORE LE TABLEAU DE BASE (FOND) **/
   public void uncolorPlateauPanelSq(int x, int y) {
        this.plateau[x][y].setBackground(Color.BLACK); // On met le fond du tableau de base en noir (permet de ressortir mieux la couleur des pieces)
   }

   
   /** METHODE QUI COLORE LES CASES DU TABLEAU **/
   public void colorPlateauPanelSq(int x, int y, int caseTab){
        this.plateau[x][y].setBackground(colorTetrimino[caseTab]); // On met un fond dans la case correspondant à la couleur de la piece
   }
   
   

   /** ON RECUPERE NOTRE TABLEAU DE COULEUR (COULEUR DES TETRIMINOS) **/
   public static Color[] colors(){
	   return colorTetrimino;
   }
}