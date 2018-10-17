package models.abstracts;

import exceptions.QuartoVazioException;
import modells.Hospede;

public abstract class Quarto {
	protected String nome;
	protected String descricao;
	protected Hospede hospede;
	
	public Quarto(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	public void adicionarHospede(Hospede h){
		this.hospede = h;
		System.out.println(h + " adicionado com sucesso!");
	}
	
	
	public void removerHospede() throws QuartoVazioException{
		if(isVazio()) {
			throw new QuartoVazioException();
		}
		hospede = null;
		System.out.println("Hospede removido!S");
	}
	
	
	public boolean isOcupado() {
		return hospede != null;
	}
	
	public boolean isVazio() {
		return !isOcupado();
	}
	
	
	@Override
	public String toString() {
		return "\nTipo do quarto: " + nome +
				"\nDescricao do quarto: " + descricao + 
				"\nNome do hospede:" + hospede.getNome() + "";
	}
	
}
