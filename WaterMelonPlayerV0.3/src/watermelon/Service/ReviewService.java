package watermelon.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import watermelon.dao.ReviewDAO;
import watermelon.dto.Review;

public class ReviewService {
	/**
	 * 
	 */
	public static List<Review> selectReviewAll(){
		//List<Review> list = new ArrayList<>();
		ReviewDAO dao = new ReviewDAO();
		
		try {
			return dao.selectReviewAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	public static int insertReview(String id, String contents){
		ReviewDAO dao = new ReviewDAO();
		
		try{
			return dao.insertReview(id,contents);
		} catch(SQLException e){
			e.printStackTrace();
		}
		return 0;
	}
	public static int deleteReview(int no, String id){
		ReviewDAO dao = new ReviewDAO();
		
		try{
			return dao.deleteReview(no,id);
		} catch(SQLException e){
			e.printStackTrace();
		}
		return 0;
	}
}
