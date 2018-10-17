package br.com.cast.transacao.principal;

import java.sql.SQLException;

import br.com.cast.transacao.modelo.Conta;
import br.com.cast.transacao.persistencia.DaoConta;

public class Principal {

	public static void main(String[] args) {
		
		Conta origem = new Conta();
		origem.setNumero("10434771");
		
		Conta destino = new Conta();
		destino.setNumero("10434772");

		DaoConta dao = new DaoConta();
		try {
			dao.transfere(origem, destino, 10.0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
