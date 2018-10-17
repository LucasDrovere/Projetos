package exercicioCarro;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		Carro c = new Carro();
		
		System.out.println("Digite a descricao do motor: ");
		String descMotor = ler.nextLine();
		System.out.println("Digite o ano do veiculo: ");
		int anoVeiculo = ler.nextInt();
		System.out.println("Digite a marca do veiculo: ");
		String marcaVeiculo = ler.next();
		System.out.println("Digite o modelo do veiculo: ");
		String descModelo = ler.next();
		c.lerDesc(descMotor, anoVeiculo, marcaVeiculo, descModelo);
		System.out.println("Digite um numero de portas: ");
		int qntPortas = ler.nextInt();
		c.adicionarPortas(qntPortas);
		System.out.println("Digite a velocidade adicional: ");
		int velAdicional = ler.nextInt();
		c.acelerar(velAdicional);
		
		c.exibirCaraceristicas();
		c.exibirEstado();
		
		//c.p1.estado = "Fechada";	
	}
}
