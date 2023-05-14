package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
 
public class ComandoPosa implements Comando{
	private IO io;
	private String nomeAttrezzo;
	
	public ComandoPosa() {
	}

	/**
	 * Eseguo comando posa
	 */
	@Override
	public void esegui(Partita partita) {
		
		if(this.nomeAttrezzo==null) {
			this.io.mostraMessaggio("Cosa vuoi posare?");
		}else if(partita.getGiocatore().getBorsa().hasAttrezzo(this.nomeAttrezzo) && this.nomeAttrezzo!=null) {
				Attrezzo attrezzo = null;
				attrezzo = partita.getGiocatore().getBorsa().getAttrezzo(this.nomeAttrezzo);
				
				//tolgo l'attrezzo dalla borsa
				partita.getGiocatore().getBorsa().removeAttrezzo(this.nomeAttrezzo); 
				
				//aggiungo l'attrezzo alla stanza
				partita.getStanzaCorrente().addAttrezzo(attrezzo);
				this.io.mostraMessaggio("Oggetto rimosso dalla Borsa!");
			}else{
				this.io.mostraMessaggio("L'oggetto che cerchi non è presente nella borsa");
			}
		}
	
	/**
	 * imposto il nome dell'attrezzo
	 */
	@Override
	public void setParametro(String nomeAttrezzo) {
		this.nomeAttrezzo = nomeAttrezzo;
		
	}

	@Override
	public void setIo(IO io) {
		this.io = io;
	}

}
