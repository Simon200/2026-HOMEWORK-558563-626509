package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe Borsa - ha il compito di gestire un inventario utilizzato
 * dal gocatore in un gioco di ruolo.
 * @author  Docente POO
 * @author  Simone Felice
 * @author  Matteo Pozza
 * @see *Partita
 * @version HWA
 */
public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	/**
	 * crea una borsa
	 * @param pesoMax é il peso che puoi inserire nella borsa*/
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10]; // speriamo bastino...
		this.numeroAttrezzi = 0;
	}
	/**
	 * inserisce un attrezzo nella borsa
	 * @param attrezzo é l'oggetto da inserire*/
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if (this.numeroAttrezzi == 10)
			return false;
		this.attrezzi[this.numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;
		return true;
	}

	public int getPesoMax() {
		return pesoMax;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i = 0; i < this.numeroAttrezzi; i++)
			if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
				a = attrezzi[i];
		return a;
	}

	public int getPeso() {
		int peso = 0;
		for (int i = 0; i < this.numeroAttrezzi; i++)
			peso += this.attrezzi[i].getPeso();
		return peso;
	}

	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo) != null;
	}
	/**
	 * rimuove un'attrezzo dalla borsa se presente.
	 * @param nomeAttrezzo attrezzo da rimuovere
	 * @return rimosso attrezzo rimosso*/
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo rimosso = null;
		// ricerco la posizione dell'attrezzo con il ciclo while  
		int i = 0;
		while(i <this.numeroAttrezzi && rimosso == null) {
			if(this.attrezzi[i].getNome().equals(nomeAttrezzo))
				rimosso = this.attrezzi[i];
			else
				i++;	
		}
		//se rimosso non è null significa che abbiamo trovato l'elemento da "rimuovere"
		if(rimosso != null) {
			// Compattiamo l'array spostando tutto da i+1 verso sinistra
			for(int j = i; j < this.numeroAttrezzi - 1; j++)
				this.attrezzi[j] =this.attrezzi[j+1];
			//aggiorno il numero di attrezzi
			this.attrezzi[this.numeroAttrezzi - 1] = null;
			this.numeroAttrezzi--;
		}
		
		return rimosso;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa (" + this.getPeso() + "kg/" + this.getPesoMax() + "kg): ");
			for (int i = 0; i < this.numeroAttrezzi; i++)
				s.append(attrezzi[i].toString() + " ");
		} else
			s.append("Borsa vuota");

		return s.toString();
	}

}
