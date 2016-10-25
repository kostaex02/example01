package watermelon.daointerface;

import java.sql.SQLException;
import java.util.List;

import watermelon.dto.Artist;

public interface ArtistInterface {
	/**
	 * 모든 가수 검색
	 */
	List<Artist> selectArtistAll() throws SQLException;
	
	/**
	 * 장르에 따른 가수 검색
	 */
	//List<Artist> selectGenreArtist() throws SQLException;
	
	/**
	 *  가수 추가
	 */
	//int insertArtist(Artist artist) throws SQLException;
	
	/**
	 *  가수 삭제
	 */
	//int deleteArtist() throws SQLException;
	
	/**
	 *  가수 수정
	 */
	//int updateArtist() throws SQLException;
}
