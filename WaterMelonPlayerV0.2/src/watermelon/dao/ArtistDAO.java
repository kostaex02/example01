package watermelon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import watermelon.util.DBUtil;

public class ArtistDAO {
	
	public String selectArtist(int artistNo){
		Connection con=null;
		Statement st = null;
		ResultSet rs=null;
		String sql = "select artist_name from artist where artist_no="+artistNo;
		String artist = null ;
		try{
			con = DBUtil.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				artist = rs.getString(1);
			}
		}catch(SQLException e){
			e.getStackTrace();
		}finally {
			DBUtil.dbClose(con, st, rs);
		}

		return artist ;
	}
}
