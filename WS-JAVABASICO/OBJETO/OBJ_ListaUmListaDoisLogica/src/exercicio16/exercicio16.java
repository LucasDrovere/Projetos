package lista1;

import java.util.Scanner;

public class exercicio16 {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);

		int numero = 0;
		int sexo = 0;
		int i = 0;
		int j = 0;
		int somamasc = 0;
		int somafem = 0;
		double mediamasc = 0;

			while (numero != 999) {
				System.out.println("Digite seu numero: ");
				numero = ler.nextInt();

				if (numero != 999) {
					
					System.out.println("Digite seu sexo '1 - masc' '2 - fem'");
					sexo = ler.nextInt();
					System.out.println("Digite sua idade: ");
					int idade = ler.nextInt();

					if (sexo == 1) {
						i = i + 1;
						somamasc = somamasc + idade;
						mediamasc = somamasc / i;
					} else if (sexo == 2) {
						j = j + 1;
						somafem = somafem + idade;
					}
				} else {
					System.out.println("999 foi digitado");
					System.out.println("A media das idades masculinas é: " + mediamasc);
					System.out.println("A soma das idades de mulheres é: " + somafem);
					System.out.println("Numero de homens: " + i);
					System.out.println("Numero de mulheres: " + j);
				}
			}
		}
	}