package principal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Pessoa;

public class Principal {

	public static void main(String[] args) {
		
		Map<Pessoa, String> map = new HashMap<>();
		
		Pessoa pablo = new Pessoa("Pablo", "Escobar");
		Pessoa pabloVittar = new Pessoa("Pablo", "Vittar");
		
		//considera o hashCode e o equals para verificar duplicidade
		map.put(pablo, pablo.getNome());
		map.put(pabloVittar, pabloVittar.getNome());
		
		List<Pessoa> pessoas = new ArrayList<>();
		pessoas.add(pablo);
		pessoas.add(pabloVittar);
		
		for (Pessoa p : pessoas) {
			System.out.println(p.getNome() + " " + p.getSobrenome());
		}
		
		Pessoa novoPablo = new Pessoa("Pablo", "Escobar");
		
		//será utilizado o equals para comparar os objetos
		if (pessoas.contains(novoPablo)) {
			System.out.println("São iguais!");
		} else {
			System.out.println("São diferentes!");
		}

		//também será utilizado o equals para comparar o objeto
		pessoas.remove(novoPablo);
		
		System.out.println(map);
		
	}

}
