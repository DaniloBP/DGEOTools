package view.login;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class LoginController implements Initializable{
	
	
	@FXML
    private Label exitLabel;    
	
	@FXML
    private JFXTextField usernameTxt;
	@FXML
    private JFXPasswordField passwordField;

    @FXML
    private JFXButton entrarBtn;
    @FXML
    private JFXButton cancelarBtn;

    @FXML
    private Hyperlink esqueceuLink;   
    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	@FXML
    void cancelarAction(ActionEvent event) {
		clear();
    }

    @FXML
    void entrarAction(ActionEvent event) {
    	
    }

    @FXML
    void esqueceuAction(ActionEvent event) {

    }
	
	@FXML
    void exitLabelAction(MouseEvent event) {
		System.out.println("Fechando Login ...");	
		System.exit(0);
    }
	
	private void clear() {
		this.usernameTxt.clear();
		this.passwordField.clear();
	}

}
