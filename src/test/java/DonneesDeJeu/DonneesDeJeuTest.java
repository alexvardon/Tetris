package test.java.DonneesDeJeu;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import DonneesDeJeu.DonneesDeJeu;

public class DonneesDeJeuTest {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testGetters() {
		DonneesDeJeu ddj = new DonneesDeJeu();
		assertEquals(0, ddj.getPoints());
		assertEquals("I",ddj.getNiveau());
		assertFalse(ddj.changedNiveau());
		assertEquals(1000L, ddj.getMiliseconds());
		ddj.addPoints();
		assertEquals(10, ddj.getPoints());
		assertEquals("I",ddj.getNiveau());
		assertFalse(ddj.changedNiveau());
		assertEquals(1000L, ddj.getMiliseconds());
		ddj.niveauSup(10, 1);
		assertEquals(10, ddj.getPoints());
		assertEquals("II",ddj.getNiveau());
		assertTrue(ddj.changedNiveau());
		assertEquals(900L, ddj.getMiliseconds());
	}
}
