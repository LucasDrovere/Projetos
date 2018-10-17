package exercicio6;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int matricula = 0;

		while (matricula != 999) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Digite a matricula: ");
			matricula = scanner.nextInt();

			if (matricula != 999) {

				System.out.println("Digite sua primeira nota: ");
				double notaum = scanner.nextInt();
				System.out.println("Digite sua segunda nota: ");
				double notadois = scanner.nextInt();
				System.out.println("Digite sua terceira nota: ");
				double notatres = scanner.nextInt();

				double somanotas = (notaum + notadois + notatres);
				double medianotas = (somanotas / 3);

				if (medianotas > 6) {
					System.out.println("Aprovado!");
				} else if (medianotas <= 4) {
					System.out.println("Reprovado!");
				} else {
					System.out.println("Media!");
				}
			}
		}
		System.out.println("999 foi digitado.");
	}
}