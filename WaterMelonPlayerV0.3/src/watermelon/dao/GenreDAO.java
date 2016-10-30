package watermelon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import watermelon.util.DBUtil;

public class GenreDAO {
	
	
	public String selectGenre(int genreCode) {
		Connection con =null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select genre_name from genre where genre_code="+genreCode;	
		String genre =null;
		try {
			con = DBUtil.getConnection();
			
			st = con.createStatement();
			rs = st.executeQuery(sql);
			genre = rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return genre;

	}
	
	
}
