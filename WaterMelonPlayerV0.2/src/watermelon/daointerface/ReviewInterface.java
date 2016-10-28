package watermelon.daointerface;

import java.sql.SQLException;
import java.util.List;

import watermelon.dto.Review;

public interface ReviewInterface {
	/**
	 *  ¸ðµç ¸®ºä °Ë»ö
	 */
	List<Review> selectReviewAll() throws SQLException;
	
	/**
	 *  idº° ¸®ºä °Ë»ö
	 */
	List<Review> selectReviewId(String reviewId) throws SQLException;
	
	/**
	 *  ³¯Â¥º° ¸®ºä °Ë»ö
	 */
	List<Review> selectReivewDate(String riviewDate) throws SQLException;
	
	/**
	 *  ¸®ºä »ðÀÔ
	 */
	int insertReview(Review review) throws SQLException;
	
	/**
	 *  ¸®ºä »èÁ¦
	 */
	int deleteReview(String review_id) throws SQLException;
	
	/**
	 *  ¸®ºä ¼öÁ¤
	 */
	int updateReivew(String review_id, String review_contents) throws SQLException;
}	
