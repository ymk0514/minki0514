package VO;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EduVO {

	private String kid_seq;
	private String kid_name;
	private String kid_password;
	private String kid_point;

	public EduVO() {
		super();
	}

	public EduVO(String kid_name, String kid_password) {
		super();
		this.kid_name = kid_name;
		this.kid_password = kid_password;
	}

	public String getKid_seq() {
		return kid_seq;
	}

	public void setKid_seq(String kid_seq) {
		this.kid_seq = kid_seq;
	}

	public String getKid_name() {
		return kid_name;
	}

	public void setKid_name(String kid_name) {
		this.kid_name = kid_name;
	}

	public String getKid_password() {
		return kid_password;
	}

	public void setKid_password(String kid_password) {
		this.kid_password = kid_password;
	}

	public String getKid_point() {
		return kid_point;
	}

	public void setKid_point(String kid_point) {
		this.kid_point = kid_point;
	}

	@Override
	public String toString() {
		return "어린이번호 : " + kid_seq + ", 어린이 이름  : " + kid_name + ", 비밀번호 : " + kid_password + ", 점수 : " + kid_point;
	}

}
