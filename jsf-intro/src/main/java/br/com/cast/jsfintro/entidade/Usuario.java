package br.com.cast.jsfintro.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "usuario", schema = "sala")
public class Usuario {

	@Id
	@SequenceGenerator(name = "sala.usuario_id_seq", sequenceName = "usuario_id_seq", schema = "sala", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sala.usuario_id_seq")
	private Integer id;
	private String nome;
	private String usuario;
	private String senha;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
