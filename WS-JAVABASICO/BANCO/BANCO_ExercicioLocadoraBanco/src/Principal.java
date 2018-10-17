import java.util.List;
import java.util.Scanner;

import Perspectiva.DAOFilme;
import Perspectiva.DAOGenero;
import models.Filme;
import models.Genero;

public class Principal {

	public static void main(String[] args) {
		Integer idADeletar = 0;
		DAOFilme daoFilmes = new DAOFilme();
		DAOGenero daoGeneros = new DAOGenero();
		List<Filme> filmes = daoFilmes.buscarTodos();
		List<Genero> generos = daoGeneros.buscarTodos();

		System.out.println("---------------------------------------");
		// * Buscar todos os gêneros e exibi-los
		listarGeneros(generos = daoGeneros.buscarTodos());
		System.out.println("---------------------------------------");

		// busca por ID
		System.out.println("---------------------------------------");
		daoFilmes.buscarPorId(5).toString();
		System.out.println("---------------------------------------");

		/*
		 * Filme jason = new Filme(); jason.setNome("Jason O Filme");
		 * jason.setAno(1998);
		 * jason.setId_genero(daoGeneros.buscarPorDescricao("Ação"));
		 * jason.setId_diretor(1); daoFilmes.inserir(jason);
		 */
		System.out.println("---------------------------------------");

		System.out.println("---------------------------------------");
		// Alterar o nome de um dos filmes
		daoFilmes.alterarNomeDoFilme(12, "Barbie O Filme");
		
		System.out.println("---------------------------------------");

		// * Utilizar o método buscarTodos do DaoFilme para exibir todos os filmes
		listarFilmes(filmes = daoFilmes.buscarTodos());

		System.out.println("---------------------------------------");
		// * Excluir um filme
		while (idADeletar != 999) {
			Scanner ler = new Scanner(System.in);
			System.out.println("Digite o id de um filme para deletar / 999 para sair");
			idADeletar = ler.nextInt();

			for (Filme f : filmes) {
				if (idADeletar.equals(f.getId())) {
					daoFilmes.excluir(f.getId());

					break;
				}
			}
		}
		System.out.println("---------------------------------------");
		listarFilmes(filmes = daoFilmes.buscarTodos());
	}

	public static void listarFilmes(List<Filme> filmes) {
		System.out.println("Lista de filmes: ");
		for (Filme f : filmes) {
			System.out.println(f);
		}
	}

	public static void listarGeneros(List<Genero> generos) {
		System.out.println("Lista de generos: ");
		for (Genero g : generos) {
			System.out.println(g);
		}
	}

}
