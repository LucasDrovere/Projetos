package br.com.cast.jsfforum.entidade;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="usuario", schema="forum")
public class Usuario {
	
	@Id
	@SequenceGenerator(name="seqGenUsuario", sequenceName="forum.usuario_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqGenUsuario")
	private Integer id;
	
	private String nome;
	private String usuario;
	private String senha;
	
	@OneToMany(mappedBy="usuario", cascade=CascadeType.ALL)
	private List<Critica> criticas = new ArrayList<>();
	
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public List<Critica> getCriticas() {
		return criticas;
	}
	
	public void addCritica(Critica critica) {
		criticas.add(critica);
		critica.setUsuario(this);
	}
	
	public void remove(Critica critica) {
		criticas.remove(critica);
		critica.setUsuario(null);
	}
	
	public Critica bucasPorId(Integer id) {
		Critica critica = null;
		for(Critica c : criticas) {
			if(c.getId().equals(id)) {
				critica = c;
			}
		}
		return critica;
	}
}
