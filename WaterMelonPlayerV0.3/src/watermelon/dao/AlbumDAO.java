package watermelon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import watermelon.dto.Album;
import watermelon.util.DBUtil;

public class AlbumDAO {
	public String selectAlbumName(int AlbumNo){
		System.out.println("AlbumDAO�� "+AlbumNo);
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
	
	public List<Album> selectAlbum(int albumNo){
		List<Album> album = new ArrayList<>();
		Connection con=null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		
		try{
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select * from album where album_no = ?");
			ps.setInt(1, albumNo);
			rs = ps.executeQuery();
			while(rs.next()){
				album.add(new Album(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5))); ;
			}
		}catch(SQLException e){
			e.getStackTrace();
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return album;
	}
	
	public String selectAlbumUrl(int AlbumNo){
		String url;
		Connection con=null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		try{
			con = DBUtil.getConnection();
			con.prepareStatement("select ");
		}
		return url;
	}
}
