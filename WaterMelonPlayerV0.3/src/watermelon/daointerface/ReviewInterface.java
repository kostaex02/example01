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
	int insertReview(String id, String contents) throws SQLException;
	
	/**
	 *  ¸®ºä »èÁ¦
	 */
	int deleteReview(int no, String id) throws SQLException;
	
	/**
	 *  ¸®ºä ¼öÁ¤
	 */
	int updateReivew(String id, String contents) throws SQLException;
}	
