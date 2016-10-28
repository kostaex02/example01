package watermelon.daointerface;

import java.sql.SQLException;
import java.util.List;

import watermelon.dto.Review;

public interface ReviewInterface {
	/**
	 *  ��� ���� �˻�
	 */
	List<Review> selectReviewAll() throws SQLException;
	
	/**
	 *  id�� ���� �˻�
	 */
	List<Review> selectReviewId(String reviewId) throws SQLException;
	
	/**
	 *  ��¥�� ���� �˻�
	 */
	List<Review> selectReivewDate(String riviewDate) throws SQLException;
	
	/**
	 *  ���� ����
	 */
	int insertReview(Review review) throws SQLException;
	
	/**
	 *  ���� ����
	 */
	int deleteReview(String review_id) throws SQLException;
	
	/**
	 *  ���� ����
	 */
	int updateReivew(String review_id, String review_contents) throws SQLException;
}	
