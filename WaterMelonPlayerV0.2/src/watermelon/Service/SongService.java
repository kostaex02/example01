package watermelon.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import watermelon.dao.ReviewDAO;
import watermelon.dto.Review;

public class SongService {
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
}
