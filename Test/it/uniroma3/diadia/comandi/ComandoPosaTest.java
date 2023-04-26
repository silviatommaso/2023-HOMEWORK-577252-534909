package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;

class ComandoPosaTest {
	private Partita partita;
	private Attrezzo attrezzo;
	private Comando comando;

	@BeforeEach
	public void setUp() {
		this.partita = new Partita();
		this.attrezzo = new Attrezzo("Martello", 3);
		this.comando = new ComandoPosa();
		
		this.partita.getGiocatore().borsa.addAttrezzo(this.attrezzo);
		this.comando.setParametro(this.attrezzo.getNome());
		this.comando.esegui(this.partita);	
	}
	
	@Test
	void oggettoCorrettamenteRimossoDallaBorsaTest() {	
		assertFalse(this.partita.getGiocatore().borsa.hasAttrezzo(this.attrezzo.getNome()));
	}
	
	@Test
	void oggettoRipostoNellaStanza() {
		assertEquals(this.partita.getStanzaCorrente().getAttrezzo(this.attrezzo.getNome()), this.attrezzo );
	}
}
