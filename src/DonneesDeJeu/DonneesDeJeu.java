package DonneesDeJeu;

public class DonneesDeJeu {

	private static Score score; //Score de la partie
	private static Vitesse vitesse; // Vitesse de la partie
	private static Niveau niveau; // Niveau de la partie
	private static boolean changedScore; //changement du score

	
	public DonneesDeJeu() {
		score = new Score();
		vitesse = new Vitesse();
		niveau = new Niveau();
		changedScore = false;
	}

	
	/** METHODE QUI RAJOUTE DES POINTS AU SCORE **/
	public void addPoints() {
		score.addPoints();
		changedScore = false;
	}

	/** METHODE QUI PERMET DE RECUPERER LA VALEUR DU SCORE DE LA PARTIE **/
	public int getPoints() {
		return score.getScore();
	}

	
	/** METHODE QUI PERMET DE CHANGER DE NIVEAU **/
	public void dataRefresh() {
		niveauSup(50, 1); // niveau 2
		niveauSup(100, 2); // niveau 3
		niveauSup(150, 3); // niveau 4
		niveauSup(200, 4); // niveau 5
		niveauSup(250, 5); // niveau 6
		niveauSup(300, 6); // niveau 7
		niveauSup(350, 7); // niveau 8
		niveauSup(400, 8); // niveau 9
	}
	
	
	/** METHODE QUI PERMET D'AUGMENTER LE NIVEAU DE LA PARTIE **/
	public static void niveauSup(int points, int ancienNiveau){

		if (score.getScore() >= points && niveau.getNiveauVal() == ancienNiveau) {
			if (!changedScore) {
				niveau.niveauSuivant(); //On augmente la valeur du niveau
				vitesse.vitesseSuivante(); // On augmente la valuer de la vitesse en fonction du niveau
				changedScore = true; // On affecte un changent d'etat en ce qui concerne les donn�es
			}
		}
	}
	
	
	public long getMiliseconds(){
		return  vitesse.getVitesse();
	}
	
	public boolean changedNiveau(){
		return changedScore;
	}
	
	public String getNiveau(){
		return niveau.getNiveau();
	}
}