package watermelon.daointerface;

import java.sql.SQLException;

import watermelon.dto.SongGenre;

public interface SongGenreInterface {
	/**
	 * �帣�ѹ��� ���� �帣
	 */
	SongGenre selectSongGenre(int no) throws SQLException;

}
