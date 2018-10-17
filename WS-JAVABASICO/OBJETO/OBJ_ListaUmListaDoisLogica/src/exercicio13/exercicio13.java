package lista1;

import java.util.Scanner;

public class exercicio13 {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);

		System.out.println("Digite seu nome e sua idade: ");
		String nome = ler.next();
		int idade = ler.nextInt();

		if (idade >= 18 && idade < 65) {
			System.out.println(nome + " - " + "Maior de idade.");
		} else if (idade >= 65) {
			System.out.println(nome + " - " + "Maior de idade" + " - " + "Maior de 65 anos.");
		} else if (idade >= 12 && idade < 18) {
			System.out.println(nome + " - " + "Menor de idade");
		}else {
			System.out.println(nome + " - " + "Menor de 12 anos.");
		}
	}
}
