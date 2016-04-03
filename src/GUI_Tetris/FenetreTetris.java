package GUI_Tetris;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class FenetreTetris extends JFrame {

	private static final long serialVersionUID = 1L;
	private InfoPanel INF; // Creation de notre instance InfoPanel
	private Plateau PLATEAU; // Creation de notre instance Plateau

	
	/** CREATION DE LA FENTRE DU TETRIS **/
	public FenetreTetris() {
		setSize(500, 800); // Dimensions de la fenetre	
		setTitle("Tetris Martini Torchin Vardon"); // Nom de la fenetre
		setDefaultCloseOperation(EXIT_ON_CLOSE); // Quand on clique sur la croix la fenetre se ferme
		setResizable(false); // Ne permet âs le redimensionnement de la fenetre
		setLocationRelativeTo(null); // La fenetre se lance au milieu de l'ecran
		setLayout(new BorderLayout());

		INF = new InfoPanel(); // On defini notre objet INF comme un nouvel objet renseignant les infos du jeu
		PLATEAU = new Plateau(); // On defini notre objet PLATEAU comme un nouveau Plateau
		add(PLATEAU, BorderLayout.CENTER); //On rajoute le plateau de jeu dans notre fenetre au centre
		add(INF, BorderLayout.EAST); // On rajoute les infos du jeu sur la droite de notre fenetre

		
		setFocusable(true);
		setVisible(true); // Rend la fenetre Tetris visible
	}
	
	
	/** PERMET DE RECUPERER LE PLATEAU (SINGLETON)**/
	public Plateau getPlateau() {
		return this.PLATEAU; // On retourne l'instance de notre plateau de jeu
	}
	
	
	/** PERMET DE RECUPERER L'INFOPANEL(SINGLETON)**/
	public InfoPanel getInfoPanel() {
		return this.INF; //On retrourn l'instance de notre infoPanel
	}

	
	public void colorPlateau(int x, int y, int i) {
		PLATEAU.colorPlateauPanelSq(x, y, i);
	}

	public void unColorPlateau(int x, int y) {
		PLATEAU.uncolorPlateauPanelSq(x, y);
	}

	
	
	
}