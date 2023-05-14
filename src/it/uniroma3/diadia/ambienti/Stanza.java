package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
*/

public class Stanza {
	
	private String nome;
	private Map<String, Attrezzo> attrezzi;
    private Map<String, Stanza> stanzeAdiacenti;
	private Set<String> direzioni;
 
    /**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     * @param nome il nome della stanza
     */
    public Stanza(String nome) {
        this.nome = nome;
        this.direzioni = new HashSet<String>();
        this.stanzeAdiacenti = new HashMap<String, Stanza>();
        this.attrezzi = new HashMap<String, Attrezzo>();
    }
    
	//*********************************************************************************************************************************************************

    /**
     * Imposta una stanza adiacente.
     *
     * @param  direzione in cui sara' posta la stanza adiacente.
     * @param stanza adiacente alla direzione indicata dal primo parametro.
     */
    public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
        
        if(!this.direzioni.contains(direzione)) {
        	this.direzioni.add(direzione);
        	this.stanzeAdiacenti.put(direzione, stanza);    	
        }
    }
    
	//*********************************************************************************************************************************************************
   
    //getter

    /**
     * Restituisce la stanza adiacente nella direzione specificata
     * @param direzione
     */
	public Stanza getStanzaAdiacente(String direzione) {
        return this.stanzeAdiacenti.get(direzione);
	}

	
    /**
     * Restituisce la nome della stanza.
     * @return il nome della stanza
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Restituisce la descrizione della stanza.
     * @return la descrizione della stanza
     */
    public String getDescrizione() {
        return this.toString();
    }

    
	//*********************************************************************************************************************************************************

    /**
     * Mette un attrezzo nella stanza.
     * @param attrezzo l'attrezzo da mettere nella stanza.
     * @return true se riesce ad aggiungere l'attrezzo, false altrimenti.
     */
    public boolean addAttrezzo(Attrezzo attrezzo) {
    	return this.attrezzi.put(attrezzo.getNome(), attrezzo)==null;
    }
    
	//*********************************************************************************************************************************************************

   /**
	* Restituisce una rappresentazione stringa di questa stanza,
	* stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	* @return la rappresentazione stringa
	*/
    public String toString() {
    	StringBuilder risultato = new StringBuilder();
    	risultato.append(this.nome);
    	risultato.append("\nUscite: ");
    	for (String direzione : this.direzioni)
    		if (direzione!=null)
    			risultato.append(" " + direzione);
    	risultato.append("\nAttrezzi nella stanza: ");
    	risultato.append(this.attrezzi.values().toString()+" ");
    	if(this.attrezzi.size()==0) {
    		risultato.append("Non ci sono attrezzi nella stanza\n");
    	}
    	return risultato.toString();
    }
    
	//*********************************************************************************************************************************************************

    /**
	* Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	* @return true se l'attrezzo esiste nella stanza, false altrimenti.
	*/
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.containsKey(nomeAttrezzo);
	}
	
	//*********************************************************************************************************************************************************

	/**
     * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
     * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.get(nomeAttrezzo);	
		}
	
	//*********************************************************************************************************************************************************

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		return this.attrezzi.remove(attrezzo.getNome(), attrezzo);
		}

	//*********************************************************************************************************************************************************

	public Set<String> getDirezioni() {
	    return this.direzioni;
	}

	public List<Attrezzo> getAttrezzi() {
		List<Attrezzo> listaAttrezzi = new LinkedList<Attrezzo>(this.attrezzi.values());
		return listaAttrezzi;
	}

	public Map<String, Stanza> getMapStanzeAdiacenti() {
		return this.stanzeAdiacenti;
	}

	

}