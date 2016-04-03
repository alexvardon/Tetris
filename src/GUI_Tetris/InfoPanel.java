package GUI_Tetris;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class InfoPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private GridLayout layout; //Layout permettant de stocker sous forme d'une grille, les éléments constituants notre InfoPanel
	private ScorePanel scorePanel; // Score de la partie
	private NiveauPanel levelPanel; //Niveau de la partie 
	private InstructionPanel instruction; //Instruction de jeu
	
	private Dimension panelDimension; // Dimension du panel
	
	
	public InfoPanel(){
		
		//On cree notre grille de 3 case en hauteur pour supperposer les differnets éléments les uns en dessous des autres
		layout = new GridLayout(3, 1);
		
		scorePanel = new ScorePanel(); //Nouveau score de la partie 
		levelPanel = new NiveauPanel(); //Nouveau de la partie
		instruction = new InstructionPanel(); //Instruction de la partie
		
		//On dimensionne la taille de 
		panelDimension = new Dimension(200, 100);
		
		//Ici on ss'occupe de notre GridLayout afin de pouvoir afficher les différents éléments
		setLayout(layout); // On fixe notre layout (notre grille)
		add(scorePanel); // On rajoute le score au GridLayout (case1)
		add(instruction); // On rajoute les instructions au GridLayout (case2)
		add(levelPanel); // On rajoute le niveau de la partie au GridLayout (case3)
	}
	
	
	
	/** METHODE QUI RETOURNE LE SCOREPANEL AFIN DE POUVOIR LE MODIFIER PLUS TARD **/
	public ScorePanel getScorePanel(){
		return this.scorePanel;
	}
	
	/** METHODE QUI RETOURNE LE LEVELPANEL AFIN DE POUVOIR LE MODIFIER PLUS TARD **/
	public NiveauPanel getLevelPanel(){
		return this.levelPanel;
	}
	
	/** METHODE QUI NOUS PERMET DE DONNER LA DIMENSION AU PANEL **/
	@Override
	public Dimension getPreferredSize() {
		return this.panelDimension;
	}
	
	
}