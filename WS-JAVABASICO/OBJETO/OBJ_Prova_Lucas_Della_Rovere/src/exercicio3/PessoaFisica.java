package exercicio3;

public class PessoaFisica extends Pessoa {

	private String cpf;

	public PessoaFisica(String nome, String cpf) {
		super(nome);
		this.cpf = cpf;
	}

	public void imprimir() {
		System.out.println(nome + "\nCPF: " + cpf);
	}
}
