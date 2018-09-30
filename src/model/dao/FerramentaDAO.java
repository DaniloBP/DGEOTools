package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.ConnectionFactory;
import javafx.scene.control.Alert;
import model.bean.Ferramenta;

public class FerramentaDAO {

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
