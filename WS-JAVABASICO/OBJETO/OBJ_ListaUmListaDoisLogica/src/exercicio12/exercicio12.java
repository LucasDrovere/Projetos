package lista1;

import java.util.Scanner;

public class exercicio12 {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		
		System.out.println("Entre com o tempo gasto na viagem em minutos: ");
		double mim = ler.nextDouble();
		
		System.out.println("Entre com a velocidade media: ");
		double velmedia = ler.nextDouble();
		
		double distancia = mim * velmedia;
		
		double litrosusados = (distancia / (int) 12);
		
		System.out.println(litrosusados);
		
		//System.out.println(String.format("A quantidade de litros de combustível necessária para se fazer essa viagem é : %.2f", litrosusados));
	}
}
