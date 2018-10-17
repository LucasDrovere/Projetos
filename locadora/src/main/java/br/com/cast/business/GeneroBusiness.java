package br.com.cast.business;

import java.util.ArrayList;
import java.util.List;

import br.com.cast.dto.GeneroDTO;
import br.com.cast.entidade.Genero;
import br.com.cast.persistencia.GeneroDAO;

public class GeneroBusiness {

	private GeneroDAO generoDao;

	public GeneroBusiness() {
		this.generoDao = new GeneroDAO();
	}

	public void inserir(GeneroDTO generoDto) {
		Genero g = new Genero();

		g.setId(generoDto.getId());
		g.setNome(generoDto.getNome());

		generoDao.inserir(g);
	}

	public void excluir(Integer id) {
		generoDao.remover(id);
	}

	public GeneroDTO buscarPorId(Integer id) {

		GeneroDTO gDTO = new GeneroDTO();
		Genero g = generoDao.buscarPorId(id);

		gDTO.setId(g.getId());
		gDTO.setNome(g.getNome());

		return gDTO;
	}

	public List<GeneroDTO> buscarTodos() {
		List<Genero> generos = generoDao.buscarTodos();

		List<GeneroDTO> generosDto = new ArrayList<>();

		for (Genero g : generos) {
			GeneroDTO generoDto = new GeneroDTO();
			generoDto.setId(g.getId());
			generoDto.setNome(g.getNome());

			generosDto.add(generoDto);

		}
		return generosDto;
	}
}
