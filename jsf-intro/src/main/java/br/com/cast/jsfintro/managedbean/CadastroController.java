package br.com.cast.jsfintro.managedbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.cast.jsfintro.business.AlunoBusiness;
import br.com.cast.jsfintro.business.ProfessorBusiness;
import br.com.cast.jsfintro.dto.AlunoDTO;
import br.com.cast.jsfintro.dto.ProfessorDTO;

@ManagedBean
public class CadastroController {
	
	private AlunoDTO alunoDTO;
	private List<ProfessorDTO> professores;
	
	private AlunoBusiness alunoBusiness;
	private ProfessorBusiness professorBusiness;
	
	/**
	 * chamado pelo JSF
	 */
	@PostConstruct
	public void aposConstrucao() {
		this.alunoDTO = new AlunoDTO();
		this.alunoBusiness = new AlunoBusiness();
		this.professorBusiness = new ProfessorBusiness();
		this.professores = professorBusiness.buscarTodos();
	}
	
	public void salvar() {
		alunoBusiness.salvar(alunoDTO);
	}
	
	public List<ProfessorDTO> getProfessores() {
		return professores;
	}
	
	public AlunoDTO getAlunoDTO() {
		return alunoDTO;
	}

	public String redirectToEdit(Integer id) {
		alunoDTO = alunoBusiness.buscarPorId(id);
		return "edit";
	}
	
	public void alterar() {
		alunoBusiness.alterar(alunoDTO);
	}
	
	public void remover(Integer id) {
		alunoBusiness.remover(id);
	}
	
	
}
