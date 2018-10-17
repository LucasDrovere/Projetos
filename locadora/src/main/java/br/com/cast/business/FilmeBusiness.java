package br.com.cast.business;

import java.util.ArrayList;
import java.util.List;

import br.com.cast.dto.DiretorDTO;
import br.com.cast.dto.FilmeDTO;
import br.com.cast.dto.GeneroDTO;
import br.com.cast.entidade.Diretor;
import br.com.cast.entidade.Filme;
import br.com.cast.entidade.Genero;
import br.com.cast.persistencia.DiretorDAO;
import br.com.cast.persistencia.FilmeDAO;
import br.com.cast.persistencia.GeneroDAO;

public class FilmeBusiness {

	private FilmeDAO filmeDao;
	private DiretorDAO diretorDao;
	private GeneroDAO generoDao;

	public FilmeBusiness() {
		this.filmeDao = new FilmeDAO();
		this.diretorDao = new DiretorDAO();
		this.generoDao = new GeneroDAO();
	}

	public void inserir(FilmeDTO filmeDto) {
		Genero g = generoDao.buscarPorId(filmeDto.getIdGenero());
		Diretor d = diretorDao.buscarPorId(filmeDto.getIdDiretor());
		
		Filme f = new Filme();
		f.setNome(filmeDto.getNome());
		f.setAno(filmeDto.getAno());
		f.setDiretor(d);
		f.setGenero(g);
		
		filmeDao.inserir(f);
	}

	public FilmeDTO buscarFilme(FilmeDTO filmeDTO) {
		return filmeDTO;
	}
	
	public void remover(Integer id) {
		filmeDao.remover(id);
	}
	
	public List<FilmeDTO> buscarTodos() {
		
		List<Filme> filmes = filmeDao.buscarTodos();
		
		List<FilmeDTO> filmesDTO = new ArrayList<>();
		
		for (Filme f : filmes) {
			
			GeneroDTO generoDto = new GeneroDTO();
			Genero genero = f.getGenero();
			
			generoDto.setId(genero.getId());
			generoDto.setNome(genero.getNome());
			
			DiretorDTO diretorDto = new DiretorDTO();
			Diretor diretor = f.getDiretor();
			
			diretorDto.setId(diretor.getId());
			diretorDto.setNome(diretor.getNome());
			diretorDto.setIdade(diretor.getIdade());
			diretorDto.setSexo(diretor.getSexo());
			
			FilmeDTO filmeDto = new FilmeDTO();
			
			filmeDto.setId(f.getId());
			filmeDto.setNome(f.getNome());
			filmeDto.setAno(f.getAno());
			filmeDto.setGenerodto(generoDto);
			filmeDto.setDiretordto(diretorDto);
			
			filmesDTO.add(filmeDto);
			
		}
		return filmesDTO;
	}
	
	public void alterar(FilmeDTO filmeDto) {
		Filme f = new Filme();
		Diretor diretor = diretorDao.buscarPorId(filmeDto.getDiretordto().getId());
		Genero genero = generoDao.buscarPorId(filmeDto.getGenerodto().getId());
		
		f.setId(filmeDto.getId());
		f.setNome(filmeDto.getNome());
		f.setAno(filmeDto.getAno());
		f.setGenero(genero);
		f.setDiretor(diretor);
		
		filmeDao.alterar(f);
	}

}
