import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import map.Pessoa;

public class Livro {
	private String nome;
	private Autor autor;
	private String dataDePublicacao;
	private String editora;
	private List<Pagina> paginas;

	public Livro(String nome, Autor autor, String dataDePublicacao, String editora) {
		this.nome = nome;
		this.autor = autor;
		this.dataDePublicacao = dataDePublicacao;
		this.editora = editora;
	}

	// private Map<String, List<Pagina>> mapaDepaginas = new HashMap<>();

	Map<String, Integer> mapaFreq = new HashMap<>();

	Set<Pagina> paginaSet = new HashSet<>();
	List<Pagina> pagLivro = new ArrayList<>();

	public void addPagina(Pagina pagina) {
		pagLivro.add(pagina);
		System.out.println("Pagina adicionada.");
	}

	public void exibirPalavrasMaisComuns() {

		if (mapaFreq.containsKey(palavra)) {
			System.out.println("Ja tenho essa palavra");
			List<Pagina> pagLivro = mapaFreq.get(palavra);
			pessoas.add(pessoa);
		} else {
			mapaFreq.put(palavra, null);

		}
	}

	public void exibirPalavrasEmOrdem() {
		String texto = "";
		String[] palavras = texto.split(" ");
		String[] charsARemover = new String[] { ",", ".", ":" };
		                                                
				Iterator<Pagina> pIterator = paginaSet.iterator();
				while (pIterator.hasNext()) {
					Pagina p = (Pagina) pIterator.next();
					Collections.sort(pagLivro);
				}
				System.out.println(p);
			}
		}
	}

	public void exibirQtdDePalavras() {
		for (Pagina p : paginas) {
			System.out.println(p);
		}
	}

	public void imprimirLivro() {
		System.out.println(toString());
	}

	@Override
	public String toString() {
		return "Livro: <" + nome + "> \nAutor: <" + autor + "> \nData De Publicacao: <" + dataDePublicacao + "> "
				+ "\nEditora: <" + editora + "> \nPagina: " + pagLivro + "";
	}

}
