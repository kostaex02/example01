package watermelon.dao;

import java.sql.SQLException;
import java.util.List;

import watermelon.daointerface.UserInterface;
import watermelon.dto.User;

public class UserDAO implements UserInterface {

	@Override
	public List<User> selectUserAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User selectUser(String userId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteUser(String userId) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
