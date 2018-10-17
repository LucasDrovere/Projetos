package modells;

public class Hospede {
	
	private String nome;
	private String rg;
	
	public Hospede(String nome, String rg) {
		this.nome = nome;
		this.rg = rg;
	}

	@Override
	public String toString() {
		return "Nome do hospede: " + nome + " - Rg: " + rg + "";
	}

	public String getNome() {
		return nome;
	}
}
