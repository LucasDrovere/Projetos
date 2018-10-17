package br.com.cast.jsfprova.business;

import java.util.ArrayList;
import java.util.List;

import br.com.cast.jsfprova.dto.AutorDTO;
import br.com.cast.jsfprova.entidade.Autor;
import br.com.cast.jsfprova.persistencia.AutorDAO;

public class AutorBusiness {
	
	private AutorDAO autorDao;
	
	public AutorBusiness() {
		this.autorDao = new AutorDAO();
	}
	
	public AutorDTO buscarPorId(Integer id) {
		AutorDTO aDTO = new AutorDTO();
		Autor a = new Autor();
		
		a = autorDao.buscarPorId(id);
		
		aDTO.setId(a.getId());
		aDTO.setNome(a.getNome());
		aDTO.setPseudonimo(a.getPseudonimo());
		
		return aDTO;
	}
	
	public List<AutorDTO> buscarTodos() {
		List<Autor> autores = autorDao.buscarTodos();

		List<AutorDTO> autoresDto = new ArrayList<>();

		for (Autor a : autores) {
			AutorDTO autorDto = new AutorDTO();
			
			autorDto.setId(a.getId());
			autorDto.setNome(a.getNome());
			autorDto.setPseudonimo(a.getPseudonimo());
			
			autoresDto.add(autorDto);
		}
		return autoresDto;
	}

}
