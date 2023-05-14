package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando{
	private IO io;
	
	public ComandoGuarda() {
	}

	@Override
	public void esegui(Partita partita) {
		this.io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione() + partita.getGiocatore().getBorsa().toString());
		this.io.mostraMessaggio("\nHai ancora a disposizione:");
		System.out.print(partita.getGiocatore().getCfu());
		this.io.mostraMessaggio(" tentativi");
	}

	@Override
	public void setParametro(String parametro) {}

	@Override
	public void setIo(IO io) {
		this.io = io;
	}
}
