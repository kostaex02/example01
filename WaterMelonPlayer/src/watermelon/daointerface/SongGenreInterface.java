package watermelon.daointerface;

import java.sql.SQLException;

import watermelon.dto.SongGenre;

public interface SongGenreInterface {
	/**
	 * �帣�ڵ忡 ���� �帣�̸�
	 */
	SongGenre selectGerneName(String genereCode) throws SQLException;

}
