package br.com.cast.filme.Business;

import java.util.ArrayList;
import java.util.List;

import br.com.cast.filme.dto.DiretorDTO;
import br.com.cast.filme.entidade.Diretor;
import br.com.cast.filme.persistencia.DiretorDao;

public class DiretorBusiness {

	private DiretorDao dDao = new DiretorDao();

	public DiretorDTO buscarPorId(Integer id) {

		DiretorDTO dDTO = new DiretorDTO();
		Diretor diretor = new Diretor();

		diretor = dDao.buscarPorId(id);

		dDTO.setId(diretor.getId());
		dDTO.setNome(diretor.getNome());
		dDTO.setIdade(diretor.getIdade());

		return dDTO;

	}

	public List<DiretorDTO> buscarTodos() {
		List<Diretor> diretores = dDao.buscarTodos();

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

}
