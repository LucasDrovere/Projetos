package br.com.cast.modelss;

public class Hospede {
	private String nome;
	private String rg;
	
	public Hospede(String nome, String rg) {
		this.nome = nome;
		this.rg = rg;
	}

	@Override
	public String toString() {
		return "nome: " + nome +"";
	}

	public String getRg() {
		return rg;
	}
}
