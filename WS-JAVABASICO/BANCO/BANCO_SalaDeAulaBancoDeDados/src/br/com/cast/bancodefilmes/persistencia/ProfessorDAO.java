package br.com.cast.bancodefilmes.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cast.bancodefilmes.modelo.Professor;

public class ProfessorDAO {

	// ok
	public void inserir(Professor professor) {
		String sql = "INSERT INTO escola.professor (nome, materia) " + "VALUES (?, ?)";

		try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setString(1, professor.getNome());
			ps.setString(2, professor.getMateria());

			int linhaAfetada = ps.executeUpdate();

			if (linhaAfetada == 0) {
				throw new RuntimeException("Registro não inserido! " + professor);
			} else {
				System.out.println("Registro inserido ao banco!");
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// arrumar
	public void alterar(Professor professor, Integer id) {
		String sql = "UPDATE escola.professor SET (nome, materia) " + "VALUES (?, ?) " + "WHERE id = ?";

		try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setString(1, professor.getNome());
			ps.setString(2, professor.getMateria());
			ps.setInt(3, id);

			int linhaAfetada = ps.executeUpdate();

			if (linhaAfetada == 0) {
				throw new RuntimeException("Registro não alterado! ");
			}
			{
				System.out.println("Professor alterado com sucesso");
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	// ok
	public List<Professor> buscarTodos() {
		List<Professor> professores = new ArrayList<>();
		String sql = "Select escola.professor.id, escola.professor.nome, escola.professor.materia from escola.professor";

		try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql);) {

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Professor p = new Professor();
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("nome"));
				p.setMateria(rs.getString("materia"));
				professores.add(p);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return professores;
	}

	// ok
	public Professor buscarPorId(Integer id) {
		String sql = "SELECT p.*" + "FROM escola.professor p " + "WHERE p.id = ?";

		Professor p = null;

		try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				p = new Professor();
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("nome"));
				p.setMateria(rs.getString("materia"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return p;
	}

	// ok
	public void excluir(Integer id) {

		String sql = "DELETE FROM escola.professor " + "WHERE id = ?";

		try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql);) {

			ps.setInt(1, id);

			int linhasAfetadas = ps.executeUpdate();

			if (linhasAfetadas == 0) {
				throw new RuntimeException("O id informado (" + id + ") não existe no banco");
			} else {
				System.out.println("Professor excluido com sucesso");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
