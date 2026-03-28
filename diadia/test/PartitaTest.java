import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


class PartitaTest {
	
	private Partita partita;
	
	@BeforeEach
	public void setUp() {
		//prepariamo l'ambiente prima di ogni test
		this.partita = new Partita();
	}
	
	@Test
	public void testIsfinitaCfu() {
		this.partita.setCfu(0);
		assertTrue(this.partita.isFinita());	
	}
	
	@Test
	public void testIsFinitaVinta() {
		Stanza stanzaVincente = this.partita.getStanzaVincente();
		
		this.partita.setStanzaCorrente(stanzaVincente);
		
		assertTrue(this.partita.isFinita());
	}
	
	@Test
	public void testIsFinitaManuale() {
		this.partita.setFinita();
		assertTrue(this.partita.isFinita());
	}
	
	@Test
	public void testIsFinita() {
		this.partita.setFinita();
		assertTrue(this.partita.isFinita());
	}
	//---------------------------------------------
	
	@Test
	public void testStartVinta() {
		assertFalse(this.partita.vinta());
	}
	
	@Test
	public void testIsVinta(){
		Stanza stanzaVincente = this.partita.getStanzaVincente();
		
		this.partita.setStanzaCorrente(stanzaVincente);
		assertTrue(this.partita.vinta());
	}
	
	@Test
	public void testVintaEsplorazione() {
		Stanza start = this.partita.getStanzaCorrente();
		Stanza aulaAd = start.getStanzaAdiacente("est");
		
		this.partita.setStanzaCorrente(aulaAd);
		
		assertFalse(this.partita.vinta());
	}
	
	
	
}
