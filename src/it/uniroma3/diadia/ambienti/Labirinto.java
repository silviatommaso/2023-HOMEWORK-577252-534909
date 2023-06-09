package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Labirinto {
	
	private Stanza stanzaIngresso;
	private Stanza stanzaUscita;
	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;
	
	public Labirinto() {
		creaStanze();
	}

	 /**
     * Crea tutte le stanze e le porte di collegamento
     */
    private void creaStanze() {

		/* crea gli attrezzi */
    	Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
		Attrezzo chiave = new Attrezzo("chiave", 2);
    	
		/* crea stanze del labirinto */
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		StanzaMagica stanzaMagica = new StanzaMagica("magic");
		StanzaBuia aulaN18 = new StanzaBuia("aula N18","lanterna");
		StanzaBloccata ufficio = new StanzaBloccata("Ufficio","nord","chiave");
		
		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("nord", ufficio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);
		aulaN11.impostaStanzaAdiacente("sud", ufficio);
		laboratorio.impostaStanzaAdiacente("est", stanzaMagica);
		stanzaMagica.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN10.impostaStanzaAdiacente("sud", stanzaMagica);
		stanzaMagica.impostaStanzaAdiacente("nord", aulaN10);
		aulaN18.impostaStanzaAdiacente("ovest", stanzaMagica);
		stanzaMagica.impostaStanzaAdiacente("est", aulaN18);
		ufficio.impostaStanzaAdiacente("sud",aulaN11);
		ufficio.impostaStanzaAdiacente("nord",aulaN11);

        /* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);
		ufficio.addAttrezzo(chiave);

		// il gioco comincia nell'atrio
        stanzaIngresso = atrio;  
		stanzaUscita = biblioteca;
    }
    
    public Stanza addStanzaIniziale(Stanza stanzaIniziale) {
		this.stanzaIniziale = stanzaIniziale;
		return this.stanzaIniziale;
	}
	
	public Stanza addStanzaVincente(Stanza stanzaVincente) {
		this.stanzaVincente = stanzaVincente;
		return this.stanzaVincente;
	}

	public Stanza getStanzaVincente() {
		return stanzaUscita;
	}
	public Stanza getStanzaCorrente() {
		return stanzaIngresso;
	}

	public Stanza getStanzaIniziale() {
		// TODO Auto-generated method stub
		return this.stanzaIniziale;
	}
}
