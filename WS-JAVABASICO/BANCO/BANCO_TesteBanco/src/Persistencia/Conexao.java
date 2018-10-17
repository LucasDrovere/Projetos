package Persistencia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Conexao {

	private Conexao() {
		//não precisa instanciar!
	}
	
	public static Connection getConexao() {
		try {
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cast", "postgres", "12345");
			return con;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
