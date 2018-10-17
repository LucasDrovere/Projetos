package br.com.cast.filme.Business;

import java.util.ArrayList;
import java.util.List;

import br.com.cast.filme.dto.DiretorDTO;
import br.com.cast.filme.dto.FilmeDTO;
import br.com.cast.filme.dto.GeneroDTO;
import br.com.cast.filme.entidade.Diretor;
import br.com.cast.filme.entidade.Filme;
import br.com.cast.filme.entidade.Genero;
import br.com.cast.filme.persistencia.FilmeDao;

public class FilmeBusiness {


	private FilmeDao fDAO = new FilmeDao();
	

	public void salvar(FilmeDTO filmeDto) {

		Filme f = new Filme();
		
		DiretorDTO diretorDto = filmeDto.getDiretorDTO();
		Diretor diretor = new Diretor();

		diretor.setId(diretorDto.getId());
		diretor.setNome(diretorDto.getNome());
		diretor.setIdade(diretorDto.getIdade());

		GeneroDTO generoDto = filmeDto.getGeneroDTO();
		Genero genero = new Genero();

		genero.setId(generoDto.getId());
		genero.setNome(generoDto.getNome());

		f.setNome(filmeDto.getNome());
		f.setDiretor(diretor);
		f.setGenero(genero);

		fDAO.inserir(f);

	}

	public List<FilmeDTO> buscarTodos() {

		List<Filme> filmes = fDAO.buscarTodos();

		List<FilmeDTO> filmessDTO = new ArrayList<>();

		for (Filme filme : filmes) {

			DiretorDTO dDTO = new DiretorDTO();
			Diretor diretor = filme.getDiretor();

			dDTO.setId(diretor.getId());
			dDTO.setNome(diretor.getNome());
			dDTO.setIdade(diretor.getIdade());

			GeneroDTO gDTO = new GeneroDTO();
			Genero genero = filme.getGenero();

			gDTO.setId(genero.getId());
			gDTO.setNome(genero.getNome());

			FilmeDTO fDTO = new FilmeDTO();

			fDTO.setId(filme.getId());
			fDTO.setNome(filme.getNome());
			fDTO.setDiretorDTO(dDTO);
			fDTO.setGeneroDTO(gDTO);
			filmessDTO.add(fDTO);
		}

		return filmessDTO;

	}
	
	public void remover(FilmeDTO filmeDto) {
		Filme f = new Filme();
		
		f = fDAO.buscarPorId(filmeDto.getId());
		
		fDAO.excluir(f);
	}
	
	public FilmeDTO buscarFilme(FilmeDTO filmeDTO) {
		return filmeDTO;
	}
	
	public void alterar(FilmeDTO filmeDTO) {
		
		Filme f = new Filme();
		
		f.setId(filmeDTO.getId());
		f.setNome(filmeDTO.getNome());
		
		
		DiretorDTO dDTO = filmeDTO.getDiretorDTO();
		
		Diretor diretor = new Diretor();
		diretor.setId(dDTO.getId());
		diretor.setNome(dDTO.getNome());
		diretor.setIdade(dDTO.getIdade());

		f.setDiretor(diretor);
		
		GeneroDTO gDTO = filmeDTO.getGeneroDTO();
		Genero genero = new Genero();
		
		genero.setId(gDTO.getId());
		genero.setNome(gDTO.getNome());
		
		f.setGenero(genero);
		
		fDAO.alterar(f);
	}

}
