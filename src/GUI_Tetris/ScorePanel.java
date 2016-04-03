package GUI_Tetris;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScorePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JLabel textScore; // Label de texte qui afiche le mot : Score
	private JLabel score; // Label qui affiche le score actuel
	private BoxLayout layout;
	
	public ScorePanel(){
		textScore = new JLabel("Score: "); // Affiche le mot : Score
		score = new JLabel("0"); // Affiche le socre actuel (initiallement à 0)
		
		textScore.setFont(PoliceTetris.getPolice()); // On utilise la police definie dans PoliceTetris
		score.setFont(PoliceTetris.getPolice()); // On utilise la police definie dans PoliceTetris
		
		textScore.setForeground(PoliceTetris.getColor()); // On utilise la couleur definie dans PoliceTetris
		score.setForeground(PoliceTetris.getColor()); // On utilise la couleur definie dans PoliceTetris
		
		// Creation d'un box layour permettant d'afficher les differents éléments les uns à la suite des autres (sur l'axe Y)
		layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		
		setLayout(layout); // On fixe le boxLayout
		add(textScore); // On rajoute le texte dans notre BoxLayout
		add(score); // On rajoute le score dans notre BxLayout
	}
	
	
	/** METHODE QUI PERMET DE RAFRAICHIR LE SCORE DE LA PARTIE **/
	public void refreshScore(int newScore){
		score.setText(String.valueOf(newScore)); // Le score est remplacé par le nouveau
		score.setVisible(false); // On rafraichi avec "false" puis "true" le niveau de la partie
		score.setVisible(true);
	}
}
