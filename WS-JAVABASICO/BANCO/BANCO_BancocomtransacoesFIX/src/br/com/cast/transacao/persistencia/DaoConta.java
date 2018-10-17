package br.com.cast.transacao.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.cast.transacao.modelo.Conta;

public class DaoConta {
	
	public void transfere(Conta origem, Conta destino, Double valor) 
		throws SQLException {
		
		Connection conn = Conexao.getConexao();
		
		PreparedStatement psSacar = null;
		PreparedStatement psDepositar = null;
		
		try {
			conn.setAutoCommit(false);
			
			//sacar
			String sqlSacar = "UPDATE banco.conta SET saldo = saldo - ? "
					+ "WHERE numero = ?";
			
			psSacar = conn.prepareStatement(sqlSacar);
				
			psSacar.setDouble(1, valor);
			psSacar.setString(2, origem.getNumero());
			
			psSacar.executeUpdate();
			
			Thread.sleep(5000);
			
			//depositar
			String sqlDepositar = "UPDATE banco.conta SET saldo = saldo + ? "
					   			+ "WHERE numero = ?";
			
			psDepositar = conn.prepareStatement(sqlDepositar);
			psDepositar.setDouble(1, valor);
			psDepositar.setString(2, destino.getNumero());
			
			psDepositar.executeUpdate();
			
			conn.commit();
			System.out.println("Transferencia efetuada com sucesso!");
			
		} catch (SQLException e) {
			System.out.println("[rollback] desfazendo os comandos");
			conn.rollback();
			throw new RuntimeException(e);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
    		if (psSacar != null) {
    			psSacar.close();
    		}
    		if (psDepositar != null) {
    			psDepositar.close();
    		}
	    }
		
	}

}
