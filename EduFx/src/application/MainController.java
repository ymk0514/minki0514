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

	// ===========================주요 게임실행================================
	@FXML // 낱말맞추기 게임 .
	Button VocaButton;
	@FXML
	public ImageView imagego;
	@FXML
	Button left;
	@FXML
	Button right;
	// ============================메뉴바에서 로그인칸 ============================
	@FXML // 메뉴바에서 로그인 버튼
	MenuItem logingo;
	@FXML // 메뉴바에서 회원가입버튼
	MenuItem resistencego;
	@FXML // 메뉴바에서 탈퇴하기버튼
	MenuItem byebye;

	// ===========================로그인 창----------------------------
	@FXML
	TextField login_name;
	@FXML
	PasswordField login_pass;
	@FXML
	Button login_bt;

	// ---------------------------회원등록 창==========================
	@FXML // 회원등록창 등록버튼
	Button insertbutton;
	@FXML // 회원등록창 별명 텍스트
	TextField insertname;
	@FXML // 회원등록창 비밀번호 필드
	PasswordField insertpassword;

	// ===========================삭제 창----------------------------

	@FXML
	TextField byename;
	@FXML
	PasswordField byepassword;
	@FXML
	Button byebutton;

	// ===========================랭킹 창----------------------------
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
				stagelogin.setTitle("로그인");
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
	private void logingo(Event e) { // 메뉴바의 로그인 버튼.
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				login = new Logingo();

			}
		});
	}

	@FXML
	private void resistencego(ActionEvent e) { // 메뉴바의 회원가입 버튼.

		if (ad.isFlag()) {
			alert2.setTitle("경고");
			alert2.setHeaderText(null);
			alert2.setContentText("이미 로그인 되어 있습니다.");
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
	private void byebye(ActionEvent e) { // 메뉴바의 회원탈퇴 버튼.

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
	private void VocaButton(ActionEvent e) { // 낱말맞추기 게임 버튼.

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

			alert2.setTitle("경고");
			alert2.setHeaderText(null);
			alert2.setContentText("로그인을 해주세요");
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
					alert.setTitle("알림");
					alert.setHeaderText(mc.login_name.getText() + " 님 환영합니다.");
					alert.setContentText("로그인 되었습니다.");
					alert.showAndWait();
					login.stagelogin.close();
                    
				} else {
					ad.setFlag(false);
					alert2.setTitle("경고");
					alert2.setHeaderText(null);
					alert2.setContentText("아이디와 비밀번호를 확인해주세요");
					alert2.showAndWait();
				}
				// Thread.currentThread().interrupt();
			}

		});
	}

	@FXML
	private void insertkids(ActionEvent e) { // 메뉴바의 회원가입 버튼.

		Platform.runLater(new Runnable() {

			@Override
			public void run() {

				EduVO eduvo = new EduVO();

				if (mc.insertname.getText().equals("") || mc.insertpassword.getText().equals("")) {
					alert2.setTitle("경고");
					alert2.setHeaderText(null);
					alert2.setContentText("이름 또는 비밀번호를 입력해주세요");
					alert2.showAndWait();

				} else if (!mc.insertname.getText().equals("") && !mc.insertpassword.getText().equals("")) {
					eduvo.setKid_name(mc.insertname.getText());
					eduvo.setKid_password(mc.insertpassword.getText());

					ad.searchkids(eduvo);

					if (ad.searchkids(eduvo) == 1) {

						alert2.setTitle("경고");
						alert2.setHeaderText(null);
						alert2.setContentText("이미 입력된 아이디입니다.");
						alert2.showAndWait();
					} else if (ad.searchkids(eduvo) == 0) {
						ad.insertkids(eduvo);
						alert.setTitle("알림");
						alert.setHeaderText(null);
						alert.setContentText("회원가입이 완료되었습니다.");
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
					alert2.setTitle("경고");
					alert2.setHeaderText(null);
					alert2.setContentText("이름 또는 비밀번호를 입력해주세요");
					alert2.showAndWait();
				} else {
					EduVO eduvo = new EduVO();
					eduvo.setKid_name(mc.byename.getText());
					eduvo.setKid_password(mc.byepassword.getText());

					ad.searchkids(eduvo);

					if (ad.searchkids(eduvo) == 0) {
						alert2.setTitle("경고");
						alert2.setHeaderText(null);
						alert2.setContentText("존재하지 않는 아이디입니다.");
						alert2.showAndWait();

					} else {

						ad.deletekids(eduvo);
						alert.setTitle("알림");
						alert.setHeaderText(null);
						alert.setContentText("삭제가 완료되었습니다.");
						alert.showAndWait();

						// Platform.exit(); 전체 종료하는 메소드
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
