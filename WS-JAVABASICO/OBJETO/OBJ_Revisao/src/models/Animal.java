package models;

//não permite instanciar, só server para herança
public abstract class Animal {

	protected String nome;
	
	public abstract void fazerBarulho();
	
}
