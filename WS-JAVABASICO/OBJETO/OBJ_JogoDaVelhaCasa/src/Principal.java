import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		JogoVelha jogo = new JogoVelha();
		String posicao;
		int valida = 0;
		int jogadas = 0;

		jogadas = Jogadores(ler, jogo, jogadas);
		System.out.println("O " + jogo.winner(jogadas) + "venceu!");
	}

	private static int Jogadores(Scanner ler, JogoVelha jogo, int jogadas) {
		String posicao;
		int valida;
		while (true) {
			System.out.println("Jogo da Velha");
			jogo.exibir();

			do {// inicia jogador X
				System.out.println("Vez do jogador X." + "\ninforme o numero da posicao desejada: ");
				posicao = ler.next();
				while (!jogo.check(posicao)) {
					System.out.println("Jogada invalida, tente novamente");
					System.out.println("Vez do jogador X." + "\nInforme o numero da posicao desejada: ");
					posicao = ler.next();
					valida = 0;
				}
				jogo.jogada(posicao, "X");
				valida = 1;

			} while (valida == 0); // fim jogador X

			jogadas++;
			valida = 0;
			jogo.exibir();
			if (!jogo.winner(jogadas).equals("null")) {
				break;
			}
			
			do {// inicia jogador O
				
				System.out.println("Vez do jogador O." + "\ninforme o numero da posicao desejada: ");
				posicao = ler.next();
				while (!jogo.check(posicao)) {
					System.out.println("Jogada invalida! tente novamente");
					System.out.println("Jogador O." + "\nInforme  o numero da posicao desejada: ");
					posicao = ler.next();
					valida = 0;
				}
				jogo.jogada(posicao, "O");
				valida = 1;
				jogo.exibir();
			} while (valida == 0); // fim jogador O

			jogadas++;
			valida = 0;
			
			if (!jogo.winner(jogadas).equals("null")) {
				break;
				}
		}
		return jogadas;
	}
}

