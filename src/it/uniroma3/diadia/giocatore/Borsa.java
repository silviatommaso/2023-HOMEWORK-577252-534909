package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;


public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Map<String, Attrezzo> attrezzi;
	private int pesoMax;
	
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new HashMap<String, Attrezzo>();
	}
	
	//************************************************************************************************************************************************************************************
	
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(this.getPeso()+attrezzo.getPeso()<this.pesoMax) {
			this.attrezzi.put(attrezzo.getNome(), attrezzo);
			return true;
		}else {
			return false;
		}
	}
	
	//************************************************************************************************************************************************************************************

	//getter
	public int getPesoMax() {
		return pesoMax;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.get(nomeAttrezzo);
	}
	
	public int getPeso() {
		List<Attrezzo> lista = new ArrayList<Attrezzo>();
		lista.addAll(this.attrezzi.values());
		int peso = 0;
		
		for(Attrezzo attrezzo : lista) {
			if(lista.size()!=0 && attrezzo!=null) {
				peso += attrezzo.getPeso();
			}
		}
		return peso;
	}
	
	//************************************************************************************************************************************************************************************
	
	public boolean isEmpty() {
			return this.attrezzi.size()==0;
	}
	
	//************************************************************************************************************************************************************************************
		
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
		}

	//************************************************************************************************************************************************************************************

	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.remove(nomeAttrezzo);
	}
	
	//************************************************************************************************************************************************************************************
	
	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa: " + this.getContenutoOrdinatoPerNome());
		}
		else {
			s.append("\nBorsa vuota");
		}
				
		return s.toString();
	}
	
	//************************************************************************************************************************************************************************
	
	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		final List<Attrezzo> lista = new ArrayList<Attrezzo>(this.attrezzi.values());
		Collections.sort(lista, new ComparatoreAttrezziPerPesoPoiNome());
		return lista;
	}
	
	//***************************************************************************************************************************************************************************************************************
	
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		final TreeSet<Attrezzo> risultato = new TreeSet<Attrezzo>(new ComparatoreAttrezziPerNome());
		risultato.addAll(this.attrezzi.values());
		return risultato;
	}
	
	//****************************************************************************************************************************************************************************************************************************************************************************************
	
	public Map<Integer, Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		final Map<Integer, Set<Attrezzo>> mappa = new HashMap<Integer, Set<Attrezzo>>();
		Set<Attrezzo> listaAttrezzi = new HashSet<Attrezzo>();
		List<Attrezzo> lista = new ArrayList<Attrezzo>(this.attrezzi.values());
		
		for(Attrezzo attrezzo : lista) {
			if(mappa.containsKey(attrezzo.getPeso())) {
				mappa.get(attrezzo.getPeso()).add(attrezzo);
			}else {
				System.out.print(listaAttrezzi);
				mappa.put(attrezzo.getPeso(), new HashSet<Attrezzo>());
				mappa.get(attrezzo.getPeso()).add(attrezzo);
			}
		}
		
		return mappa;
	}
	
	//**************************************************************************************************************************************************************************************
	
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		final TreeSet<Attrezzo> risultato = new TreeSet<Attrezzo>(new ComparatoreAttrezziPerPesoPoiNome());
		risultato.addAll(this.attrezzi.values());
		return risultato;
	}
}