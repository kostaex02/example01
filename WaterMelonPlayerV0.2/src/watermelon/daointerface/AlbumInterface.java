package watermelon.daointerface;

import java.sql.SQLException;
import java.util.List;

import watermelon.dto.Album;

public interface AlbumInterface {
	
	/**
	 *  ��ü �ٹ�
	 */
	List<Album> selectAlbumAll() throws SQLException;
	
	/**
	 *  ������ �ٹ� �˻�
	 */
	List<Album> selectAlbumName(String albumName) throws SQLException;
	
	
}
