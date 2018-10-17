package models;

public class Filme {

	private Integer id;
	private String nome;
	private Integer ano;
	private Integer id_genero;
	private Integer id_diretor;
	private Integer genero;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	public Integer getId_genero() {
		return id_genero;
	}
	public void setId_genero(Integer id_genero) {
		this.id_genero = id_genero;
	}
	public Integer getId_diretor() {
		return id_diretor;
	}
	public void setId_diretor(Integer id_diretor) {
		this.id_diretor = id_diretor;
	}
	@Override
	public String toString() {
		return "ID do filme: " + id + " "
				+ "Nome: " + nome + " "
				+ "Ano: " + ano + " "
				+ "Genero: " + genero + "";
	}
	public Integer getGenero() {
		return genero;
	}
	public void setGenero(Integer string) {
		this.genero = string;
	}

	
}
