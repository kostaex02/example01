package watermelon.daointerface;

import java.sql.SQLException;
import java.util.List;

import watermelon.dto.Artist;

public interface ArtistInterface {
	/**
	 *  ��Ƽ��Ʈ ��� �˻�
	 */
	List<Artist> selectArtistAll() throws SQLException;
	
	/**
	 *  �̸� �� ��Ƽ��Ʈ �˻�
	 */
	List<Artist> selectArtist(String artistName) throws SQLException;
	
	/**
	 *  
	 */
	
}
