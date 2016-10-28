package watermelon.daointerface;

import java.sql.SQLException;
import java.util.List;

import watermelon.dto.Album;

public interface AlbumInterface {
	
	/**
	 *  전체 앨범
	 */
	List<Album> selectAlbumAll() throws SQLException;
	
	/**
	 *  선택적 앨범 검색
	 */
	List<Album> selectAlbumName(String albumName) throws SQLException;
	
	
}
