package exercicio1;

import java.util.ArrayList;
import java.util.List;

public class Carro {

	private int ano;
	private String marca;
	private String modelo;
	private String cor;
	private Motor motor;
	private List<Item> itensDeSerie;
	
	public Carro(int ano, String marca, String modelo, String cor, Motor motor) {
		super();
		this.ano = ano;
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.motor = motor;
		this.itensDeSerie = new ArrayList<>();
		
	}
	
	public void adicionarItemDeSerie(Item i) {
		itensDeSerie.add(i);
		
	}

	@Override
	public String toString() {
		return "Descricao do carro: " + marca + ", "
				+ modelo + ", " + ano + ", " + cor + ". "
				+ "\nItens De Serie: " + itensDeSerie + ", "
				+ "\nMotor: " + motor + "";
				 
	}

	
}
