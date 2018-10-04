package view.ferramenta;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.bean.Ferramenta;
import model.dao.FerramentaDAO;

public class FetchFerramentaController implements Initializable {

	
	@FXML
    private AnchorPane rootPane;
	
	@FXML
    private Label exitLabel;
	
    @FXML
    private JFXTextField criterioTxt;
    @FXML
    private JFXComboBox<Label> criterioBuscaComboBox;
    
    @FXML
    private VBox resultadoVBox;
    
    @FXML
    private JFXButton cancelBtn;
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		initComboBoxCriterio();
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
    
    private void initComboBoxCriterio() {
    	
//    	this.tiposComboBox = new ComboBox<>();       	
    	ObservableList<Label> tipos = FXCollections.observableArrayList(new Label("1 - Por Nº Identificação"), new Label("2 - Por Tipo"), new Label("3 - Martelo Cristalino"), 
				new Label("4 - Martelo Sedimentar"), new Label("5 - Perneiras") );
    	
		this.criterioBuscaComboBox.setItems(tipos);
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
