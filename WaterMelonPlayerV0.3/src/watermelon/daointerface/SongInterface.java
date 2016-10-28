package watermelon.daointerface;

import java.sql.SQLException;
import java.util.List;

import watermelon.dto.Song;

public interface SongInterface {
	/**
	 * 모든 곡 검색
	 */
	List<Song> selectSongAll() throws SQLException;
	
	/**
	 * 곡이름 검색
	 */
	List<Song> selectSongName(String songName) throws SQLException;
	
	/**
	 *  가수이름 검색
	 */
	List<Song> selectSongArtist(int songArtist) throws SQLException;
	
	/**
	 *  앨범이름 검색
	 */
	List<Song> selectSongAlbum(int songAlbum) throws SQLException;
	
	/**
	 *  선택곡 삽입
	 */
	int insertSong(Song song) throws SQLException;
	
	/**
	 *  선택곡 삭제
	 */
	int deleteSong(String songName, int songArtist) throws SQLException;
	
	
}
