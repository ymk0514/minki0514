package AllController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Set;

import VO.VocaVO;
import application.MainController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class VocaTest {
	MainController mc = MainController.mc;
	static AllDAO pc = new AllDAO(); // �����ͺ��̽����� �޾ƿ� ������ �迭�� Ŭ���� ȣ��
	int card = 0; // ���õ� ī���� ������ int������ �ޱ����� card
	ArrayList<VocaVO> vocaList;
	ArrayList<String> vList;

	public VocaTest() { // �������߱� ��ư Ŭ���� ���Ǵ� Ŭ����

		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader();

		Parent root = null;

		try {
			loader.setLocation(getClass().getResource("/AllXtml/VocaTest.fxml"));
			root = loader.load();

			stage.setTitle("���� ���߱� ����");
			stage.setResizable(false);
			stage.setScene(new Scene(root));
			stage.show();
			// mc.setleft();

			// System.out.println(PhotoVoca());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		vList = new ArrayList<>();
		vocaList = pc.vocaName();
		System.out.println();
		for (int i = 0; i < vList.size(); i++) {
			System.out.println(vList.get(i));
		}
		for (int i = 0; i < vocaList.size(); i++) {
			vList.add(vocaList.get(i).getVoca_name());
		}

	}

	public ArrayList<String> PhotoVoca() {

		// System.out.println(cardList.size());

		Image img = new Image("Resource/" + vList.get(0) + ".jpg", 540, 380, false, false);
		// Image img =new3
		// Image("/ImageSource/"+pc.vocaName().get(card)+".jpg",540,380,false,false);

		MainController.mc.imagego.setImage(img);

		// System.out.println(cardname.get(0));
		// +pc.vocaName().get(card)+

		return vList;

	}
}
