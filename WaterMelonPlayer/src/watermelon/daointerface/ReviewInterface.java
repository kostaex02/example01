package watermelon.daointerface;

import java.sql.SQLException;
import java.util.List;

import watermelon.dto.Review;

public interface ReviewInterface {
	/**
	 *  모든 review 검색
	 */
	List<Review> selectReview() throws SQLException;
	
	/**
	 * 회원에 따른 review 검색
	 */
	List<Review> selectMemberReview(String reviewId) throws SQLException;
	
	/**
	 * 앨범에 따른 review 검색
	 */
	List<Review> selectAlbumReview(String reviewAlbum) throws SQLException;
	
}	
