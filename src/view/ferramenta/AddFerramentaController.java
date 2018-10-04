package view.ferramenta;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
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
    private ComboBox<Label> tiposComboBox;
    @FXML
    private JFXTextArea descricaoTxtArea;
    
    @FXML
    private JFXButton saveBtn;
    @FXML
    private JFXButton cancelBtn;
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		initComboBoxTipos();
	}
	
	@FXML
    public void saveFerramenta(ActionEvent event) {
		
		String toolId = idTxt.getText();
		String toolTipo = tiposComboBox.getSelectionModel().getSelectedItem().getText();
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
    
    private void initComboBoxTipos() {
    	
//    	this.tiposComboBox = new ComboBox<>();       	
    	ObservableList<Label> tipos = FXCollections.observableArrayList(new Label("1 - Bússola"), new Label("2 - GPS"), new Label("3 - Martelo Cristalino"), 
				new Label("4 - Martelo Sedimentar"), new Label("5 - Perneiras") );
    	
		this.tiposComboBox.setItems(tipos);
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
