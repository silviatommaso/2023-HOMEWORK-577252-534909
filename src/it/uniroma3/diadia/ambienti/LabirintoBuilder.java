package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder {
	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;
	private LinkedList<Stanza> stanze;
	
	public LabirintoBuilder() {
		stanze = new LinkedList<Stanza>();
	}
	
	/**
	 * Aggiunge la stanza iniziale alla lista
	 * @param nomeStanza
	 * @return
	 */
	public LabirintoBuilder addStanzaIniziale(String nomeStanza) {
		this.stanzaIniziale = new Stanza(nomeStanza);
		
		if(this.stanze.isEmpty()) {
			this.stanze.add(this.stanzaIniziale);
		}else {
			this.stanze.addLast(this.stanzaIniziale);
		}
		
		return this;
	}
	
	/**
	 * Aggiunge la stanza vincente alla lista
	 * @param nomeStanza
	 * @return
	 */
	public LabirintoBuilder addStanzaVincente(String nomeStanza) {
		this.stanzaVincente = new Stanza(nomeStanza);
		
		if(this.stanze.isEmpty()) {
			this.stanze.add(this.stanzaVincente);
		}else {
			this.stanze.addLast(this.stanzaVincente);
		}
		
		return this;
	}
	
	//restituisce il Labirinto così specificato
	public Labirinto getLabirinto() {
		Labirinto labirinto = new Labirinto();
		labirinto.addStanzaIniziale(this.stanzaIniziale);
		labirinto.addStanzaVincente(this.stanzaVincente);
		
		return labirinto;
	}
	
	/**
	 * aggiunge l'attrezzo all'ultima stanza inserita
	 * @param attrezzo
	 * @return
	 */
	public LabirintoBuilder addAttrezzo(String nome, int peso) {
		Attrezzo attrezzo = new Attrezzo(nome, peso);
		if(!this.stanze.isEmpty()) {
			this.stanze.getLast().addAttrezzo(attrezzo);
		}
		
		return this;
	}
	
	/**
	 * Aggiunge stanza adiacente
	 * @param nomeStanzaIniziale
	 * @param nomeStanzaVincente
	 * @param direzione
	 * @return
	 */
	public LabirintoBuilder addAdiacenza(String stanzaCorrente, String nomeStanzaAdiacente, String direzione) {
		if(!this.stanze.isEmpty()) {
			for(Stanza room : this.stanze) {
				if(room.getNome().equals(stanzaCorrente)) {
					room.impostaStanzaAdiacente(direzione, new Stanza(nomeStanzaAdiacente));
				}
			}
		}
		
		return this;
	}
	
	
	/**
	 * Aggiunge stanza
	 * @param nome
	 */
	public LabirintoBuilder addStanza(String nome) {
		Stanza stanza = new Stanza(nome);
		
		if(!this.stanze.contains(stanza)) {
			this.stanze.add(stanza);
		}
		
		return this;
	}
	
	
	/**
	 * Aggiungi stanza magica
	 * @param nome
	 * @param sogliaMagica
	 * @return
	 */
	public LabirintoBuilder addStanzaMagica(String nome, int sogliaMagica) {
		Stanza magic = new StanzaMagica(nome, sogliaMagica);
		
		if(!this.stanze.contains(magic)) {
			this.stanze.addLast(magic);
		}
		return this;
	}
	
	public LabirintoBuilder addStanzaMagica(String nome) {
		Stanza magic = new StanzaMagica(nome);
		
		if(!this.stanze.contains(magic)) {
			this.stanze.addLast(magic);
		}
		return this;
	}
	
	/**
	 * Aggiungi stanza bloccata
	 * @param nome
	 * @param direzioneBloccata
	 * @param attrezzoSbloccante
	 * @return
	 */
	public LabirintoBuilder addStanzaBloccata(String nome, String direzioneBloccata, String attrezzoSbloccante) {
		Stanza blocked = new StanzaBloccata(nome, direzioneBloccata, attrezzoSbloccante);
		
		if(!this.stanze.contains(blocked)) {
			this.stanze.addLast(blocked);
		}
		
		return this;
	}
	
	/**
	 * Aggiungi stanza buia
	 * @param nome
	 * @param attrezzoLuminoso
	 * @return
	 */
	public LabirintoBuilder addStanzaBuia(String nome, String attrezzoLuminoso) {
		Stanza dark = new StanzaBuia(nome, attrezzoLuminoso);
		
		if(!this.stanze.contains(dark)) {
			this.stanze.add(dark);
		}
		return this;
	}

	public List<Stanza> getListaStanze() {
		return this.stanze;
	}
	
	public Map<String, Stanza> getMapStanzeAdiacenti() {
		Map<String, Stanza> mappa = new HashMap<String, Stanza>();
		
		for(Stanza room : this.stanze) {
			mappa.put(room.getNome(), room);
		}
		return mappa;
	}
	
}
