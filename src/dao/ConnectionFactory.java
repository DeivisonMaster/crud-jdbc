package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private String url = "jdbc:mysql://localhost/bradesco";
	private String user = "";
	private String password = "";
	private Connection conexao = null;
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.conexao = DriverManager.getConnection(url, user , password);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} 
		return conexao;
	}
}
























