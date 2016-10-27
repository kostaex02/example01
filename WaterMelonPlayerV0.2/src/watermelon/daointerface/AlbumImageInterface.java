package watermelon.daointerface;

import java.sql.SQLException;

import watermelon.dto.AlbumImage;

public interface AlbumImageInterface {
	/**
	 *  앨범 no 를 통한 url 
	 */
	AlbumImage selectImgUrl(int no) throws SQLException;
}
