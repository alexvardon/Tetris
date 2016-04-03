package test.java.Tetriminos;

import org.junit.*;

import Tetrimino.Tetrimino;

import static org.junit.Assert.*;

public class TetriminoTest {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testGetters() {
		Tetrimino t = new Tetrimino(0, 1, 2, 3, 4, 5, 6, 7, 8);
		Tetrimino t2 = new Tetrimino(1, 2, 3, 4, 5, 6, 7, 8, 9);
	    assertEquals(0, t.getBlockX(0));
	    assertEquals(2, t.getBlockX(1));
	    assertEquals(4, t.getBlockX(2));
	    assertEquals(6, t.getBlockX(3));
	    assertEquals(1, t.getBlockY(0));
	    assertEquals(3, t.getBlockY(1));
	    assertEquals(5, t.getBlockY(2));
	    assertEquals(7, t.getBlockY(3));
	    assertEquals(8, t.getBlockImg(0));
	    assertEquals(8, t.getBlockImg(1));
	    assertEquals(8, t.getBlockImg(2));
	    assertEquals(8, t.getBlockImg(3));
	    assertFalse(t.isEqualTo(t2));
	}
}
