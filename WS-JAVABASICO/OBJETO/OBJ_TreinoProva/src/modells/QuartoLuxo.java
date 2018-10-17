package modells;

import interfaces.Faturavel;
import models.abstracts.Quarto;

public class QuartoLuxo extends Quarto implements Faturavel{

	private static final double VALOR_DIARIA = 450.0;
	
	public QuartoLuxo(String nome, String descricao) {
		super(nome, descricao);
	}

	@Override
	public double faturar(int qntDeDiarias) {
		return qntDeDiarias * VALOR_DIARIA;
	}

}
