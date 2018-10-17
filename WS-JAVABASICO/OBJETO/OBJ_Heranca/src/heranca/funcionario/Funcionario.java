package heranca.funcionario;

public class Funcionario {
	protected String nome;
	protected String sobrenome;
	protected int idade;
	
	public void exibir() {
		System.out.println("Nome: " + nome);
		System.out.println("Sobrenome: " + sobrenome);
		System.out.println("Idade: " + idade);
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setSobreNome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
}
