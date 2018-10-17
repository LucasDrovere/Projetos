package Persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

//objeto de acesso a dados do banco
public class DAOFilme {

	public void excluiFilmes(Integer id) {
		Connection con = Conexao.getConexao();

		try {
			Statement st = con.createStatement();
			String sql = "DELETE FROM treinamento.filme WHERE (id) VALUES(" + id + ")";
			
			if (id.equals(obj))
			
			int linhasInseridas = st.executeUpdate(sql);

			if (linhasInseridas == 0) {
				throw new RuntimeException("Registro não encontrado");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void insereFilmes(Filme f) {

		Connection con = Conexao.getConexao();

		try {
			Statement st = con.createStatement();
			String sql = "INSERT INTO treinamento.filme (nome, ano) VALUES (" + f.getNome() + f.getAno() + ")";
			int linhasInseridas = st.executeUpdate(sql);

			if (linhasInseridas == 0) {
				throw new RuntimeException("Registro não inserido");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Filme> buscarTodos() {
		// cria a conexao
		Connection con = Conexao.getConexao();
		// cria uma lista de objetos para armazenar os dados
		List<Filme> filmes = new ArrayList<Filme>();

		try {
			// st puxa na conexao o banco
			Statement st = con.createStatement();
			// rs puxa no banco as informações que existem dentro do banco
			// na query usar o select para chegar na tabela no banco
			ResultSet rs = st.executeQuery("Select * from treinamento.filme");

			while (rs.next()) {
				String nome = rs.getString("nome");
				Integer ano = rs.getInt("ano");
				// istancia o objeto para guardar os dados vindo do bando
				Filme f = new Filme();
				// set do objeto criado
				f.setNome(nome);
				f.setAno(ano);
				// adiciona o objeto criado na lista,
				filmes.add(f);
			}
			return filmes;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
