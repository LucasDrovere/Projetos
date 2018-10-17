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
		//converter um DTO para entidade
		Professor professor = professorDao.buscarPorId(
				alunoDTO.getIdProfessor());
		
		Aluno aluno = new Aluno();
		aluno.setNome(alunoDTO.getNome());
		aluno.setProfessor(professor);
		
		alunoDao.inserir(aluno);
	}

	public List<AlunoDTO> buscarTodos() {
		
		List<Aluno> alunos = alunoDao.buscarTodos();
		
		List<AlunoDTO> dtos = new ArrayList<>();
		
		for (Aluno aluno : alunos) {
			
			AlunoDTO dto = new AlunoDTO();
			dto.setId(aluno.getId());
			dto.setNome(aluno.getNome());
			
			Professor professor = aluno.getProfessor();
			
			if (professor != null) {
				ProfessorDTO professorDTO = new ProfessorDTO();
				professorDTO.setId(professor.getId());
				professorDTO.setNome(professor.getNome());
				
				dto.setProfessorDTO(professorDTO);
			}
			
			dtos.add(dto);
		}
		
		return dtos;
	}

}