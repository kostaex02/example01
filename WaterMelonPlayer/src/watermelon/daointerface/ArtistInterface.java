package watermelon.daointerface;

import java.sql.SQLException;
import java.util.List;

import watermelon.dto.Artist;

public interface ArtistInterface {
	/**
	 * ��� ���� �˻�
	 */
	List<Artist> selectArtistAll() throws SQLException;
	
	/**
	 * �帣�� ���� ���� �˻�
	 */
	//List<Artist> selectGenreArtist() throws SQLException;
	
	/**
	 *  ���� �߰�
	 */
	//int insertArtist(Artist artist) throws SQLException;
	
	/**
	 *  ���� ����
	 */
	//int deleteArtist() throws SQLException;
	
	/**
	 *  ���� ����
	 */
	//int updateArtist() throws SQLException;
}
