package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{
	private String nomeAttrezzo;

	public StanzaBuia(String nome, String attrezzo) {
		super(nome);
		this.nomeAttrezzo = new String(attrezzo);
	}
	
	/**
	 *	Restituisce una descrizione della stanza pari a stanza buia, se non ha l'attrezzo desiderato
	 */
	
	@Override
	public String getDescrizione() {
		if(!this.hasAttrezzo(nomeAttrezzo)) {
			return "Qui c'è buio pesto!";
		
		}else {
			return this.toString();
		}
	}
}
