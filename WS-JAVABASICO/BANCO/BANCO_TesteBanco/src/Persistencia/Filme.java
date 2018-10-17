package Persistencia;

public class Filme {

	String nome;
	Integer ano;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	@Override
	public String toString() {
		return "Nome do filme: " + nome + "\t" + "Ano:" + ano;
	}
}
