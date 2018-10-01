package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import javafx.scene.control.Alert;
import model.bean.Ferramenta;


public class FerramentaDAO {
	
	private List<Ferramenta> list = new ArrayList<>();
	

	public void createFerramenta(Ferramenta ferramenta) {
		
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = conn.prepareStatement("INSERT INTO ferramenta VALUES (?, ?, ?, ?)");
			
			stmt.setString(1, ferramenta.getId());
			stmt.setString(2, ferramenta.getTipo());
			stmt.setString(3, ferramenta.getDescricao());
			stmt.setBoolean(4, ferramenta.getIsDisponivel());
			
			stmt.executeUpdate();			
			successAlert();
			
		} catch (SQLException ex) {
			errorAlert(ex);
		} finally {
			ConnectionFactory.closeConnection(conn, stmt);
		}
	}
	
	public List<Ferramenta> readAll() {
		
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String query = "SELECT * FROM ferramenta;";   
		    	
    	try {
    		stmt = conn.prepareStatement(query);
    		rs = stmt.executeQuery();
    		
			while (rs.next()) {
				
				String id = rs.getString("id");
				String tipo = rs.getString("tipo");
				String descricao = rs.getString("descricao");
				Boolean isDisponivel = rs.getBoolean("isDisponivel");
				
				list.add( new Ferramenta(tipo, id, descricao, isDisponivel) ); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	return list;
	}
	
	private void successAlert() {
		
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setHeaderText(null);
		alert.setContentText("Ferramenta Cadastrada Com Sucesso!");
		alert.showAndWait();
	}
	
	private void errorAlert(SQLException exception) {
		
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setHeaderText(null);
		alert.setContentText("Erro ao tentar cadastrar: " + exception);
		alert.showAndWait();
	}
}
