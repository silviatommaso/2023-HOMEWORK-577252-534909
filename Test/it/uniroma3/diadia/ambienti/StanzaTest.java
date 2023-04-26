package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaTest {
	
	private Stanza bagno;
	private Stanza camera;
	private Attrezzo martello;
	
	@BeforeEach
	public void setUp() {
		this.bagno = new Stanza("Bagno");
		this.camera = new Stanza("Camera");
		this.martello = new Attrezzo("Martello", 7);
		
		this.bagno.addAttrezzo(this.martello);
	}
	
	@Test
	public void stanzaAdiacenteTest() {
		this.bagno.impostaStanzaAdiacente("destra", camera);
		assertEquals("Camera", this.bagno.getStanzaAdiacente("destra").getNome());
	}
	
	@Test
	public void attrezzoEPresenteNellaStanzaTest() {
		assertTrue(this.bagno.hasAttrezzo("Martello"));
	}
	
	@Test
	public void attrezzoCorrettamenteRimossoDallaStanza() {
		assertTrue(this.bagno.removeAttrezzo(this.martello));
	}
	
	@Test
	public void attrezzoNonRimossoDallaStanzaPercheNonEsisteNellaStanza() {
		assertFalse(this.camera.removeAttrezzo(this.martello));
	}
	
	@Test
	public void attrezzoAggiuntoNellaStanza() {
		assertTrue(this.camera.addAttrezzo(this.martello));
	}
}
