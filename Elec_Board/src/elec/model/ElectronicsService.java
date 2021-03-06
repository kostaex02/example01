package elec.model;

import java.sql.SQLException;
import java.util.List;

import elec.model.dao.ElectronicsDAOImpl;
import elec.model.dto.Electronics;

public class ElectronicsService {
	private static ElectronicsDAOImpl electronicsDao = new ElectronicsDAOImpl();

	public ElectronicsService(){
		
	}
	/**
	 * ElectronicsDAOImpl의 모든레코드 검색하는 메소드 호출
	 */
	public static List<Electronics> selectAll() throws SQLException{
		List<Electronics> list = null;
		list = electronicsDao.selectAll();
	
		return list;
	}
	
	/**
	 * ElectronicsDAOImpl의 레코드 삽입하는 메소드 호출
	 */
	public static int insert(Electronics electronics) throws SQLException{
		return electronicsDao.insert(electronics);
	}

	/**
	 * ElectronicsDAOImpl의 모델번호에 해당하는 레코드 검색하는 메소드 호출
	 * 
	 * @param :
	 *            boolean flag - 조회수 증가 여부를 판별하는 매개변수임(true이면 조회수증가 / false이면
	 *            조회수 증가 안함)
	 */
	public static Electronics selectByModelNum(String modelNum, boolean flag) throws SQLException{
		Electronics elec = electronicsDao.selectByModelNum(modelNum, flag);
		return elec;
	}
	/**
	 * ElectronicsDAOImpl의 모델번호에 해당하는 레코드 삭제 메소드 호출
	 */
	public static int delete(String modelNum, String password) throws SQLException{
		return electronicsDao.delete(modelNum, password);
	}

	/**
	 * ElectronicsDAOImpl의 모델번호에 해당하는 레코드 수정 메소드 호출
	 */
	public static int update(Electronics elec) throws SQLException{
		return electronicsDao.update(elec);
	}
}
