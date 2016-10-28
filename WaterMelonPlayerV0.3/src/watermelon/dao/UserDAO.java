package watermelon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import watermelon.daointerface.UserInterface;
import watermelon.dto.User;
import watermelon.util.DBUtil;

public class UserDAO implements UserInterface {

	@Override
	public List<User> selectUserAll() throws SQLException {
		List<User> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pr = null;
		ResultSet rs = null;
		try{
			con = DBUtil.getConnection();
			pr = con.prepareStatement("select * from user_table");
			rs = pr.executeQuery();
			
			while(rs.next()){
				User user = new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6));
				list.add(user);
			}
		}finally{
			DBUtil.dbClose(con, pr, rs);
		}
		return list;
	}

	@Override
	public User selectUser(String userId) throws SQLException {
		User user = null;
		Connection con = null;
		PreparedStatement pr = null;
		ResultSet rs = null;
		try{
			con = DBUtil.getConnection();
			pr = con.prepareStatement("select * from user_table where user_id=?");
			pr.setString(1, userId);
			rs = pr.executeQuery();
			
			if(rs.next()){
				user = new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6));
			}
		}finally{
			DBUtil.dbClose(con, pr, rs);
		}
		return user;
	}

	@Override
	public int deleteUser(String userId) throws SQLException {
		int result = 0;
		Connection con = null;
		PreparedStatement pr = null;
		
		try{
			con = DBUtil.getConnection();
			pr = con.prepareStatement("delete from user_table where user_id=?");
			pr.setString(1, userId);
			result = pr.executeUpdate();
		}finally{
			DBUtil.dbClose(con, pr, null);
		}
		return result;
	}

	@Override
	public int updateUser(String newPwd, String id) throws SQLException {
		int result = 0;
		Connection con = null;
		PreparedStatement pr = null;
		try{
			con = DBUtil.getConnection();
			pr = con.prepareStatement("update user_table set user_password = ? where user_id=?");
			pr.setString(1, newPwd);
			pr.setString(2, id);
			result = pr.executeUpdate();
		}finally{
			DBUtil.dbClose(con, pr, null);
		}
		return result;
	}

	@Override
	public int insertUser(User user) throws SQLException {
		int result = 0;
		Connection con = null;
		PreparedStatement pr = null;
		try{
			con = DBUtil.getConnection();
			pr = con.prepareStatement("insert into user_table values(?,?,?,?,?,?)");
			pr.setString(1, user.getUserId());
			pr.setString(2, user.getUserPassword());
			pr.setString(3, user.getUserName());
			pr.setString(4, user.getUserBirth());
			pr.setInt(5, user.getUserGender());
			pr.setInt(6, user.getUserCheck());
			result = pr.executeUpdate();
		}finally{
			DBUtil.dbClose(con, pr, null);
		}
		return result;
	}
	
	@Override
	public User loginUser(String userId, String pwd) throws SQLException {
		
		User user = null;
		Connection con = null;
		PreparedStatement pr = null;
		ResultSet rs = null;
		try{
			con = DBUtil.getConnection();
			pr = con.prepareStatement("select * from user_table where user_id=? and user_password=?");
			pr.setString(1, userId);
			pr.setString(2, pwd);
			rs = pr.executeQuery();
			if(rs.next()){
				user = new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6));
			}
		}finally{
			DBUtil.dbClose(con, pr, rs);
		}
		return user;
	}

}
