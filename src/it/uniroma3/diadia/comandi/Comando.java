package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public interface Comando {
	
	/**
	 * esecuzione di un comando
	 * @param partita
	 */
	public void esegui(Partita partita);
	
	/**
	 * imposto il parametro del comando
	 */
	public void setParametro(String parametro);
	
	/**
	 * imposto io
	 */
	public void setIo(IO io);

}
