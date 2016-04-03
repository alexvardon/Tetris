package DonneesDeJeu;

public class Vitesse {

	private long[] gears; // On cree notre tableau qui contient les valeurs des differentes vitesses du jeu
	private int vitesse; // On cree la vitesse actuelle
	
	public Vitesse(){
		gears = new long[10];
		vitesse = 1;
		
		// On initilaise notre tableau avec les diff�rentes valeur de vitesse
		gears[1] = 1000L;
		gears[2] = 900L;
		gears[3] = 800L;
		gears[4] = 700L;
		gears[5] = 600L;
		gears[6] = 500L;
		gears[7] = 250L;
		gears[8] = 200L;
		gears[9] = 150L;
	}
	
	
	/** METHODE QUI PERMET DE RECUPERER LA VITESSE DU JOUEUR **/
	public long getVitesse(){
		return gears[this.vitesse];
	}
	
	
	/** METHODE QUI PERMET D'AUGMENTER LA VITESSE DU JOUEUR **/
	public void vitesseSuivante(){
		this.vitesse++; // On augent simplement la vitese de 1
	}
	
}
