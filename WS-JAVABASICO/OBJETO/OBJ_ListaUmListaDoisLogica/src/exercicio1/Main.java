package exercicio1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Infome o valor do salario hora:");
		int shora = scanner.nextInt();
		
		System.out.println("Informe o numero de horas trabalhadas no mes");
		double hmes = scanner.nextDouble();
		
		System.out.println("Digite o valor do percentual de desconto do INSS");
		double inss = scanner.nextDouble();
		
		double salariob = (shora * hmes);
		double vinss = ((salariob /100) * inss);
		double salariol = (salariob - vinss);
		
		System.out.println("O salario bruto é: " + salariob + " reais");
		System.out.println("O salario liquido é: " + salariol + " reais");
	}
}
