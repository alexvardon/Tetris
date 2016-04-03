package Tetrimino;

public class Tetrimino_Z extends Tetrimino implements TetriminoInterface {
	
	private int x0a; private int y0a;
	private int x0A; private int y0A;
	private int x1;  private int y1;
	
	public Tetrimino_Z() {
		
		super(5, 0, 5, 1, 4, 1, 4, 2, 6);
		
		super.getBlock(0).setTextureImage(6);
		super.getBlock(1).setTextureImage(6);
		super.getBlock(2).setTextureImage(6);
		super.getBlock(3).setTextureImage(6);
		
		x0a=0;y0a=0;x0A=0;y0A=0;x1=0;y1=0;		
	}

	@Override
	public void rotation(boolean[][] xRay) {

		if (super.getRotationPhase() == 0 && !super.getRotationSet()) {
			
			x0a = super.getBlockX(0) - 1;
			y0a = super.getBlockY(0);
			x0A = super.getBlockX(0) + 1;
			y0A = super.getBlockY(0);
			
			x1 = super.getBlockX(1) + 1;
			y1 = super.getBlockY(1);
			
			TetriminoUtil.removeTetriminoFromXRay(this, xRay);

			if (TetriminoUtil.pInRange(x0a, y0a) && TetriminoUtil.pInRange(x0A, y0A) && TetriminoUtil.pInRange(x1, y1)) {
				

				if (!xRay[y0a][x0a] && !xRay[y0A][x0A] && !xRay[y1][x1]) {
					

					super.getBlock(0).setXY((super.getBlockX(0) + 1),
							(super.getBlockY(0) + 1));
					super.getBlock(2).setXY((super.getBlockX(2) + 1),
							(super.getBlockY(2) - 1));
					super.getBlock(3).setXY((super.getBlockX(3)),
							(super.getBlockY(3) - 2));

					super.setRotationPhase(1);
					super.setRotationSet(true);
				}
			}
			
			TetriminoUtil.putTetriminoOnXRay(this, xRay);
		}

		if (super.getRotationPhase() == 1 && !super.getRotationSet()) {
			
			x0a = super.getBlockX(0);
			y0a = super.getBlockY(0) - 1;
			x0A = super.getBlockX(0);
			y0A = super.getBlockY(0) + 1;
			
			x1 = super.getBlockX(1);
			y1 = super.getBlockY(1) + 1;
			
			TetriminoUtil.removeTetriminoFromXRay(this, xRay);

			if (TetriminoUtil.pInRange(x0a, y0a) && TetriminoUtil.pInRange(x0A, y0A) && TetriminoUtil.pInRange(x1, y1)) {
				

				if (!xRay[y0a][x0a] && !xRay[y0A][x0A] && !xRay[y1][x1]) {
					

					super.getBlock(0).setXY((super.getBlockX(0) - 1),
							(super.getBlockY(0) + 1));
					super.getBlock(2).setXY((super.getBlockX(2) + 1),
							(super.getBlockY(2) + 1));
					super.getBlock(3).setXY((super.getBlockX(3) + 2),
							(super.getBlockY(3)));

					super.setRotationPhase(2);
					super.setRotationSet(true);
				}
			}
			
			TetriminoUtil.putTetriminoOnXRay(this, xRay);
		}
		
		if (super.getRotationPhase() == 2 && !super.getRotationSet()) {
			
			x0a = super.getBlockX(0) - 1;
			y0a = super.getBlockY(0);
			x0A = super.getBlockX(0) + 1;
			y0A = super.getBlockY(0);
			
			x1 = super.getBlockX(1) - 1;
			y1 = super.getBlockY(1);
			
			TetriminoUtil.removeTetriminoFromXRay(this, xRay);

			if (TetriminoUtil.pInRange(x0a, y0a) && TetriminoUtil.pInRange(x0A, y0A) && TetriminoUtil.pInRange(x1, y1)) {
				

				if (!xRay[y0a][x0a] && !xRay[y0A][x0A] && !xRay[y1][x1]) {
					

					super.getBlock(0).setXY((super.getBlockX(0) - 1),
							(super.getBlockY(0) - 1));
					super.getBlock(2).setXY((super.getBlockX(2) - 1),
							(super.getBlockY(2) + 1));
					super.getBlock(3).setXY((super.getBlockX(3)),
							(super.getBlockY(3) + 2));

					super.setRotationPhase(3);
					super.setRotationSet(true);
				}
			}
			
			TetriminoUtil.putTetriminoOnXRay(this, xRay);
		}
		
		if (super.getRotationPhase() == 3 && !super.getRotationSet()) {
			
			x0a = super.getBlockX(0);
			y0a = super.getBlockY(0) - 1;
			x0A = super.getBlockX(0);
			y0A = super.getBlockY(0) + 1;
			
			x1 = super.getBlockX(1);
			y1 = super.getBlockY(1) - 1;
			
			TetriminoUtil.removeTetriminoFromXRay(this, xRay);

			if (TetriminoUtil.pInRange(x0a, y0a) && TetriminoUtil.pInRange(x0A, y0A) && TetriminoUtil.pInRange(x1, y1)) {
				

				if (!xRay[y0a][x0a] && !xRay[y0A][x0A] && !xRay[y1][x1]) {
					

					super.getBlock(0).setXY((super.getBlockX(0) + 1),
							(super.getBlockY(0) - 1));
					super.getBlock(2).setXY((super.getBlockX(2) - 1),
							(super.getBlockY(2) - 1));
					super.getBlock(3).setXY((super.getBlockX(3) - 2),
							(super.getBlockY(3)));

					super.setRotationPhase(0);
					super.setRotationSet(true);
				}
			}
			
			TetriminoUtil.putTetriminoOnXRay(this, xRay);
		}
		//
		super.setRotationSet(false);
	}

}