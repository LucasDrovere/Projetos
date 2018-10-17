package exercicio5;

public class PrincipalCasa {

	public static void main(String[] args) {

		Casa c = new Casa("Fulano");

		try {
			c.adicionarQuarto(new Quarto("Azul", "1"));
			System.out.println("Quarto adicionado com sucesso!");
			c.adicionarQuarto(new Quarto("Branco", "1"));
			System.out.println("Quarto adicionado com sucesso!");
		} catch (QuartoExistenteException e) {
			System.out.println(e.getMessage());
		}

		System.out.println();
		System.out.println(c.toString());
	}

}
