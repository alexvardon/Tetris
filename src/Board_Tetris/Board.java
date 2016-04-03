package Board_Tetris;

import java.util.ArrayList;

import Tetrimino.*;

public class Board {
	private ArrayList<Tetrimino> tetriminoSurPlateau; //Liste des tetriminos sur le plateau
	private Tetrimino tetriminoCourant; // Tetrimino courant (actuellement en deplacement)
	private static boolean[][] xRay; //Tableau permettant de verifier les positions possibles de pieces pour bouger
	private ArrayList<Block> stopBlocks; //Liste des blocks stoppés

	private ArrayList<Block> uniqueY0;
	private ArrayList<Block> uniqueY1;
	private ArrayList<Block> uniqueY2;
	private ArrayList<Block> uniqueY3;

	private int x;
	private int y;

	private int currentPos; //Position courrante

	public Board() {
		tetriminoSurPlateau = new ArrayList<Tetrimino>();  //On cree a liste des tetrmino sur le plateau
		tetriminoCourant = new Tetrimino(); //On cree le Tetrimino courant 
		xRay = new boolean[20][10]; // On cree le plateau de jeu
		stopBlocks = new ArrayList<Block>(); // On cree la liste des blocks arretés
		x = 0; // On initialise la position x à 0
		y = 0; //On initialise la position y à 0
		currentPos = 0; // On initilalise la position courante du tetrimino à 0

		//On cree les tableau de blocks
		uniqueY0 = new ArrayList<Block>();
		uniqueY1 = new ArrayList<Block>();
		uniqueY2 = new ArrayList<Block>();
		uniqueY3 = new ArrayList<Block>();

		//On parcours notre plateau de jeu en disant que toute les cases sont faussses (non occupées)
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 10; j++) {
				xRay[i][j] = false; //les cases ne sont pas occupées
			}
		}
	}

	/** METHODE QUI PERMET DE RAJOUTER UN TETRIMINO SUR LE PLATEAU DE JEU **/
	public void addTetrimino(Tetrimino tetrimino) {
		this.tetriminoCourant = tetrimino; //Le tetrimino crée est considéré comme le tetrmino courant
		tetriminoSurPlateau.add(tetrimino); //On rajoute le tetrmino crée sur le plateau de jeu

		//On en inform le xRay
		for (int i = 0; i < 4; i++) {
			xRay[tetrimino.getBlockY(i)][tetrimino.getBlockX(i)] = true;
		}
	}

	/** METHODE DU XRAY (TABLEAU DE BOOLEAN DISANT SI LES CASES SONT OCCUPEES PAR DES BLOCKS) **/
	public static boolean xRay(int Y, int X) {
		return xRay[Y][X]; //On retrourne le xRay
	}


	/** METHODE QUI PERMET DE RECUPERER LE TETRIMINO COURANT **/
	public Tetrimino getTetriminoCourant() {
		return this.tetriminoCourant; // On retroune le tetrimino courant
	}

	/** METHODE QUI PERMET DE RECUPERER LE TETRIMINO VIA L'INDEX DU TABLEAU **/
	public Tetrimino getTetriminoFromIndex(int index) {
		return tetriminoSurPlateau.get(index); //On retrounre le tetrimino
	}

	
	public int nrOfTetriminos() {
		return tetriminoSurPlateau.size();
	}

	/** METHODE QUI PERMET DE FAIRE DESCENDRE LE TETRIMINO COURANT **/
	public void tetriminoCourantDown() {
		//On recupère les coordonnées actuelles du tetrimino et on le retire du xRay
		for (int i = 0; i < 4; i++) {
			xRay[this.tetriminoCourant.getBlockY(i)][this.tetriminoCourant
					.getBlockX(i)] = false; // On supprime la position actuelle du tetrimino sur le xRay
		}

		//On fixe les nouvelles coordonnées du tetrimino
		for (int j = 0; j < 4; j++) {
			currentPos = this.tetriminoCourant.getBlockY(j);
			this.tetriminoCourant.setBlockY(currentPos + 1, j);
		}

		
		//On informe le xRay de la nouvelle position du tetrimino
		for (int i = 0; i < 4; i++) {
			xRay[this.tetriminoCourant.getBlockY(i)][this.tetriminoCourant
					.getBlockX(i)] = true;
		}
	}

	public void tetriminoCourantLeft() {
		//On recupère les coordonnées actuelles du tetrimino et on le retire du xRay
		for (int i = 0; i < 4; i++) {
			xRay[this.tetriminoCourant.getBlockY(i)][this.tetriminoCourant
					.getBlockX(i)] = false; // On supprime la position actuelle du tetrimino sur le xRay
		}

		//On fixe les nouvelles coordonnées du tetrimino
		for (int j = 0; j < 4; j++) {
			currentPos = this.tetriminoCourant.getBlockX(j);
			this.tetriminoCourant.setBlockX(currentPos - 1, j);
		}

		//On informe le xRay de la nouvelle position du tetrimino
		for (int i = 0; i < 4; i++) {
			xRay[this.tetriminoCourant.getBlockY(i)][this.tetriminoCourant
					.getBlockX(i)] = true; // On ajoute la position actuelle du tetrimino sur le xRay
		}
	}

	public void tetriminoCourantRight() {
		//On recupère les coordonnées actuelles du tetrimino et on le retire du xRay
		for (int i = 0; i < 4; i++) {
			xRay[this.tetriminoCourant.getBlockY(i)][this.tetriminoCourant
					.getBlockX(i)] = false; // On supprime la position actuelle du tetrimino sur le xRay
		}

		//On fixe les nouvelles coordonnées du tetrimino
		for (int j = 0; j < 4; j++) {
			currentPos = this.tetriminoCourant.getBlockX(j);
			this.tetriminoCourant.setBlockX(currentPos + 1, j);
		}

		//On informe le xRay de la nouvelle position du tetrimino
		for (int i = 0; i < 4; i++) {
			xRay[this.tetriminoCourant.getBlockY(i)][this.tetriminoCourant
					.getBlockX(i)] = true; // On ajoute la position actuelle du tetrimino sur le xRay
		}
	}

	/** METHODE QUI PERMET AU TETRIMINO DE NE PAS ALLER PLUS A GAUCHE **/
	public boolean tetriminoCourantMustStopLeft() {
		return FreshStopSides.mustStopL(true, stopBlocks, uniqueY0, uniqueY1,
				uniqueY2, uniqueY3, xRay, tetriminoCourant, x, y);
	}
	
	/** METHODE QUI PERMET AU TETRIMINO DE NE PAS ALLER PLUS A DROITE **/
	public boolean tetriminoCourantMustStopRight() {
		return FreshStopSides.mustStopL(false, stopBlocks, uniqueY0, uniqueY1,
				uniqueY2, uniqueY3, xRay, tetriminoCourant, x, y);

	}

	/** METHODE QUI PERMET AU TETRIMINO DE NE PAS ALLER PLUS EN BAS**/
	public boolean tetriminoCourantMustStopDown() {
		return FreshStopDown.mustStopDown(stopBlocks, uniqueY0, uniqueY1,
				uniqueY2, uniqueY3, xRay, tetriminoCourant, x, y);
	}

	
	/** METHODE QUI PERMET DE RECUPERER LE TABLEAU XRAY **/
	public static boolean[][] getxRay() {
		return xRay; //On retroune le tableau xRay
	}

	/** METHODE QUI SUPPRIME DES LIGNES S'IL LE FAUT **/
	public void cleanLinesIfNeeded() {
		SuppressionLignes.suppressionLignes(this);
	}

	
	/** METHODE QUI PERMET DE RETOURNER LE TABLEAU DE TETRIMINO SUR LE PLATEAU **/
	public ArrayList<Tetrimino> getTetriminoSurPlateau() {
		return this.tetriminoSurPlateau;
	}

	/** METHODE QUI PERMET DE DESCENDRE LES BLOCKS SUITE A LA SUPPRESSION DE LIGNES **/
	public void putDownBlocksIfNeeded() {
		SuppressionLignes.putDownBlocksIfNeeded(this);
	}
	
	
	/** METHODE QUIPERMET DE RAFRAICHIR LE TABLEAU XRAY **/
	public void refreshX_Ray(){
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 10; j++) {
				xRay[i][j] = false; //On passe toutes les case à false (non occupées)
			}
		}
		
		for (int i = 0; i < tetriminoSurPlateau.size(); i++) {
			for (int j = 0; j < tetriminoSurPlateau.get(i).getNrOfBlocks(); j++) {
				xRay[tetriminoSurPlateau.get(i).getBlockY(j)][tetriminoSurPlateau.get(i).getBlockX(j)] = true;
				//On met à true les positions des blocks du tableau des pieces sur le plateau
			}
		}
	}
	
	
	/** METHODE QUI PERMET DE VERIFIER SI LA PARTIE EST FINI **/
	public boolean verifyWin(){
		for (int i = 0; i < tetriminoSurPlateau.size(); i++) { //On parcours notre plateau
			if(!tetriminoSurPlateau.get(i).isEqualTo(tetriminoCourant)){ //Si il y a supperposition d'un block courant et d'un block d'une piece sur le plateau
				for (int j = 0; j < tetriminoSurPlateau.get(i).getNrOfBlocks(); j++) {
					if(tetriminoSurPlateau.get(i).getBlockY(j) == 0){
						return true; //On retroune true (partie finie)
					}
				}
			}
		}
		
		return false; //Sinon on retroune false (la partie continue)
	}
}