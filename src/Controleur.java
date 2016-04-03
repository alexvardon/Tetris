import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import Board_Tetris.Board;
import Board_Tetris.SuppressionLignes;
import DonneesDeJeu.DonneesDeJeu;
import DonneesDeJeu.GenerateurDeTetrimino;
import GUI_Tetris.FenetreTetris;
import Tetrimino.Tetrimino;

public class Controleur {
	private FenetreTetris FT; // Fenetre du jeu
	private Board BD; // Plateau du jeu
	private DonneesDeJeu DJ; //Donnees de jeu
	private boolean perdu; // Flag du jeu permettant de voir si on a perdu la partie
	private GenerateurDeTetrimino tetrimino; // Generatuer de piece (la piece creee en question)

	private Tetrimino[] deuxTetriminos; // Tableau de deux tetriminos (l'actuel et le suivant)
	
	private int coordXTetriminoGener; // Coordonnees en X du tetrimino
	private int coordYTetriminoGener; // Coordonnees en Y du tetrimino
	private int textureTetriminoGener; // Texture du tetrimino

	private long nowTime;
	private long nexTime;

	private KeyListener keyListener;
	private int keyCode;
	
	public Controleur() {
		this.FT = new FenetreTetris();
		this.BD = new Board();
		this.perdu = false;
		this.tetrimino = new GenerateurDeTetrimino();

		deuxTetriminos = new Tetrimino[2];

		DJ = new DonneesDeJeu();

		deuxTetriminos[0] = tetrimino.giveRandomTetrimino();
		deuxTetriminos[1] = tetrimino.giveRandomTetrimino();

		// Ajout d'une nouvelle piece sur le plateau
		BD.addTetrimino(deuxTetriminos[1]);
		displayBoard(); // On "rafraichi" le tableau


		
		
		
		keyListener = new KeyListener(){ // KEY LISTENERS

			
			
			/** LES DIFFERENTES TOUCHES DU JEU **/
			@Override
			public void keyPressed(KeyEvent e){
				
				keyCode = e.getKeyCode();
				
				//Si on appuie sur la fleche de gauche
				if(keyCode == KeyEvent.VK_LEFT){
					if (!BD.tetriminoCourantMustStopLeft()) { //Si on peut aller � gacuhe
						BD.tetriminoCourantLeft(); // On va � gauche
						displayBoard(); // On "rafraichi" le tableau
					}
				}
				
				//Si on appuie sur la fleche de droite
				if(keyCode == KeyEvent.VK_RIGHT){
					if (!BD.tetriminoCourantMustStopRight()) { // Si on peut aller � droite
						BD.tetriminoCourantRight(); // On va � droite
						displayBoard(); // On "rafraichi" le tableau
					}
				}
				
				//Si on appuie sur la fleche du bas
				if(keyCode == KeyEvent.VK_DOWN){
					if (!BD.tetriminoCourantMustStopDown()) { // Si on peux aller vers le bas
						BD.tetriminoCourantDown(); // On va en bas
						displayBoard(); // On "rafraichi" le tableau
					}
				}
				
				//Si on appuie sur la touche MAJ
				if(keyCode == KeyEvent.VK_SHIFT){ 
					while (!BD.tetriminoCourantMustStopDown()) { //Si on peut aller en bas
						BD.tetriminoCourantDown(); //On va en bas
					}
					displayBoard(); // On "rafraichi" le tableau � la fin (quand il peut pas aller plus bas)
				}
				
				//Si on apuie sur la touche BARRE ESPACE
				if(keyCode == KeyEvent.VK_SPACE){
					BD.getTetriminoCourant().rotation(Board.getxRay()); // On tourne la piece
					displayBoard(); // On "rafraichi" le tableau 
				}
				e.consume();
			}

			@Override
			public void keyReleased(KeyEvent arg0) {}

			@Override
			public void keyTyped(KeyEvent arg0) {}
			
		};
		
		FT.addKeyListener(keyListener); // On rajoute notre evenement keyListnener
		

		/** TIMER DU JEU **/
		nowTime = 0;
		nexTime = 0;

		
		// On initilaise les diff�rents parametres du tetrimino cr��
		////////////////////////////////////////////////////////////////////////
		coordXTetriminoGener = 0;
		coordYTetriminoGener = 0;
		textureTetriminoGener = 0;
		////////////////////////////////////////////////////////////////////////

		
		
		while (perdu == false) // Boucle du jeu (temps que le joueur n'a pas perdu)
		{
			nowTime = System.currentTimeMillis();

			while (nexTime - DJ.getMiliseconds() < nowTime) {
				nexTime = System.currentTimeMillis();
			}

			if (!BD.tetriminoCourantMustStopDown()) { // Si le tetrimino peut continuer de descendre
				BD.tetriminoCourantDown(); // Le tetrimino descend
			} else {
				BD.cleanLinesIfNeeded(); // Supprime la ligne si elle est pleine
				BD.putDownBlocksIfNeeded(); // On descend les blocks de 1

				// Score de la partie
				if (SuppressionLignes.getScoreNr() > 0) { // Si le nombre de lignes supprim�es est superieur � 0
					for (int i = 0; i < SuppressionLignes.getScoreNr(); i++) { //Pour le nombre de lignes supprim�es
						DJ.addPoints(); // On augmente le score
					}

					FT.getInfoPanel().getScorePanel().refreshScore(DJ.getPoints()); // On met � jour le score de la parite dans le panel correspondant
				}

				deuxTetriminos[1] = deuxTetriminos[0];
				deuxTetriminos[0] = tetrimino.giveRandomTetrimino();

				BD.addTetrimino(deuxTetriminos[1]);


				DJ.dataRefresh(); // On "rafraichi" les donn�es du jeu 

				
				
				//////////////////////////////////////////////////////////////////////////
				if (DJ.changedNiveau()) { //Si on change de niveau
					FT.getInfoPanel().getLevelPanel().setNiveau(DJ.getNiveau()); // On modifie le niveau de la partie
				}
				//////////////////////////////////////////////////////////////////////////

				
			}
			displayBoard();
			if (BD.verifyWin()) { // Si on a supperposition de deux blocks (courant et deja sur le plateau)
				perdu = true; // On considere que l'on a perdu)
				
				// On affiche une fenetre qui indique le score de la partie et le niveau atteint
				JOptionPane.showMessageDialog(FT, 
						"FINI \n Votre score est de : " + DJ.getPoints()
								+ "\n Vous avez atteint le niveau : " + DJ.getNiveau(), "",
						JOptionPane.PLAIN_MESSAGE);
			}
		}

	}

	/** METHODE QUI PERMET DE COLORER ET DECOLORER LES DIFFERNETES CASE DU TABLEAU **/
	private void displayBoard() {

		coordXTetriminoGener = 0;
		coordYTetriminoGener= 0;
		textureTetriminoGener = 0;

		for (int j = 0; j < BD.nrOfTetriminos(); j++) {
			for (int k = 0; k < BD.getTetriminoFromIndex(j).getNrOfBlocks(); k++) {
				coordXTetriminoGener = BD.getTetriminoFromIndex(j).getBlockX(k);
				coordYTetriminoGener = BD.getTetriminoFromIndex(j).getBlockY(k);
				textureTetriminoGener = BD.getTetriminoFromIndex(j).getBlockImg(k);

				FT.colorPlateau(coordYTetriminoGener, coordXTetriminoGener, textureTetriminoGener); // On colore la case qui correspond
			}
		}

		for (int i = 0; i < 20; i++) {
			for (int v = 0; v < 10; v++) {
				if (!Board.xRay(i, v)) { 
					FT.unColorPlateau(i, v);
				}
			}
		}

	}

}