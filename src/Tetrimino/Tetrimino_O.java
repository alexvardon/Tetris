package Tetrimino;

public class Tetrimino_O extends Tetrimino implements TetriminoInterface {

	public Tetrimino_O() {
		super(4, 0, 5, 0, 4, 1, 5, 1, 3); //On fixe les coordonnées initiales des differents blocks

		super.getBlock(0).setTextureImage(3); //On fixe la texture (couleur) du block 1
		super.getBlock(1).setTextureImage(3); //On fixe la texture (couleur) du block 2
		super.getBlock(2).setTextureImage(3); //On fixe la texture (couleur) du block 3
		super.getBlock(3).setTextureImage(3); //On fixe la texture (couleur) du block 4
	}

	public void rotation(boolean[][] xRay) {
		// TODO Auto-generated method stub
		
	}

}