package br.com.cast.managedBean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.cast.business.DiretorBusiness;
import br.com.cast.business.FilmeBusiness;
import br.com.cast.business.GeneroBusiness;
import br.com.cast.dto.DiretorDTO;
import br.com.cast.dto.FilmeDTO;
import br.com.cast.dto.GeneroDTO;

@ManagedBean(name = "filme")
public class FilmeController {

	private FilmeDTO filmeDto;
	private FilmeBusiness filmeBusiness;
	private List<FilmeDTO> listaDeFilmes;

	private GeneroBusiness generoBusiness;
	private List<GeneroDTO> listaDeGeneros;
	private Integer idGeneroSelecionado;

	private DiretorBusiness diretorBusiness;
	private List<DiretorDTO> listaDeDiretores;
	private Integer idDiretorSelecionado;

	public FilmeController() {

	}

	@PostConstruct
	public void aposConstrucao() {
		this.filmeDto = new FilmeDTO();
		this.filmeBusiness = new FilmeBusiness();
		this.generoBusiness = new GeneroBusiness();
		this.diretorBusiness = new DiretorBusiness();
		listaDeFilmes = filmeBusiness.buscarTodos();
	}

	public String salvar() {
		filmeDto.setDiretordto(diretorBusiness.buscarPorId(idDiretorSelecionado));
		filmeDto.setGenerodto(generoBusiness.buscarPorId(idGeneroSelecionado));

		filmeBusiness.inserir(filmeDto);

		listaDeFilmes = filmeBusiness.buscarTodos();

		return "listaDeFilmes";
	}

	public String remover(Integer id) {
		filmeBusiness.remover(id);
		listaDeFilmes = filmeBusiness.buscarTodos();

		return "listaDeFilmes";
	}

	public String redirectToEdit(FilmeDTO filmeDto) {
		this.filmeDto = filmeBusiness.buscarFilme(filmeDto);
		return "edit";
	}

	public String alterar() {
		this.filmeDto.setDiretordto(diretorBusiness.buscarPorId(idDiretorSelecionado));
		this.filmeDto.setGenerodto(generoBusiness.buscarPorId(idGeneroSelecionado));

		filmeBusiness.alterar(filmeDto);

		listaDeFilmes = filmeBusiness.buscarTodos();

		return "listaDeFilmes";
	}

	public FilmeDTO getFilmeDto() {
		return filmeDto;
	}

	public void setFilmeDto(FilmeDTO filmeDto) {
		this.filmeDto = filmeDto;
	}

	public List<FilmeDTO> getListaDeFilmes() {
		return listaDeFilmes;
	}

	public void setListaDeFilmes(List<FilmeDTO> listaDeFilmes) {
		this.listaDeFilmes = listaDeFilmes;
	}

	public List<GeneroDTO> getListaDeGeneros() {
		GeneroBusiness gb = new GeneroBusiness();
		
		return listaDeGeneros = gb.buscarTodos();
	}

	public void setListaDeGeneros(List<GeneroDTO> listaDeGeneros) {
		this.listaDeGeneros = listaDeGeneros;
	}

	public Integer getIdGeneroSelecionado() {
		return idGeneroSelecionado;
	}

	public void setIdGeneroSelecionado(Integer idGeneroSelecionado) {
		this.idGeneroSelecionado = idGeneroSelecionado;
	}

	public List<DiretorDTO> getListaDeDiretores() {
		DiretorBusiness db = new DiretorBusiness();
		
		return listaDeDiretores = db.buscarTodos();
	}

	public void setListaDeDiretores(List<DiretorDTO> listaDeDiretores) {
		this.listaDeDiretores = listaDeDiretores;
	}

	public Integer getIdDiretorSelecionado() {
		return idDiretorSelecionado;
	}

	public void setIdDiretorSelecionado(Integer idDiretorSelecionado) {
		this.idDiretorSelecionado = idDiretorSelecionado;
	}

}
