package br.com.cast.models.abstracts;

import java.util.ArrayList;
import java.util.List;

import br.com.cast.exceptions.QuartoOcupadoException;
import br.com.cast.exceptions.QuartoVazioException;
import br.com.cast.modelss.Hospede;

public abstract class Quarto {
	protected String nome;
	protected String descricao;
	protected List<Hospede> hospedes;

	public Quarto(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
		hospedes = new ArrayList<>();
	}

	public void adicionarHospede(Hospede h) throws QuartoOcupadoException {
		if (hospedes.isEmpty()) {
			hospedes.add(h);
		} else {
			throw new QuartoOcupadoException();
		}
	}

	public void removerHospede() throws QuartoVazioException {
		if (hospedes.isEmpty()) {
			throw new QuartoVazioException();
		} else {
			hospedes.remove(0);
		}
	}

	//DUVIDA
	public boolean isOcupado() {
		hospedes.isEmpty();
		return false;
		// público, retorna true caso o quarto esteja ocupado;
	}
	//DUVIDA
	public boolean isVazio() {
		hospedes.isEmpty();
		return true;
		// público, retorna true caso o quarto esteja vazio;
	}

	@Override
	public String toString() {
		return "\tQuarto tipo: " + nome + " \n\tDescricao: " + descricao + "hospedes: " + hospedes + "\n";
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
