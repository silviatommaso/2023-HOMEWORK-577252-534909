package it.uniroma3.diadia;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class PartitaTest {
	private Partita partita;

	@BeforeEach
	public void setUp() {
		this.partita = new Partita();
		
	}
	
	@Test
	public void partitaPersaTest() {
		this.partita.getGiocatore().setCfu(0);
		assertTrue(this.partita.persa());
	}
	
	@Test
	public void partitaNonPersaTest() {
		this.partita.getGiocatore().setCfu(10);
		assertFalse(this.partita.persa());
	}
	
	@Test
	public void partitaVinta() {
		this.partita.setStanzaCorrente(this.partita.getStanzaVincente());
		assertTrue(this.partita.vinta());
	}
}
