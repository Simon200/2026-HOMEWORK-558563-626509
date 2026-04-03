package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class GiocatoreTest {
	
	private Giocatore giocatore;
	
	@BeforeEach
	void setUp() {
		giocatore = new Giocatore();
	}

	@Test
	void testGetCfu() {
		assertEquals(20, giocatore.getCfu());
	}
	
	@Test
	void testSetCfu() {
		giocatore.setCfu(30);
		assertEquals( 30, giocatore.getCfu());
	}
	
	@Test
	void testGetBorsa() {
		// Verifichiamo che il giocatore nasca con una borsa (non deve essere null)
		assertNotNull(giocatore.getBorsa());
	}
}
