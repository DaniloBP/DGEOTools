package view.login;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LoginController implements Initializable{
	
	@FXML
    private TextField usernameTxt;
    @FXML
    private PasswordField passwordField;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	@FXML
    void exitLabelAction(MouseEvent event) {
		System.out.println("Fechando Login ...");	
		System.exit(0);
    }

}
