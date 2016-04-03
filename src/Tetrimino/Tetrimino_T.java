package Tetrimino;

public class Tetrimino_T extends Tetrimino implements TetriminoInterface {

	private int x0; private int y0;
	private int x1; private int y1;
	private int x2; private int y2;
	private int x3; private int y3;
	
	public Tetrimino_T() {
		super(5, 0, 5, 1, 4, 1, 5, 2, 5);
		
		super.getBlock(0).setTextureImage(5);
		super.getBlock(1).setTextureImage(5);
		super.getBlock(2).setTextureImage(5);
		super.getBlock(3).setTextureImage(5);
		
		x0=0;y0=0;x1=0;y1=0;x2=0;y2=0;x3=0;y3=0;
	}

	@Override
	public void rotation(boolean[][] xRay) {

		if (super.getRotationPhase() == 0 && !super.getRotationSet()) {
			
			x0 = super.getBlockX(0) + 1;
			y0 = super.getBlockY(0);
			x1 = super.getBlockX(1) + 1;
			y1 = super.getBlockY(1);
			x2 = super.getBlockX(2);
			y2 = super.getBlockY(2) - 1;
			x3 = super.getBlockX(3) - 1;
			y3 = super.getBlockY(3);

			TetriminoUtil.removeTetriminoFromXRay(this, xRay);

			if (TetriminoUtil.pInRange(x0, y0) && TetriminoUtil.pInRange(x1, y1)
					&& TetriminoUtil.pInRange(x2, y2) && TetriminoUtil.pInRange(x3, y3)) {

				if (!xRay[y0][x0] && !xRay[y1][x1] && !xRay[y2][x2]
						&& !xRay[y3][x3]) { 

					super.getBlock(0).setXY((super.getBlockX(0) + 1),
							(super.getBlockY(0) + 1));
					super.getBlock(2).setXY((super.getBlockX(2) + 1),
							(super.getBlockY(2) - 1));
					super.getBlock(3).setXY((super.getBlockX(3) - 1),
							(super.getBlockY(3) - 1));

					super.setRotationPhase(1);
					super.setRotationSet(true);
				}
			}
			
			TetriminoUtil.putTetriminoOnXRay(this, xRay);
		}

		if (super.getRotationPhase() == 1 && !super.getRotationSet()) {
			
			x0 = super.getBlockX(0);
			y0 = super.getBlockY(0) + 1;
			x1 = super.getBlockX(1);
			y1 = super.getBlockY(1) + 1;
			x2 = super.getBlockX(2) + 1;
			y2 = super.getBlockY(2);
			x3 = super.getBlockX(3);
			y3 = super.getBlockY(3) - 1;

			TetriminoUtil.removeTetriminoFromXRay(this, xRay);

			if (TetriminoUtil.pInRange(x0, y0) && TetriminoUtil.pInRange(x1, y1)
					&& TetriminoUtil.pInRange(x2, y2) && TetriminoUtil.pInRange(x3, y3)) {
				

				if (!xRay[y0][x0] && !xRay[y1][x1] && !xRay[y2][x2]
						&& !xRay[y3][x3]) {

					super.getBlock(0).setXY((super.getBlockX(0) - 1),
							(super.getBlockY(0) + 1));
					super.getBlock(2).setXY((super.getBlockX(2) + 1),
							(super.getBlockY(2) + 1));
					super.getBlock(3).setXY((super.getBlockX(3) + 1),
							(super.getBlockY(3) - 1));

					super.setRotationPhase(2);
					super.setRotationSet(true);
				}

			}

			TetriminoUtil.putTetriminoOnXRay(this, xRay);
		}
		
		if (super.getRotationPhase() == 2 && !super.getRotationSet()) {
			
			x0 = super.getBlockX(0) - 1;
			y0 = super.getBlockY(0);
			x1 = super.getBlockX(1) - 1;
			y1 = super.getBlockY(1);
			x2 = super.getBlockX(2);
			y2 = super.getBlockY(2) + 1;
			x3 = super.getBlockX(3) + 1;
			y3 = super.getBlockY(3);

			TetriminoUtil.removeTetriminoFromXRay(this, xRay);

			if (TetriminoUtil.pInRange(x0, y0) && TetriminoUtil.pInRange(x1, y1)
					&& TetriminoUtil.pInRange(x2, y2) && TetriminoUtil.pInRange(x3, y3)) {
				

				if (!xRay[y0][x0] && !xRay[y1][x1] && !xRay[y2][x2]
						&& !xRay[y3][x3]) {

					super.getBlock(0).setXY((super.getBlockX(0) - 1),
							(super.getBlockY(0) - 1));
					super.getBlock(2).setXY((super.getBlockX(2) - 1),
							(super.getBlockY(2) + 1));
					super.getBlock(3).setXY((super.getBlockX(3) + 1),
							(super.getBlockY(3) + 1));

					super.setRotationPhase(3);//
					super.setRotationSet(true);
				}

			}

			TetriminoUtil.putTetriminoOnXRay(this, xRay);
		}
		
		if (super.getRotationPhase() == 3 && !super.getRotationSet()) {
			
			x0 = super.getBlockX(0);
			y0 = super.getBlockY(0) - 1;
			x1 = super.getBlockX(1);
			y1 = super.getBlockY(1) - 1;
			x2 = super.getBlockX(2) - 1;
			y2 = super.getBlockY(2);
			x3 = super.getBlockX(3);
			y3 = super.getBlockY(3) + 1;

			TetriminoUtil.removeTetriminoFromXRay(this, xRay);

			if (TetriminoUtil.pInRange(x0, y0) && TetriminoUtil.pInRange(x1, y1)
					&& TetriminoUtil.pInRange(x2, y2) && TetriminoUtil.pInRange(x3, y3)) {
				

				if (!xRay[y0][x0] && !xRay[y1][x1] && !xRay[y2][x2]
						&& !xRay[y3][x3]) { 

					super.getBlock(0).setXY((super.getBlockX(0) + 1),
							(super.getBlockY(0) - 1));
					super.getBlock(2).setXY((super.getBlockX(2) - 1),
							(super.getBlockY(2) - 1));
					super.getBlock(3).setXY((super.getBlockX(3) - 1),
							(super.getBlockY(3) + 1));

					super.setRotationPhase(0);
					super.setRotationSet(true);
				}

			}

			TetriminoUtil.putTetriminoOnXRay(this, xRay);
		}

		super.setRotationSet(false);
	}
}