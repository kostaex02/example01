package watermelon.daointerface;

import java.sql.SQLException;
import java.util.List;

import watermelon.dto.User;

public interface UserInterface {
	/**
	 * ��� ���� �˻�
	 */
	List<User> selectUserAll() throws SQLException;
	
	/**
	 * ���̵� ���� ���� �˻�
	 */
	User selectUser(String userId) throws SQLException;
	
	/**
	 * �α����� ���� �����˻�
	 * */
	User loginUser(String userId,String pwd) throws SQLException;
	/**
	 * ���� ����
	 */
	int deleteUser(String userId) throws SQLException;
	
	/**
	 * ���� ����
	 */
	int updateUser(String userPassword, String id) throws SQLException;
	
	/**
	 * ���� �߰�
	 */
	int insertUser(User user) throws SQLException;
}
