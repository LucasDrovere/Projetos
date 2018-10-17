package maquina;

import dinheiro.Dinheiro;
import produto.Produto;

public class MaquinaDeGuloseimas {

	public static final int INDICE_REFRI = 1;
	public static final int INDICE_SALGADINHO = 0;

	private Produto[] produtos;
	private double credito = 0.0;

	public MaquinaDeGuloseimas() {
		produtos = new Produto[2];

		produtos[INDICE_REFRI] = new Produto("Refrigerante", 3.5);
		produtos[INDICE_SALGADINHO] = new Produto("Salgadinho", 4.0);
	}

	public void depositar(Dinheiro dinheiro) {
		credito += dinheiro.getValor();

		System.out.println("Seu crédito é de: " + credito);
	}

	public Produto comprar(int indice) throws ProdutoIndisponivelException, SaldoInsuficienteException {

		if (indice == 10) {
			throw new ProdutoIndisponivelException();
		}

		Produto produtoAComprar = produtos[indice];

		if (credito < produtoAComprar.getValor()) {
			throw new SaldoInsuficienteException();
		} else {
			System.out.println("Comprando produto...");
			if (credito > produtoAComprar.getValor()) {
				double troco = credito - produtoAComprar.getValor();
				System.out.println("Devolvendo troco: " + troco);
			}
			credito = 0.0;
		}

		return produtoAComprar;
	}

}
