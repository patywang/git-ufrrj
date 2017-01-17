package data.gateway;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
public static Connection getConnection(){
		
		Connection conexao = null;
		String usuario = "patricia";
		String senha = "123qwe..";
		String nomeBanco = "comp3_proj";
		
		try {
			DriverManager.registerDriver(new org.postgresql.Driver());
			Class.forName("org.postgresql.Driver");
			conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + nomeBanco,usuario, senha);
		} catch (Exception e) {
			e.printStackTrace(); //criar nova exceção aqui!!
		}
		return conexao;
		
	}
}
