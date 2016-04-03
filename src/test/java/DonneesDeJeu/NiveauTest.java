package test.java.DonneesDeJeu;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import DonneesDeJeu.Niveau;

public class NiveauTest {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testGetters() {
		Niveau n = new Niveau();
		assertEquals(1, n.getNiveauVal());
		assertEquals("I", n.getNiveau());
		n.niveauSuivant();
		assertEquals(2, n.getNiveauVal());
		assertEquals("II", n.getNiveau());
	}
}
