package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{
	private String nomeDirezioneBloccata;
	private String nomeAttrezzoSbloccante;
	
	public StanzaBloccata(String nome, String nomeDirezioneBloccata, String nomeAttrezzoSbloccante) {
		super(nome);
		this.nomeDirezioneBloccata = new String(nomeDirezioneBloccata);
		this.nomeAttrezzoSbloccante = new String(nomeAttrezzoSbloccante);
	}
	
	/**
	 * Blocca la direzione di quella stanza
	 * @param direzione
	 */
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(direzione.equals(this.nomeDirezioneBloccata) && !this.hasAttrezzo(this.nomeAttrezzoSbloccante)) {
			return (Stanza)this;
		}else {
			return super.getStanzaAdiacente(direzione);
		}		
	}
	
	@Override
	public String getDescrizione() {
		return super.getDescrizione().toString() + "\n\nOra sei in una stanza con una direzione bloccata!\nSe c'è la chiave usala o esci da un'altra parte".toString();
	}	
}
