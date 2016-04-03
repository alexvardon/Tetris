package GUI_Tetris;

import java.awt.Color;
import java.awt.Font;

public class PoliceTetris {

	/** METHODE QUI GERE LA COULEUR DU TEXTE **/
	public static Color getColor(){
		return Color.BLACK; // On fixe la couleur des textes à NOIR
	}
	
	/** METHIDE QUI GERE LA POLICE D'ECRITURE DES TEXTES DANS LE JEU **/
	public static Font getPolice(){
		return new Font("Arial", Font.BOLD, 16); // La police utilisée dans le jeu est Arial, de taille 16 et en gras
	}
	
	
	
}