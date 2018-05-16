package AllController;

import org.apache.ibatis.session.SqlSessionFactory;

import application.MainController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Registration{ // Registration.fxml을 담당하는 클래스
	MainController mc = MainController.mc;
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	public Registration() {
		
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		
		Parent root=null;
		try {
			loader.setLocation(getClass().getResource("/AllXtml/Registration.fxml"));
			root = loader.load();
			stage.setTitle("회원가입");
			stage.setResizable(false);
			stage.setScene(new Scene(root));
			stage.show();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
