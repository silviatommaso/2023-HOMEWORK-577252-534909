package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class BorsaTest {
	private Borsa borsa;
	private Attrezzo attrezzo1;
	private Attrezzo attrezzo2;
	private Attrezzo attrezzo3;
	private Attrezzo attrezzo4;
	private List<Attrezzo> lista;
	private Set<Attrezzo> set;
	private Map<Integer, Set<Attrezzo>> mappa;
	
	@BeforeEach
	public void setUp() {
		this.borsa = new Borsa(30);
		this.attrezzo1 = new Attrezzo("piombo", 10);
		this.attrezzo2 = new Attrezzo("ps", 5);
		this.attrezzo3 = new Attrezzo("piuma", 1);
		this.attrezzo4 = new Attrezzo("libro", 5);
		this.borsa.addAttrezzo(attrezzo1);
		this.borsa.addAttrezzo(attrezzo2);
		this.borsa.addAttrezzo(attrezzo3);
		this.borsa.addAttrezzo(attrezzo4);
		this.lista = new ArrayList<Attrezzo>(4);
		this.set = new HashSet<Attrezzo>();
		this.mappa = new HashMap<Integer, Set<Attrezzo>>();
	}
	
	@Test
	public void nonAggiungeNuovoAttrezzoAllaBorsaPercheTroppoPesanteTest() {
		Attrezzo attrezzo = new Attrezzo("Martello", 30);
		assertFalse(this.borsa.addAttrezzo(attrezzo));
	}
	
	@Test
	public void aggiungiNuovoAttrezzoAllaBorsaTest() {
		assertTrue(this.borsa.addAttrezzo(new Attrezzo("Martello", 1)));
	}
	
	@Test 
	public void nonRimuoveAttrezzoPercheNonENellaBorsaTest() {
		Attrezzo attrezzo = new Attrezzo("Scivolo", 10);
		assertNull(this.borsa.removeAttrezzo(attrezzo.getNome()));
	}
	
	@Test
	public void rimuoviAttrezzoDallaBorsaTest() {
		assertEquals(attrezzo1, this.borsa.removeAttrezzo(attrezzo1.getNome()));
	}
	
	@Test
	public void laBorsaEVuotaTest() {
		this.borsa.removeAttrezzo(this.attrezzo1.getNome());
		this.borsa.removeAttrezzo(this.attrezzo2.getNome());
		this.borsa.removeAttrezzo(this.attrezzo3.getNome());
		this.borsa.removeAttrezzo(this.attrezzo4.getNome());
		assertTrue(this.borsa.isEmpty());
	}
	
	@Test
	public void laBorsaNonEVuotaTest() {
		Attrezzo attrezzo = new Attrezzo("vite", 2);
		this.borsa.addAttrezzo(attrezzo);
		assertFalse(this.borsa.isEmpty());
	}
	
	@Test
	public void getContenutoOrdinatoPerPesoTest() {
		this.lista.add(attrezzo3);
		this.lista.add(attrezzo4);
		this.lista.add(attrezzo2);
		this.lista.add(attrezzo1);
		assertEquals(this.lista, this.borsa.getContenutoOrdinatoPerPeso());
	}
	
	@Test
	public void getContenutoOrdinatoPerNomeTest() {
		this.set.add(attrezzo4);
		this.set.add(attrezzo1);
		this.set.add(attrezzo3);
		this.set.add(attrezzo2);
		assertEquals(this.set, this.borsa.getContenutoOrdinatoPerNome());
	}
	
	@Test
	public void getContenutoRaggruppatoPerPesoTest() {
		mappa = this.borsa.getContenutoRaggruppatoPerPeso();
		this.lista.add(attrezzo3);
		this.lista.add(attrezzo4);
		this.lista.add(attrezzo2);
		this.lista.add(attrezzo1);
		for(Attrezzo attrezzo : this.lista) {
			//assertTrue(this.lista);
		}
	}
	
	@Test
	public void getSortedSetOrdinatoPerPesoTest() {
		this.set.add(attrezzo4);
		this.set.add(attrezzo1);
		this.set.add(attrezzo3);
		this.set.add(attrezzo2);
		assertEquals(this.set ,this.borsa.getSortedSetOrdinatoPerPeso());
	}
}
