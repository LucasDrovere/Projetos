package set;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import modelos.Pessoa;

public class PrincipalSet {

	public static void main(String[] args) {
		
		Pessoa mar = new Pessoa("Maria", "1111111111111");
		Pessoa jos = new Pessoa("Jose", "1111111111112");
		
		if (mar.equals(jos)) {
			System.out.println("são iguais");
		} else {
			System.out.println("são diferentes");
		}
		
		Set<Pessoa> pessoasSet = new HashSet<>();
		boolean addMaria = pessoasSet.add(mar);
		boolean addMaria2 = pessoasSet.add(jos);
				
		System.out.println(addMaria);
		System.out.println(addMaria2);
		
		System.out.println("Percorrendo os elementos...");
		
		for (Pessoa p : pessoasSet) {
			System.out.println(p);
		}
		
		Pessoa novaMaria = new Pessoa("Maria", "1111111111111");
		
		if (pessoasSet.contains(novaMaria)) {
			System.out.println("Existe esse objeto");
		}
		
		//utiliza o hashCode o equals
		pessoasSet.remove(novaMaria);
		System.out.println(pessoasSet);
		
		Iterator<Pessoa> itPessoas = pessoasSet.iterator();
		System.out.println("Percorrendo com iterator");
		while (itPessoas.hasNext()) {
			Pessoa p = itPessoas.next();
			System.out.println(p);
			itPessoas.remove();
		}
		System.out.println(pessoasSet);
		
		System.out.println("*****Testando hashset*****");
		testPerformance(new HashSet<>());
		
		System.out.println("*****Testando arraylist*****");
		testPerformance(new ArrayList<>());

	}
	
	public static void testPerformance(Collection<Pessoa> colecao) {
		long inicio = new Date().getTime();		
		int c = 0;
		while (c <= 6000000) {
			colecao.add(new Pessoa(""+c, ""+c));
			c++;
		}
		System.out.println("tempo inserção " + ((new Date().getTime() - inicio)));
		
		inicio = new Date().getTime();		
		colecao.contains(new Pessoa("6000000", "6000000"));
		System.out.println("tempo consulta " + ((new Date().getTime() - inicio)));	
		
		
	}

}

package modelos;

public class Pessoa implements Comparable<Pessoa> {
	
	private String nome;
	private String cpf;
	
	public Pessoa(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object outroObj) {
		if (!(outroObj instanceof Pessoa)) {
			return false;
		}
		
		Pessoa outraPessoa = (Pessoa) outroObj;
		
		return cpf.equals(outraPessoa.getCpf()) && 
			   nome.equals(outraPessoa.getNome());
	}
	
	@Override
	public String toString() {
		return "Nome: " + nome + " Cpf: " + cpf;
	}

	@Override
	public int compareTo(Pessoa outraPessoa) {
		int stringCompare = nome.compareToIgnoreCase(
					outraPessoa.getNome());
		return stringCompare * -1;
	}

}

