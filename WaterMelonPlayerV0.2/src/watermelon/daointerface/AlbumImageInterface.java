package watermelon.daointerface;

import java.sql.SQLException;

import watermelon.dto.AlbumImage;

public interface AlbumImageInterface {
	/**
	 *  �ٹ� no �� ���� url 
	 */
	AlbumImage selectImgUrl(int no) throws SQLException;
}
