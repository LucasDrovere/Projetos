package maquina;

public class SaldoInsuficienteException extends Exception {

	public SaldoInsuficienteException() {
		super("Seu saldo � insuficiente!");
	}
	
}
