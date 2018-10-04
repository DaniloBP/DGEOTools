package view.ferramenta;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.bean.Ferramenta;
import model.dao.FerramentaDAO;


public class FetchFerramentaController implements Initializable {

	
	@FXML
    private AnchorPane rootPane;
	
	@FXML
    private Label exitLabel;
	
	@FXML
	private GridPane gridPane;
	
	@FXML
    private JFXRadioButton tipoRadioBtn;
    @FXML
    private JFXRadioButton numIDRadioBtn;
    
	@FXML
	private JFXComboBox<Label> tipoComboBox;
    @FXML
    private JFXTextField idTxt;       
    
    private ToggleGroup toggle = new ToggleGroup();
    
    @FXML
    private JFXButton buscarButton;
    @FXML
    private JFXButton cancelBtn;
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		this.tipoRadioBtn.setToggleGroup(toggle);
		this.numIDRadioBtn.setToggleGroup(toggle);

		initComboBoxCriterio();
	}
	
	@FXML
    void buscarFerramenta(ActionEvent event) {
		
		
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
    	
    	ObservableList<Label> tipos = FXCollections.observableArrayList(new Label("1 - Bússola"), new Label("2 - GPS"), new Label("3 - Martelo Cristalino"), 
																		new Label("4 - Martelo Sedimentar"), new Label("5 - Perneiras") );    	
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
