package exercicioConta;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		int opcaoConta = 0;

		Pessoa teste = new Pessoa();
		teste.setCpf("3123213");
		teste.setNome("Retardo");
		teste.criarConta(334, "443");

		System.out.println("Deseja criar um conta? s/n");
		String opcaoCriar = ler.next();

		if (opcaoCriar.equals("s")) {
			Pessoa p = new Pessoa();

			System.out.println("Digite seu nome: ");
			String lerNome = ler.next();
			p.setNome(lerNome);

			System.out.println("Digite seu CPF: ");
			String lerCpf = ler.next();
			p.setCpf(lerCpf);

			System.out.println("Digite o numero da agencia: ");
			int agenciaDigitada = ler.nextInt();
			p.getConta().setAgencia(agenciaDigitada);

			System.out.println("Digite sua senha: ");
			String senhaDigitada = ler.next();
			p.getConta().setSenha(senhaDigitada);

			while (opcaoConta != 5) {
				System.out.println(
						"\nDigite: \n1 - Sacar \n2 - Depositar \n3 - Tranferir \n4 - Exibir Informações \n5 - Sair");
				opcaoConta = ler.nextInt();

				if (opcaoConta == 1) {
					System.out.println("Digite o valor do saque que voce deseja fazer:  ");
					double valorSaque = ler.nextDouble();
					try {
						p.getConta().saca(valorSaque);
					} catch (SaldoInsuficienteException e) {
						System.out.println(e.getMessage());
					}
				}

				else if (opcaoConta == 2) {
					System.out.println("Digite o valor do deposito: ");
					double valorDeposito = ler.nextDouble();
					p.getConta().deposita(valorDeposito);
				}

				else if (opcaoConta == 3) {
					System.out.println("Digite o valor da transferencia: ");
					double valorTransferencia = ler.nextDouble();
					System.out.println("Digite a conta destino da transferencia: ");
					int contaDestino = ler.nextInt();
					try {
						p.getConta().transfere(valorTransferencia, contaDestino);
					} catch (SaldoInsuficienteException e) {
						System.out.println(e.getMessage());
					}
				}

				else if (opcaoConta == 4) {
					p.imprime();
					p.getConta().imprime();
				}

				else {
					System.out.println("O numero de transações efetuadas é: " + Conta.getQtdDeTransações());
					System.out.println("Fechando...");
					System.out.println("Fechado com sucesso.");
				}
			}

		} else {
			System.out.println("O numero de contas criadas é: " + Conta.getQtdDeContas());
			System.out.println("Não foi digitado.");
		}

	}
}