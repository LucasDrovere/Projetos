package animal.principal;

import java.util.ArrayList;

import heranca.animal.Animal;
import heranca.animal.Cachorro;
import heranca.animal.Casa;
import heranca.animal.Cobra;
import heranca.animal.EmissoraDeSom;
import heranca.animal.Gato;
import heranca.animal.Pitbull;
import heranca.animal.Poodle;
import heranca.animal.Siames;

public class Principal {

	public static void main(String[] args) {
		Casa cas = new Casa();
		cas.criar(new Poodle());
		cas.criar(new Siames());
		cas.criar(new Cobra());
		cas.criar(new Pitbull());
		
		Cachorro c = new Cachorro();
		c.setNomeAnimal("Nina");
		c.exibir();

		Cobra co = new Cobra();
		co.setNomeAnimal("Snakeeeers");
		co.exibir();
		
		
		Gato g = new Gato();
		g.setNomeAnimal("Bibi");
		g.exibir();

		Poodle p = new Poodle();
		p.setNomeAnimal("Peralta");
		p.exibir();

		Siames s = new Siames();
		s.setNomeAnimal("Roberta");
		s.exibir();

//		Animal animais[] = new Animal[3];
//		animais[2] = s;
//		for (int i = 0; i < animais.length; i++) {
//			animais[i] = s;
//			System.out.println(animais);
//		}
//
//		EmissoraDeSom e = new EmissoraDeSom();
//		e.emitir(a);

	}
}