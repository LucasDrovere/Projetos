package modells;

import interfaces.Faturavel;
import models.abstracts.Quarto;

public class QuartoSimples extends Quarto implements Faturavel{

	private final static double VALOR_DIARIA = 87.90;
	
	
	public QuartoSimples(String nome, String descricao) {
		super(nome, descricao);
	}

	@Override
	public double faturar(int qntDeDiarias) {
		return qntDeDiarias * VALOR_DIARIA;
	}

}
