package watermelon.Service;

import java.sql.SQLException;

import watermelon.dao.UserDAO;
import watermelon.dto.User;

public class SelectUser {
	UserDAO dao = new UserDAO();
	User user = new User();
	public User login(String email, String pwd) {
	 	try {
	 		//10.26����-�α����� �����ϴ� ���� �����̸����� user��ü�� ����.
	 		return dao.loginUser(email,pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 	return null;
	}
}
