package lista1;

import java.util.Scanner;

public class exercicio11 {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		
		System.out.println("Entre com o valor do salario minimo: ");
		double salariom = ler.nextDouble();
		System.out.println("A quantidade de quilowatts gasta: ");
		double quilow = ler.nextDouble();
		
		double psalario = salariom / 7;
		double valorcadaquilow = psalario / 100;
		double valortotalquilow = valorcadaquilow * quilow;
		double valordescquilow = valortotalquilow * 0.10;
		double valortotaldescquilow = valortotalquilow - valordescquilow;
		
		System.out.println(String.format("O valor em reais de cada quilowatt é: %.2f", valorcadaquilow));
		System.out.println(String.format("O valor total em reais a ser pago é: %.2f", valortotalquilow));
		System.out.println(String.format("O novo valor a ser pago por esta residência com um desconto de 10% é: %.2f", valortotaldescquilow));
	}
}
