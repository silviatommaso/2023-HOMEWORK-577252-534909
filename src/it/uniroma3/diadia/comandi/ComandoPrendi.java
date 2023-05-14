package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando{
	private IO io;
	private String nomeAttrezzo;
	
	public ComandoPrendi() {
	}
 
	/**
	 * Eseguo comando prendi
	 */
	@Override
	public void esegui(Partita partita) {
	
		if(this.nomeAttrezzo==null) {
			this.io.mostraMessaggio("Cosa vuoi prendere?");
		}else {
			if(partita.getStanzaCorrente().hasAttrezzo(this.nomeAttrezzo)) {
				Attrezzo attrezzo = null;
				attrezzo = partita.getStanzaCorrente().getAttrezzo(this.nomeAttrezzo);
				
				
				//rimuovo l'attrezzo dalla stanza
				if(partita.getStanzaCorrente().removeAttrezzo(attrezzo)) {
					this.io.mostraMessaggio("Oggetto Preso!");
					}
				
				//aggiungo l'attrezzo in borsa
				partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
				
			}else {
				this.io.mostraMessaggio("L'oggetto che cerchi non è presente nella stanza");
			}
		}
	}

	@Override
	public void setParametro(String nomeAttrezzo) {
		this.nomeAttrezzo=nomeAttrezzo;
	}

	@Override
	public void setIo(IO io) {
		this.io = io;
	}
	
}
