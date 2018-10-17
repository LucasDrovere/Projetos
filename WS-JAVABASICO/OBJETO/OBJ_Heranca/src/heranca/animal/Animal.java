package heranca.animal;

public abstract class Animal {
	protected String nome;
	
	public abstract void exibir() ;
	
	public void setNomeAnimal(String nome) {
		this.nome = nome;
	}
	
	public String getNomeAnimal() {
		return nome;
	}
	
}
