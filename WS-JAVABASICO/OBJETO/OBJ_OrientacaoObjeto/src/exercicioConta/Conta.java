package exercicioConta;

public class Conta {
	private int numero = (int) (Math.random() * 10) + 1;
	private int agencia;
	private String senha;
	private double saldo = 0;

	boolean Conta = true;
	
	private static int qtdDeTransações = 0;
	private static int qtdDeContas = 0;
	
	public Conta() {
		qtdDeContas++;
	}
	
	void saca(double valor) throws SaldoInsuficienteException{
		if (valor <= saldo) {
			saldo = saldo - valor;
			qtdDeTransações++;
			System.out.println("Valor " + valor + " sacado com sucesso.");
		} else {
			throw new SaldoInsuficienteException();
		}
	}

	void deposita(double valor) {
		this.saldo = saldo + valor;
		qtdDeTransações++;
		System.out.println("Seu deposito de " + valor + " foi depositado com sucesso.");
	}

	void transfere(double valor, int contaDestino) throws SaldoInsuficienteException{
		
		
		if (saldo >= valor) {
			saldo -= valor;
			qtdDeTransações++;
			System.out.println(
					"Deposito para conta " + contaDestino + " no valor de R$" + valor + " foi realizado com sucesso.");
		} else {
			throw new SaldoInsuficienteException();
		}
	}

	public String toString() {
		return "\nConta: " + this.numero + " \nAgencia " + this.agencia + "\nSaldo R$: " + this.saldo;

	}

	void imprime() {
		System.out.println(toString());
	}

	public void setSenha(String senhaDigitada) {
		this.senha = senhaDigitada;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setAgencia(int agenciaDigitada) {
		this.agencia = agenciaDigitada;
	}

	public int getAgencia() {
		return this.agencia;
	}
	
	public static int getQtdDeContas() {
		return qtdDeContas;
	}
	
	public static int getQtdDeTransações() {
		return qtdDeTransações;
	}
}
