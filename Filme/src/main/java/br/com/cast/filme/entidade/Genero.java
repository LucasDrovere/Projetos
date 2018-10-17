package br.com.cast.filme.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="genero", schema="filme")
public class Genero {

	
	
	@Id
	@SequenceGenerator(name="gerador_genero_seq",
				sequenceName="genero_id_seq",
				schema="filme",
				allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
	generator="gerador_genero_seq")
	private Integer id;
	private String nome;
	
	
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
	
}
