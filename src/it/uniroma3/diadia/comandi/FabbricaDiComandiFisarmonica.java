package it.uniroma3.diadia.comandi;

import java.util.Scanner;

import it.uniroma3.diadia.IO;

public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi{
	
	/**
	 * Costruisco i comandi dell'utente
	 * @param istruzione
	 * @param io 
	 * @return
	 */
	
	@Override
	public Comando costruisciComando(String istruzione, IO io) {
		String nomeComando=null;  
		String parametro=null;
		Scanner scannerDiParole = new Scanner(istruzione);
		Comando comando = null;
		
		//nome del comando
		if (scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next();
		//parametro
		if (scannerDiParole.hasNext()) 
			parametro = scannerDiParole.next();
		
		if(nomeComando==null) {
			comando = new ComandoNonValido();
		}else if("fine".equals(nomeComando)) {
			comando = new ComandoFine();
		}else if("vai".equals(nomeComando)) {
			comando = new ComandoVai();
		}else if("prendi".equals(nomeComando)) {
			comando = new ComandoPrendi();
		}else if("posa".equals(nomeComando)) {
			comando = new ComandoPosa();
		}else if("aiuto".equals(nomeComando)) {
			comando = new ComandoAiuto();
		}else if("guarda".equals(nomeComando)){
			comando = new ComandoGuarda();
		}else {
			comando = new ComandoNonValido();
		}
		comando.setParametro(parametro);
		comando.setIo(io);
		
		return comando;
	}
	
}
