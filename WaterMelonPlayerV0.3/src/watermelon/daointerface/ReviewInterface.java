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
	int insertReview(String id, String contents) throws SQLException;
	
	/**
	 *  ���� ����
	 */
	int deleteReview(int no, String id) throws SQLException;
	
	/**
	 *  ���� ����
	 */
	int updateReivew(String id, String contents) throws SQLException;
}	
