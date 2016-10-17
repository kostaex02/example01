package elec.model.dao;

import java.sql.SQLException;
import java.util.List;

import elec.model.dto.Electronics;

public interface ElectronicsDAO {
	/**
	 * 레코드 전체 검색
	 */
	List<Electronics> selectAll() throws SQLException;

	/**
	 * 모델번호에 해당하는 레코드 검색
	 * 
	 * @param :	boolean flag - true이면 조회수 증가, false이면 조회증가 안함.
	 */
	Electronics selectByModelNum(String model_num, boolean flag) throws SQLException;

	/**
	 * 레코드 삽입
	 * 
	 * @return : true-삽입성공 , false - 삽입실패
	 */
	int insert(Electronics electronics) throws SQLException;

	/**
	 * 모델번호에 해당하는 레코드 삭제
	 * 
	 * @return : true-삭제성공 , false - 삭제실패
	 */
	int delete(String model_num, String password) throws SQLException;

	/**
	 * 모델번호에 해당하는 레코드 수정
	 * 
	 * @return : true-수정성공 , false - 수정실패
	 */
	int update(Electronics electronics) throws SQLException;
}
