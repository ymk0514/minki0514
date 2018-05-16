package VO;

public class VocaVO {
	
	private String voca_name;

	public VocaVO() {
		super();
	}

	public VocaVO(String voca_name) {
		super();
		this.voca_name = voca_name;
	}

	public String getVoca_name() {
		return voca_name;
	}

	public void setVoca_name(String voca_name) {
		this.voca_name = voca_name;
	}

	@Override
	public String toString() {
		return voca_name;
	}
	

}
