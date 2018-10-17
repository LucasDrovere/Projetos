package exercicio1;

public class Item {

	private String descricao;
	private double valor;
	
	public Item(String descricao, double valor) {
		this.descricao = descricao;
		this.valor = valor;
	}

	@Override
	public String toString() {
		return  descricao  ;
	}
	
	
	
}
