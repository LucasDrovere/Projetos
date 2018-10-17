package br.com.cast.modelss;

import br.com.cast.interfaces.Faturavel;
import br.com.cast.models.abstracts.Quarto;

public class QuartoLuxo extends Quarto implements Faturavel{

	private final static double VALOR_DIARIA = 450.0;
	
	public QuartoLuxo(String nome, String descricao) {
		super(nome, descricao);
	}

	@Override
	public double faturar(int qtdDeDiarias) {
		return qtdDeDiarias * VALOR_DIARIA;
	}
}