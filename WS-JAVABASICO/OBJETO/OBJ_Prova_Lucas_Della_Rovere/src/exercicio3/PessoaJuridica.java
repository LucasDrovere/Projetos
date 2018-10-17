package exercicio3;

public class PessoaJuridica extends Pessoa {

	private String cnpj;

	public PessoaJuridica(String nome, String cnpj) {
		super(nome);
		this.cnpj = cnpj;
	}

	public void imprimir() {
		System.out.println(nome + "\nCNPJ: " + cnpj);
	}
}
