package heranca.maquina;

public class Maquina {
	public static final int IDX_REFRIGERANTE = 0;
	public static final int IDX_SALGADINHO = 1;
	public static final int IDX_CHOCOLATE = 2;
	public static final int IDX_NESCAL = 3;
	public static final int IDX_CHICLETE = 4;

	private Produto[] produtos;
	private double valorDepositado;
	// private Double valorAcumulado;

	public Maquina() {
		produtos = new Produto[5];
		produtos[0] = new Produto("Refrigerante", 5);
		produtos[1] = new Produto("Salgadinho", 10);
		produtos[2] = new Produto("Chocolate", 4);
		produtos[3] = new Produto("Nescalzinho", 4);
		produtos[4] = new Produto("Chiclete", 0.50);
	}

	public void depositar(Dinheiro dinheiro) {
		valorDepositado += dinheiro.valor;
		System.out.println("Valor depositado na maquina: " + valorDepositado);
	}

	public Produto comprar(int IDX) throws SaldoInsuficienteException, ProdutoIndisponivelException {
		Produto prov = produtos[IDX];

		if (IDX >= 6) {
			throw new ProdutoIndisponivelException();
		}
		
		if (valorDepositado >= prov.getValor()) {
			System.out.println("Voce depositou R$: " + valorDepositado);
			double troco = valorDepositado - prov.getValor();
			if (troco == 0) {
				System.out.println("Seu " + prov.getDescricao() + " esta pronto para retirada na maquina");
			} else {
				System.out.println("Seu " + prov.getDescricao() + " esta pronto para retirada na maquina");
				System.out.println("Valor do troco R$: " + troco);
				return produtos[IDX];
			}
		}
		
		if (valorDepositado < prov.getValor()) {
			throw new ProdutoIndisponivelException();
		}

		// } else {
		// System.out.println("O valor depositado insuficiente para efetuar a compra de
		// " + prov.getDescricao());
		// System.out.println("Valor atual depositado R$: " + valorDepositado + "\nValor
		// necessario para a compra de " + prov.getDescricao() + " R$: " +
		// prov.getValor());

		return null;
	}

	public double getValorDepositado() {
		return valorDepositado;
	}
}