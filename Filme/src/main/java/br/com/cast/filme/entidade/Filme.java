package br.com.cast.filme.entidade;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table (name="filme", schema="filme")
public class Filme {
	
	@Id
	@SequenceGenerator(name="gerador_filme_seq",
				sequenceName="filme_id_seq",
				schema="filme",
				allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
	generator="gerador_filme_seq")
	private Integer id;
	private String nome;
	
	@ManyToOne (fetch=FetchType.LAZY)
	@JoinColumn(name="id_diretor")
	private Diretor diretor;
	
	@ManyToOne (fetch=FetchType.LAZY)
	@JoinColumn (name="id_genero")
	private Genero genero;
	
	
	
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
	public Diretor getDiretor() {
		return diretor;
	}
	public void setDiretor(Diretor diretor) {
		this.diretor = diretor;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	

}
