package br.com.cast.bancodefilmes.modelo;

public class Aluno {

	private Integer id;
	private String nome;
	private Professor professor;
	
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
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	@Override
	public String toString() {
		return "Aluno id=" + id + ", nome=" + nome + ", professor=" + professor + "";
	}
	
}