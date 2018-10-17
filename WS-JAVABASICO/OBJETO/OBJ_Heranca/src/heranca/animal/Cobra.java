package heranca.animal;

public class Cobra extends Animal implements Domesticavel{
	public void exibir () {
		System.out.println("Som do " + nome + " é SssssssSssssssSssssss");
		System.out.println();
	}

	@Override
	public void darCarinho() {
		System.out.println("Sempre tentando matar o dono...");
		
	}
}
