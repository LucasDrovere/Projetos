package br.com.cast.modelss;

import br.com.cast.interfaces.Faturavel;
import br.com.cast.models.abstracts.Quarto;

public class QuartoSimples extends Quarto implements Faturavel{

	private final static double VALOR_DIARIA = 87.90;
	
	public QuartoSimples(String nome, String descricao) {
		super(nome, descricao);
	}

	@Override
	public double faturar(int qtdDeDiarias) {
		return qtdDeDiarias * VALOR_DIARIA;
	}
}



