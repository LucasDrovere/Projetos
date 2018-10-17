package br.com.sisgec.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="critica", schema="sistema")
public class Critica {
	
	@Id
	@SequenceGenerator(name="seqGenCritica", sequenceName="sistema.critica_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqGenCritica")
	private Integer id;
	
	private String titulo;
	private String descricao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	@OneToMany(mappedBy="critica", cascade=CascadeType.ALL)
	private List<Imagem> imagens = new ArrayList<>();
	
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public List<Imagem> getImagens() {
		return imagens;
	}
	
	public void addImagem(Imagem imagem) {
		imagens.add(imagem);
		imagem.setCritica(this);
	}
	
	public void removeImagem(Imagem imagem) {
		imagens.remove(imagem);
		imagem.setCritica(null);
	}

}
