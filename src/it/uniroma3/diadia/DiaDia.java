package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

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

public class DiaDia implements Comando{

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	//static final private String[] elencoComandi = {"vai     nord|sud|ovest|est", "\naiuto", "\nfine", "\nprendi   (nome attrezzo)", "\nposa   (nome attrezzo)"};

	private Partita partita;
	private IO io;
	private Labirinto labirinto;

	public DiaDia(IO io) {
		this.partita = new Partita();
		this.io = io;
	}
	
	/**
	 * Costruttore per la creazione di una partita da svolgersi in un certo labirinto
	 * @param labirinto
	 * @param io
	 */
	public DiaDia(Labirinto labirinto, IO io) {
		this.partita= new Partita(labirinto);
		this.io = io;;
	} 

	public void gioca() {
		String istruzione; 
		
		//mostra utente messaggio di Benvenuto
		this.io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		
		//legge le istruzioni dell'utente
		do		
			istruzione = io.leggiRiga();
		while (!processaIstruzione(istruzione));

	}   
	
	//***************************************************************************************************************************************************

	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire;
		FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica();
		
		comandoDaEseguire = factory.costruisciComando(istruzione, this.io);
		comandoDaEseguire.esegui(partita);
			
		if(this.partita.vinta()) {
			this.io.mostraMessaggio("Hai vinto!");
			return true;
			}else if(this.partita.persa()) {
				this.io.mostraMessaggio("Hai perso!");
				return true;
			}else {
				return this.partita.isFinita();
			}
		}   

	//***************************************************************************************************************************************************

	public static void main(String[] argc) {
		IO io = new IOConsole();
		DiaDia gioco = new DiaDia(io);
		gioco.gioca();
	}

	@Override
	public void esegui(Partita partita) {}

	@Override
	public void setParametro(String parametro) {}

	@Override
	public void setIo(IO io) {
	}
}