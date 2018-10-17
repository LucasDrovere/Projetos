package exercicio5;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite sua primeira nota: ");
		double notaum = scanner.nextInt();
		System.out.println("Digite sua segunda nota: ");
		double notadois = scanner.nextInt();
		System.out.println("Digite sua terceira nota: ");
		double notatres = scanner.nextInt();

		if (notaum > notadois && notaum > notatres) {
			double notamaior = notaum;
			System.out.println("A maior nota digitada é: " + notamaior);
			
		} else if (notadois > notaum && notadois > notatres) {
			double notamaior = notadois;
			System.out.println("A maior nota digitada é: " + notamaior);
			
		} else {
			double notamaior = notatres;
			System.out.println("A maior nota digitada é: " + notamaior);
		}
		
		if (notaum < notadois && notaum < notatres) {
			double notamenor = notaum;
			System.out.println("A maior nota digitada é: " + notamenor);
			
		} else if (notadois < notaum && notadois < notatres) {
			double notamenor = notadois;
			System.out.println("A maior nota digitada é: " + notamenor);
			
		} else {
			double notamenor = notatres;
			System.out.println("A maior nota digitada é: " + notamenor);
		}
		
	}
}
