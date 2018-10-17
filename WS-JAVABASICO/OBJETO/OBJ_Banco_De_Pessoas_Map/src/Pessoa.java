
public class Pessoa {
	private String nome;
	private String cpf;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String pegarLetra() {
		String nomeDigitado = this.nome;
		String pLetra = "";
		for (char letra : nomeDigitado.toCharArray()) {
			if (Character.isUpperCase(letra)) {
				pLetra += letra;
			}
		}
		return pLetra;
	}

	
	@Override
	public String toString() {
		return "Pessoa: [Nome: " + nome + ", Cpf: " + cpf + "]";
	}

}
