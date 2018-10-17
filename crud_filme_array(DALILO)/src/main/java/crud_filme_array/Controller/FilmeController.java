package crud_filme_array.Controller;

import java.util.ArrayList;
import java.util.List;

import crud_filme_array.Entidade.Filme;

public class FilmeController {

	private static List<Filme> filmes = new ArrayList<Filme>();

	public FilmeController() {
	
	}

	public void inserir(Filme filme) {
		filmes.add(filme);
		if (!filmes.isEmpty()) {
			System.out.println("Adicionou no array" + " " + filme.toString());
		}
		
		System.out.println("filmes no array" + " : " + filmes.toString());
	}

	public List<Filme> buscarFilmes() {
		System.out.println("Buscando filmes");
		System.out.println("filmes no array" + " : " + filmes.toString());
		return FilmeController.filmes;
	}

	public void deletar(Integer id) {
		Filme fDeletar = buscarPorId(id);
		
		if (!fDeletar.equals(null)) {
			filmes.remove(fDeletar);
		}else {
			System.out.println("filme não encontrado");
		}
	}

	public void alterar(Filme filme) {
		for (Filme f : filmes) {
			if (f.getId().equals(filme.getId())) {
				int index = filmes.indexOf(f);
				filmes.set(index, filme);
			}
		}
	}

	public Filme buscarPorId(Integer id) {
		for (Filme f : filmes) {
			if (f.getId().equals(id)) {
				return f;
			}
		}
		return null;
	}
}
