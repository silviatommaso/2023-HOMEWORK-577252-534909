package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai     nord|sud|ovest|est", "\naiuto", "\nfine", "\nprendi   (nome attrezzo)", "\nposa   (nome attrezzo)"};

	private Partita partita;
	private IOConsole messaggio;

	public DiaDia() {
		this.partita = new Partita();
		this.messaggio = new IOConsole();
	}

	public void gioca() {
		String istruzione; 
		
		//mostra utente messaggio di Benvenuto
		this.getMessage().mostraMessaggio(MESSAGGIO_BENVENUTO);
		
		//legge le istruzioni dell'utente
		do		
			istruzione = this.getMessage().leggiRiga();
		while (!processaIstruzione(istruzione));

	}   
	
	//***************************************************************************************************************************************************

	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);
		String nome = comandoDaEseguire.getNome();
		
			if ("fine".equals(nome)){
			 this.fine();
			 return true;
			 } else if ("vai".equals(nome)) {
				 if(this.partita.persa()) {
					 this.getMessage().mostraMessaggio("Hai esaurito i tentativi a disposizione!");
					 this.fine();
					 return true;
					}else {
						this.vai(comandoDaEseguire.getParametro());
					}
				}else if ("aiuto".equals(nome)) {
					this.aiuto();
				}else if("prendi".equals(nome)) {
					this.prendi(comandoDaEseguire.getParametro());
				}else if("posa".equals(nome)) {
					this.posa(comandoDaEseguire.getParametro());
					}else{
						 this.getMessage().mostraMessaggio("Comando sconosciuto");
						}
			
			if(this.partita.vinta()){
				 this.getMessage().mostraMessaggio("Hai vinto!");
				 return true;
				 }else{
					 return false;
					 }
			}   

	//***************************************************************************************************************************************************

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++)
			 this.getMessage().mostraMessaggio(elencoComandi[i]+" ");
	}
	
	//***************************************************************************************************************************************************

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			this.getMessage().mostraMessaggio("Dove vuoi andare ?");
		else {
			Stanza prossimaStanza = null;
			prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
			if (prossimaStanza == null)
				this.getMessage().mostraMessaggio("Direzione inesistente \n\nStanza corrente:");
			else {
				this.partita.setStanzaCorrente(prossimaStanza);
				int cfu = this.partita.getGiocatore().getCfu()-1;
				this.partita.getGiocatore().setCfu(cfu--);
			}
			this.getMessage().mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
			}
		}

	//***************************************************************************************************************************************************

	private void prendi(String nomeAttrezzo) {
		if(nomeAttrezzo==null) {
			this.getMessage().mostraMessaggio("Cosa vuoi prendere?");
		}else {
			if(this.partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
				Attrezzo attrezzo = null;
				attrezzo = this.partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
				
				//aggiungo l'attrezzo in borsa
				this.partita.getGiocatore().borsa.addAttrezzo(attrezzo);
				
				//rimuovo l'attrezzo dalla stanza
				if(this.partita.getStanzaCorrente().removeAttrezzo(attrezzo)) {
					this.getMessage().mostraMessaggio("Oggetto Preso!");
					}
			}else {
				this.getMessage().mostraMessaggio("L'oggetto che cerchi non è presente nella stanza");
			}
		}
		}
	//***************************************************************************************************************************************************
	
	private void posa(String nomeAttrezzo) {
		if(nomeAttrezzo==null) 
			this.getMessage().mostraMessaggio("Cosa vuoi posare?");
		else if(this.partita.getGiocatore().borsa.hasAttrezzo(nomeAttrezzo) && nomeAttrezzo!=null) {
			Attrezzo attrezzo = null;
			attrezzo = this.partita.getGiocatore().borsa.getAttrezzo(nomeAttrezzo);
			
			//tolgo l'attrezzo dalla borsa
			this.partita.getGiocatore().borsa.removeAttrezzo(nomeAttrezzo);
			
			//rimuovo l'attrezzo dalla stanza
			this.partita.getStanzaCorrente().addAttrezzo(attrezzo);
			this.getMessage().mostraMessaggio("Oggetto rimosso dalla Borsa!");
		}
		else {
			this.getMessage().mostraMessaggio("L'oggetto che cerchi non è presente nella borsa");
		}
	}
	
	//***************************************************************************************************************************************************

	public IOConsole getMessage() {
		return this.messaggio;
	}
	
	//***************************************************************************************************************************************************

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		this.getMessage().mostraMessaggio("Grazie di aver giocato!");		 // si desidera smettere di giocare	
	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}