package watermelon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
				Song song = new Song(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getInt(7));
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
		PreparedStatement pr = null;
		ResultSet rs = null;

		try {
			con = DBUtil.getConnection();
			pr = con.prepareStatement("select * from song where song_name = ?");
			pr.setString(1, songName);
			rs = pr.executeQuery();

			while (rs.next()) {
				Song song = new Song(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getInt(7));
				list.add(song);
			}
		} finally {
			DBUtil.dbClose(con, pr, rs);
		}
		return list;
	}

	@Override
	public List<Song> selectSongArtist(String songArtist) throws SQLException {
		List<Song> list = new ArrayList<Song>();
		Connection con = null;
		PreparedStatement pr = null;
		ResultSet rs = null;

		try {
			con = DBUtil.getConnection();
			pr = con.prepareStatement("select * from song where song_artist = ?");
			pr.setString(1, songArtist);
			rs = pr.executeQuery();

			while (rs.next()) {
				Song song = new Song(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getInt(7));
				list.add(song);
			}
		} finally {
			DBUtil.dbClose(con, pr, rs);
		}
		return list;
	}

	@Override
	public List<Song> selectSongAlbum(String songAlbum) throws SQLException {
		List<Song> list = new ArrayList<Song>();
		Connection con = null;
		PreparedStatement pr = null;
		ResultSet rs = null;

		try {
			con = DBUtil.getConnection();
			pr = con.prepareStatement("select * from song where song_album=?");
			rs = pr.executeQuery();

			while (rs.next()) {
				Song song = new Song(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getInt(7));
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
			pr.setString(1, song.getSongName());
			pr.setString(2, song.getSongArtist());
			pr.setString(3, song.getGenreCode());
			pr.setString(4, song.getSongAlbum());
			pr.setString(5, song.getSongUrl());
			pr.setString(6, song.getSongImgUrl());
			pr.setInt(7, song.getSongTitle());
			result = pr.executeUpdate();
		} finally {
			DBUtil.dbClose(con, pr, null);
		}
		return result;
	}

	@Override
	public int deleteSong(String songName, String songArtist) throws SQLException {
		Connection con = null;
		PreparedStatement pr = null;
		int result = 0;
		try{
			con = DBUtil.getConnection();
			pr = con.prepareStatement("delete from song where song_name = ? and song_artist = ?");
			pr.setString(1, songName);
			pr.setString(2, songArtist);
			result = pr.executeUpdate();
		}finally{
			DBUtil.dbClose(con, pr, null);
		}
		return result;
	}

}
