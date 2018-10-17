package models;

public class Cachorro extends Animal {
	
	@Override
	public void fazerBarulho() {
		System.out.println("Au au");		
	}
	
	public void morder() {
		System.out.println("mordendo...");
	}

}
