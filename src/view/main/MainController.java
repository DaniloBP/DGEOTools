package view.main;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.bean.Ferramenta;


public class MainController implements Initializable {

	//	Botões Laterais...
	@FXML
    private JFXButton registrarEmprestimoBtn;
	@FXML
    private JFXButton buscarUsuarioBtn;
	@FXML
    private JFXButton buscarFerramentaBtn;
	@FXML
    private JFXButton addUsuarioBtn;
    @FXML
    private JFXButton addFerramentaBtn;
    
       
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
    void loadRegistrarEmprestimo(ActionEvent event) {
		
    }
	
	@FXML
    void loadBuscarUsuario(ActionEvent event) {
		
    }
	
	@FXML
    void loadBuscarFerramenta(ActionEvent event) {
		
    }    
	
	@FXML
    void loadAddUsuario(ActionEvent event) {
		
    }
    
    @FXML
    void loadAddFerramenta(ActionEvent event) {
    	
    	loadWindow("Cadastrar Nova Ferramenta", "src/view/ferramenta/AddFerramenta.fxml");
    }    
    
    void loadWindow(String title, String location) {
    	
    	try {
//			Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource(location));
			
    		// Só está carregando assim do contrário lança exceção;
			URL url = new File(location).toURI().toURL();
			Parent parent = FXMLLoader.load(url);
			
			Stage stage = new Stage(StageStyle.UNDECORATED);
			stage.setTitle(title);
			stage.setScene( new Scene(parent) );
			stage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
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
