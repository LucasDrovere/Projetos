package exercicio10;

public class Main {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {

			int carta = (int) (Math.random() * 13) + 1;

			if (carta == 1) {
				System.out.print("A -");
			} else if (carta == 11) {
				System.out.print("J -");
			} else if (carta == 12) {
				System.out.print("Q -");
			} else if (carta == 13) {
				System.out.print("K -");
			} else {
				System.out.print(carta + " -");
			}

			int naipe = (int) (Math.random() * 4) + 1;
			
			if (naipe == 1) {
				System.out.println(" OURO");
			} else if (naipe == 2) {
				System.out.println(" COPAS");
			} else if (naipe == 3) {
				System.out.println(" PAUS");
			} else {
				System.out.println(" ESPADA");
			}

		}
	}

}
