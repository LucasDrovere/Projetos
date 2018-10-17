package forum.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="imagem", schema="forum")
public class Imagem {
	
	@Id
	@SequenceGenerator(name="seqGenImagem", sequenceName="forum.imagem_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqGenImagem")
	private Integer id;
	
	private String caminho;
	
	@ManyToOne
	@JoinColumn(name="id_critica")
	private Critica critica;
	
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
	
	public String getCaminho() {
		return caminho;
	}
	
	public void setCritica(Critica critica) {
		this.critica = critica;
	}
	
	public Critica getCritica() {
		return critica;
	}

}
