package watermelon.daointerface;

import java.sql.SQLException;
import java.util.List;

import watermelon.dto.Artist;

public interface ArtistInterface {
	/**
	 *  아티스트 모두 검색
	 */
	List<Artist> selectArtistAll() throws SQLException;
	
	/**
	 *  이름 별 아티스트 검색
	 */
	List<Artist> selectArtist(String artistName) throws SQLException;
	
	/**
	 *  
	 */
	
}
