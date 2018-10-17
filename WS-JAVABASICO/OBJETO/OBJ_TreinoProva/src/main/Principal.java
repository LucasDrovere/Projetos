package main;

import modells.Andar;
import modells.Hospede;
import modells.Hotel;
import models.abstracts.Quarto;

public class Principal {

	public static void main(String[] args) {
		Hospede hosp = new Hospede("Lucas", "4131313");
		
		System.out.println(hosp);

		Hotel hotel = new Hotel("Super Hotel");
		
		Andar primeiroAndar = new Andar(1);
		Andar segundoAndar = new Andar(2);
		Andar terceiroAndar = new Andar(3);
		hotel.adicionarAndares(primeiroAndar);
		hotel.adicionarAndares(segundoAndar);
		hotel.adicionarAndares(terceiroAndar);
		
		
		System.out.println(hotel);
	}

}
