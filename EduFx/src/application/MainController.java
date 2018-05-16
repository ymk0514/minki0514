package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import AllController.AllDAO;
import AllController.Byebye;
import AllController.PointRank;
import AllController.Registration;
import AllController.VocaTest;
import VO.EduVO;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MainController implements Initializable {
	public static MainController mc;
	AllDAO ad = new AllDAO();
	ArrayList<EduVO> kidsList = new ArrayList<>();
	boolean flag;
	Alert alert = new Alert(AlertType.INFORMATION);
	Alert alert2 = new Alert(AlertType.ERROR);

	// VocaTest vc=new VocaTest();
	public MainController() {
		mc = this;
	}

	// ===========================�ֿ� ���ӽ���================================
	@FXML // �������߱� ���� .
	Button VocaButton;
	@FXML
	public ImageView imagego;
	@FXML
	Button left;
	@FXML
	Button right;
	// ============================�޴��ٿ��� �α���ĭ ============================
	@FXML // �޴��ٿ��� �α��� ��ư
	MenuItem logingo;
	@FXML // �޴��ٿ��� ȸ�����Թ�ư
	MenuItem resistencego;
	@FXML // �޴��ٿ��� Ż���ϱ��ư
	MenuItem byebye;

	// ===========================�α��� â----------------------------
	@FXML
	TextField login_name;
	@FXML
	PasswordField login_pass;
	@FXML
	Button login_bt;

	// ---------------------------ȸ����� â==========================
	@FXML // ȸ�����â ��Ϲ�ư
	Button insertbutton;
	@FXML // ȸ�����â ���� �ؽ�Ʈ
	TextField insertname;
	@FXML // ȸ�����â ��й�ȣ �ʵ�
	PasswordField insertpassword;

	// ===========================���� â----------------------------

	@FXML
	TextField byename;
	@FXML
	PasswordField byepassword;
	@FXML
	Button byebutton;

	// ===========================��ŷ â----------------------------
	@FXML
	MenuItem rankinggo;
	TableColumn<String, String> rank;
	TableColumn<EduVO, String> rankname;
	TableColumn<EduVO, String> rankpoint;

	VocaTest voca;
	Logingo login;

	public class Logingo extends Stage {
		Stage stagelogin;
		MainController mc = MainController.mc;
		public Logingo() {
			stagelogin = new Stage();
			FXMLLoader loader = new FXMLLoader();
			
			Parent root=null;
			try {
				loader.setLocation(getClass().getResource("/AllXtml/Login.fxml"));
				root = loader.load();
				stagelogin.setTitle("�α���");
				stagelogin.setResizable(false);
				stagelogin.setScene(new Scene(root));
				stagelogin.show();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		public void closelogin(){
			stagelogin.close();
		   }

	}

	@FXML
	private void logingo(Event e) { // �޴����� �α��� ��ư.
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				login = new Logingo();

			}
		});
	}

	@FXML
	private void resistencego(ActionEvent e) { // �޴����� ȸ������ ��ư.

		if (ad.isFlag()) {
			alert2.setTitle("���");
			alert2.setHeaderText(null);
			alert2.setContentText("�̹� �α��� �Ǿ� �ֽ��ϴ�.");
			alert2.showAndWait();
		} else {
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					new Registration();
				}
			});
		}

	}

	@FXML
	private void byebye(ActionEvent e) { // �޴����� ȸ��Ż�� ��ư.

		Platform.runLater(new Runnable() {
			@Override
			public void run() {

				new Byebye();
			}
		});
	}

	@FXML
	public void rankinggo(ActionEvent e) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {

				new PointRank();
			}

		});

	}

	ArrayList<String> vList = new ArrayList<>();
	

	@FXML
	private void VocaButton(ActionEvent e) { // �������߱� ���� ��ư.

		if (ad.isFlag()) {

			Platform.runLater(new Runnable() {

				@Override
				public void run() {

					voca = new VocaTest();

					Random rd = new Random();
					int a = rd.nextInt(2);
					
				   
				    for(int i=0;i<voca.PhotoVoca().size();i++) {
				    	mc.vList.add(voca.PhotoVoca().get(i));
				    }
				    
					System.out.println(mc.vList);
					System.out.println(voca.PhotoVoca().get(0));
					 System.out.println(a);
					if (a == 1) {
						// System.out.println(vc.PhotoVoca().get(0));
						mc.left.setText(voca.PhotoVoca().get(0));
						mc.right.setText(voca.PhotoVoca().get(1));

					} else if (a == 0) {
						mc.left.setText(voca.PhotoVoca().get(1));
						mc.right.setText(voca.PhotoVoca().get(0));
						// mc.left.setText(vc.PhotoVoca().get(1));
						// mc.right.setText(vc.PhotoVoca().get(0));
					}
				}

			});
		} else {

			alert2.setTitle("���");
			alert2.setHeaderText(null);
			alert2.setContentText("�α����� ���ּ���");
			alert2.showAndWait();

		}

	}

	int count = 0;
	int countsum = 0;

	@FXML
	private void doLeft(ActionEvent e) {
	

		
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				
				
				if (mc.vList.get(0).equals(mc.left.getText())) {
				
					count++;

					System.out.println(count);
				}
			}
		});
	}
	@FXML
	private void right(ActionEvent e) {
		

		
		Platform.runLater(new Runnable() {
			@Override
			public void run() {

			
				if (mc.vList.get(0).equals(mc.right.getText())) {
					
					count++;

					System.out.println(count);
				}
			}
		});
	}
   
	@FXML
	private void login_bt(ActionEvent e) {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {

				EduVO vo = new EduVO();

				vo.setKid_name(mc.login_name.getText());
				vo.setKid_password(mc.login_pass.getText());

				if (ad.loginkids(vo) == 1) {
					ad.setFlag(true);
					alert.setTitle("�˸�");
					alert.setHeaderText(mc.login_name.getText() + " �� ȯ���մϴ�.");
					alert.setContentText("�α��� �Ǿ����ϴ�.");
					alert.showAndWait();
					login.stagelogin.close();
                    
				} else {
					ad.setFlag(false);
					alert2.setTitle("���");
					alert2.setHeaderText(null);
					alert2.setContentText("���̵�� ��й�ȣ�� Ȯ�����ּ���");
					alert2.showAndWait();
				}
				// Thread.currentThread().interrupt();
			}

		});
	}

	@FXML
	private void insertkids(ActionEvent e) { // �޴����� ȸ������ ��ư.

		Platform.runLater(new Runnable() {

			@Override
			public void run() {

				EduVO eduvo = new EduVO();

				if (mc.insertname.getText().equals("") || mc.insertpassword.getText().equals("")) {
					alert2.setTitle("���");
					alert2.setHeaderText(null);
					alert2.setContentText("�̸� �Ǵ� ��й�ȣ�� �Է����ּ���");
					alert2.showAndWait();

				} else if (!mc.insertname.getText().equals("") && !mc.insertpassword.getText().equals("")) {
					eduvo.setKid_name(mc.insertname.getText());
					eduvo.setKid_password(mc.insertpassword.getText());

					ad.searchkids(eduvo);

					if (ad.searchkids(eduvo) == 1) {

						alert2.setTitle("���");
						alert2.setHeaderText(null);
						alert2.setContentText("�̹� �Էµ� ���̵��Դϴ�.");
						alert2.showAndWait();
					} else if (ad.searchkids(eduvo) == 0) {
						ad.insertkids(eduvo);
						alert.setTitle("�˸�");
						alert.setHeaderText(null);
						alert.setContentText("ȸ�������� �Ϸ�Ǿ����ϴ�.");
						alert.showAndWait();

					}
				}
			}

		});
	}

	@FXML
	private void deletekids(ActionEvent e) {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {

				if (mc.byename.getText().equals("") || mc.byepassword.getText().equals("")) {
					alert2.setTitle("���");
					alert2.setHeaderText(null);
					alert2.setContentText("�̸� �Ǵ� ��й�ȣ�� �Է����ּ���");
					alert2.showAndWait();
				} else {
					EduVO eduvo = new EduVO();
					eduvo.setKid_name(mc.byename.getText());
					eduvo.setKid_password(mc.byepassword.getText());

					ad.searchkids(eduvo);

					if (ad.searchkids(eduvo) == 0) {
						alert2.setTitle("���");
						alert2.setHeaderText(null);
						alert2.setContentText("�������� �ʴ� ���̵��Դϴ�.");
						alert2.showAndWait();

					} else {

						ad.deletekids(eduvo);
						alert.setTitle("�˸�");
						alert.setHeaderText(null);
						alert.setContentText("������ �Ϸ�Ǿ����ϴ�.");
						alert.showAndWait();

						// Platform.exit(); ��ü �����ϴ� �޼ҵ�
					}

				}
			}

		});

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		/*
		 * left.setOnAction(event -> left(event)); right.setOnAction(event ->
		 * right(event));
		 */

	}

}
