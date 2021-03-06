package watermelon.Service;

import java.sql.SQLException;
import java.util.List;

import watermelon.dao.MyAlbumDAO;
import watermelon.dao.UserDAO;
import watermelon.dto.Album;
import watermelon.dto.MyAlbum;
import watermelon.dto.User;

public class UserService {
	static UserDAO userDAOdao = new UserDAO();
	static MyAlbumDAO myAlbumDAO = new MyAlbumDAO();
	public static String login(String email, String pwd) {
	 	try {
	 		User user = userDAOdao.loginUser(email,pwd);
			String userName = user.getUserName();
			return userName;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 	return null;
	}
	
	public boolean insert(User user){
		try {
			int i = userDAOdao.insertUser(user);
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
	public static List<MyAlbum> getMyalbum(String id) {
		List<MyAlbum> list = null;
		try {
			list = myAlbumDAO.getMyAlbum(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//비밀번호 확인후 일치할경우 비밀번호를 새로운 비밀번호로 변경
	public static boolean pwdChange(String id, String oldPwd, String newPwd) {
		try {
			if (userDAOdao.loginUser(id, oldPwd)!=null) {
				if (userDAOdao.updateUser(newPwd, id)>0) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
