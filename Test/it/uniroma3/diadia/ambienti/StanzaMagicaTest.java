package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaMagicaTest {
	private Attrezzo attrezzo;
	private StanzaMagica stanza;

	@BeforeEach
	public void setUp(){
		this.attrezzo = new Attrezzo("Attrezzo", 2);
		this.stanza = new StanzaMagica("stanza1");
	}

	@Test
	public void testAggiungiAttrezzoAllaStanza() {
		assertTrue(this.stanza.addAttrezzo(attrezzo));
	}
	
	@Test
	public void testAggiungiAttrezzoAllaStanzaSenzaModifiche() {
		this.stanza.addAttrezzo(attrezzo);
		assertEquals("Attrezzo", this.stanza.getAttrezzo(attrezzo.getNome()).getNome());
	}
	
	@Test
	public void testAggiungiAttrezzoAllaStanzaConModifiche() {
		for(int i=0; i<3; i++) {
			this.stanza.addAttrezzo(new Attrezzo("nuovoAttrezzo"+i, 1));
		}
		this.stanza.addAttrezzo(new Attrezzo("AttrezzoInvertito", 1));
		assertTrue(this.stanza.hasAttrezzo("otitrevnIozzerttA"));
		assertEquals(2, this.stanza.getAttrezzo("otitrevnIozzerttA").getPeso());
	}

}
