package br.com.cast.jsfintro.managedbean;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;


import br.com.cast.jsfintro.entidade.Aluno;
import br.com.cast.jsfintro.persistencia.AlunoDao;

/**
 * um bean tem:
 * - construtor default
 * - getter e setters
 * @author Cast
 */
@ManagedBean
public class AlunoController {

	private AlunoDao alunoDao;
	private List<Aluno> listagemDeAlunos;


	public AlunoController() {
		//default
	}
	
	/**
	 * chamado pelo JSF
	 */
	@PostConstruct
	public void aposConstrucao() {
		this.alunoDao = new AlunoDao();
	
		listagemDeAlunos = alunoDao.buscarTodos();
		
	}
	
	public List<Aluno> getListagemDeAlunos() {
		return listagemDeAlunos;
	}

}
