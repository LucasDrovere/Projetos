package br.com.cast.managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.cast.business.DiretorBusiness;
import br.com.cast.dto.DiretorDTO;

@ManagedBean(name = "diretor")
public class DiretorController {

	private DiretorBusiness diretorBusiness;
	private DiretorDTO diretorDto;
	private List<DiretorDTO> listaDeDiretores;

	public DiretorController() {

	}

	@PostConstruct
	public void aposConstrucao() {
		this.diretorBusiness = new DiretorBusiness();
		this.diretorDto = new DiretorDTO();
		listaDeDiretores = new ArrayList<>();
	}

	public void salvar() {
		diretorBusiness.inserir(diretorDto);
	}

	public String remover(Integer id) {
		diretorBusiness.remover(id);
		listaDeDiretores = diretorBusiness.buscarTodos();
		return "listaDeDiretores";
	}

	public String alterar() {
		diretorBusiness.alterar(diretorDto);
		listaDeDiretores = diretorBusiness.buscarTodos();
		return "listaDeDiretores";
	}

	public DiretorBusiness getDiretorBusiness() {
		return diretorBusiness;
	}

	public void setDiretorBusiness(DiretorBusiness diretorBusiness) {
		this.diretorBusiness = diretorBusiness;
	}

	public DiretorDTO getDiretorDto() {
		return diretorDto;
	}

	public void setDiretorDto(DiretorDTO diretorDto) {
		this.diretorDto = diretorDto;
	}

	public List<DiretorDTO> getListaDeDiretores() {
		return listaDeDiretores = diretorBusiness.buscarTodos();
	}

	public void setListaDeDiretores(List<DiretorDTO> listaDeDiretores) {
		this.listaDeDiretores = listaDeDiretores;
	}

}
