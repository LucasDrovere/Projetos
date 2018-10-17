package heranca.animal;

public class Gato extends Animal implements Domesticavel{
	public void exibir () {
		System.out.println("Som do " + getNomeAnimal() + " é Miau Miau Miau");
		System.out.println();
	}

	@Override
	public void darCarinho() {
		System.out.println("Sendo muito mala...");
		
	}
}
