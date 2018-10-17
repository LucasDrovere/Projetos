package maquina.principal;

import java.util.Scanner;

import heranca.maquina.CincoReais;
import heranca.maquina.CinquentaCentavos;
import heranca.maquina.DezReais;
import heranca.maquina.Dinheiro;
import heranca.maquina.DoisReais;
import heranca.maquina.Maquina;
import heranca.maquina.MaquinaComArray;
import heranca.maquina.UmReal;

public class Principal {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		
		Maquina m = new Maquina();
		
		//MaquinaComArray mc = new MaquinaComArray();
		//mc.percorreArray(); !PERCORRE O ARRAYLIST MOSTRANDO O PRODUTO E O VALOR
		
		System.out.println("Produtos disponiveis na maquina: ");
		
		
		System.out.println("Valores aceitos na maquina: R$ 0.50, R$ 1.00, R$ 2.00, R$ 5.00, R$ 10.00");
		System.out.println();
		System.out.println("Deposite na maquina a quantidade necessaria para efetuar a compra.");
		System.out.println();
		
		m.depositar(new UmReal());
		
		System.out.println("Escolha o produto que deseja comprar: ");
		int op = ler.nextInt();
		m.comprar(Maquina.IDX_REFRIGERANTE) throws ProdutoIndisponivelException, SaldoInsuficienteException;
		
		
	}


}