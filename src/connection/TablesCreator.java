package connection;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TablesCreator {

	
	private static Connection conn = null;
	private static Statement stmt = null;
	
	
	TablesCreator() {
		
		conn = ConnectionFactory.getConnection();		
	}
	
	
	void setupFerramentaTable() {
		
		String TABLE_NAME = "FERRAMENTA";
		
		try {
			stmt = conn.createStatement();
			DatabaseMetaData dbm = conn.getMetaData();
			ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);
			
			if (tables.next()) {
				System.out.println("Table " + TABLE_NAME + " already exists. We're good to go!");
			} else {
				stmt.execute( "CREATE TABLE " + TABLE_NAME + " ("
							+ "		id varchar(1) NOT NULL primary key, \n"
							+ "		tipo varchar(50) NOT NULL,\n"
							+ "		descricao varchar(200),\n"
							+ " 	isDisponivel boolean default true"
							+ " ) DEFAULT CHARSET = UTF8MB4;" 
							);
			}
			
		} catch (SQLException e) {
			System.err.println(e.getMessage() + " ... set up Database");
			e.printStackTrace();
		}
		
		
	}
	
	private void setupMemberTable() {
		
		String TABLE_NAME = "MEMBER";
		
		try {
			stmt = conn.createStatement();
			DatabaseMetaData dbm = conn.getMetaData();
			ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);
			
			if (tables.next()) {
				System.out.println("Table " + TABLE_NAME + " already exists. We're good to go!");
			} else {
				stmt.execute("	CREATE TABLE " + TABLE_NAME + " ("
							+ "		id varchar(50) NOT NULL primary key, \n"
							+ "		name varchar(100),\n"
							+ "		phone varchar(20),\n"
							+ "		email varchar(100)\n"
							+ " ) DEFAULT CHARSET = UTF8MB4;" 
							);
			}
			
		} catch (SQLException e) {
			System.err.println(e.getMessage() + " ... set up Database");
			e.printStackTrace();
		}		
	}

}
