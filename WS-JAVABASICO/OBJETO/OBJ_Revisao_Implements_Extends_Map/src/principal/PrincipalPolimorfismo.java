package principal;

import java.util.ArrayList;
import java.util.List;

import models.Animal;
import models.Cachorro;
import models.Gato;

public class PrincipalPolimorfismo {
	
	public static void main(String[] args) {
		
		List<Animal> animais = new ArrayList<>();
		
		Cachorro cachorro = new Cachorro();
		Gato gato = new Gato();
		
		animais.add(cachorro);
		animais.add(gato);
		
		for (Animal a : animais) {
			aceitamosAnimais(a);
		}
		
		soAceitoCachorro(cachorro);
	}
	
	public static void soAceitoCachorro(Cachorro c) {
		c.fazerBarulho();
		c.morder();
	}
	
	public static void aceitamosAnimais(Animal a) {
		a.fazerBarulho();
	}

}
