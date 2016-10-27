package watermelon.daointerface;

import java.sql.SQLException;
import java.util.List;

import watermelon.dto.MyAlbum;

public interface MyAlbumInterface {
	/**
	 * 아이디에 해당하는 마이앨범을 찾아서 리스트에 담아 리턴
	 * @return 마이앨범의 곡의 정보가 담긴 MyAlbum객체
	 * @throws SQLException
	 */
	List<MyAlbum> getMyAlbum(String id) throws SQLException;
}
