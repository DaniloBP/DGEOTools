package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import javafx.scene.control.Alert;
import model.bean.Usuario;


public class UsuarioDAO {
	

	private List<Usuario> list = new ArrayList<>();
	

	public void createUsuario(Usuario usuario) {
		
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = conn.prepareStatement("INSERT INTO usuario VALUES (?, ?, ?, ?)");
			
			stmt.setString(1, usuario.getMatricula());
			stmt.setString(2, usuario.getCpf());
			stmt.setString(3, usuario.getNome());
			stmt.setString(4, usuario.getEmail());
			
			stmt.executeUpdate();			
			successAlert();
			
		} catch (SQLException ex) {
			errorAlert(ex);
		} finally {
			ConnectionFactory.closeConnection(conn, stmt);
		}
	}
	
	public List<Usuario> readAll() {
		
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String query = "SELECT * FROM usuario;";   
		    	
    	try {
    		stmt = conn.prepareStatement(query);
    		rs = stmt.executeQuery();
    		
			while (rs.next()) {
				
				String matricula = rs.getString("matricula");
				String cpf = rs.getString("cpf");
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				
				list.add( new Usuario(cpf, matricula, nome, email) ); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	return list;
	}
	
	private void successAlert() {
		
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setHeaderText(null);
		alert.setContentText("Usuário Cadastrado Com Sucesso!");
		alert.showAndWait();
	}
	
	private void errorAlert(SQLException exception) {
		
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setHeaderText(null);
		alert.setContentText("Erro ao tentar cadastrar: " + exception);
		alert.showAndWait();
	}
	
}
