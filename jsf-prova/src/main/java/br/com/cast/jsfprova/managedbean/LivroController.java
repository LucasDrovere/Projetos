package br.com.cast.jsfprova.managedbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.hibernate.service.spi.InjectService;

import br.com.cast.jsfprova.business.AutorBusiness;
import br.com.cast.jsfprova.business.CategoriaBusiness;
import br.com.cast.jsfprova.business.LivroBusiness;
import br.com.cast.jsfprova.dto.AutorDTO;
import br.com.cast.jsfprova.dto.CategoriaDTO;
import br.com.cast.jsfprova.dto.LivroDTO;
import br.com.cast.jsfprova.excecao.TituloExistenteException;

@ManagedBean(name = "livro")
public class LivroController {

	private LivroDTO livroDto;
	private LivroBusiness livroBusiness;
	private List<LivroDTO> listaDeLivros;
	private List<AutorDTO> autores;
	private List<CategoriaDTO> categorias;
	
	private AutorBusiness autorBusiness;
	private CategoriaBusiness categoriaBusiness;

	public LivroController() {

	}

	@PostConstruct
	public void aposConstrucao() {
		this.livroDto = new LivroDTO();
		this.livroBusiness = new LivroBusiness();
		this.autorBusiness = new AutorBusiness();
		this.categoriaBusiness = new CategoriaBusiness();
		listaDeLivros = livroBusiness.buscarTodos();

	}

	public String salvar() {
		try {
			livroBusiness.inserir(livroDto);
			listaDeLivros = livroBusiness.buscarTodos();
			return "listarLivro.xhtml";
		} catch (TituloExistenteException e) {
			e.printStackTrace();

			FacesContext.getCurrentInstance().addMessage("tituloExisteMsg",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
		}
		return "";
	}

	public String remover(Integer id) {
		livroBusiness.remover(id);
		listaDeLivros = livroBusiness.buscarTodos();
		return "listarLivro.xhtml";
	}

	public String redirectToEdit(Integer id) {
		livroDto = livroBusiness.buscarPorId(id);
		return "edit";
	}

	public String alterar() {
		try {
			livroBusiness.alterar(livroDto);
			listaDeLivros = livroBusiness.buscarTodos();
			return "listarLivro.xhtml";
		} catch (TituloExistenteException e) {
			e.printStackTrace();

			FacesContext.getCurrentInstance().addMessage("tituloExisteMsg",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
		}
		return "";
	}

	public LivroDTO getLivroDto() {
		return livroDto;
	}

	public void setLivroDto(LivroDTO livroDto) {
		this.livroDto = livroDto;
	}

	public List<LivroDTO> getListaDeLivros() {
		return listaDeLivros;
	}

	public void setListaDeLivros(List<LivroDTO> listaDeLivros) {
		this.listaDeLivros = listaDeLivros;
	}

	public List<AutorDTO> getAutores() {
		AutorBusiness ab = new AutorBusiness();

		return autores = ab.buscarTodos();
	}

	public void setAutores(List<AutorDTO> autores) {
		this.autores = autores;
	}

	public List<CategoriaDTO> getCategorias() {
		CategoriaBusiness cb = new CategoriaBusiness();

		return categorias = cb.buscarTodos();
	}

	public void setCategorias(List<CategoriaDTO> categorias) {
		this.categorias = categorias;
	}
}
