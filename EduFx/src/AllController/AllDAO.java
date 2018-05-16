package AllController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import VO.EduVO;
import VO.VocaVO;

public class AllDAO implements EduMapper {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory(); // 마이바티스 객체

	// 데이터베이스의 카드이름 가져와서 넣는 리스트
	static ArrayList<EduVO> kidsList = null; // 회원가입되고 지워질때 사용할 배열
	static EduVO aduvo = new EduVO();

	static boolean flag = false;

	public static ArrayList<EduVO> getKidsList() {
		return kidsList;
	}

	public static void setKidsList(ArrayList<EduVO> kidsList) {
		AllDAO.kidsList = kidsList;
	}

	public static boolean isFlag() {
		return flag;
	}

	public static void setFlag(boolean flag) {
		AllDAO.flag = flag;
	}

	public ArrayList<VocaVO> vocaName() {// 카드 이름가져와서 셔플링하는 메소드

		SqlSession session = null;
		ArrayList<VocaVO> cardList = null;

		// 카드이름 담는애 ;

		try {
			session = factory.openSession();
			EduMapper mapper = session.getMapper(EduMapper.class);
			cardList = mapper.vocaName();

			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}

		Collections.shuffle(cardList);
		for (int i = 0; i < cardList.size(); i++) {
			System.out.println(cardList.get(i));
		}
		return cardList;

	}

	@Override
	public void insertkids(EduVO vo) {
		// TODO Auto-generated method stub
		SqlSession session = null;

		try {
			session = factory.openSession();
			EduMapper mapper = session.getMapper(EduMapper.class);
			mapper.insertkids(vo);

			session.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	@Override
	public void deletekids(EduVO vo) {
		// TODO Auto-generated method stub
		SqlSession session = null;

		try {
			session = factory.openSession();
			EduMapper mapper = session.getMapper(EduMapper.class);
			mapper.deletekids(vo);
			session.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	@Override
	public int loginkids(EduVO vo) {
		// TODO Auto-generated method stub

		int i = 0;
		SqlSession session = null;

		try {
			session = factory.openSession();
			EduMapper mapper = session.getMapper(EduMapper.class);
			i = mapper.loginkids(vo);
			session.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return i;

	}

	@Override
	public int searchkids(EduVO vo) {
		// TODO Auto-generated method stub

		int i = 0;
		SqlSession session = null;

		try {
			session = factory.openSession();
			EduMapper mapper = session.getMapper(EduMapper.class);
			i = mapper.searchkids(vo);
			session.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return i;

	}

}
