package watermelon.daointerface;

import java.sql.SQLException;
import java.util.List;

import watermelon.dto.Song;

public interface SongInterface {
	/**
	 * ��� �� �˻�
	 */
	List<Song> selectSongAll() throws SQLException;
	
	/**
	 * ���̸� �˻�
	 */
	List<Song> selectSongName(String songName) throws SQLException;
	
	/**
	 *  �����̸� �˻�
	 */
	List<Song> selectSongArtist(int songArtist) throws SQLException;
	
	/**
	 *  �ٹ��̸� �˻�
	 */
	List<Song> selectSongAlbum(int songAlbum) throws SQLException;
	
	/**
	 *  ���ð� ����
	 */
	int insertSong(Song song) throws SQLException;
	
	/**
	 *  ���ð� ����
	 */
	int deleteSong(String songName, int songArtist) throws SQLException;
	
	
}
