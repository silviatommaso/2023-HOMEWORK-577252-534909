package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {
	private IO io;
	static final private String[] elencoComandi = {"vai     nord|sud|ovest|est", "\naiuto", "\nfine", "\nprendi   (nome attrezzo)", "\nposa   (nome attrezzo)"};

	
	public ComandoAiuto() {}
	
	@Override
	public void esegui(Partita partita) {
		for(int i=0; i<elencoComandi.length; i++)
			this.io.mostraMessaggio(elencoComandi[i]);
	}

	@Override
	public void setParametro(String parametro) {}

	@Override
	public void setIo(IO io) {
		this.io = io;
	}
	
	
}
