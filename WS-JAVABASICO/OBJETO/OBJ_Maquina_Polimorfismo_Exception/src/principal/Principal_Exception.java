package principal;

public class Principal_Exception {

	public static void main(String[] args) {

		for (int i = 0; i < 4; i++) {
			System.out.println(i);
		}

		metodoUm();
		System.out.println("Fechando main");
	}

	private static void metodoUm() {
		System.out.println("Iniciando metodo 1...");
		try {
			metodoDois();
		} catch (ArithmeticException e) {
			System.out.println("Ocorreu um erro de programador burro!");
		}
		System.out.println("Fechando metodo 1...");
	}

	private static void metodoDois() {
		System.out.println("Iniciando metodo 2...");
		
		metodoTres();
		double result = 10 / 0;
		System.out.println("Fechando metodo 2...");

	}

	private static void metodoTres() {
		System.out.println("Iniciando metodo 3...");

		System.out.println("Fechando metodo 3...");
	}

}
