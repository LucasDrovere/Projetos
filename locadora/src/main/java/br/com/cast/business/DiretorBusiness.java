package br.com.cast.business;

import java.util.ArrayList;
import java.util.List;

import br.com.cast.dto.DiretorDTO;
import br.com.cast.entidade.Diretor;
import br.com.cast.persistencia.DiretorDAO;

public class DiretorBusiness {
	private DiretorDAO diretorDao;

	public DiretorBusiness() {
		this.diretorDao = new DiretorDAO();
	}

	public DiretorDTO buscarPorId(Integer id) {
		DiretorDTO dDTO = new DiretorDTO();
		Diretor diretor = new Diretor();

		diretor = diretorDao.buscarPorId(id);

		dDTO.setId(diretor.getId());
		dDTO.setNome(diretor.getNome());
		dDTO.setIdade(diretor.getIdade());

		return dDTO;

	}

	public List<DiretorDTO> buscarTodos() {
		List<Diretor> diretores = diretorDao.buscarTodos();

		List<DiretorDTO> diretorDto = new ArrayList<>();

		for (Diretor diretor : diretores) {
			DiretorDTO dto = new DiretorDTO();
			dto.setId(diretor.getId());
			dto.setNome(diretor.getNome());
			dto.setIdade(diretor.getIdade());

			diretorDto.add(dto);
		}

		return diretorDto;
	}

	public void inserir(DiretorDTO diretorDto) {
		Diretor d = new Diretor();
		d.setNome(diretorDto.getNome());
		d.setIdade(diretorDto.getIdade());
		d.setSexo(diretorDto.getSexo());
		
		diretorDao.inserir(d);
	}
	
	public void remover(Integer id) {
		diretorDao.excluir(id);
	}
	
	public void alterar(DiretorDTO diretorDto) {
		Diretor d = new Diretor();
		
		d.setId(diretorDto.getId());
		d.setNome(diretorDto.getNome());
		d.setIdade(diretorDto.getIdade());
		d.setSexo(diretorDto.getSexo());
		
		diretorDao.alterar(d);
	}
}
