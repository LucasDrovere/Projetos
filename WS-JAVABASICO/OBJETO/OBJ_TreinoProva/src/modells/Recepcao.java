package modells;

import interfaces.Faturavel;

public class Recepcao {

	
	
	public static void pagar(Faturavel f, int qntDeDiarias) {
		double valorPagar = (f.faturar(qntDeDiarias));
		System.out.println("Valor a pagar pela estadia R$: " + valorPagar);
	}
}

