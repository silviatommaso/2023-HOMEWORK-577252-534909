package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita{


	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	private boolean finita;
	private Labirinto labirinto;
	private Giocatore giocatore;
	
	public Partita(){
		this.finita = false;
		this.giocatore=new Giocatore();
		this.labirinto=new Labirinto();
		this.stanzaCorrente=labirinto.getStanzaCorrente();
		this.stanzaVincente=labirinto.getStanzaVincente();
	}
	
	public Partita(Labirinto labirinto) {
		this.labirinto = labirinto;
	}
	
	//********************************************************************************************************************************************************************************************************
 
   	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}
   	
	//********************************************************************************************************************************************************************************************************

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}
	
	//********************************************************************************************************************************************************************************************************

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	//********************************************************************************************************************************************************************************************************
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente()== this.getStanzaVincente();
	}
	
	//********************************************************************************************************************************************************************************************************

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita�
	 */
	
	public Giocatore getGiocatore() {
		return this.giocatore;
	}
	
	//********************************************************************************************************************************************************************************************************

	public boolean persa() {
		return this.getGiocatore().getCfu()==0;
	}
	
	//********************************************************************************************************************************************************************************************************

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}
	
	//********************************************************************************************************************************************************************************************************
	
	public boolean isFinita() {
		if(this.finita==true) {
			return true;
		}else{
			return false;
		}   
	}
	
	//********************************************************************************************************************************************************************************************************
	
	public void setLabirinto(Labirinto labirinto) {
		this.labirinto = labirinto;
	}
}

