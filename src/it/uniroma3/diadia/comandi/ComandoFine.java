package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando{
	private IO io;  
	
	public ComandoFine() {
	}

	@Override
	public void esegui(Partita partita) {
		partita.setFinita();
		this.io.mostraMessaggio("Grazie per aver giocato!");
	}
	
	@Override
	public void setParametro(String parametro) {}

	
	@Override
	public void setIo(IO io) {
		this.io = io;
		
	}
	
}
