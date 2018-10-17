package heranca.maquina;

import java.util.ArrayList;
import java.util.Scanner;

public class MaquinaComArray {

	private ArrayList<Produto> produtos;
	private double valorDepositado;

	public MaquinaComArray() {
		produtos = new ArrayList<>();
		produtos.add(new Produto("Refrigerante", 5));
		produtos.add(new Produto("Salgadinho", 10));
		produtos.add(new Produto("Chocolate", 4));
		produtos.add(new Produto("Nescalzinho", 4));
		produtos.add(new Produto("Chiclete", 0.50));
	}
	
	public void listaProdutos() {
		for (Produto p : produtos) {
			System.out.println(p.getDescricao() + " R$: " +  p.getValor());
		}
		System.out.println();
	}
	
	public void depositar(Dinheiro dinheiro) {
		valorDepositado += dinheiro.valor;
		System.out.println("Valor depositado na maquina: " + valorDepositado);
	}

	public Produto comprar(int ler) {
		Produto p = produtos.get(ler);
		if (valorDepositado >= p.getValor()) {
			double troco = valorDepositado - p.getValor();
			if (troco == 0) {
				System.out.println("Seu " + p.getDescricao() + " esta pronto para retirada na maquina");
			} else {
				System.out.println("Comprando...");
				System.out.println("Seu " + p.getDescricao() + " esta pronto para retirada na maquina");
				System.out.println("Valor do troco R$: " + troco);
				return produtos.get(ler);
			}
		} else {
			System.out.println("O valor depositado insuficiente para efetuar a compra de " + p.getDescricao());
			System.out.println("Valor atual depositado R$: " + valorDepositado + "\nValor necessario para a compra de "
					+ p.getDescricao() + " R$: " + p.getValor());
		}
		return null;
	}
	
	public void depositar(MaquinaComArray mc) {
		//System.out.println("Depositando dinheiro na maquina...");
		mc.depositar(new UmReal());
		//System.out.println("Depositando dinheiro na maquina...");
		//mc.depositar(new CincoReais());
		//System.out.println("Depositando dinheiro na maquina...");
		//mc.depositar(new DezReais());
		System.out.println("Valor total depositado R$: " + valorDepositado);
	}
	
	public double getValorDepositado() {
		return valorDepositado;
	}
}




