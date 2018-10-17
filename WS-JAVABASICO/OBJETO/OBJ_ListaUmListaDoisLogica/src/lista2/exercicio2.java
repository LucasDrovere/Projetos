package lista2;

import java.util.Scanner;

public class exercicio2 {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		int fat = 1;
		
		System.out.println("Digite um numero para saber seu fatorial :");
		int num = ler.nextInt();

		for(int i = num; i >= 1; i--) {
			fat = fat * i;
			System.out.print(i + " * ");
		}
		System.out.println(" = " + fat);
	}
}
