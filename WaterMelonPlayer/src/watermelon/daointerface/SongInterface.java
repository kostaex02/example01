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
	List<Song> selectSongArtist(String songArtist) throws SQLException;
	
	/**
	 *  �ٹ��̸� �˻�
	 */
	List<Song> selectSongAlbum(String songAlbum) throws SQLException;
	
	/**
	 *  ���ð� ����
	 */
	int insertSong(Song song) throws SQLException;
	
	/**
	 *  ���ð� ����
	 */
	int deleteSong(Song song) throws SQLException;
	
	
}
