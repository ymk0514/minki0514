package AllController;

import application.MainController;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Byebye {
	MainController mc = MainController.mc;
	public Byebye() {
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		
		Parent root=null;
		try {
			loader.setLocation(getClass().getResource("/AllXtml/Byebye.fxml"));
			root = loader.load();
			stage.setTitle("Å»ÅðÇÏ±â");
			stage.setResizable(false);
			stage.setScene(new Scene(root));
			stage.show();
			
			
		   
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
