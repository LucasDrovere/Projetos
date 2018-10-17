package Perspectiva;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Filme;

public class DAOFilme {

	public void inserir(Filme f) {
		String sql = "INSERT INTO treinamento.filme (nome, ano, id_genero, id_diretor) " + "VALUES (?, ?, ?, ?)";

		try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setString(1, f.getNome());
			ps.setInt(2, f.getAno());
			ps.setInt(3, f.getId_genero());
			ps.setInt(4, f.getId_diretor());

			int linhaAfetada = ps.executeUpdate();

			if (linhaAfetada == 0) {
				throw new RuntimeException("Registro não inserido! " + f);
			} else {
				System.out.println("filme adicionado com sucesso ao banco!");
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void excluir(Integer id) {
		String sql = "DELETE FROM treinamento.filme " + "WHERE id = ? ";

		try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, id);
			
			int linhasAfetadas = ps.executeUpdate();

			if (linhasAfetadas == 0) {
				throw new RuntimeException("O id informado (" + id + ") não existe no banco");
			} else {
				System.out.println("Filme excluido com sucesso");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void alterarNomeDoFilme(Integer id, String nome) {
		String sql = "UPDATE treinamento.filme SET nome = ? " + "WHERE id = ?";

		try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setString(1, nome);
			ps.setInt(2, id);
			int linhaAfetada = ps.executeUpdate();

			if (linhaAfetada == 0) {
				throw new RuntimeException("Registro não alterado! ");
			}
			{
				System.out.println("Filme aterado com sucesso");
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public List<Filme> buscarTodos() {
		List<Filme> filmes = new ArrayList<>();

		try (Connection conn = Conexao.getConexao(); Statement st = conn.createStatement();) {

			ResultSet rs = st.executeQuery(
					"Select treinamento.filme.id, treinamento.filme.nome, treinamento.filme.ano, treinamento.genero.nome from (treinamento.filme"
							+ " inner join treinamento.genero ON filme.id_genero = genero.id)");

			while (rs.next()) {
				Filme f = new Filme();
				f.setId(rs.getInt("id"));
				f.setNome(rs.getString("nome"));
				f.setAno(rs.getInt("ano"));
				f.setGenero(rs.getInt("id"));
				filmes.add(f);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return filmes;
	}

	public Filme buscarPorId(Integer id) {
		Filme f = new Filme();
		String sql = "UPDATE treinamento.filme SET nome = ? " + "WHERE id = ?";
		
		try (Connection conn = Conexao.getConexao(); Statement st = conn.createStatement();) {

			ResultSet rs = st.executeQuery("Select * from treinamento.filme WHERE id = " + id);

			while (rs.next()) {
				f.setId(rs.getInt("id"));
				f.setNome(rs.getString("nome"));
				f.setAno(rs.getInt("ano"));
				System.out.println(f);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;
	}
}
