package exercicio3;

public abstract class Pessoa {
	protected String nome;

	public Pessoa(String nome) {
		this.nome = nome;
	}

	public void imprimir() {
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "Nome: " + nome;
	}

	public String getNome() {
		return nome;
	}
}
