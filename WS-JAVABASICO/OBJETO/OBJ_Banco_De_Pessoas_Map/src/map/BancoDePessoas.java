package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BancoDePessoas {
	
	private Map<String, List<Pessoa>> mapaDePessoas = new HashMap<>();
	
	public void addPessoa(Pessoa pessoa) {
		
		
		String primeiraLetra = String.valueOf(pessoa.getNome().charAt(0));
		
		if (mapaDePessoas.containsKey(primeiraLetra)) {
			System.out.println("Ja tenho essa chave");
			List<Pessoa> pessoas = mapaDePessoas.get(primeiraLetra);
			pessoas.add(pessoa);
		} else {
			List<Pessoa> pessoas = new ArrayList<>();
			pessoas.add(pessoa);
			mapaDePessoas.put(primeiraLetra, pessoas);
			System.out.println("Não tenho essa chave");
		}
	}

	public void mostraPessoas(String letra) {
		List<Pessoa> pessoas = mapaDePessoas.get(letra);
		for (Pessoa p : pessoas) {
			System.out.println(p);
		}
	}

	public void mostrarTodasAsPessoas() {
		for (String letra : mapaDePessoas.keySet()) {
			System.out.println("Pessoas que começam com a letra: " + letra);
			mostraPessoas(letra);
		}
	}
}