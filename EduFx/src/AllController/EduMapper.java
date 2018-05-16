package AllController;

import java.util.ArrayList;

import VO.EduVO;
import VO.VocaVO;

public interface EduMapper {

	public  ArrayList<VocaVO> vocaName();
	
	public int loginkids(EduVO vo);
	
	public void insertkids(EduVO vo);
	
	public void deletekids(EduVO vo);
    
	public int searchkids(EduVO vo);

}
