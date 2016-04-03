package test.java.Tetriminos;

import org.junit.*;

import Tetrimino.Block;

import static org.junit.Assert.*;

public class BlockTest {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testGetters() {
		Block b = new Block(41, 42, 1);
	    assertEquals(41, b.getPosX());
	    assertEquals(42, b.getPosY());
	    assertEquals(1, b.getTextureImage());
	}
}
