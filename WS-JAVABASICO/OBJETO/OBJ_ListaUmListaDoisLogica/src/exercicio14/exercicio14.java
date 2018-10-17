package lista1;

import java.util.Scanner;

public class exercicio14 {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);

		System.out.println("Digite seu nome e sua idade: ");
		String nome = ler.next();
		int idade = ler.nextInt();

		if (idade <= 10) {
			System.out.println(nome + " - " + "R$ 30,00");
		} else if (idade > 10 && idade <= 29) {
			System.out.println(nome + " - " + "R$ 60,00");
		} else if (idade > 29 && idade <= 45) {
			System.out.println(nome + " - " + "R$ 120,00");
		} else if (idade > 45 && idade <= 59) {
			System.out.println(nome + " - " + "R$ 150,00");
		} else if (idade > 59 && idade <= 65) {
			System.out.println(nome + " - " + "R$ 250,00");
		} else {
			System.out.println(nome + " - " + "R$ 400,00");
		}
	}
}
