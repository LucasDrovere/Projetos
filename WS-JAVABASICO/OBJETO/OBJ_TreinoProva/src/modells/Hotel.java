package modells;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

	private String nome;
	private List<Andar> andares;
	
	public Hotel(String nome) {
		this.nome = nome;
		andares = new ArrayList<>();
	}
	
	public void adicionarAndares(Andar a) {
		andares.add(a);
	}

	public void imprimeDados() {
		System.out.println(this);
	}
	
	@Override
	public String toString() {
		return 	"\nNome do hotel: " + nome + 
				"\nAndares do hotel: " + andares + "";
	}
}
