package br.com.cast.entidade;

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
@Table(name = "filme", schema ="locadora")
public class Filme {
	@Id
	@SequenceGenerator(name = "gerador_filme_seq", sequenceName = "locadora.filme_id_seq", schema = "locadora", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gerador_filme_seq")
	private Integer id;
	private String nome;
	private String ano;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_genero")
	private Genero genero;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_diretor")
	private Diretor diretor;

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

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Diretor getDiretor() {
		return diretor;
	}

	public void setDiretor(Diretor diretor) {
		this.diretor = diretor;
	}
}
