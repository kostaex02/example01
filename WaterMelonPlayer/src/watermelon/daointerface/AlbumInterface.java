package watermelon.daointerface;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import watermelon.dto.Album;

public interface AlbumInterface {
	/**
	 *	모든 앨범 검색 
	 */
	List<Album> selectAlbumAll() throws SQLException;
	
	/**
	 *  가수에 따른 앨범 검색
	 */
	List<Album> selectArtistAlbum(String songArtist) throws SQLException;
	
	/**
	 *  장르에 따른 앨범 검색
	 */
	List<Album> selectGenreAlbum(String genreCode) throws SQLException;
	
	/**
	 *  앨범 날짜에 따른 앨범 검색
	 */
	List<Album> selectDateAlbum(Date debutDate) throws SQLException;
	
	/**
	 *  앨범 추가
	 */
	int insertAlbum(Album album) throws SQLException;
	
	/**
	 *  앨범 삭제
	 */
	int deleteAlbum(String songArtist, String songAlbum) throws SQLException;
	
	/**
	 *  앨범 수정
	 */
	//int updateAlbum() throws SQLException;
}
