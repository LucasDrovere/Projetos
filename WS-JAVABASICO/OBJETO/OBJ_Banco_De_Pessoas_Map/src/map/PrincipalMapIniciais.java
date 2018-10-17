package map;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PrincipalMapIniciais {

	public static void main(String[] args) {
		Pessoa mar = new Pessoa("Maria", "1111111");
		Pessoa jos = new Pessoa("Jos", "22222222");

		if (mar.equals(jos)) {
			System.out.println("são iguais");
		} else {
			System.out.println("são diferentes");
		}

		Set<Pessoa> pessoasSet = new HashSet<>();
		boolean addMaria = pessoasSet.add(mar);
		boolean addJos = pessoasSet.add(jos);

		System.out.println("Conseguiu adicionar: " + addMaria);
		System.out.println("Conseguiu adicionar: " + addJos);

		percorreHash(pessoasSet);

		percorreHash(pessoasSet);

		if (pessoasSet.contains(mar)) {
			pessoasSet.remove(mar);
		}
	}

	private static void percorreHash(Set<Pessoa> pessoasSet) {
		System.out.println();
		Iterator<Pessoa> pIterator = pessoasSet.iterator();
		while (pIterator.hasNext()) {
			Pessoa p = (Pessoa) pIterator.next();
			System.out.println(p);
		}
	}
}

/*
 * Iterator<Carro> carrosAsIterator = carros.iterator(); while
 * (carrosAsIterator.hasNext()){ Carro it = carrosAsIterator.next();
 */

/*
 * BancoDePessoas banco = new BancoDePessoas(); banco.addPessoa(new
 * Pessoa("Teste", "3132132132132")); banco.addPessoa(new Pessoa("Teste 2",
 * "1111121313213")); banco.addPessoa(new Pessoa("Matheus", "65165166516"));
 * banco.addPessoa(new Pessoa("Marcia", "65165166516"));
 * 
 * banco.mostraPessoas("M");
 * 
 * banco.mostrarTodasAsPessoas();
 */