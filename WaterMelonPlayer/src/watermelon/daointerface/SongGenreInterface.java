package watermelon.daointerface;

import java.sql.SQLException;

import watermelon.dto.SongGenre;

public interface SongGenreInterface {
	/**
	 * 장르코드에 따른 장르이름
	 */
	SongGenre selectGerneName(String genereCode) throws SQLException;

}
