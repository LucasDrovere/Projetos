package br.com.cast.sala.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name="professor", schema="exercicio")
public class Professor {
	
	
	@Id
	@SequenceGenerator(name="gerador_id_professor",
					   sequenceName = "professor_id_seq", 
					   schema="exercicio",
					   allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="gerador_id_professor")
	@Column(name= "id")
	private Integer idP;
	
	private String nome;
	private String materia;
	
	
	public Integer getIdP() {
		return idP;
	}
	public void setIdP(Integer idP) {
		this.idP = idP;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	

}
