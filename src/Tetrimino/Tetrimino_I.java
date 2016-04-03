package Tetrimino;

public class Tetrimino_I extends Tetrimino {

	
	/** COORDONNEES DES DIFFERENTS BLOCKS (CASE) COMPOSANT LE TETRIMINO I **/
	
	////////////////////////////////////////////////////
	private int x0A; private int y0A;
	private int x0B; private int y0B;
	////////////////////////////////////////////////////
	
	
	////////////////////////////////////////////////////	
	private int x1A; private int y1A;
	private int x1B; private int y1B;
	////////////////////////////////////////////////////
	
	////////////////////////////////////////////////////
	private int x2A; private int y2A;
	private int x2B; private int y2B;
	////////////////////////////////////////////////////	
	
	private int x3; private int y3;

	public Tetrimino_I() {
		super(3, 0, 4, 0, 5, 0, 6, 0, 0); //On fixe les coordonnées initiales des differents blocks
		super.getBlock(0).setTextureImage(0); //On fixe la texture (couleur) du block 1
		super.getBlock(1).setTextureImage(0); //On fixe la texture (couleur) du block 2
		super.getBlock(2).setTextureImage(0); //On fixe la texture (couleur) du block 3
		super.getBlock(3).setTextureImage(0); //On fixe la texture (couleur) du block 4
		
		//Blocks permettant de verifier si il n'y a pas d'obstacles pour pouvoir tourner
		x0A=0;y0A=0;x0B=0;y0B=0;x1A=0;y1A=0;x1B=0;y1B=0;x2A=0;y2A=0;x2B=0;y2B=0;x3=0;y3=0;
	}


