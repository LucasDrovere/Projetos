package heranca.animal;

public class Poodle extends Cachorro implements Domesticavel{
	
	@Override
	public void darCarinho() {
		System.out.println("Latindo e pulando sem parar...");
		
	}
}
