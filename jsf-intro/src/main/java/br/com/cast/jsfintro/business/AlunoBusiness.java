package br.com.cast.jsfintro.business;

import java.util.ArrayList;
import java.util.List;

import br.com.cast.jsfintro.dto.AlunoDTO;
import br.com.cast.jsfintro.dto.ProfessorDTO;
import br.com.cast.jsfintro.entidade.Aluno;
import br.com.cast.jsfintro.entidade.Professor;
import br.com.cast.jsfintro.persistencia.AlunoDao;
import br.com.cast.jsfintro.persistencia.ProfessorDao;

public class AlunoBusiness {

	private AlunoDao alunoDao;
	private ProfessorDao professorDao;


	public AlunoBusiness() {
		this.alunoDao = new AlunoDao();
		this.professorDao = new ProfessorDao();
	}

	public void salvar(AlunoDTO alunoDTO) {
		// converter um DTO para entidade
		Professor professor = professorDao.buscarPorId(alunoDTO.getIdProfessor());

		Aluno aluno = new Aluno();
		aluno.setNome(alunoDTO.getNome());
		aluno.setSobrenome(alunoDTO.getSobrenome());
		aluno.setProfessor(professor);

		alunoDao.inserir(aluno);
	}

	
	public AlunoDTO buscarPorId(Integer id) {
		AlunoDTO alunoDTO = new AlunoDTO();
		Aluno aluno = alunoDao.buscarPorId(id);
		alunoDTO.setId(aluno.getId());
		alunoDTO.setNome(aluno.getNome());
		alunoDTO.setSobrenome(aluno.getNome());
		
		ProfessorDTO professorDTO = new ProfessorDTO();
		Professor professor = aluno.getProfessor();
		alunoDTO.setIdProfessor(professor.getId());
		professorDTO.setId(professor.getId());
		professorDTO.setNome(professor.getNome());
		professorDTO.setMateria(professor.getMateria());
		alunoDTO.setProfessorDTO(professorDTO);
		return alunoDTO;
	}

	public void remover(Integer id) {
		alunoDao.remover(id);
	}

	public void alterar(AlunoDTO alunoDTO) {
		Aluno aluno = new Aluno();
		
		Professor professor = professorDao.buscarPorId(alunoDTO.getProfessorDTO().getId());
		
		aluno.setId(alunoDTO.getId());
		aluno.setSobrenome(alunoDTO.getSobrenome());
		aluno.setProfessor(professor);
		aluno.setNome(alunoDTO.getNome());
		alunoDao.alterar(aluno);
	}

	public List<AlunoDTO> buscarTodos() {
		
		List<Aluno> alunos = alunoDao.buscarTodos();
		List<AlunoDTO> alunosDto = new ArrayList<>();
		
		for (Aluno aluno : alunos) {
			AlunoDTO dto = new AlunoDTO();
			dto.setId(aluno.getId());
			dto.setNome(aluno.getNome());
			dto.setSobrenome(aluno.getSobrenome());
			
			ProfessorDTO professorDTO = new ProfessorDTO();
			Professor professor = aluno.getProfessor();
			dto.setIdProfessor(professor.getId());
			professorDTO.setId(professor.getId());
			professorDTO.setNome(professor.getNome());
			professorDTO.setMateria(professor.getMateria());
			dto.setProfessorDTO(professorDTO);
		}

		// sem pojo
		/*
		 * List<Professor> professores = professorDao.buscarTodos(); 
		 * List<ProfessorDTO> professoresDTO = new ArrayList<>();
		 * 
		 * for (Professor professor : professores) 
		 * { ProfessorDTO dto = new ProfessorDTO(); dto.setId(professor.getId());
		 * dto.setMateria(professor.getMateria()); dto.setNome(professor.getNome());
		 * professoresDTO.add(dto); }
		 */

		return alunosDto;
	}
}
