package GUI_Tetris;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NiveauPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JLabel texte; // Label de texte qui afiche le mot : Niveau de difficult�
	private JLabel niveau; // Label de level qui afiche le niveau actuel
	private BoxLayout layout;
	
	public NiveauPanel(){
		texte = new JLabel("Niveau de difficulte:"); // Affiche : Niveau de difficult�
		niveau = new JLabel("I"); // Affiche : I
		
		texte.setFont(PoliceTetris.getPolice()); // On utilise la police definie dans PoliceTetris
		niveau.setFont(PoliceTetris.getPolice()); // On utilise la police definie dans PoliceTetris
		
		texte.setForeground(PoliceTetris.getColor()); // On utilise la couleur definie dans PoliceTetris
		niveau.setForeground(PoliceTetris.getColor()); //On utilise la couleur defini dans PoliceTetris
		
		// Creation d'un box layour permettant d'afficher les differents �l�ments les uns � la suite des autres (sur l'axe Y)
		layout = new BoxLayout(this, BoxLayout.Y_AXIS); 
		
		setLayout(layout); // On fixe le boxLayout
		add(texte); // On rajoute le texte dans notre BxLayout
		add(niveau); // On rajoute le niveau de la partie dans le BoxLayout
	}
	
	
	/** METHODE QUI PERMET DE MODIFIER LA VALEUR DU NIVEAU **/
	public void setNiveau(String niveau){
		this.niveau.setText(niveau); //Le texte est remplac� par le nouveau
		this.niveau.setVisible(false); // On rafraichi avec "false" puis "true" le niveau de la partie
		this.niveau.setVisible(true);
	}
}