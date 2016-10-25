package watermelon.daointerface;

import java.sql.SQLException;
import java.util.List;

import watermelon.dto.Review;

public interface ReviewInterface {
	/**
	 *  ��� review �˻�
	 */
	List<Review> selectReview() throws SQLException;
	
	/**
	 * ȸ���� ���� review �˻�
	 */
	List<Review> selectMemberReview(String reviewId) throws SQLException;
	
	/**
	 * �ٹ��� ���� review �˻�
	 */
	List<Review> selectAlbumReview(String reviewAlbum) throws SQLException;
	
}	
