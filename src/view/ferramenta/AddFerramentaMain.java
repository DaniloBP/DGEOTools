package view.ferramenta;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class AddFerramentaMain extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("AddFerramenta.fxml"));	 
			primaryStage.initStyle(StageStyle.UNDECORATED);
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("ferramenta.css").toExternalForm());
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) { 
		launch(args);
	}
	 
}
