package exercicio8;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Infome um dia:");
		int dia = scanner.nextInt();

		System.out.println("Infome um mes:");
		int mes = scanner.nextInt();

		System.out.println("Infome e um ano:");
		int ano = scanner.nextInt();

		// (notaum > notadois && notaum > notatres)

		if (dia >= 1 && dia <= 31) {
			if (mes >= 1 && mes <= 12) {
				if (ano >= 1900 && ano <= 2099) {
					System.out.println("Data valida!");
				} else {
					System.out.println("Data invalida!");
				}
			} else {
				System.out.println("Data invalida!");
			}
		} else {
			System.out.println("Data invalida!");
		}
	}
}
