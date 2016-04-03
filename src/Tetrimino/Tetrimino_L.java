package Tetrimino;

public class Tetrimino_L extends Tetrimino implements TetriminoInterface {

	private int x0a; private int y0a;
	private int x1a; private int y1a;
	
	private int x0A; private int y0A;
	private int x1A; private int y1A;
	
	private int x2; private int y2;
	
	public Tetrimino_L() {
		super(4, 0, 4, 1, 4, 2, 5, 2, 2);
		
		super.getBlock(0).setTextureImage(2);
		super.getBlock(1).setTextureImage(2);
		super.getBlock(2).setTextureImage(2);
		super.getBlock(3).setTextureImage(2);
		
		x0a=0;y0a=0;x1a=0;y1a=0;
		x0A=0;y0A=0;x1A=0;y1A=0;
		x2=0;y2=0;
	}


	@Override
	public void rotation(boolean[][] xRay) {
		
		if (super.getRotationPhase() == 0 && !super.getRotationSet()) {

			x0a = super.getBlockX(0) - 1;
			y0a = super.getBlockY(0);
			x1a = super.getBlockX(1) - 1;
			y1a = super.getBlockY(1);
			
			x0A = super.getBlockX(0) + 1;
			y0A = super.getBlockY(0);
			x1A = super.getBlockX(1) + 1;
			y1A = super.getBlockY(1);
			
			x2 = super.getBlockX(2) - 1;
			y2 = super.getBlockY(2);
			
			TetriminoUtil.removeTetriminoFromXRay(this, xRay);

			if (TetriminoUtil.pInRange(x0a, y0a) && TetriminoUtil.pInRange(x1a, y1a) && TetriminoUtil.pInRange(x0A, y0A) && TetriminoUtil.pInRange(x1A, y1A)
					&& TetriminoUtil.pInRange(x2, y2)) {


				if (!xRay[y0a][x0a] && !xRay[y1a][x1a] && !xRay[y0A][x0A] && !xRay[y1A][x1A]
						&& !xRay[y2][x2]) {


					super.getBlock(0).setXY((super.getBlockX(0) + 1),
							(super.getBlockY(0) + 1));
					super.getBlock(2).setXY((super.getBlockX(2) - 1),
							(super.getBlockY(2) - 1));
					super.getBlock(3).setXY((super.getBlockX(3) - 2),
							(super.getBlockY(3)));

					super.setRotationPhase(1);//
					super.setRotationSet(true);
				}
			}
			
			TetriminoUtil.putTetriminoOnXRay(this, xRay);
		}

		if (super.getRotationPhase() == 1 && !super.getRotationSet()) {

			x0a = super.getBlockX(0);
			y0a = super.getBlockY(0) - 1;
			x1a = super.getBlockX(1);
			y1a = super.getBlockY(1) - 1;
			
			x0A = super.getBlockX(0);
			y0A = super.getBlockY(0) + 1;
			x1A = super.getBlockX(1);
			y1A = super.getBlockY(1) + 1;

			x2 = super.getBlockX(2);
			y2 = super.getBlockY(2) - 1;
			
			TetriminoUtil.removeTetriminoFromXRay(this, xRay);

			if (TetriminoUtil.pInRange(x0a, y0a) && TetriminoUtil.pInRange(x1a, y1a) && TetriminoUtil.pInRange(x0A, y0A) && TetriminoUtil.pInRange(x1A, y1A)
					&& TetriminoUtil.pInRange(x2, y2)) {
				

				if (!xRay[y0a][x0a] && !xRay[y1a][x1a] && !xRay[y0A][x0A] && !xRay[y1A][x1A]
						&& !xRay[y2][x2]) {
					

					super.getBlock(0).setXY((super.getBlockX(0) - 1),
							(super.getBlockY(0) + 1));
					super.getBlock(2).setXY((super.getBlockX(2) + 1),
							(super.getBlockY(2) - 1));
					super.getBlock(3).setXY((super.getBlockX(3)),
							(super.getBlockY(3) - 2));

					super.setRotationPhase(2);
					super.setRotationSet(true);
				}
			}
			
			TetriminoUtil.putTetriminoOnXRay(this, xRay);
		}
		
		if (super.getRotationPhase() == 2 && !super.getRotationSet()) {
			
			x0a = super.getBlockX(0) + 1;
			y0a = super.getBlockY(0);
			x1a = super.getBlockX(1) + 1;
			y1a = super.getBlockY(1) ;
			
			x0A = super.getBlockX(0) - 1;
			y0A = super.getBlockY(0);
			x1A = super.getBlockX(1) - 1;
			y1A = super.getBlockY(1);
			
			x2 = super.getBlockX(2) + 1;
			y2 = super.getBlockY(2);

			TetriminoUtil.removeTetriminoFromXRay(this, xRay);

			if (TetriminoUtil.pInRange(x0a, y0a) && TetriminoUtil.pInRange(x1a, y1a) && TetriminoUtil.pInRange(x0A, y0A) && TetriminoUtil.pInRange(x1A, y1A)
					&& TetriminoUtil.pInRange(x2, y2)) {


				if (!xRay[y0a][x0a] && !xRay[y1a][x1a] && !xRay[y0A][x0A] && !xRay[y1A][x1A]
						&& !xRay[y2][x2]) {


					super.getBlock(0).setXY((super.getBlockX(0) - 1),
							(super.getBlockY(0) - 1));
					super.getBlock(2).setXY((super.getBlockX(2) + 1),
							(super.getBlockY(2) + 1));
					super.getBlock(3).setXY((super.getBlockX(3) + 2),
							(super.getBlockY(3)));

					super.setRotationPhase(3);
					super.setRotationSet(true);
				}
			}
			
			TetriminoUtil.putTetriminoOnXRay(this, xRay);
		}
		
		if (super.getRotationPhase() == 3 && !super.getRotationSet()) {
			
			x0a = super.getBlockX(0);
			y0a = super.getBlockY(0) + 1;
			x1a = super.getBlockX(1);
			y1a = super.getBlockY(1) + 1;
			
			x0A = super.getBlockX(0);
			y0A = super.getBlockY(0) - 1;
			x1A = super.getBlockX(1);
			y1A = super.getBlockY(1) - 1;
			
			x2 = super.getBlockX(2);
			y2 = super.getBlockY(2) + 1;

			TetriminoUtil.removeTetriminoFromXRay(this, xRay);

			if (TetriminoUtil.pInRange(x0a, y0a) && TetriminoUtil.pInRange(x1a, y1a) && TetriminoUtil.pInRange(x0A, y0A) && TetriminoUtil.pInRange(x1A, y1A)
					&& TetriminoUtil.pInRange(x2, y2)) {

				if (!xRay[y0a][x0a] && !xRay[y1a][x1a] && !xRay[y0A][x0A] && !xRay[y1A][x1A]
						&& !xRay[y2][x2]) {

					super.getBlock(0).setXY((super.getBlockX(0) + 1),
							(super.getBlockY(0) - 1));
					super.getBlock(2).setXY((super.getBlockX(2) - 1),
							(super.getBlockY(2) + 1));
					super.getBlock(3).setXY((super.getBlockX(3)),
							(super.getBlockY(3) + 2));

					super.setRotationPhase(0);
					super.setRotationSet(true);
				}
			}
			
			TetriminoUtil.putTetriminoOnXRay(this, xRay);
		}
		
		
		super.setRotationSet(false);
	}


}