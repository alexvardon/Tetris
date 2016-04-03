package Tetrimino;

public class TetriminoUtil {

	public static boolean pInRange(int x, int y){
		if(x >= 0 && x < 10 && y >= 0 && y < 20){
			return true;
		}
		return false;
	}
	
	public static void removeTetriminoFromXRay(Tetrimino tetrimino, boolean[][] ar){
	      for (int i = 0; i < 4; i++)
	      {
	         ar[tetrimino.getBlockY(i)][tetrimino.getBlockX(i)] = false;
	      }
	}
	
	public static void putTetriminoOnXRay(Tetrimino tetrimino, boolean[][] ar) {
	      for (int i = 0; i < 4; i++)
	      {
	    	  ar[tetrimino.getBlockY(i)][tetrimino.getBlockX(i)] = true;
	      }
	}
}