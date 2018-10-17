package br.com.cast.conta.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cast.conta.modelo.Conta;
import br.com.cast.persistencia.Conexao;

public class DaoConta {
	
	public List<Conta> buscarTodas() {
		
		String sql = "select * from banco.conta;";
		
		try (Connection conn = Conexao.getConexao(); 
			 PreparedStatement ps = conn.prepareStatement(sql)){

			ResultSet rs = ps.executeQuery();
			List<Conta> contas = new ArrayList<>();
			
			while (rs.next()) {
				Conta c = new Conta();
				c.setNumero(rs.getString("numero"));
				c.setSaldo(rs.getDouble("saldo"));
				contas.add(c);
			}
			return contas;			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public void inserir(Conta conta) {
		String sql = "insert into banco.conta(numero, saldo) "
				   + "values(?, ?)";
		
		try (Connection conn = Conexao.getConexao(); 
			 PreparedStatement ps = conn.prepareStatement(sql)){
			
			ps.setString(1, conta.getNumero());
			ps.setDouble(2, conta.getSaldo());

			ps.executeUpdate();			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void alterar(Conta conta) {
		String sql = "update banco.conta set saldo = ? "
				   + "where numero = ?";
		
		try (Connection conn = Conexao.getConexao(); 
			 PreparedStatement ps = conn.prepareStatement(sql)){
			
			ps.setDouble(1, conta.getSaldo());
			ps.setString(2, conta.getNumero());

			ps.executeUpdate();			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Conta buscarPorNumero(String numero) {
		String sql = "select * from banco.conta "
				   + "where numero = ?";
		
		try (Connection conn = Conexao.getConexao(); 
			 PreparedStatement ps = conn.prepareStatement(sql)){

			ps.setString(1, numero);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				Conta conta = new Conta();
				conta.setNumero(rs.getString("numero"));
				conta.setSaldo(rs.getDouble("saldo"));
				
				return conta;
			} else {
				throw new RuntimeException(
						"Número de conta inexistente (" + numero +")");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void excluir(String numero) {
		String sql = "delete from banco.conta "
				   + "where numero = ?";
		
		try (Connection conn = Conexao.getConexao(); 
			 PreparedStatement ps = conn.prepareStatement(sql)){
			
			ps.setString(1, numero);

			ps.executeUpdate();			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
