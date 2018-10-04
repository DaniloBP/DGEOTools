package view.usuario;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.bean.Discente;
import model.bean.Docente;
import model.bean.Usuario;
import model.dao.UsuarioDAO;


public class AddUsuarioController implements Initializable {

	@FXML
    private AnchorPane rootPane;
	
	@FXML
    private Label exitLabel;
	
	@FXML
    private JFXComboBox<Label> tipoComboBox;
    @FXML
    private JFXTextField matriculaTxt;
    @FXML
    private JFXTextField cpfTxt;  
    @FXML
    private JFXTextField nomeTxt;   
    @FXML
    private JFXTextField emailTxt;       
    
    @FXML
    private JFXButton saveBtn;
    @FXML
    private JFXButton cancelBtn;
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		initComboBoxTipo(); 
	}
	
	@FXML
    public void saveUsuario(ActionEvent event) { 
		
		String userTipo = tipoComboBox.getSelectionModel().getSelectedItem().getText();	
		String userMatricula = matriculaTxt.getText();
		String userCPF = cpfTxt.getText();
		String userNome = nomeTxt.getText();
		String userEmail = emailTxt.getText();
		
		Usuario usuario;
		
		if (userMatricula.isEmpty() || userMatricula.isEmpty() || userCPF.isEmpty() 
			|| userNome.isEmpty() || userEmail.isEmpty()) {		
			
			emptyFieldAlert();
		}
		
		if (userTipo == "DOCENTE") {			
			usuario = new Docente(userMatricula, userCPF, userNome, userEmail);
		} else if (userTipo == "DISCENTE"){			
			usuario = new Discente(userMatricula, userCPF, userNome, userEmail); 
		} else {
			usuario = null;
		}
		
		UsuarioDAO dao = new UsuarioDAO();
		dao.createUsuario(usuario);
    }
	
	private void emptyFieldAlert() {
		// Tá dando algum tipo de CRASH no JVM quando a janela é fechada.
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setHeaderText(null);
		alert.setContentText("Todos os campos devem ser preenchidos!");
		alert.showAndWait();
		return;
	}

    @FXML
    void cancel(ActionEvent event) {    	
    	closeWindow();
    }
    
    private void initComboBoxTipo() {
    	
    	ObservableList<Label> tipos = FXCollections.observableArrayList( new Label("1 - DOCENTE"), new Label("2 - DISCENTE") );
    	
		this.tipoComboBox.setItems(tipos);
	}
    
    @FXML
    void exitAction(MouseEvent event) {
    	closeWindow();
    }

    
    public void closeWindow() {
    	
    	Stage stage = (Stage) rootPane.getScene().getWindow();
    	stage.close();
    }

}
