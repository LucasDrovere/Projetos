package br.com.cast.bancodefilmes.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cast.bancodefilmes.modelo.Aluno;
import br.com.cast.bancodefilmes.modelo.Professor;

public class AlunoDAO {

	// ok
	public void inserir(Aluno aluno) {
		String sql = "INSERT INTO escola.aluno (nome, id_professor) " + "VALUES (?, ?)";

		try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setString(1, aluno.getNome());
			if (aluno.getId() != null) {
				ps.setInt(2, aluno.getProfessor().getId());
			}

			int linhaAfetada = ps.executeUpdate();

			if (linhaAfetada == 0) {
				throw new RuntimeException("Registro não inserido! " + aluno);
			} else {
				System.out.println("Registro inserido ao banco!");
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	// arrumar
	public void alterar(Aluno aluno, Integer id) {
		String sql = "UPDATE escola.aluno SET (nome, id_professor) " + "VALUES (?, ?) " + "WHERE id = ?";

		try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setString(1, aluno.getNome());
			ps.setInt(2, aluno.getProfessor().getId());
			ps.setInt(3, id);

			int linhaAfetada = ps.executeUpdate();

			if (linhaAfetada == 0) {
				throw new RuntimeException("Registro não alterado! ");
			}
			{
				System.out.println("Aluno alterado com sucesso");
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// ok
	public List<Aluno> buscarTodos() {
		List<Aluno> alunos = new ArrayList<>();

		String sql = "Select escola.aluno.id as idAln, escola.aluno.nome as nomeAln, escola.aluno.id_professor as idProf, escola.professor.nome as nomeProf, escola.professor.materia as materiaProf from (escola.aluno"
				+ " inner join escola.professor  on escola.aluno.id_professor = professor.id)";

		try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql);) {

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Aluno a = new Aluno();

				Professor p = new Professor();
				p.setId(rs.getInt("idProf"));
				p.setNome(rs.getString("nomeProf"));
				p.setMateria(rs.getString("materiaProf"));

				a.setId(rs.getInt("idAln"));
				a.setNome(rs.getString("nomeAln"));
				a.setProfessor(p);

				alunos.add(a);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return alunos;
	}

	// ok
	public Aluno buscarPorId(Integer id) {
		String sql = "Select escola.aluno.id as idAln, escola.aluno.nome as nomeAln, escola.aluno.id_professor as idProf, escola.professor.nome as nomeProf, escola.professor.materia as materiaProf from (escola.aluno"
				+ " inner join escola.professor  on escola.aluno.id_professor = professor.id)" + "WHERE aluno.id = ?";

		Aluno a = null;

		try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				a = new Aluno();

				Professor p = new Professor();
				p.setId(rs.getInt("idProf"));
				p.setNome(rs.getString("nomeProf"));
				p.setMateria(rs.getString("materiaProf"));

				a.setId(rs.getInt("idAln"));
				a.setNome(rs.getString("nomeAln"));
				a.setProfessor(p);
			}
			return a;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	// ok
	public void excluir(Integer id) {
		String sql = "DELETE FROM escola.aluno " + "WHERE id = ? ";

		try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, id);

			int linhasAfetadas = ps.executeUpdate();

			if (linhasAfetadas == 0) {
				throw new RuntimeException("O id informado (" + id + ") não existe no banco");
			} else {
				System.out.println("Aluno excluido com sucesso");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
