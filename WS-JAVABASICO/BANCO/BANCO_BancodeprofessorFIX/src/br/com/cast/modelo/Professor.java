package br.com.cast.modelo;

public class Professor {

	private Integer id;
	private String nome;
	private String materia;
	
	public String getNome() {
		return nome;
	}
	
	public String getMateria() {
		return materia;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setMateria(String materia) {
		this.materia = materia;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
}
