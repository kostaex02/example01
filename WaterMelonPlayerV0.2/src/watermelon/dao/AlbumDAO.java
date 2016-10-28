package watermelon.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import watermelon.util.DBUtil;

public class AlbumDAO {
	public String selectAlbum(int AlbumNo){
		System.out.println("AlbumDAOÀÇ "+AlbumNo);
		Connection con=null;
		Statement st = null;
		ResultSet rs=null;
		String sql = "select album_name from album where album_no="+AlbumNo;
		String AlbumName=null; 	
		try{
			con = DBUtil.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				AlbumName = rs.getString(1);
				System.out.println("AlbumName : "+AlbumName);
			}
		}catch(SQLException e){
			e.getStackTrace();
		}finally {
			DBUtil.dbClose(con, st, rs);
		}
		return AlbumName;
	}
}
