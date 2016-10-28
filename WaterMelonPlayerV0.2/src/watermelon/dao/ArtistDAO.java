package watermelon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import watermelon.Service.SelectArtist;
import watermelon.dto.Album;
import watermelon.dto.Artist;
import watermelon.util.DBUtil;

public class ArtistDAO {
	
	public String selectArtistName(int artistNo)  throws SQLException{
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
		
		}finally {
			DBUtil.dbClose(con, st, rs);
		}

		return artist ;
	}
	
	public List<Artist> selectArtist(String content) throws SQLException{
		Connection con=null;
		Statement st = null;
		ResultSet rs=null;
		String sql = "select * from album where ALBUM_NAME like '%"+content+"%'";
		List<Artist> list = new ArrayList<>();
		
		try {
			con = DBUtil.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				list.add(new Artist(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4)));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
