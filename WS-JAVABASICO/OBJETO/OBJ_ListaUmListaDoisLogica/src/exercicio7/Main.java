package exercicio7;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Estados civis: \n" + "1 - Solteiro(a)\n" + "2 - Desquitado(a)\n" + "3 - Casado(a)\n"
				+ "4 - Divorciado(a)\n" + "5 - Viúvo(a)");

		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite seu estado civil:");
		int opcao = scanner.nextInt();

		if (opcao == 1) {
			System.out.println("Solteiro(a)");
		} else if (opcao == 2) {
			System.out.println("Desquitado(a)");
		} else if (opcao == 3) {
			System.out.println("Casado(a)");
		} else if (opcao == 4) {
			System.out.println("Divorciado(a)");
		}else if (opcao == 5) {
			System.out.println("Viúvo(a)");
		}else {
			System.out.println("Opcao digitada invalida");
		}
	}
}
