package br.com.cast.conta.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.cast.conta.modelo.Usuario;
import br.com.cast.persistencia.Conexao;

public class DaoUsuario {
	
	public Usuario logar(String usuario, String senha) {
		String sql = "select * from banco.usuario "
				   + "where usuario = ? "
				   + "and senha = ?";
		
		try (Connection conn = Conexao.getConexao(); 
			 PreparedStatement ps = conn.prepareStatement(sql)){

			ps.setString(1, usuario);
			ps.setString(2, senha);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				Usuario u = new Usuario();
				u.setId(rs.getInt("id"));
				u.setNome(rs.getString("nome"));
				u.setUsuario(rs.getString("usuario"));
				return u;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return null;
	}

	

}
