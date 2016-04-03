package Tetrimino;

public class Tetrimino_J extends Tetrimino implements TetriminoInterface {
	
	
/** COORDONNEES DES DIFFERENTS BLOCKS (CASE) COMPOSANT LE TETRIMINO I **/
	
	////////////////////////////////////////////////////
	private int x0a; private int y0a;
	private int x1a; private int y1a;
	////////////////////////////////////////////////////
	
	
	////////////////////////////////////////////////////
	private int x0A; private int y0A;
	private int x1A; private int y1A;
	////////////////////////////////////////////////////
	
	public Tetrimino_J() {
		
		super(5, 0, 5, 1, 5, 2, 4, 2, 1); //On fixe les coordonnées initiales des differents blocks
		super.getBlock(0).setTextureImage(1); //On fixe la texture (couleur) du block 1
		super.getBlock(1).setTextureImage(1); //On fixe la texture (couleur) du block 2
		super.getBlock(2).setTextureImage(1); //On fixe la texture (couleur) du block 3
		super.getBlock(3).setTextureImage(1); //On fixe la texture (couleur) du block 4
		
		//Blocks permettant de verifier si il n'y a pas d'obstacles pour pouvoir tourner
		x0a=0;y0a=0;x1a=0;y1a=0;
		x0A=0;y0A=0;x1A=0;y1A=0;
		
	}

	
	/** METHODE QUI PERMET AU PIECE DE TOURNER **/
	@Override
	public void rotation(boolean[][] xRay) {
		
		
		//Si on est dans la rotationPhase 0 (position 0)
		if (super.getRotationPhase() == 0 && !super.getRotationSet()) {
			
			// endroits possibles pour les blocks
			x0a = super.getBlockX(0) - 1;
			y0a = super.getBlockY(0);
			x1a = super.getBlockX(1) - 1;
			y1a = super.getBlockY(1) ;
			
			x0A = super.getBlockX(0) + 1;
			y0A = super.getBlockY(0);
			x1A = super.getBlockX(1) + 1;
			y1A = super.getBlockY(1);
			
			TetriminoUtil.removeTetriminoFromXRay(this, xRay);

			//Si les pieces ne sortent pas du tableau lors de la rotation
			if (TetriminoUtil.pInRange(x0a, y0a) && TetriminoUtil.pInRange(x1a, y1a) && TetriminoUtil.pInRange(x0A, y0A) && TetriminoUtil.pInRange(x1A, y1A)) {
				
				//Si il n'y a pas d'obstacles sur le chemin de la rotation
				if (!xRay[y0a][x0a] && !xRay[y1a][x1a] && !xRay[y0A][x0A] && !xRay[y1A][x1A]) {
					
					//On effectue la rotation des pieces
					super.getBlock(0).setXY((super.getBlockX(0) + 1),
							(super.getBlockY(0) + 1));
					super.getBlock(2).setXY((super.getBlockX(2) - 1),
							(super.getBlockY(2) - 1));
					super.getBlock(3).setXY((super.getBlockX(3)),
							(super.getBlockY(3) - 2));

					super.setRotationPhase(1);// On change la phase de rotation (on passe en position 1)
					super.setRotationSet(true);
				}
			}
			
			TetriminoUtil.putTetriminoOnXRay(this, xRay);
		}

		
		//Si on est dans la rotationPhase 1 (position 1)
		if (super.getRotationPhase() == 1 && !super.getRotationSet()) {
			
			// endroits possibles pour les blocks
			x0a = super.getBlockX(0);
			y0a = super.getBlockY(0) - 1;
			x1a = super.getBlockX(1);
			y1a = super.getBlockY(1) - 1;
			
			x0A = super.getBlockX(0);
			y0A = super.getBlockY(0) + 1;
			x1A = super.getBlockX(1);
			y1A = super.getBlockY(1) + 1;

			TetriminoUtil.removeTetriminoFromXRay(this, xRay);

			//Si les pieces ne sortent pas du tableau lors de la rotation
			if (TetriminoUtil.pInRange(x0a, y0a) && TetriminoUtil.pInRange(x1a, y1a) && TetriminoUtil.pInRange(x0A, y0A) && TetriminoUtil.pInRange(x1A, y1A)) {
				
				//Si il n'y a pas d'obstacles sur le chemin de la rotation
				if (!xRay[y0a][x0a] && !xRay[y1a][x1a] && !xRay[y0A][x0A] && !xRay[y1A][x1A]) {
					
					//On effectue la rotation des pieces
					super.getBlock(0).setXY((super.getBlockX(0) - 1),
							(super.getBlockY(0) + 1));
					super.getBlock(2).setXY((super.getBlockX(2) + 1),
							(super.getBlockY(2) - 1));
					super.getBlock(3).setXY((super.getBlockX(3) + 2),
							(super.getBlockY(3)));

					super.setRotationPhase(2);// On change la phase de rotation (on passe en position 2)
					super.setRotationSet(true);
				}
			}
			
			TetriminoUtil.putTetriminoOnXRay(this, xRay);
		}
		
		//Si on est dans la rotationPhase 2 (position 2)
		if (super.getRotationPhase() == 2 && !super.getRotationSet()) {
			
			// endroits possibles pour les blocks
			x0a = super.getBlockX(0) + 1;
			y0a = super.getBlockY(0);
			x1a = super.getBlockX(1) + 1;
			y1a = super.getBlockY(1) ;
			
			x0A = super.getBlockX(0) - 1;
			y0A = super.getBlockY(0);
			x1A = super.getBlockX(1) - 1;
			y1A = super.getBlockY(1);

			TetriminoUtil.removeTetriminoFromXRay(this, xRay);
			
			//Si les pieces ne sortent pas du tableau lors de la rotation
			if (TetriminoUtil.pInRange(x0a, y0a) && TetriminoUtil.pInRange(x1a, y1a) && TetriminoUtil.pInRange(x0A, y0A) && TetriminoUtil.pInRange(x1A, y1A)) {
				
				//Si il n'y a pas d'obstacles sur le chemin de la rotation
				if (!xRay[y0a][x0a] && !xRay[y1a][x1a] && !xRay[y0A][x0A] && !xRay[y1A][x1A]) {
					
					//On effectue la rotation des pieces
					super.getBlock(0).setXY((super.getBlockX(0) - 1),
							(super.getBlockY(0) - 1));
					super.getBlock(2).setXY((super.getBlockX(2) + 1),
							(super.getBlockY(2) + 1));
					super.getBlock(3).setXY((super.getBlockX(3)),
							(super.getBlockY(3) + 2));

					super.setRotationPhase(3);// On change la phase de rotation (on passe en position 3)
					super.setRotationSet(true);
				}
			}
			
			TetriminoUtil.putTetriminoOnXRay(this, xRay);
		}
		
		//Si on est dans la rotationPhase 3 (position 3)
		if (super.getRotationPhase() == 3 && !super.getRotationSet()) {
			
			// endroits possibles pour les blocks
			x0a = super.getBlockX(0);
			y0a = super.getBlockY(0) + 1;
			x1a = super.getBlockX(1);
			y1a = super.getBlockY(1) + 1;
			
			x0A = super.getBlockX(0);
			y0A = super.getBlockY(0) - 1;
			x1A = super.getBlockX(1);
			y1A = super.getBlockY(1) - 1;

			TetriminoUtil.removeTetriminoFromXRay(this, xRay);
			
			//Si les pieces ne sortent pas du tableau lors de la rotation
			if (TetriminoUtil.pInRange(x0a, y0a) && TetriminoUtil.pInRange(x1a, y1a) && TetriminoUtil.pInRange(x0A, y0A) && TetriminoUtil.pInRange(x1A, y1A)) {
				
				//Si il n'y a pas d'obstacles sur le chemin de la rotation
				if (!xRay[y0a][x0a] && !xRay[y1a][x1a] && !xRay[y0A][x0A] && !xRay[y1A][x1A]) {
					
					//On effectue la rotation des pieces
					super.getBlock(0).setXY((super.getBlockX(0) + 1),
							(super.getBlockY(0) - 1));
					super.getBlock(2).setXY((super.getBlockX(2) - 1),
							(super.getBlockY(2) + 1));
					super.getBlock(3).setXY((super.getBlockX(3) - 2),
							(super.getBlockY(3)));

					super.setRotationPhase(0);// On change la phase de rotation (on passe en position 0)
					super.setRotationSet(true);
				}
			}
			
			TetriminoUtil.putTetriminoOnXRay(this, xRay);
		}
		
		//
		super.setRotationSet(false);
	}

}