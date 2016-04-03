package Tetrimino;

public class Tetrimino_S extends Tetrimino implements TetriminoInterface {

	private int x0a; private int y0a;
	private int x0b; private int y0b;
	private int x1;  private int y1;
	
	public Tetrimino_S() {
		super(4, 0, 4, 1, 5, 1, 5, 2, 4);
		
		super.getBlock(0).setTextureImage(4);
		super.getBlock(1).setTextureImage(4);
		super.getBlock(2).setTextureImage(4);
		super.getBlock(3).setTextureImage(4);
		
		x0a=0;y0a=0;x0b=0;y0b=0;x1=0;y1=0;
	}

	@Override
	public void rotation(boolean[][] xRay) {

		if (super.getRotationPhase() == 0 && !super.getRotationSet()) {
			
			x0a = super.getBlockX(0) + 1;
			y0a = super.getBlockY(0);
			x0b = super.getBlockX(0) + 2;
			y0b = super.getBlockY(0);
			
			x1 = super.getBlockX(1);
			y1 = super.getBlockY(1) + 1;
			
			TetriminoUtil.removeTetriminoFromXRay(this, xRay);

			if (TetriminoUtil.pInRange(x0a, y0a) && TetriminoUtil.pInRange(x0b, y0b) && TetriminoUtil.pInRange(x1, y1)) {


				if (!xRay[y0a][x0a] && !xRay[y0b][x0b] && !xRay[y1][x1]) {


					super.getBlock(0).setXY((super.getBlockX(0) + 2),
							(super.getBlockY(0)));
					super.getBlock(1).setXY((super.getBlockX(1) + 1),
							(super.getBlockY(1) - 1));
					super.getBlock(3).setXY((super.getBlockX(3) - 1),
							(super.getBlockY(3) - 1));

					super.setRotationPhase(1);//
					super.setRotationSet(true);
				}
			}
			
			TetriminoUtil.putTetriminoOnXRay(this, xRay);
		}

		if (super.getRotationPhase() == 1 && !super.getRotationSet()) {
			
			x0a = super.getBlockX(0);
			y0a = super.getBlockY(0) + 1;
			x0b = super.getBlockX(0);
			y0b = super.getBlockY(0) + 2;
			
			x1 = super.getBlockX(1) - 1;
			y1 = super.getBlockY(1);
			
			TetriminoUtil.removeTetriminoFromXRay(this, xRay);

			if (TetriminoUtil.pInRange(x0a, y0a) && TetriminoUtil.pInRange(x0b, y0b) && TetriminoUtil.pInRange(x1, y1)) {


				if (!xRay[y0a][x0a] && !xRay[y0b][x0b] && !xRay[y1][x1]) {

					super.getBlock(0).setXY((super.getBlockX(0)),
							(super.getBlockY(0) + 2));
					super.getBlock(1).setXY((super.getBlockX(1) + 1),
							(super.getBlockY(1) + 1));
					super.getBlock(3).setXY((super.getBlockX(3) + 1),
							(super.getBlockY(3) - 1));

					super.setRotationPhase(2);//
					super.setRotationSet(true);
				}
			}
			
			TetriminoUtil.putTetriminoOnXRay(this, xRay);
		}
		
		if (super.getRotationPhase() == 2 && !super.getRotationSet()) {
			
			x0a = super.getBlockX(0) - 1;
			y0a = super.getBlockY(0);
			x0b = super.getBlockX(0) - 2;
			y0b = super.getBlockY(0);
			
			x1 = super.getBlockX(1);
			y1 = super.getBlockY(1) - 1;
			
			TetriminoUtil.removeTetriminoFromXRay(this, xRay);

			if (TetriminoUtil.pInRange(x0a, y0a) && TetriminoUtil.pInRange(x0b, y0b) && TetriminoUtil.pInRange(x1, y1)) {

				
				if (!xRay[y0a][x0a] && !xRay[y0b][x0b] && !xRay[y1][x1]) {


					super.getBlock(0).setXY((super.getBlockX(0) - 2),
							(super.getBlockY(0)));
					super.getBlock(1).setXY((super.getBlockX(1) - 1),
							(super.getBlockY(1) + 1));
					super.getBlock(3).setXY((super.getBlockX(3) + 1),
							(super.getBlockY(3) + 1));

					super.setRotationPhase(3);
					super.setRotationSet(true);
				}
			}
			
			TetriminoUtil.putTetriminoOnXRay(this, xRay);
		}
		
		if (super.getRotationPhase() == 3 && !super.getRotationSet()) {
			
			x0a = super.getBlockX(0);
			y0a = super.getBlockY(0) - 1;
			x0b = super.getBlockX(0);
			y0b = super.getBlockY(0) - 2;
			
			x1 = super.getBlockX(1) + 1;
			y1 = super.getBlockY(1);
			
			TetriminoUtil.removeTetriminoFromXRay(this, xRay);

			if (TetriminoUtil.pInRange(x0a, y0a) && TetriminoUtil.pInRange(x0b, y0b) && TetriminoUtil.pInRange(x1, y1)) {


				if (!xRay[y0a][x0a] && !xRay[y0b][x0b] && !xRay[y1][x1]) {


					super.getBlock(0).setXY((super.getBlockX(0)),
							(super.getBlockY(0) - 2));
					super.getBlock(1).setXY((super.getBlockX(1) - 1),
							(super.getBlockY(1) - 1));
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