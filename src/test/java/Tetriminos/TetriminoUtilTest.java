package test.java.Tetriminos;

import org.junit.*;

import Tetrimino.TetriminoUtil;

import static org.junit.Assert.*;

public class TetriminoUtilTest {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testMethod() {
	    assertTrue(TetriminoUtil.pInRange(5, 7));
	    assertFalse(TetriminoUtil.pInRange(42, 42));
	}
}
