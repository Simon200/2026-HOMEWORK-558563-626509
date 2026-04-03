package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @author  Simone Felice
 * @author  Matteo Pozza
 * @see *Stanza
 * @version HWA
 */

public class Partita {

	private Giocatore giocatore;
	private Labirinto labirinto;
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	private boolean finita;
	
	/**
	 * Crea una nuova partita e la inizializza.
	 */
	public Partita(){
		
		// Chiediamo al Labirinto di costruirsi (stanze, attrezzi e collegamenti)
		this.labirinto = new Labirinto();
		
		//crea il giocatore con 20 cfu e borsa (inventario)
		this.giocatore = new Giocatore(); 
		
		// Impostiamo lo stato iniziale della partita usando i getter di Labirinto
		this.stanzaCorrente = this.labirinto.getEntrata();
		this.stanzaVincente = this.labirinto.getUscita();
		
		this.finita = false;
	}
	
	/**
	 * restituisce la stanza vincente
	 * @return stanzaVincente
	 */
	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}
	
	/**
	 * Imposta la stanza corrente
	 * @param stanzaCorrente
	 */
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}
	
	/**
	 * restituisce la stanza corrente
	 * @return stanzaCorrente
	 */
	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	/**
	 * restituisce la stanza vincente
	 * @return stanzaVincente
	 */
	public Giocatore getGiocatore() {
		return this.giocatore;
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente()== this.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (this.giocatore.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 */
	public void setFinita() {
		this.finita = true;
	}

}
