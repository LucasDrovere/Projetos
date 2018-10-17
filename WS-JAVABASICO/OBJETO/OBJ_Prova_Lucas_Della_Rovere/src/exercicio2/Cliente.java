package exercicio2;

public class Cliente {

	private String nome;
	private String cpf;
	private String rg;
	
	
	public Cliente(String nome, String cpf, String rg) {
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
	}


	@Override
	public String toString() {
		return "\nDados do cliente: \nNome: " + nome + " \nCPF: " + cpf + "\nRG: " + rg + "";
	}
}
