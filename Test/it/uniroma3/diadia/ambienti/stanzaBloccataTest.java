package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class stanzaBloccataTest {
	private StanzaBloccata stanza1;
	private Stanza stanza2;

	@BeforeEach
	public void setUp() {
		stanza1 = new StanzaBloccata("stanza1", "nord", "passepartout");
		stanza2 = new Stanza("stanza2");
		this.stanza2.impostaStanzaAdiacente("est", stanza1);
		this.stanza1.impostaStanzaAdiacente("ovest", stanza2);
		this.stanza1.impostaStanzaAdiacente("nord", stanza2);
	}

	@Test
	public void testStanzaAdiacenteStanzaBloccataNonCeAttrezzo() {
		assertEquals(stanza1, stanza1.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testStanzaAdiacenteStanzaNonBloccataPerAtrezzoSbloccante() {
		stanza1.addAttrezzo(new Attrezzo("passepartout", 2));;
		assertEquals(stanza2, stanza1.getStanzaAdiacente("nord"));
	}
}
