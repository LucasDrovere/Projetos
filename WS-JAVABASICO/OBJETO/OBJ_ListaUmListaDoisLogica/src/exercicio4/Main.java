package exercicio4;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite a primeira nota: ");
		double notaum = scanner.nextInt();
		System.out.println("Digite a segunda nota: ");
		double notadois = scanner.nextInt();
		System.out.println("Digite a terceira nota: ");
		double notatres = scanner.nextInt();


		if (notaum > notadois && notaum > notatres) {
			double notamaior = notaum;
			int notadigitada = 1;
			System.out.println("A maior nota digitada e: " + notamaior + " e essa nota foi digitada em " + notadigitada);
		} else if (notadois > notaum && notadois > notatres) {
			double notamaior = notadois;
			int notadigitada = 2;
			System.out.println("A maior nota digitada e: " + notamaior + " e essa nota foi digitada em " + notadigitada);
		} else {
			double notamaior = notatres;
			int notadigitada = 3;
			System.out.println("A maior nota digitada e: " + notamaior + " e essa nota foi digitada em " + notadigitada);
		}
	}
}
