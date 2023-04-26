package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando{
	private String direzione;
	private IO io;
	
	public ComandoVai() {
	}
	
	/**
	 * Imposto la direzione
	 */
	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;	 
	} 
	
	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	@Override
	public void esegui(Partita partita) {
		
		if(this.direzione==null) {
			this.io.mostraMessaggio("Dove vuoi andare?\nSpecifica una direzione!");
		}else {
			Stanza prossimaStanza = null;
			prossimaStanza = partita.getStanzaCorrente().getStanzaAdiacente(this.direzione);
			if (prossimaStanza == null)
				this.io.mostraMessaggio("Direzione inesistente \n\nStanza corrente:");
			else {
				partita.setStanzaCorrente(prossimaStanza);
				int cfu = partita.getGiocatore().getCfu()-1;
				partita.getGiocatore().setCfu(cfu--);
			}
			this.io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
			}
		}

	@Override
	public void setIo(IO io) {
		this.io = io;
	}
	}
	

