package br.com.cast.managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.cast.business.GeneroBusiness;
import br.com.cast.dto.GeneroDTO;

@ManagedBean(name = "genero")
public class GeneroController {

	private GeneroBusiness generoBusiness;
	private GeneroDTO generoDto;
	private List<GeneroDTO> listaDeGeneros;
	
	public GeneroController() {
		
	}
	
	@PostConstruct
	public void aposConstrucao() {
		this.generoBusiness = new GeneroBusiness();
		this.generoDto = new GeneroDTO();
		listaDeGeneros = new ArrayList<>();
	}
	
	public List<GeneroDTO> getListagemGenero(){
		return listaDeGeneros = generoBusiness.buscarTodos();
	}
	
	public void salvar() {
		generoBusiness.inserir(generoDto);
	}
	
	public String remover(Integer id) {
		generoBusiness.excluir(id);
		listaDeGeneros = generoBusiness.buscarTodos();
		return "listaDeGeneros";
	}

	public GeneroDTO getGeneroDto() {
		return generoDto;
	}

	public void setGeneroDto(GeneroDTO generoDto) {
		this.generoDto = generoDto;
	}

	public List<GeneroDTO> getListaDeGeneros() {
		return listaDeGeneros = generoBusiness.buscarTodos();
	}

	public void setListaDeGeneros(List<GeneroDTO> listaDeGeneros) {
		this.listaDeGeneros = listaDeGeneros;
	}
}
