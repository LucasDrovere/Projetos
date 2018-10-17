package br.com.cast.jsfprova.excecao;

public class TituloExistenteException extends Exception {
	
	public TituloExistenteException() {
		super("Titulo existente no banco!");
	}

}
