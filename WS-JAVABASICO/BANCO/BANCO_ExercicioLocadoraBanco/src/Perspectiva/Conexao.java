package Perspectiva;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.postgresql.Driver;

public class Conexao {
	
	private Conexao() {
		//não precisa instanciar!
	}
	
	public static Connection getConexao() {
		
		try {
			DriverManager.registerDriver(new Driver());
			Connection conn = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/cast", 
					"postgres", "12345");
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

}
