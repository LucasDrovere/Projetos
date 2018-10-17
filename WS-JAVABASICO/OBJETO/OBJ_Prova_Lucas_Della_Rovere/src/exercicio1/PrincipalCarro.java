package exercicio1;

public class PrincipalCarro {

	public static void main(String[] args) {
		Carro gol = new Carro(2000, "Volkswagen", "Gol", "Preto", new Motor());
		gol.adicionarItemDeSerie(new Item("Ar condicionado vidro elétrico trava elétrica", 500));
		System.out.println(gol.toString());
		
	}
}

