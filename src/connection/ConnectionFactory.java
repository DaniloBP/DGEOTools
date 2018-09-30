package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/dgeotools?useTimezone=true&serverTimezone=UTC";
	private static final String USER = "root"; 
	private static final String PASS = "1234";
	
	
	private ConnectionFactory() {
		
	}
	
	public static Connection getConnection() {
		
		try {
			Class.forName(DRIVER).newInstance();
			
			return DriverManager.getConnection(URL, USER, PASS);
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			throw new RuntimeException("Erro na Conexão: ", e);
		}
	}
	
	public static void closeConnection(Connection conn) {		
		
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public static void closeConnection(Connection conn, PreparedStatement stmt) {				
		
		closeConnection(conn);
		
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public static void closeConnection(Connection conn, PreparedStatement stmt, ResultSet rs) {				
		
		closeConnection(conn, stmt);
		
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
}