	/** METHODE QUI PERMET AU PIECE DE TOURNER **/
	public void rotation(boolean[][] xRay) {
		
		//Si on est dans la rotationPhase 0 (position 0)
				if (super.getRotationPhase() == 0 && !super.getRotationSet()) {
					
					// endroits possibles pour les blocks
					x0A = super.getBlockX(0);
					y0A = super.getBlockY(0) - 1;
					x0B = super.getBlockX(0);
					y0B = super.getBlockY(0) - 2;
					
					x1A = super.getBlockX(1);
					y1A = super.getBlockY(1) - 1;
					x1B = super.getBlockX(1);
					y1B = super.getBlockY(1) - 2;
					
					x2A = super.getBlockX(2);
					y2A = super.getBlockY(2) - 1;
					x2B = super.getBlockX(2);
					y2B = super.getBlockY(2) - 2;
					
					x3 = super.getBlockX(2);
					y3 = super.getBlockY(2) + 1;
					
					TetriminoUtil.removeTetriminoFromXRay(this, xRay);
					
					//Si les pieces ne sortent pas du tableau lors de la rotation
					if (TetriminoUtil.pInRange(x0A, y0A) && TetriminoUtil.pInRange(x0B, y0B) && TetriminoUtil.pInRange(x1A, y1A) && TetriminoUtil.pInRange(x1B, y1B)
							&& TetriminoUtil.pInRange(x2A, y2A) && TetriminoUtil.pInRange(x2B, y2B) && TetriminoUtil.pInRange(x3, y3)) {
						
						//Si il n'y a pas d'obstacles sur le chemin de la rotation
						if (!xRay[y0A][x0A] && !xRay[y0B][x0B] && !xRay[y1A][x1A] && !xRay[y1B][x1B] && !xRay[y2A][x2A] && !xRay[y2B][x2B]
								&& !xRay[y3][x3]) { 

							//On effectue la rotation des pieces
							super.getBlock(0).setXY((super.getBlockX(0) + 2),
									(super.getBlockY(0) - 2));
							super.getBlock(1).setXY((super.getBlockX(1) + 1),
									(super.getBlockY(1) - 1));
							super.getBlock(3).setXY((super.getBlockX(3) - 1),
									(super.getBlockY(3) + 1));

							super.setRotationPhase(1); // On change la phase de rotation (on passe en position 1)
							super.setRotationSet(true);
						}
					}
					
					TetriminoUtil.putTetriminoOnXRay(this, xRay);
				}
		
				//Si on est dans la rotationPhase 1 (position 1)
				if (super.getRotationPhase() == 1 && !super.getRotationSet()) {
					
					// endroits possibles pour les blocks
					x0A = super.getBlockX(0) + 1;
					y0A = super.getBlockY(0);
					x0B = super.getBlockX(0) + 2;
					y0B = super.getBlockY(0);
					
					x1A = super.getBlockX(1) + 1;
					y1A = super.getBlockY(1);
					x1B = super.getBlockX(1) + 2;
					y1B = super.getBlockY(1);
					
					x2A = super.getBlockX(2) + 1;
					y2A = super.getBlockY(2);
					x2B = super.getBlockX(2) + 2;
					y2B = super.getBlockY(2);
					
					x3 = super.getBlockX(2) - 1;
					y3 = super.getBlockY(2);

					TetriminoUtil.removeTetriminoFromXRay(this, xRay);

					//Si les blocks ne sortent pas du tableau lors de la rotation
					if (TetriminoUtil.pInRange(x0A, y0A) && TetriminoUtil.pInRange(x0B, y0B) && TetriminoUtil.pInRange(x1A, y1A) && TetriminoUtil.pInRange(x1B, y1B)
							&& TetriminoUtil.pInRange(x2A, y2A) && TetriminoUtil.pInRange(x2B, y2B) && TetriminoUtil.pInRange(x3, y3)) {// in range

						//Si il n'y a pas d'obstacles sur le chemin de la rotation
						if (!xRay[y0A][x0A] && !xRay[y0B][x0B] && !xRay[y1A][x1A] && !xRay[y1B][x1B] && !xRay[y2A][x2A] && !xRay[y2B][x2B]
								&& !xRay[y3][x3]) {

							//On effectue la rotation de la piece (des blocks)
							super.getBlock(0).setXY((super.getBlockX(0) + 2),
									(super.getBlockY(0) + 2));
							super.getBlock(1).setXY((super.getBlockX(1) + 1),
									(super.getBlockY(1) + 1));
							super.getBlock(3).setXY((super.getBlockX(3) - 1),
									(super.getBlockY(3) - 1));

							super.setRotationPhase(2); // On change la phase de rotation (on passe en position 2)
							super.setRotationSet(true);
						}
					}
					
					TetriminoUtil.putTetriminoOnXRay(this, xRay);
				}
				
				//Si on est dans la rotationPhase 2 (position 2)
				if (super.getRotationPhase() == 2 && !super.getRotationSet()) {
					
					// endroits possibles pour les blocks
					x0A = super.getBlockX(0);
					y0A = super.getBlockY(0) + 1;
					x0B = super.getBlockX(0);
					y0B = super.getBlockY(0) + 2;
					
					x1A = super.getBlockX(1);
					y1A = super.getBlockY(1) + 1;
					x1B = super.getBlockX(1);
					y1B = super.getBlockY(1) + 2;
					
					x2A = super.getBlockX(2);
					y2A = super.getBlockY(2) + 1;
					x2B = super.getBlockX(2);
					y2B = super.getBlockY(2) + 2;
					
					x3 = super.getBlockX(2);
					y3 = super.getBlockY(2) - 1;

					TetriminoUtil.removeTetriminoFromXRay(this, xRay);

					//Si les blocks ne sortent pas du tableau lors de la rotation
					if (TetriminoUtil.pInRange(x0A, y0A) && TetriminoUtil.pInRange(x0B, y0B) && TetriminoUtil.pInRange(x1A, y1A) && TetriminoUtil.pInRange(x1B, y1B)
							&& TetriminoUtil.pInRange(x2A, y2A) && TetriminoUtil.pInRange(x2B, y2B) && TetriminoUtil.pInRange(x3, y3)) {// in range

						//Si il n'y a pas d'obstacles sur le chemin de la rotation
						if (!xRay[y0A][x0A] && !xRay[y0B][x0B] && !xRay[y1A][x1A] && !xRay[y1B][x1B] && !xRay[y2A][x2A] && !xRay[y2B][x2B]
								&& !xRay[y3][x3]) { // no obstacles

							//On effectue la rotation de la piece (des blocks)
							super.getBlock(0).setXY((super.getBlockX(0) - 2),
									(super.getBlockY(0) + 2));
							super.getBlock(1).setXY((super.getBlockX(1) - 1),
									(super.getBlockY(1) + 1));
							super.getBlock(3).setXY((super.getBlockX(3) + 1),
									(super.getBlockY(3) - 1));

							super.setRotationPhase(3); // On change la phase de rotation (on passe en position 3)
							super.setRotationSet(true);
						}
					}
					
					TetriminoUtil.putTetriminoOnXRay(this, xRay);
				}
				
				
				//Si on est dans la rotationPhase 3 (position 3)
				if (super.getRotationPhase() == 3 && !super.getRotationSet()) {// R.P. ======================================================= 3;
					
					// endroits possibles pour les blocks
					x0A = super.getBlockX(0) - 1;
					y0A = super.getBlockY(0);
					x0B = super.getBlockX(0) - 2;
					y0B = super.getBlockY(0);
					
					x1A = super.getBlockX(1) - 1;
					y1A = super.getBlockY(1);
					x1B = super.getBlockX(1) - 2;
					y1B = super.getBlockY(1);
					
					x2A = super.getBlockX(2) - 1;
					y2A = super.getBlockY(2);
					x2B = super.getBlockX(2) - 2;
					y2B = super.getBlockY(2);
					
					x3 = super.getBlockX(2) + 1;
					y3 = super.getBlockY(2);

					TetriminoUtil.removeTetriminoFromXRay(this, xRay);

					
					//Si les blocks ne sortent pas du tableau lors de la rotation
					if (TetriminoUtil.pInRange(x0A, y0A) && TetriminoUtil.pInRange(x0B, y0B) && TetriminoUtil.pInRange(x1A, y1A) && TetriminoUtil.pInRange(x1B, y1B)
							&& TetriminoUtil.pInRange(x2A, y2A) && TetriminoUtil.pInRange(x2B, y2B) && TetriminoUtil.pInRange(x3, y3)) {// in range

						
						//Si il n'y a pas d'obstacles sur le chemin de la rotation
						if (!xRay[y0A][x0A] && !xRay[y0B][x0B] && !xRay[y1A][x1A] && !xRay[y1B][x1B] && !xRay[y2A][x2A] && !xRay[y2B][x2B]
								&& !xRay[y3][x3]) { // no obstacles

							
							//On effectue la rotation de la piece (des blocks)
							super.getBlock(0).setXY((super.getBlockX(0) - 2),
									(super.getBlockY(0) - 2));
							super.getBlock(1).setXY((super.getBlockX(1) - 1),
									(super.getBlockY(1) - 1));
							super.getBlock(3).setXY((super.getBlockX(3) + 1),
									(super.getBlockY(3) + 1));

							super.setRotationPhase(0); // On change la phase de rotation (on passe en position 0)
							super.setRotationSet(true);
						}
					}
					
					TetriminoUtil.putTetriminoOnXRay(this, xRay);
				}
				
				super.setRotationSet(false);
			}

	}