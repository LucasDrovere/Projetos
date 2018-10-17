package heranca.maquina;

public class Produto {
	private double valor;
	private String descricao;

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
