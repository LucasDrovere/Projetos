package principal;

import dinheiro.UmReal;
import maquina.MaquinaDeGuloseimas;
import maquina.ProdutoIndisponivelException;
import maquina.SaldoInsuficienteException;
import produto.Produto;

public class Principal {

	public static void main(String[] args) {
		MaquinaDeGuloseimas maquina = new MaquinaDeGuloseimas();

		UmReal umReal = new UmReal();

		maquina.depositar(umReal);

		try {

			// exceção não tratada
			Produto produtoComprado = maquina.comprar(11);

			// produto indisponivel
			// Produto produtoComprado = maquina.comprar(10); 

			// saldo insuficiente
			// Produto produtoComprado = maquina.comprar(MaquinaDeGuloseimas.INDICE_REFRI); 

			System.out.println("Consegui comprar o produto: " + produtoComprado.getDescricao());
			
		} catch (SaldoInsuficienteException e) {
			System.out.println(e.getMessage());
		
		} catch (ProdutoIndisponivelException e) {
			
			System.out.println(e.getMessage());
			System.out.println("Enviando e-mail para o responsável...");
			
		} catch (Exception e) {
			System.out.println("Exceção mais generica");
			e.printStackTrace();
			
		}

	}

}
