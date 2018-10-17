package exercicio9;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String nomePraia = "z";
		double maiorDistancia = 0;
		double somapraia = 0;
		String nomeDistante = "";
		double distanciaPraia = 0;
		int i = 0;
		int numeroPraias = 0;
		
		double mediapraia = 0;
		
		while (!nomePraia.equals("zzz")) {
			System.out.println("Infome o nome da praia:");
			nomePraia = scanner.next();
			
			System.out.println("Infome a quantos km do hotel fica a praia:");
			distanciaPraia = scanner.nextDouble();
			
			if (distanciaPraia > maiorDistancia) {
				maiorDistancia = distanciaPraia;
				nomeDistante = nomePraia;
			}
			
			if (distanciaPraia >= 10 && distanciaPraia <= 15) {
				i++;
				numeroPraias = i;
			}
			
			
			
			/*
			somapraia = somapraia + distancia; 
			
			
			
			mediapraia = somapraia / i;
		}
		System.out.println("Praia 'zzz' foi digitada!");
		System.out.println("A praia mais distante do hotel é: " + nomeDistante);
		System.out.println("O numero de praias entre 10 a 15 km é: " + numeroPraias);
		System.out.println(mediapraia);
		*/
		}
	}
}
