package br.com.cast.entidade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "post", schema = "blog")
public class Post {

	@Id
	@SequenceGenerator(name = "seqGenPost", sequenceName = "blog.post_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGenPost")
	private Integer id;

	private String texto;

	@Version
	private Date data;
	
	@OneToMany(
			mappedBy = "postagem",
			cascade = CascadeType.ALL, 
	        orphanRemoval = true)
	private List<Imagem> imagens = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getData() {
		return data;
	}

	public Post setData(Date data) {
		this.data = data;
		return this;
	}
	
	public Post addImagem(Imagem imagem) {
		imagens.add(imagem);
		imagem.setPostagem(this);
		return this;
	}
	
	public void removeImagem(Imagem imagem) {
		imagens.remove(imagem);
		imagem.setPostagem(null);
	}
	
	public String getTextoComImagens() {
		int from = 0;
		int iChave = 0;
		List<String> encontradas = new ArrayList<>();
		
		while ((iChave = texto.indexOf("{", from)) != -1) {
			from = iChave + 1;
			encontradas.add(texto.substring(iChave, iChave + 4));
		}
		
		for (String encontrada : encontradas) {
			String id = encontrada.replace("{", "")
								  .replace("}", "");
			
			for (Imagem img : imagens) {
				if (img.getId().equals(Integer.valueOf(id))) {
					String tagImg = 
							"<img width='200px' src='http://localhost:8080/web-hibernate/images/"
									+img.getArquivo() + "' />";
					texto = texto.replace(encontrada, tagImg);
				}
			}
		}
		
		return texto;
	}
	
	public List<Imagem> getImagens() {
		return imagens;
	}

}
