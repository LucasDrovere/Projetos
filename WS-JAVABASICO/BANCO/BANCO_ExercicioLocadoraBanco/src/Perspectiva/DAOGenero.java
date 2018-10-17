package Perspectiva;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Genero;

public class DAOGenero {

	public List<Genero> buscarTodos() {
		List<Genero> generos = new ArrayList<>();

		try (Connection conn = Conexao.getConexao(); Statement st = conn.createStatement();) {

			ResultSet rs = st.executeQuery("Select * from treinamento.genero");

			while (rs.next()) {
				Genero g = new Genero();
				g.setId(rs.getInt("id"));
				g.setNome(rs.getString("nome"));
				generos.add(g);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return generos;
	}

	public Integer buscarPorDescricao(String descricao) {

		Genero g = new Genero();

		try (Connection conn = Conexao.getConexao(); Statement st = conn.createStatement();) {

			ResultSet rs = st.executeQuery("Select id from treinamento.genero WHERE nome ='" + descricao + "'");
			while (rs.next()) {
				g.setId(rs.getInt("id"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return g.getId();
	}
}
