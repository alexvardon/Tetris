package GUI_Tetris;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class InstructionPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	//On cree les diff�rents textes permettant de renseigner l'utilisateur sur les touches du jeu
	private JLabel consigne1 = new JLabel("Deplacement : <- et ->"); //On utilise les touches du clavier pour bouger la piece
	private JLabel consigne2 = new JLabel("Rotation : [SPACE]"); // On utilise la barre espace pour tourner la piece
	private JLabel consigne3 = new JLabel("Faire tomber : [MAJ]"); // On utilise maj pour faire tomber directement la piece
	
	public InstructionPanel(){
		add(consigne1); // Ajout � notre panel de la consigne de deplacement
		add(consigne2); // Ajout � notre panel de la consigne de rotation
		add(consigne3); // Ajout � notre panel de la consigne de chute de pi�ce
	}
}