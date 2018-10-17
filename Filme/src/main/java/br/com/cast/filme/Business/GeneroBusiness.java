package br.com.cast.filme.Business;

import java.util.ArrayList;
import java.util.List;

import br.com.cast.filme.dto.GeneroDTO;
import br.com.cast.filme.entidade.Genero;
import br.com.cast.filme.persistencia.GeneroDao;

public class GeneroBusiness {
	
	private GeneroDao gDao = new GeneroDao();

	
	public GeneroDTO buscarPorId(Integer id) {
		
		GeneroDTO gDTO = new GeneroDTO();
		 Genero genero = new Genero();
		 
		genero = gDao.buscarPorId(id);
		
		gDTO.setId(genero.getId());
		gDTO.setNome(genero.getNome());
		
		
		return gDTO;
		
	}
	
	public List<GeneroDTO> buscarTodos() {
		List<Genero> generos = gDao.buscarTodos();

		List<GeneroDTO> generoDto = new ArrayList<>();

		for (Genero genero : generos) {
			
			GeneroDTO dto = new GeneroDTO();
			dto.setId(genero.getId());
			dto.setNome(genero.getNome());
			
			generoDto.add(dto);
		}

		return generoDto;
	}
	

}
