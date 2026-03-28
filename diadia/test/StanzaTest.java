import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class StanzaTest {
	private Stanza stanzaVuota;
	private Attrezzo spada;
	
	@BeforeEach
	public void setUp() {
		//prepariamo l'ambiente prima di ogni test
		stanzaVuota = new Stanza("N11");
		spada = new Attrezzo("spada", 5);
	}
	//-------------------------------------------------------
	@Test
	public void testAddAttrezzo() {
		// Verifichiamo che l'aggiunta funzioni
        assertTrue(stanzaVuota.addAttrezzo(spada));
        // Verifichiamo che l'attrezzo sia effettivamente presente
        assertTrue(stanzaVuota.hasAttrezzo("spada"));
	}
	
	@Test
	public void testAddTroppiAttrezzi() {
		for(int i = 0; i < 10; i++) {
			stanzaVuota.addAttrezzo(new Attrezzo("attrezzo" + i, 1));
		}
		
		Attrezzo extra = new Attrezzo("extra", 1);
		assertFalse(stanzaVuota.addAttrezzo(extra));
	}
	
	@Test
	public void testAddAttrezzoNull() {
		assertFalse(stanzaVuota.addAttrezzo(null));
	}
	
	//----------------------------------------------------
	
	@Test
	public void testStanzaAdiacenteInisistente() {
		//verifico che non ci sia una stanza adiacente
		assertNull(stanzaVuota.getStanzaAdiacente("sud"));
	}
	
	@Test
    public void testGetStanzaAdiacente() {
        Stanza N1 = new Stanza("N1");
        stanzaVuota.impostaStanzaAdiacente("nord", N1);
        
        // Verifichiamo che a nord ci sia N1
        assertEquals(N1, stanzaVuota.getStanzaAdiacente("nord"));
    }
	
	@Test
	public void testImpostaStanzaAdiacenteAggiornamento() {
		Stanza n1 = new Stanza("N1");
		Stanza n2 = new Stanza("N2");
		
		stanzaVuota.impostaStanzaAdiacente("sud", n1);
		stanzaVuota.impostaStanzaAdiacente("sud", n2);
		
		assertEquals(n2, stanzaVuota.getStanzaAdiacente("sud"));
	}
	
	@Test
	public void testTroppeStanze() {
		Stanza n1 = new Stanza("N1");
		Stanza n2 = new Stanza("N2");
		Stanza n3 = new Stanza("N3");
		Stanza n4 = new Stanza("N4");
		Stanza n5 = new Stanza("StanzaDiTroppo");
		//collego le stanze create alla stanza vuota
		stanzaVuota.impostaStanzaAdiacente("sud", n1);
		stanzaVuota.impostaStanzaAdiacente("ovest", n2);
		stanzaVuota.impostaStanzaAdiacente("nord", n3);
		stanzaVuota.impostaStanzaAdiacente("est", n4);
		
		//forzo l'inserimento della quinta direzione
		stanzaVuota.impostaStanzaAdiacente("sudEst", n5);
		//verifico
		assertNull(stanzaVuota.getStanzaAdiacente("sudEst"));
	}
	
}
