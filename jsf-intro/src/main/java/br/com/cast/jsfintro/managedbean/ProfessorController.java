package br.com.cast.jsfintro.managedbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.cast.jsfintro.business.ProfessorBusiness;
import br.com.cast.jsfintro.dto.ProfessorDTO;

@ManagedBean(name="prof")
public class ProfessorController {

	private ProfessorDTO profDTO;
	private ProfessorBusiness profBusiness;
	private List<ProfessorDTO> listaDeProfessores;

	@PostConstruct
	public void aposConstrucao() {
		this.profDTO = new ProfessorDTO();
		this.profBusiness = new ProfessorBusiness();
		this.listaDeProfessores = profBusiness.buscarTodos();
	}

	public List<ProfessorDTO> getListagemDeProfessores() {
		return listaDeProfessores;
	}

	public void salvar() {
		profBusiness.salvar(profDTO);
	}

	public ProfessorDTO getProfessorDTO() {
		return profDTO;
	}

	public void remover(Integer id) {
		profBusiness.remover(id);
	}

	public String redirectToEdit(Integer id) {
		profDTO = profBusiness.buscarPorId(id);
		return "edit";
	}
}
