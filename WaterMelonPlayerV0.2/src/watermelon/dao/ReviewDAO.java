package watermelon.dao;

import java.sql.SQLException;
import java.util.List;

import watermelon.daointerface.ReviewInterface;
import watermelon.dto.Review;

public class ReviewDAO implements ReviewInterface {

	@Override
	public List<Review> selectReviewAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Review> selectReviewId(String reviewId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Review> selectReivewDate(String riviewDate) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertReview(Review review) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteReview(int review_no) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
