package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	

	@Override
	public void start(Stage Stage) {
		Parent root = null;
		try {

			// FXMLLoader loader = new FXMLLoader();
			// loader.setLocation(Main.class.getResource("/application/Root.fxml"));

			root = FXMLLoader.load(getClass().getResource("/AllXtml/Root.fxml"));

			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		} catch (Exception e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		Stage.setTitle("자녀와 함께 행복의나라로~");
		Stage.setResizable(false);
		Stage.setScene(scene);
		Stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
