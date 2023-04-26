package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBuiaTest {
	private StanzaBuia stanza;

	@BeforeEach
	public void setUp(){
		this.stanza = new StanzaBuia("stanza1", "candela");
	}

	@Test
	public void testLaStanzaEBuia() {
		assertEquals("Qui c'è buio pesto!",  this.stanza.getDescrizione());
	}
	
	@Test
	public void testLaStanzaNonEBuia() {
		Attrezzo attrezzo = new Attrezzo("candela", 1);
		this.stanza.addAttrezzo(attrezzo);
		assertNotEquals("Qui c'è buio pesto!",  this.stanza.getDescrizione());
	}

}
