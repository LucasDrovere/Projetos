package br.com.cast.modelss;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
private String nome;
private List<Andar> andares;

public Hotel(String nome) {
	this.nome = nome;
	andares = new ArrayList<>();
}

public void adicionarAndar(Andar a) {
	if (andares.contains(a)) {
		System.out.println("Andar ja existente!");
	} else {
		andares.add(a);
		System.out.println("Andar: " + a + " adicionado com sucesso.");
	}
}


public void imprimeDados() {
	System.out.println("------------------------------------------------------------------------------");
	System.out.println(this);
	System.out.println("------------------------------------------------------------------------------");
}


@Override
public String toString() {
	return "Hotel: \tNome: " + nome + " \n\tAndares: " + andares + "";
}

}
