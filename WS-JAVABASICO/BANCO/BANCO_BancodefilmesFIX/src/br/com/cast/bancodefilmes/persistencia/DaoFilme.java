package br.com.cast.bancodefilmes.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.cast.bancodefilmes.modelo.Diretor;
import br.com.cast.bancodefilmes.modelo.Filme;
import br.com.cast.bancodefilmes.modelo.Genero;

public class DaoFilme {
	
	public void alterarNome(Integer id, String nome) {
		
		String sql = "UPDATE filme.filme SET nome = ? "
				   + "WHERE id = ?";
		
		try (Connection conn = Conexao.getConexao();
			 PreparedStatement ps = conn.prepareStatement(sql)) {
			
			ps.setString(1, nome);
			ps.setInt(2, id);
			
			int linhasAfetadas = ps.executeUpdate();
			
			if (linhasAfetadas == 0) {
				throw new RuntimeException("Id (" + id + ") não existe no banco ");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
	public Filme buscarPorId(Integer id) {
		String sql = "SELECT f.*, g.nome as nomeGenero, d.nome as nomeDiretor, d.idade, d.sexo " + 
					 "FROM filme.filme f " + 
					 "    INNER JOIN filme.genero g ON f.id_genero = g.id " + 
					 "    INNER JOIN filme.diretor d ON f.id_diretor = d.id " +
					 "WHERE f.id = ?";
		
		Filme f = null;
		
		try (Connection conn = Conexao.getConexao();
			 PreparedStatement ps = conn.prepareStatement(sql)) {
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				f = new Filme();
				Genero genero = new Genero();
				genero.setNome(rs.getString("nomeGenero"));
				
				Diretor diretor = new Diretor();
				diretor.setNome(rs.getString("nomeDiretor"));
				diretor.setIdade(rs.getInt("idade"));
				
				f.setNome(rs.getString("nome"));
				f.setGenero(genero);
				f.setDiretor(diretor);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		return f;
	}

}
