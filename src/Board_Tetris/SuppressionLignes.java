package Board_Tetris;

public class SuppressionLignes {
	private static int elemNr;
	private static int[] supprLignes;
	private static int indexLigneSuppr;
	private static boolean[][] xRayPointer;
	private static int y;

	private static int scored;

	public static int[] giveSupprLignes() {
		return supprLignes;
	}

	
	public static void suppressionLignes(Board board) {
		elemNr = 0;
		supprLignes = new int[4];
		supprLignes[0] = 100;
		supprLignes[1] = 100;
		supprLignes[2] = 100;
		supprLignes[3] = 100;
		indexLigneSuppr = 0;
		xRayPointer = Board.getxRay();

		scored = 0;

		for (int i = 0; i < 20; i++) { //Parcours des lignes du tableau
			for (elemNr = 0; elemNr < 10; elemNr++) { // Parcours des colonnes du tableau
				if (xRayPointer[i][elemNr] == false) { // Si une ligne est vide				
					elemNr = 100; //On place notre marqueur elemNr à 100 et on quitte la boucle
				}

			}

			if (elemNr == 10) { // Si tous les elements d'une même ligne sont true (ligne complétée)
				supprLignes[indexLigneSuppr] = i; // On stocke dans notre tableau l'index de la ligne à supprimer
				indexLigneSuppr++; // On passe à la ligne suivante
				scored++; // On augmente le score
			}
		}

		// Suppression des blocks et ajustement du tableau xRay
		for (int i = 0; i < 4; i++) {
			if (supprLignes[i] != 100) { // Si la ligne est a supprimer
				deleteBlocks(supprLignes[i], board); // On supprime la ligne du tableau de jeu
				for (int j = 0; j < 10; j++) {
					Board.getxRay()[supprLignes[i]][j] = false; // On rend la case associé au xRay innoccupée
				}
			}
		}

		//Suppreision de tetrimino si la piece n'existe plus su le plateau (plus de blocks associés)
		for (int i = 0; i < board.getTetriminoSurPlateau().size(); i++) { // On parcours le tableau de tetrimino sur le plateau
			if (board.getTetriminoSurPlateau().get(i).getNrOfBlocks() == 0) { // Si il n'y a plus de blocks associés au tetrimino
				board.getTetriminoSurPlateau().remove(i); //On supprime le tetrimino du tableau des tetriminos sur le plateau de jeu
				i--; 
			}
		}

	}

	
	/** METHODE QU PERMET DE SUPPRIMER LES BLOCKS **/
	public static void deleteBlocks(int ligneSuppr, Board board) {
		y = ligneSuppr; //

		for (int i = 0; i < board.getTetriminoSurPlateau().size(); i++) { //On parcours l'ensemble des tetriminos sur le plateau
			for (int j = 0; j < board.getTetriminoSurPlateau().get(i).getNrOfBlocks(); j++) { // On arcours les blocks des tetriminos
				if (y == board.getTetriminoSurPlateau().get(i).getBlock(j).getPosY()) { // Si le block a la même coordonnées y que la ligne à supprimer
					board.getTetriminoSurPlateau().get(i).removeBlock(j); // On supprime ce block
					j = -1;
				}
			}
		}
	}
	
	
	/** METHODE QUI PERMET DE DESCENDRE LES BLOCKS LORS DE LA SUPPRESSION **/
	public static void putDownBlocksIfNeeded(Board board) {
		for (int i = 0; i < 4; i++) {
			if (supprLignes[i] != 100) {
				for (int j = 0; j < board.getTetriminoSurPlateau().size(); j++) { // On parcours l'ensemble des tetrminos sur le plateau
					for (int j2 = 0; j2 < board.getTetriminoSurPlateau().get(j).getNrOfBlocks(); j2++) { // On parcours les blocks du tetrimino en question
						
						int positionActuelleYBlock = board.getTetriminoSurPlateau().get(j).getBlock(j2).getPosY();

						if (positionActuelleYBlock < supprLignes[i]) {// On augmente la position de chaque blocks plus grand que la position de la ligne supprimée
							board.getTetriminoSurPlateau().get(j).getBlock(j2).setPosY((positionActuelleYBlock + 1));
						}
					}
				}

				board.refreshX_Ray();
			}

		}
	}

	
	/** METHODE QUI PERMET DE RETOURNER LE SCORE **/
	public static int getScoreNr() {
		return scored;
	}
}