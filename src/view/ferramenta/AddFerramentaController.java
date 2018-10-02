package view.ferramenta;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.bean.Ferramenta;
import model.dao.FerramentaDAO;


public class AddFerramentaController implements Initializable {

	@FXML
    private AnchorPane rootPane;
	
	@FXML
    private Label exitLabel;
	
    @FXML
    private JFXTextField idTxt;
    @FXML
    private JFXTextField tipoTxt;
    @FXML
    private JFXTextArea descricaoTxtArea;
    
    @FXML
    private JFXButton saveBtn;
    @FXML
    private JFXButton cancelBtn;
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	@FXML
    public void saveFerramenta(ActionEvent event) {
		
		String toolId = idTxt.getText();
		String toolTipo = tipoTxt.getText();
		String toolDescricao = descricaoTxtArea.getText();
		
		if (toolId.isEmpty() || toolTipo.isEmpty() || toolDescricao.isEmpty()) {		
			
			emptyFieldAlert();
		}
		
		// Uma Ferramenta sempre deve ser cadastrada como isDisponivel = 'true'.
		Ferramenta ferramenta = new Ferramenta(toolId, toolTipo, toolDescricao, true); 
		
		FerramentaDAO dao = new FerramentaDAO();		
		dao.createFerramenta(ferramenta);
    }
	
	private void emptyFieldAlert() {
		// T� dando algum tipo de CRASH no JVM quando a janela � fechada.
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
    
    @FXML
    void exitAction(MouseEvent event) {
    	closeWindow();
    }

    
    public void closeWindow() {
    	
    	Stage stage = (Stage) rootPane.getScene().getWindow();
    	stage.close();
    }

}
