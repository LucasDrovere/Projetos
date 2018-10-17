package lista2;

import java.util.Scanner;

public class exercicio3 {

	public static void main(String[] args) {
		// 0 && 1 não são primos
		// numeros primos são divisiveis apenas por 1 e por si mesmo
		// só existem 2 divisores
		// não existem numeros primos pares exceto o 2 que é o primeiro numero primo.
		// i % 2 != 0
		// se for impar talvez seja primo
		// numeros > 5 terminados em 5 não são primos
		// não é numero primo quando terminado em 2, 4, 6, 8, 0

		Scanner ler = new Scanner(System.in);

		System.out.println("Digite um numero inteiro para saber quantos numeros primos existem até ele: ");
		int n = ler.nextInt();
		
		int cont = 0;
		
		for (int i = 2; i <= n; i++) {
			if ((i == 2) || (i == 3) || (i == 5) || (i == 7) || (i == 11) || (i == 13) || (i != 2)
					&& (i % 2 != 0) && (i % 3 != 0) && (i % 5 != 0) && (i % 7 != 0)) {
				
				System.out.print(i + " - ");
				cont = cont + 1;
			}
		}
		System.out.println("\nA quantidade de numeros primos até o numero digitado é: " + cont);
	}
}
