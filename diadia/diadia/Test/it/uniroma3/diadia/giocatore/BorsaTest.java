package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class BorsaTest {
	private Borsa borsa;
	private Attrezzo attrezzo;
	
	@BeforeEach
	public void setUp() {
		this.borsa = new Borsa(20);
		this.attrezzo = new Attrezzo("Bullone", 3);
	}
	
	@Test
	public void nonAggiungeNuovoAttrezzoAllaBorsaPercheTroppoPesante() {
		this.attrezzo = new Attrezzo("Martello", 40);
		assertFalse(this.borsa.addAttrezzo(attrezzo));
	}
	
	@Test
	public void aggiungiNuovoAttrezzoAllaBorsa() {
		this.attrezzo = new Attrezzo("Martello", 20);
		assertTrue(this.borsa.addAttrezzo(attrezzo));
	}
	
	@Test 
	public void nonRimuoveAttrezzoPercheNonENellaBorsa() {
		assertNull(this.borsa.removeAttrezzo(attrezzo.getNome()));
	}
	
	@Test
	public void rimuoviAttrezzoDallaBorsa() {
		this.borsa.addAttrezzo(this.attrezzo);
		assertEquals(this.attrezzo, this.borsa.removeAttrezzo(this.attrezzo.getNome()));
	}
	
	@Test
	public void laBorsaEVuota() {
		assertTrue(this.borsa.isEmpty());
	}
	
	@Test
	public void laBorsaNonEVuota() {
		this.borsa.addAttrezzo(this.attrezzo);
		assertFalse(this.borsa.isEmpty());
	}
}
