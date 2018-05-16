package AllController;

import org.w3c.dom.stylesheets.LinkStyle;

import VO.EduVO;
import application.MainController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class PointRank {

	MainController mc = MainController.mc;
	ListView<EduVO> listView;
	public PointRank() {
		
			Stage stage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			
			Parent root=null;
			try {
				loader.setLocation(getClass().getResource("/AllXtml/PointRank.fxml"));
				root = loader.load();
				stage.setTitle("내 점수를 확인해요~");
				stage.setResizable(false);
				stage.setScene(new Scene(root));
				stage.show();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
}
