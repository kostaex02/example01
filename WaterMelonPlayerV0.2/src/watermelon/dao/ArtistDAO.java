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
		String sql = "select * from artist where artist_NAME like '%"+content+"%'";
		List<Artist> list = new ArrayList<>();
		
		try {
			con = DBUtil.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
				
			/*
			artist_no number primary key,	-- 아티스트별 코드
			artist_name varchar2(25) not null, -- 아티스트 이름
			artist_gender number, 	--아티스트 성별 남 0 여 1
			artist_group number	-- 아티스트 그룹 구분
			*/
				
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
