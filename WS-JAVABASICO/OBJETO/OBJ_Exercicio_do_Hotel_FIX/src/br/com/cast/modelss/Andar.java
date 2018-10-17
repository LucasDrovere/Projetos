package br.com.cast.modelss;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import br.com.cast.exceptions.NumeroDoQuartoRepetidoException;
import br.com.cast.exceptions.QuartoNaoEncontradoException;
import br.com.cast.exceptions.QuartoOcupadoException;
import br.com.cast.models.abstracts.Quarto;

public class Andar {
	private int andar;
	private Map<Integer, Quarto> mapaDeQuartos;

	public Andar(int andar) {
		this.andar = andar;
		mapaDeQuartos = new HashMap<>();
	}

	// private HashSet<Andar> aKeys = new HashSet<>();

	public void adicionarQuarto(Integer numero, Quarto quarto) throws NumeroDoQuartoRepetidoException {
		if (mapaDeQuartos.containsKey(numero)) {
			throw new NumeroDoQuartoRepetidoException();
		} else {
			mapaDeQuartos.put(numero, quarto);
			System.out.println(quarto + " numero: " + numero + " Adicionado com sucesso.");
		}
	}

	public Quarto entregarChaveDoQuarto(Integer numero) throws QuartoNaoEncontradoException, QuartoOcupadoException {
		if (!mapaDeQuartos.containsKey(numero)) {
			throw new QuartoNaoEncontradoException();
		}
		if (mapaDeQuartos.get(numero).isOcupado()) {
			throw new QuartoOcupadoException();
		}
		return mapaDeQuartos.get(numero);
	}

	@Override
	public String toString() {
		return "" + andar + "";
	}

}