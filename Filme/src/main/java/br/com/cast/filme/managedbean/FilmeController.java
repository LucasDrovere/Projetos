package br.com.cast.filme.managedbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.cast.filme.Business.DiretorBusiness;
import br.com.cast.filme.Business.FilmeBusiness;
import br.com.cast.filme.Business.GeneroBusiness;
import br.com.cast.filme.dto.DiretorDTO;
import br.com.cast.filme.dto.FilmeDTO;
import br.com.cast.filme.dto.GeneroDTO;

@ManagedBean
public class FilmeController {
	
	private FilmeDTO filmeDTO;
	

	private Integer diretorSelecionado;
	private Integer generoSelecionado;
	
	private FilmeBusiness filmeBusiness;
	
	private List <FilmeDTO> listagemFilmes;
	private List<GeneroDTO> listagemGenero;
	private List<DiretorDTO> listagemDiretor;
	
	
	private DiretorBusiness diretorBusiness;
	private GeneroBusiness generoBusiness;
	
	public FilmeController() {
		
	}
	
	@PostConstruct
	public void aposConstrucao() {
		this.filmeDTO = new FilmeDTO();
		this.filmeBusiness = new FilmeBusiness();
		this.diretorBusiness = new DiretorBusiness();
		this.generoBusiness = new GeneroBusiness();
		listagemFilmes = filmeBusiness.buscarTodos();
	}
	
	
	public String salvar() {
		
		filmeDTO.setDiretorDTO(diretorBusiness.buscarPorId(diretorSelecionado));
		filmeDTO.setGeneroDTO(generoBusiness.buscarPorId(generoSelecionado));
		
		filmeBusiness.salvar(filmeDTO);
		
		listagemFilmes = filmeBusiness.buscarTodos();
		
		return "listaFilmes";
	}
	
	public List<FilmeDTO> getListagemFilmes() {
		return listagemFilmes;
	}

	public void setListagemFilmes(List<FilmeDTO> listagemFilmes) {
		this.listagemFilmes = listagemFilmes;
	}
	
	public List<GeneroDTO> getListagemGenero() {
		GeneroBusiness gb = new GeneroBusiness();
		
		return listagemGenero = gb.buscarTodos();
	}

	public List<DiretorDTO> getListagemDiretor() {
		DiretorBusiness db = new DiretorBusiness();

		return listagemDiretor = db.buscarTodos();
	}

	public Integer getDiretorSelecionado() {
		return diretorSelecionado;
	}

	public void setDiretorSelecionado(Integer diretorSelecionado) {
		this.diretorSelecionado = diretorSelecionado;
	}

	public Integer getGeneroSelecionado() {
		return generoSelecionado;
	}

	public void setGeneroSelecionado(Integer generoSelecionado) {
		this.generoSelecionado = generoSelecionado;
	}
	public FilmeDTO getFilmeDTO() {
		return filmeDTO;
	}

	public void setFilmeDTO(FilmeDTO filmeDTO) {
		this.filmeDTO = filmeDTO;
	}
	
	public String remover(FilmeDTO filmeDto) {
		filmeBusiness.remover(filmeDto);
		listagemFilmes = filmeBusiness.buscarTodos();
		return "ListarFilmes";
	}
	
	public String alterar(FilmeDTO filmeDto) {
		this.filmeDTO = filmeBusiness.buscarFilme(filmeDto);
		return "alterarFilme";
		
	}
	
	public String alterarMesmo () {
		
		this.filmeDTO.setDiretorDTO(diretorBusiness.buscarPorId(diretorSelecionado));
		this.filmeDTO.setGeneroDTO(generoBusiness.buscarPorId(generoSelecionado));
		
		filmeBusiness.alterar(filmeDTO);
		
		listagemFilmes = filmeBusiness.buscarTodos();
		
		return "ListaFilmes";
		
	}

}
