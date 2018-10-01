package view.main;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import model.bean.Ferramenta;


public class MainController implements Initializable {

	@FXML
    private JFXButton addUsuarioBtn;
    @FXML
    private JFXButton addFerramentaBtn;
    @FXML
    private JFXButton viewUsuariosBtn;
    @FXML
    private JFXButton viewEmprestimosBtn;
    @FXML
    private JFXButton settingsBtn;

    // ---- TAB 'Ferramentas' START ----
    @FXML
    private Tab tabFerramentas;
    
    @FXML
    private HBox headerFerramentas;
    @FXML
    private JFXComboBox<Label> comboBoxBuscarFerramentas; 
    @FXML
    private JFXButton buscarFerramentasBtn;

    @FXML
    private TableView<Ferramenta> tableViewFerramentas;
    @FXML
    private TableColumn<Ferramenta, String> ferramentaColumnID;
    @FXML
    private TableColumn<Ferramenta, String> ferramentaColumnTipo;
    @FXML
    private TableColumn<Ferramenta, String> ferramentaColumnStatus;     

    @FXML
    private HBox bottomFerramentas;
    @FXML
    private JFXButton viewFerramentaBtn;
    // ---- TAB 'Ferramentas' END ---- 
 
   
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		initComboBoxFerramentas();
		initColumnsFerramentas();	//Tab Ferramentas
	}
	
	
	@FXML
    void loadAddUsuario(ActionEvent event) {

    }
    
    @FXML
    void loadAddFerramenta(ActionEvent event) {

    }
    
    @FXML
    void loadViewUsuarios(ActionEvent event) {

    }
    
    @FXML
    void loadViewEmprestimos(ActionEvent event) {

    }

    @FXML
    void loadSettings(ActionEvent event) {

    }
    
//   ---- ACTIONS FROM TAB 'Ferramentas'  ----
    private void initComboBoxFerramentas() {
    	
		this.comboBoxBuscarFerramentas.getItems().add(new Label("Empréstimos Ativos") );
		this.comboBoxBuscarFerramentas.getItems().add(new Label("Empréstimos Encerrados") );
		this.comboBoxBuscarFerramentas.getItems().add(new Label("Empréstimos Em Atraso") );
	}

    private void initColumnsFerramentas() {
		
		ferramentaColumnID.setCellValueFactory(new PropertyValueFactory<>("id"));	
		ferramentaColumnTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));	
		ferramentaColumnStatus.setCellValueFactory(new PropertyValueFactory<>("status"));		
	}
    
    @FXML
    void buscarFerramentasAction(ActionEvent event) {
    	
    }

    @FXML
    void openViewFerramenta(ActionEvent event) {

    }

    @FXML
    void verifyAction(ActionEvent event) {
    	
    	this.comboBoxBuscarFerramentas.setStyle(  
						    			  "-fx-font: 15px \"Serif\";"
										+ "-fx-background-color: #669b92;"
										+ "-fx-font-weight: bold;"  	);
    }
  
}
