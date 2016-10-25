package watermelon.daointerface;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import watermelon.dto.Album;

public interface AlbumInterface {
	/**
	 *	��� �ٹ� �˻� 
	 */
	List<Album> selectAlbumAll() throws SQLException;
	
	/**
	 *  ������ ���� �ٹ� �˻�
	 */
	List<Album> selectArtistAlbum(String songArtist) throws SQLException;
	
	/**
	 *  �帣�� ���� �ٹ� �˻�
	 */
	List<Album> selectGenreAlbum(String genreCode) throws SQLException;
	
	/**
	 *  �ٹ� ��¥�� ���� �ٹ� �˻�
	 */
	List<Album> selectDateAlbum(Date debutDate) throws SQLException;
	
	/**
	 *  �ٹ� �߰�
	 */
	int insertAlbum(Album album) throws SQLException;
	
	/**
	 *  �ٹ� ����
	 */
	int deleteAlbum(String songArtist, String songAlbum) throws SQLException;
	
	/**
	 *  �ٹ� ����
	 */
	//int updateAlbum() throws SQLException;
}
