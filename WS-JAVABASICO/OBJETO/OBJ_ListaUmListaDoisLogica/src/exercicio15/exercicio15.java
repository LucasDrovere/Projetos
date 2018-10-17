package lista1;

import java.util.Scanner;

public class exercicio15 {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);

		System.out.println("Digite o valor do seu salario: ");
		double salario = ler.nextDouble();

		if (salario <= 600) {
			System.out.println("Isento do desconto INSS");
		} else if (salario > 600 && salario <= 1200) {
			double descinss = salario * 0.20;
			double salariodesc = salario - descinss;
			System.out.println("O valor do desconto do INSS sob o salario de " + salario + " é de: " + descinss + ""
					+ ", e o seu salario com o desconto aplicado é: " + salariodesc);
			// maior do que R$ 600,00 e menor ou igual a R$ 1.200,00 - 20%.
		} else if (salario > 1200 && salario <= 2000) {
			double descinss = salario * 0.25;
			double salariodesc = salario - descinss;
			System.out.println("O valor do desconto do INSS sob o salario de " + salario + " é de: " + descinss + ""
					+ ", e o seu salario com o desconto aplicado é: " + salariodesc);
			// maior do que R$ 1.200,00 e menor ou igual a R$ 2.000,00 - 25%.
		} else if (salario > 2000) {
			double descinss = salario * 0.30;
			double salariodesc = salario - descinss;
			System.out.println("O valor do desconto do INSS sob o salario de " + salario + " é de: " + descinss + ""
					+ ", e o seu salario com o desconto aplicado é: " + salariodesc);
			// maior do que R$ 2.000,00 - 30%.
		}
	}
}
