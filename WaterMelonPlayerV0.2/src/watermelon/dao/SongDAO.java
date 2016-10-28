package watermelon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import watermelon.daointerface.SongInterface;
import watermelon.dto.Song;
import watermelon.util.DBUtil;

public class SongDAO implements SongInterface {

	@Override
	public List<Song> selectSongAll() throws SQLException {
		List<Song> list = new ArrayList<Song>();
		Connection con = null;
		PreparedStatement pr = null;
		ResultSet rs = null;
		
		try {
			con = DBUtil.getConnection();
			pr = con.prepareStatement("select * from song");
			rs = pr.executeQuery();
			while (rs.next()) {
				
				Song song = new Song(rs.getInt(1), rs.getString(2),rs.getInt(3), rs.getString(4),
						rs.getInt(5), rs.getString(6), rs.getInt(7));
				
				list.add(song);
			}
		} finally {
			DBUtil.dbClose(con, pr, rs);
		}
		return list;
	}

	@Override
	public List<Song> selectSongName(String songName) throws SQLException {
		List<Song> list = new ArrayList<Song>();
		Connection con = null;
		Statement st=null;;
		ResultSet rs = null;
		String sql = "SELECT * FROM song WHERE song_name LIKE '%"+songName.trim()+"%'" ;
		
		try {
			con = DBUtil.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			ArtistDAO artistDao =new ArtistDAO();
			AlbumDAO albumDao = new AlbumDAO();
			while (rs.next()) {
				Song song = new Song(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),
						rs.getInt(5), rs.getString(6), rs.getInt(7),artistDao.selectArtist(rs.getInt(3)),albumDao.selectAlbum(rs.getInt(5)));
				list.add(song);
			}	
		} finally {
			DBUtil.dbClose(con, st, rs);
		}
		return list;
	}

	@Override
	public List<Song> selectSongArtist(int songArtist) throws SQLException {
		List<Song> list = new ArrayList<Song>();
		Connection con = null;
		PreparedStatement pr = null;
		ResultSet rs = null;

		try {
			con = DBUtil.getConnection();
			pr = con.prepareStatement("select * from song where artist_code = ?");
			pr.setInt(1, songArtist);
			rs = pr.executeQuery();

			while (rs.next()) {
				Song song = new Song(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),
						rs.getInt(5), rs.getString(6), rs.getInt(7));
				list.add(song);
			}
		} finally {
			DBUtil.dbClose(con, pr, rs);
		}
		return list;
	}

	@Override
	public List<Song> selectSongAlbum(int songAlbum) throws SQLException {
		List<Song> list = new ArrayList<Song>();
		Connection con = null;
		PreparedStatement pr = null;
		ResultSet rs = null;

		try {
			con = DBUtil.getConnection();
			pr = con.prepareStatement("select * from song where album_code=?");
			rs = pr.executeQuery();

			while (rs.next()) {
				Song song = new Song(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),
						rs.getInt(5), rs.getString(6), rs.getInt(7));
				list.add(song);
			}
		} finally {
			DBUtil.dbClose(con, pr, rs);
		}
		return list;
	}

	@Override
	public int insertSong(Song song) throws SQLException {
		Connection con = null;
		PreparedStatement pr = null;
		int result = 0;
		try {
			con = DBUtil.getConnection();
			pr = con.prepareStatement("insert into song values (?,?,?,?,?,?,?)");
			pr.setInt(1, song.getSongNo());
			pr.setString(2, song.getSongName());
			pr.setInt(3, song.getArtistCode());
			pr.setString(4, song.getGenreCode());
			pr.setInt(5, song.getAlbumCode());
			pr.setString(6, song.getAlbumImgUrl());
			pr.setInt(7, song.getSongTitle());
			result = pr.executeUpdate();
		} finally {
			DBUtil.dbClose(con, pr, null);
		}
		return result;
	}

	@Override
	public int deleteSong(String songName, int songArtist) throws SQLException {
		Connection con = null;
		PreparedStatement pr = null;
		int result = 0;
		try{
			con = DBUtil.getConnection();
			pr = con.prepareStatement("delete from song where song_name = ? and artist_code = ?");
			pr.setString(1, songName);
			pr.setInt(2, songArtist);
			result = pr.executeUpdate();
		}finally{
			DBUtil.dbClose(con, pr, null);
		}
		return result;
	}

}
