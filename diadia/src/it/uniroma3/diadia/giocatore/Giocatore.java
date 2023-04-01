package it.uniroma3.diadia.giocatore;

public class Giocatore {
	
	static final private int CFU_INIZIALI = 20;

	private int cfu;
	
	public Giocatore() {
		this.cfu = CFU_INIZIALI;	
	}
	
	public Borsa borsa = new Borsa();
	
	//getter
	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}	
}