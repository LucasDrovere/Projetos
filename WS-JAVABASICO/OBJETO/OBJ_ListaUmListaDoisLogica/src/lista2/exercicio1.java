package lista2;

import java.util.Scanner;

public class exercicio1 {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		
		System.out.printf("Informe um n�mero inteiro: ");
		int num = ler.nextInt();
		
		if (num % 2 == 0) {
			System.out.println(num + " � um numero par");
		}else{
			System.out.println(num + " � um numero impar");
		}
	}

}