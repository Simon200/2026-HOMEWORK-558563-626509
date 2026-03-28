
/**
 * Questa classeha la responsabilità di creare il labirinto
 * di memorizzare la stanzainiziale (entrata) e quella finale (uscita)
 *
 * @author  Simone Felice
 * @see Partita
 * @version alpha
 */

public class Labirinto {
	
	private Stanza entrata;
	private Stanza uscita;
	
	/* costruttore della classe*/
	public Labirinto() {

		/* crea gli attrezzi */
    	Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
    	
		/* crea stanze del labirinto */
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		
		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);

        /* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);

		// il gioco comincia nell'atrio
        this.entrata = atrio; 
      //finisce in biblioteca
		this.uscita = biblioteca;
	}
	
	/*metodi della classe*/
	
	/*@return stanza di entrata del labirito*/
	public Stanza getEntrata() {
		return this.entrata;
	}
	
	/*@return stanza di uscita del labirito*/
	public Stanza getUscita() {
		return this.uscita;
	}
}
