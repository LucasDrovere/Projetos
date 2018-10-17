package br.com.cast.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cast.modelo.Professor;

public class ProfessorDao {

	public void inserir(Professor professor) {

		String sql = "INSERT INTO sala.professor (nome, materia) " + "VALUES (?, ?);";

		try (Connection con = Conexao.getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, professor.getNome());
			ps.setString(2, professor.getMateria());

			int qtdLinhasAfetadas = ps.executeUpdate();

			if (qtdLinhasAfetadas == 0) {
				throw new RuntimeException("Não conseguiu inserir professor!");
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void alterar(Professor professor, Integer id) {

		String sql = "UPDATE sala.professor SET nome = ?, " + "    materia = ? " + "WHERE id = ?;";

		try (Connection con = Conexao.getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, professor.getNome());
			ps.setString(2, professor.getMateria());
			ps.setInt(3, id);

			int qtdLinhasAfetadas = ps.executeUpdate();

			if (qtdLinhasAfetadas == 0) {
				throw new RuntimeException("Não conseguiu alterar o professor!");
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Professor> buscarTodos() {

		List<Professor> professores = new ArrayList<>();

		String sql = "SELECT id, nome, materia " + 
		             "FROM sala.professor;";

		try (Connection con = Conexao.getConexao(); 
				PreparedStatement ps = con.prepareStatement(sql)) {

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

	public Professor buscarPorId(Integer id) {
		
		String sql = "SELECT id, nome, materia " + 
				"FROM sala.professor " + 
				"WHERE id = ?;";
		
		Professor professor = null;
		
		try (Connection con = Conexao.getConexao();
				PreparedStatement ps = con.prepareStatement(sql)) {
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				professor = new Professor();
				professor.setId(rs.getInt("id"));
				professor.setNome(rs.getString("nome"));
				professor.setMateria(rs.getString("materia"));
			}else {
				System.out.println("Professor não encontrado no banco!");
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return professor;
	}

	public void excluir(Integer id) {
				
		String sql = "DELETE FROM sala.professor " + 
					 "WHERE id = ?;";
		
		try (Connection con = Conexao.getConexao();
				PreparedStatement ps = con.prepareStatement(sql)) {
			
			ps.setInt(1, id);
			
			int qtdLinhasAfetadas = ps.executeUpdate();
			
			if (qtdLinhasAfetadas == 0) {
				throw new RuntimeException("Não conseguiu excluir o professor!");
			}else {
				System.out.println("Professor excluido com sucesso do banco!");
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

}
