package br.com.cast.jsfprova.business;

import java.util.ArrayList;
import java.util.List;

import br.com.cast.jsfprova.dto.AutorDTO;
import br.com.cast.jsfprova.dto.CategoriaDTO;
import br.com.cast.jsfprova.dto.LivroDTO;
import br.com.cast.jsfprova.entidade.Autor;
import br.com.cast.jsfprova.entidade.Categoria;
import br.com.cast.jsfprova.entidade.Livro;
import br.com.cast.jsfprova.excecao.TituloExistenteException;
import br.com.cast.jsfprova.persistencia.AutorDAO;
import br.com.cast.jsfprova.persistencia.CategoriaDAO;
import br.com.cast.jsfprova.persistencia.LivroDAO;

public class LivroBusiness {
	private LivroDAO livroDao;
	private AutorDAO autorDao;
	private CategoriaDAO categoriaDao;

	public LivroBusiness() {
		this.livroDao = new LivroDAO();
		this.autorDao = new AutorDAO();
		this.categoriaDao = new CategoriaDAO();
	}

	public void inserir(LivroDTO livroDto) throws TituloExistenteException {

		Livro livro = buscarLivro(livroDto.getTitulo());

		if (livro == null) {
			Autor a = autorDao.buscarPorId(livroDto.getIdAutor());
			Categoria c = categoriaDao.buscarPorId(livroDto.getIdCategoria());

			Livro l = new Livro();
			l.setTitulo(livroDto.getTitulo());
			l.setData_publicacao(livroDto.getData_publicacao());
			l.setAutor(a);
			l.setCategoria(c);
			livroDao.inserir(l);
		} else {
			throw new TituloExistenteException();
		}

	}

	public Livro buscarLivro(String titulo) {
		Livro l = livroDao.buscarLivro(titulo);
		return l;
	}

	public LivroDTO buscarPorId(Integer id) {
		AutorDTO autorDto = new AutorDTO();
		Autor autor = new Autor();

		autorDto.setId(autor.getId());
		autorDto.setNome(autor.getNome());
		autorDto.setPseudonimo(autor.getPseudonimo());

		CategoriaDTO categoriaDto = new CategoriaDTO();
		Categoria categoria = new Categoria();

		categoriaDto.setId(categoria.getId());
		categoriaDto.setDescricao(categoria.getDescricao());

		LivroDTO livroDto = new LivroDTO();
		Livro l = livroDao.buscarPorIds(id);

		livroDto.setId(l.getId());
		livroDto.setTitulo(l.getTitulo());
		livroDto.setData_publicacao(l.getData_publicacao());
		livroDto.setAutorDto(autorDto);
		livroDto.setCategoriaDto(categoriaDto);
		return livroDto;
	}

	public void remover(Integer id) {
		livroDao.remover(id);
	}

	public List<LivroDTO> buscarTodos() {

		List<Livro> livros = livroDao.buscarTodos();

		List<LivroDTO> livrosDto = new ArrayList<>();

		for (Livro l : livros) {
			AutorDTO autorDto = new AutorDTO();
			Autor autor = l.getAutor();

			autorDto.setId(autor.getId());
			autorDto.setNome(autor.getNome());
			autorDto.setPseudonimo(autor.getPseudonimo());

			CategoriaDTO categoriaDto = new CategoriaDTO();
			Categoria categoria = l.getCategoria();

			categoriaDto.setId(categoria.getId());
			categoriaDto.setDescricao(categoria.getDescricao());

			LivroDTO livroDto = new LivroDTO();

			livroDto.setId(l.getId());
			livroDto.setTitulo(l.getTitulo());
			livroDto.setData_publicacao(l.getData_publicacao());
			livroDto.setAutorDto(autorDto);
			livroDto.setCategoriaDto(categoriaDto);

			livrosDto.add(livroDto);
		}

		return livrosDto;
	}

	public void alterar(LivroDTO livroDto) throws TituloExistenteException {

		Livro livro = buscarLivro(livroDto.getTitulo());

		if (livro == null) {
			Livro l = new Livro();
			Autor a = autorDao.buscarPorId(livroDto.getIdAutor());
			Categoria c = categoriaDao.buscarPorId(livroDto.getIdCategoria());

			l.setId(livroDto.getId());
			l.setTitulo(livroDto.getTitulo());
			l.setData_publicacao(livroDto.getData_publicacao());
			l.setAutor(a);
			l.setCategoria(c);

			livroDao.alterar(l);
		} else {
			throw new TituloExistenteException();
		}
	}

}
