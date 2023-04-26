package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaProtected extends StanzaProtected{
	final static private int SOGLIA_MAGICA_DEFAULT = 3;
	
	private int contatoreAttrezziPosati;
	private int sogliaMagica;

	/**
	 * Costruttori
	 * @param nome
	 * @param sogliaMagica
	 */
	
	public StanzaMagicaProtected(String nome, int sogliaMagica) {
		super(nome);
		this.sogliaMagica = sogliaMagica;
		this.contatoreAttrezziPosati = 0;
	}
	
	public StanzaMagicaProtected(String nome) {
		this(nome, SOGLIA_MAGICA_DEFAULT);
		//super(nome);
		//this.sogliaMagica = SOGLIA_MAGICA_DEFAULT;
	}

	
	/**
	 * Restituisce un attrezzo a partire dall'attrezzo
	 * passato come parametro
	 */
	
	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		Attrezzo nuovoAttrezzo;
		int peso; 
		
		StringBuilder nomeInvertito;
		nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();
		peso = attrezzo.getPeso()*2;
		nuovoAttrezzo = new Attrezzo(nomeInvertito.toString(), peso);
		return nuovoAttrezzo;

	}
	
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		this.contatoreAttrezziPosati++;
		System.out.println(this.contatoreAttrezziPosati);
		if(this.contatoreAttrezziPosati>this.sogliaMagica) {
			attrezzo = this.modificaAttrezzo(attrezzo);
			if(this.numeroAttrezzi<this.attrezzi.length)
				attrezzi[numeroAttrezzi]=attrezzo;
			return true;
		}else {
			return false;
		}
	}
}
	
