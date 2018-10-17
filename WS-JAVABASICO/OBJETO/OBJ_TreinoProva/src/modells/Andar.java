package modells;

import java.util.HashMap;
import java.util.Map;

import exceptions.NumeroDoQuartoRepetidoException;
import exceptions.QuartoNaoEncontradoException;
import exceptions.QuartoOcupadoException;
import models.abstracts.Quarto;

public class Andar {

	private int andar;
	private Map<Integer, Quarto> mapaDeQuartos;
	
	public Andar(int andar) {
		this.andar = andar;
		mapaDeQuartos = new HashMap<>();
	}
	
	public void adicionarQuarto(Integer numero, Quarto quarto) throws NumeroDoQuartoRepetidoException {
		if (mapaDeQuartos.containsKey(numero)) {
			throw new NumeroDoQuartoRepetidoException();
		}
		mapaDeQuartos.put(numero, quarto);
		System.out.println(quarto + " numero " + numero + " adicionado com sucesso!");
	}
	
	public Quarto entregarChaveDoQuarto(Integer numero) throws QuartoNaoEncontradoException, QuartoOcupadoException {
		if (!mapaDeQuartos.containsKey(numero)) {
			throw new QuartoNaoEncontradoException();
		}
		Quarto quarto = mapaDeQuartos.get(numero);
				
		if(quarto.isOcupado()) {
			throw new QuartoOcupadoException();
		}	
		return quarto;	
	}

	@Override
	public String toString() {
		return 	"\nAndar: " + andar +
				"\nQuartos: " + mapaDeQuartos + "";
	}
	
	
	
}
