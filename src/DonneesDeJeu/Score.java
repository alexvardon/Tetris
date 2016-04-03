package DonneesDeJeu;

public class Score {

	private int score; //Score de la partie

	public Score() {
		score = 0; // On initialise le score initiale � 0
	}

	/** METHODE QUI AJOUTE DES POINTS AU SCORE DU JOUEUR **/
	public void addPoints() {
		this.score += 10;  // On rajoute 10 points
	}

	/** METHODE QUI PERMET DE RECUPERER LE SCORE DU JOUEUR **/
	public int getScore() {
		return this.score;
	}
}