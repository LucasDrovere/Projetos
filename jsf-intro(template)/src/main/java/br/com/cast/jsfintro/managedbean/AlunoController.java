package br.com.cast.jsfintro.managedbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.cast.jsfintro.business.AlunoBusiness;
import br.com.cast.jsfintro.dto.AlunoDTO;

/**
 * um bean tem:
 * - construtor default
 * - getter e setters
 * @author Cast
 */
@ManagedBean
public class AlunoController {
	
	private AlunoBusiness alunoBusiness;
	private List<AlunoDTO> listagemDeAlunos;
	
	public AlunoController() {
		//default
	}
	
	/**
	 * chamado pelo JSF
	 */
	@PostConstruct
	public void aposConstrucao() {
		this.alunoBusiness = new AlunoBusiness();
		listagemDeAlunos = alunoBusiness.buscarTodos();
	}
	
	public List<AlunoDTO> getListagemDeAlunos() {
		return listagemDeAlunos;
	}
	
	public void test() {
		System.out.println("chamando!");
	}
	
}
