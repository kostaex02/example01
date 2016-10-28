package watermelon.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import watermelon.util.DBUtil;

public class AlbumDAO {
	public String selectAlbum(int AlbumNo){
		Connection con=null;
		Statement st = null;
		ResultSet rs=null;
		String sql = "select album_name from album where album_no="+AlbumNo;
		String AlbumName=null; 	
		try{
			con = DBUtil.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			AlbumName = rs.getString(1);	
		}catch(SQLException e){
			e.getStackTrace();
		}finally {
			DBUtil.dbClose(con, st, rs);
		}
		return AlbumName;
	}
}
