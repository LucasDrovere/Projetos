package lista2;

import java.util.Scanner;

public class exercicio3 {

	public static void main(String[] args) {
		// 0 && 1 n�o s�o primos
		// numeros primos s�o divisiveis apenas por 1 e por si mesmo
		// s� existem 2 divisores
		// n�o existem numeros primos pares exceto o 2 que � o primeiro numero primo.
		// i % 2 != 0
		// se for impar talvez seja primo
		// numeros > 5 terminados em 5 n�o s�o primos
		// n�o � numero primo quando terminado em 2, 4, 6, 8, 0

		Scanner ler = new Scanner(System.in);

		System.out.println("Digite um numero inteiro para saber quantos numeros primos existem at� ele: ");
		int n = ler.nextInt();
		
		int cont = 0;
		
		for (int i = 2; i <= n; i++) {
			if ((i == 2) || (i == 3) || (i == 5) || (i == 7) || (i == 11) || (i == 13) || (i != 2)
					&& (i % 2 != 0) && (i % 3 != 0) && (i % 5 != 0) && (i % 7 != 0)) {
				
				System.out.print(i + " - ");
				cont = cont + 1;
			}
		}
		System.out.println("\nA quantidade de numeros primos at� o numero digitado �: " + cont);
	}
}
