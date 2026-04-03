package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

class LabirintoTest {
	
	private Labirinto labirinto;
	
	@BeforeEach
	public void setUp() {
		//prepariamo l'ambiente prima di ogni test
		labirinto = new Labirinto();
	}
	
	@Test
	void testGetEntrata() {
		assertEquals( "Atrio", labirinto.getEntrata().getNome());
	}
	
	@Test
	void testGetUscita() {
		assertEquals( "Biblioteca", labirinto.getUscita().getNome());
	}
	
	@Test
	void testAdiacenzaIniziale() {
		// Verifichiamo che il collegamento Atrio -> Nord porti effettivamente in Biblioteca
		Stanza atrio = this.labirinto.getEntrata();
		Stanza biblioteca = this.labirinto.getUscita();
		
		assertEquals(biblioteca, atrio.getStanzaAdiacente("nord"));
	}
	
}
