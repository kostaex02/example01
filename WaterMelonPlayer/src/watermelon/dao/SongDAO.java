package watermelon.dao;

import java.sql.SQLException;
import java.util.List;

import watermelon.daointerface.SongInterface;
import watermelon.dto.Song;

public class SongDAO implements SongInterface {

	@Override
	public List<Song> selectSongAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Song> selectSongName(String songName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Song> selectSongArtist(String songArtist) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Song> selectSongAlbum(String songAlbum) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertSong(Song song) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteSong(Song song) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
