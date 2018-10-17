package exercicio2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Infome o numero de videos disponiveis: ");
		int nvideos = scanner.nextInt();
		
		System.out.println("Informe o valor de cada alocação: ");
		int valoc = scanner.nextInt();
	
		double alugadosMes = nvideos / 3;
		double alugadosAno = alugadosMes * 12;
		System.out.println("Numero de videos alugados no ano é: " + alugadosAno);
		
		double multaAlocacao = valoc * 0.10;
		double devolvidosAtraso = alugadosMes / 10;
		double ganhoMulta = devolvidosAtraso * multaAlocacao;
		System.out.println("Valor ganho com multas no mes é: " + ganhoMulta);
		
		double estragadosAno = nvideos * 0.02;
		double menosEstragados = nvideos - estragadosAno;
		double totalReposicao = nvideos / 10;
		double quantidadeFinal = menosEstragados + totalReposicao;
		
		System.out.println("Quantidade de videos no final do ano será: " + quantidadeFinal);
	}
}


