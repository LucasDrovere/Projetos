package br.com.cast.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import br.com.cast.modelo.Aluno;
import br.com.cast.modelo.Professor;

public class AlunoDao {

	public void inserir(Aluno aluno) {
		String sql = "INSERT INTO sala.aluno (nome, id_professor) VALUES (?, ?) ";

		try (Connection con = Conexao.getConexao(); 
				PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, aluno.getNome());
			
			if (aluno.getProfessor() == null || aluno.getProfessor().getId() == null) {
				ps.setNull(2, Types.INTEGER);
			} else {
				ps.setInt(2, aluno.getProfessor().getId());
			}

			int qtdLinhasAfetadas = ps.executeUpdate();

			if (qtdLinhasAfetadas == 0) {
				throw new RuntimeException("Não conseguiu inserir um Aluno!");
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void alterar(Aluno aluno, Integer id) {
		
		String sql = "UPDATE sala.aluno SET nome = ?, " + 
				     "  id_professor = ? " + 
				     "WHERE id = ?";
		
		try (Connection con = Conexao.getConexao();
				PreparedStatement ps = con.prepareStatement(sql)) {
			
			ps.setString(1, aluno.getNome());
			
			if (aluno.getProfessor() == null || aluno.getProfessor().getId() == null) {
				ps.setNull(2, Types.INTEGER);
			} else {
				ps.setInt(2, aluno.getProfessor().getId());
			}
			
			ps.setInt(3, id);
			
			int qtdLinhasAfetadas = ps.executeUpdate();
			
			if (qtdLinhasAfetadas == 0) {
				throw new RuntimeException("Não conseguiu alterar um aluno!");
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		
	}

	public List<Aluno> buscarTodos() {
		
		List<Aluno> alunos = new ArrayList<>();
		
		String sql = "SELECT a.id AS id_aluno, " + 
				"       a.nome AS nome_aluno, " + 
				"       p.id AS id_professor, " + 
				"       p.nome AS nome_professor, " + 
				"       p.materia AS materia_professor " + 
				"FROM sala.aluno AS a " + 
				"LEFT JOIN sala.professor AS p  " + 
				"     ON a.id_professor = p.id ";
		
		try (Connection con = Conexao.getConexao();
				PreparedStatement ps = con.prepareStatement(sql)) {
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Aluno aluno = new Aluno();
				aluno.setId(rs.getInt("id_aluno"));
				aluno.setNome(rs.getString("nome_aluno"));
				
				Professor professor = new Professor();
				professor.setId(rs.getInt("id_professor"));
				professor.setNome(rs.getString("nome_professor"));
				professor.setMateria(rs.getString("materia_professor"));
				
				aluno.setProfessor(professor);
				
				alunos.add(aluno);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return alunos;
	}

	public Aluno buscarPorId(Integer id) {
		
		Aluno aluno = null;
		
		String sql = "SELECT a.id AS id_aluno, " + 
				"       a.nome AS nome_aluno, " + 
				"       p.id AS id_professor, " + 
				"       p.nome AS nome_professor, " + 
				"       p.materia AS materia_professor " + 
				"FROM sala.aluno AS a " + 
				"LEFT JOIN sala.professor AS p  " + 
				"     ON a.id_professor = p.id " +
				"WHERE a.id = ? ";
		
		try (Connection con = Conexao.getConexao();
				PreparedStatement ps = con.prepareStatement(sql)) {
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				aluno = new Aluno();
				aluno.setId(rs.getInt("id_aluno"));
				aluno.setNome(rs.getString("nome_aluno"));
				
				Professor professor = new Professor();
				professor.setId(rs.getInt("id_professor"));
				professor.setNome(rs.getString("nome_professor"));
				professor.setMateria(rs.getString("materia_professor"));
				
				aluno.setProfessor(professor);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return aluno;
	}

	public void excluir(Integer id) {
		String sql = "DELETE FROM sala.aluno " + "WHERE id = ?;";

		try (Connection con = Conexao.getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, id);

			int qtdLinhasAfetadas = ps.executeUpdate();

			if (qtdLinhasAfetadas == 0) {
				throw new RuntimeException("Não conseguiu excluir o aluno!");
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
