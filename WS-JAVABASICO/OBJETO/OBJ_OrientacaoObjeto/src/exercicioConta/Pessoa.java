package exercicioConta;

public class Pessoa {
	private String nome;
	private String cpf;
	private Conta c = new Conta();
	
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String toString() {
		return "\nNome: " + this.nome + " \nCPF " + this.cpf;
	}
	
	void imprime() {
		System.out.println(toString());
	}
	 												
	void criarConta(int numeroAgencia, String criarSenha) {
		numeroAgencia = c.getAgencia();
		criarSenha = c.getSenha();
	}
	
	public Conta getConta() {
		return this.c;
	}
}

