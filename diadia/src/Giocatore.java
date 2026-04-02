/**
 * Giocatore ha la responsabilità di gestire i CFU del giocatore e di
 * memorizzare gli attrezzi in un oggetto istanza della classe Borsa
 * 
 * @author Simone Felice
 * @version alpha
 */
public class Giocatore {

	static final private int CFU_INIZIALI = 20;
	
    private int cfu;
    private borsa borsa;

    public Giocatore() {
        this.cfu = CFU_INIZIALI;
        
        this.borsa = new borsa();
    }

    public int getCfu() {
        return cfu;
    }

    public void setCfu(int cfu) {
        this.cfu = cfu;
    }

    public void decrementaCfu() {
        if(cfu > 0) {
            cfu--;
        }
    }

    public borsa getBorsa() {
        return borsa;
    }
}
