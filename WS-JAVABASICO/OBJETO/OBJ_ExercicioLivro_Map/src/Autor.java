
public class Autor {
	private String nome;
	private String sobrenome;
	private String pseudonimo;

	public Autor(String nome, String sobrenome, String pseudonimo) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.pseudonimo = pseudonimo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getPseudonimo() {
		return pseudonimo;
	}

	public void setPseudonimo(String pseudonimo) {
		this.pseudonimo = pseudonimo;
	}

	@Override
	public String toString() {
		return "Nome: " + nome + ", Sobrenome: " + sobrenome + ", Pseudonimo: " + pseudonimo + "";
	}

}
