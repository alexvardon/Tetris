package DonneesDeJeu;

public class Niveau {

	private String[] niveaux; // Tableau des diff�rents niveaux pr�sents dans le jeu
	private int niveauActuel; //Niveau Actuel du joueur
	
	public Niveau(){
		niveaux = new String[10];
		niveauActuel = 1; // On fixe le niveau initial du joueur � A
		
		//On utilise les nombres romains 
		niveaux[0] = "";
		niveaux[1] = "I";
		niveaux[2] = "II";
		niveaux[3] = "III";
		niveaux[4] = "IV";
		niveaux[5] = "V";
		niveaux[6] = "VI";
		niveaux[7] = "VII";
		niveaux[8] = "VIII";
		niveaux[9] = "IX";
	}
	
	
	/** METHODE QUI PERMET DE RECUPERER LE TEXTE DU NIVEAU DU JOUEUR **/
	public String getNiveau(){
		return this.niveaux[niveauActuel];
	}
	
	
	/** METHODE QUI PERMET DE PASSER AU NIVEAU SUIVANT **/
	public void niveauSuivant(){
		this.niveauActuel++; //On augmente simplement le niveau de 1
	}
	
	
	/** METHODE QUI PERMET DE RECUPERER LE NIVEAU DU JOUEUR **/
	public int getNiveauVal(){
		return this.niveauActuel;
	}
}
