package watermelon.Service;

import java.sql.SQLException;

import watermelon.dao.UserDAO;
import watermelon.dto.User;

public class SelectUser {
	UserDAO dao = new UserDAO();
	User user = new User();
	public User login(String email, String pwd) {
	 	try {
			user = dao.loginUser(email,pwd);
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 	return user;
	}
}
