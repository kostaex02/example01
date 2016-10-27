package watermelon.daointerface;

import java.sql.SQLException;

import watermelon.dto.SongGenre;

public interface SongGenreInterface {
	/**
	 * 장르넘버에 따른 장르
	 */
	SongGenre selectSongGenre(int no) throws SQLException;

}
