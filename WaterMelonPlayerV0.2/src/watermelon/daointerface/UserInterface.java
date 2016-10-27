package watermelon.daointerface;

import java.sql.SQLException;
import java.util.List;

import watermelon.dto.User;

public interface UserInterface {
	/**
	 * 모든 유저 검색
	 */
	List<User> selectUserAll() throws SQLException;
	
	/**
	 * 아이디를 통한 유저 검색
	 */
	User selectUser(String userId) throws SQLException;
	
	/**
	 * 로그인을 위한 유저검색
	 * */
	User loginUser(String userId,String pwd) throws SQLException;
	/**
	 * 유저 삭제
	 */
	int deleteUser(String userId) throws SQLException;
	
	/**
	 * 유저 수정
	 */
	int updateUser(String userPassword, String id) throws SQLException;
	
	/**
	 * 유저 추가
	 */
	int insertUser(User user) throws SQLException;
}
