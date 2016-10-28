package watermelon.Service;

import java.sql.SQLException;

import watermelon.dao.UserDAO;
import watermelon.dto.User;

public class SelectUser {
	UserDAO dao = new UserDAO();
	User user = new User();
	public User login(String email, String pwd) {
	 	try {
	 		//10.26수정-로그인후 리턴하는 값을 유저이름에서 user객체로 변경.
	 		return dao.loginUser(email,pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 	return null;
	}
}
