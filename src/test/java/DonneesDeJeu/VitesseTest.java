package test.java.DonneesDeJeu;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import DonneesDeJeu.Vitesse;

public class VitesseTest {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testGetters() {
		Vitesse v = new Vitesse();
		assertEquals(1000L, v.getVitesse());
		v.vitesseSuivante();
		assertEquals(900L, v.getVitesse());
	}
}
