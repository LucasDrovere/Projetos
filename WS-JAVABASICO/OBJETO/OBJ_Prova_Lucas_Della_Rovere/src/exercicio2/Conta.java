package exercicio2;

public class Conta {

	private String numero;
	private double saldo;
	private Cliente cliente;
	
	public Conta(String numero, double saldo, Cliente cliente) {
		this.numero = numero;
		this.saldo = saldo;
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Dados da conta: \nNumero: " + numero + " \nSaldo: " + saldo + "\n" + cliente  ;
	}
	

	
}
