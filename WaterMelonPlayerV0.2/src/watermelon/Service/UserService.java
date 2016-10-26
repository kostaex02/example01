package watermelon.Service;

import java.sql.SQLException;
import java.util.List;

import watermelon.dao.UserDAO;
import watermelon.dto.Album;
import watermelon.dto.User;

public class UserService {
	UserDAO dao = new UserDAO();
	User user = new User();
	public String login(String email, String pwd) {
	 	try {
	 		user = dao.loginUser(email,pwd);
			String userName = user.getUserName();
			return userName;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 	return null;
	}
	
	public boolean insert(User user){
		try {
			int i = dao.insertUser(user);
			if(i>0){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	//유저 아이디로 해당아이디의 앨범을 검색해서 리턴
	public static List<Album> getMyalbum(String id) {
		//10.26 DAO생성후 추가 요망
		return null;
	}
}
