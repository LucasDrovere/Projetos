package heranca.maquina;

public abstract class Dinheiro {
	protected double valor;
	
	public Dinheiro(double valor) {
		this.valor = valor;
	}
	
	public double getValor() {
		return valor;
	}
}
