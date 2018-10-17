package produto;

public class Produto {
	
	private String descricao;
	private double valor;
	
	public Produto(String descricao, double valor) {
		this.descricao = descricao;
		this.valor = valor;
	}
	
	public double getValor() {
		return valor;
	}

	public String getDescricao() {
		return descricao;
	}

}
