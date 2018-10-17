package br.com.cast.modelss;

import br.com.cast.interfaces.Faturavel;

public class Recepcao {

	private Recepcao(){
	//alterar o construtor padrão para privado
	}
	
	
	public static void pagar(Faturavel f, int qtdDeDiarias) {
		double valor = f.faturar(qtdDeDiarias);
		System.out.println("Valor a pagar R$: " + valor);
	}
}