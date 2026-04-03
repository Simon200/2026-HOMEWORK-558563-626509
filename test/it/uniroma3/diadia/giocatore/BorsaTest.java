package it.uniroma3.diadia.giocatore;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class BorsaTest {
	
	private Borsa borsa;
	private Attrezzo attrezzoLeggero;
	private Attrezzo attrezzoPesante;
	
	@BeforeEach
	void setUp() {
		borsa = new Borsa();
		this.attrezzoLeggero = new Attrezzo("piuma", 1);
		this.attrezzoPesante = new Attrezzo("incudine", 11);
	}
	
	@Test
	void testAddAttrezzoPesoConsentito() {
		// Caso 1: Aggiunta normale (deve restituire true)
		
		assertTrue(borsa.addAttrezzo(attrezzoLeggero));
		assertEquals(attrezzoLeggero, this.borsa.getAttrezzo("piuma"));
	}
	
	@Test
	void testAddAttrezzoTroppoPesante() {
		// Caso 2: Superamento del peso massimo (11kg > 10kg)
		
		assertFalse(this.borsa.addAttrezzo(attrezzoPesante));
		assertNull(this.borsa.getAttrezzo("incudine"));
	}
	
	@Test
	void testAddAttrezzoOltreLimiteNumero() {
		// Caso 3: Superamento del numero massimo di oggetti (10)
		
		for(int i = 0; i < 10; i++) {
			this.borsa.addAttrezzo(new Attrezzo("oggetto" + i, 0));
		}
		// L'undicesimo deve fallire anche se pesa 0kg
		assertFalse(this.borsa.addAttrezzo(new Attrezzo("extra", 0)));
	}
	
	
}
