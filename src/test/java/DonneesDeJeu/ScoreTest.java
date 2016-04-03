package test.java.DonneesDeJeu;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import DonneesDeJeu.Score;

public class ScoreTest {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testGetters() {
		Score s = new Score();
		assertEquals(0, s.getScore());
		s.addPoints();
		assertEquals(10, s.getScore());
	}
}
