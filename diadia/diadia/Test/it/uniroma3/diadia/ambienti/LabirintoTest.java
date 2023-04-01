package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LabirintoTest {

	private Labirinto labirinto;
	private Stanza bagno;
	
	@BeforeEach
	public void setUp() {
		this.labirinto = new Labirinto();
		this.bagno = new Stanza("Bagno");
	}
	
	@Test
	public void RitornaLaStanzaVincente() {
		assertNotNull(this.labirinto.getStanzaVincente());
	}
}
