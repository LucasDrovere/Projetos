package figuras.principal;

import heranca.figuras.Losango;
import heranca.figuras.Quadrado;

public class Principal {
	
	public static void main(String[] args) {
				
		Quadrado q = new Quadrado(5);
		System.out.println("Área do quadrado: " + q.calcularArea());
		
		Losango l = new Losango(10, 5);
		System.out.println("Área do losango: " + l.calcularArea());
		
	}

}
