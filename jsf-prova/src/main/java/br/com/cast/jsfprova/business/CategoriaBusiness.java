package br.com.cast.jsfprova.business;

import java.util.ArrayList;
import java.util.List;

import br.com.cast.jsfprova.dto.CategoriaDTO;
import br.com.cast.jsfprova.entidade.Categoria;
import br.com.cast.jsfprova.persistencia.CategoriaDAO;

public class CategoriaBusiness {

	private CategoriaDAO categoriaDao;
	
	public CategoriaBusiness() {
		this.categoriaDao = new CategoriaDAO();
	}
	
	public CategoriaDTO buscarPorId(Integer id) {
		CategoriaDTO cDTO = new CategoriaDTO();
		Categoria c = new Categoria();
		
		c = categoriaDao.buscarPorId(id);
		
		cDTO.setId(c.getId());
		cDTO.setDescricao(c.getDescricao());
		
		return cDTO;
	}
	
	
	public List<CategoriaDTO> buscarTodos() {
		List<Categoria> categorias = categoriaDao.buscarTodos();

		List<CategoriaDTO> categoriasDto = new ArrayList<>();

		for (Categoria c : categorias) {
			CategoriaDTO caDto = new CategoriaDTO();
			
			caDto.setId(c.getId());
			caDto.setDescricao(c.getDescricao());

			categoriasDto.add(caDto);
		}
		return categoriasDto;
	}
}


