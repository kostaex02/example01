package watermelon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import watermelon.daointerface.ReviewInterface;
import watermelon.dto.Review;
import watermelon.util.DBUtil;

public class ReviewDAO implements ReviewInterface {

	@Override
	public List<Review> selectReviewAll() throws SQLException {
		Connection con = null;
		PreparedStatement pr = null;
		ResultSet rs = null;
		List<Review> list = new ArrayList<>();
		
		try{
			con = DBUtil.getConnection();
			pr = con.prepareStatement("select * from review");
			rs = pr.executeQuery();
			
			while(rs.next()){
				Review review = new Review(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				list.add(review);
			}
		}finally{
			DBUtil.dbClose(con, pr, rs);
		}
		return list;
	}

	@Override
	public List<Review> selectReviewId(String reviewId) throws SQLException {
		Connection con = null;
		PreparedStatement pr = null;
		ResultSet rs = null;
		List<Review> list = new ArrayList<>();
		
		try{
			con = DBUtil.getConnection();
			pr = con.prepareStatement("select * from review where review_id = ?");
			pr.setString(1, reviewId);
			rs = pr.executeQuery();
			
			while(rs.next()){
				Review review = new Review(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				list.add(review);
			}
		}finally{
			DBUtil.dbClose(con, pr, rs);
		}
		return list;
	}

	@Override
	public List<Review> selectReivewDate(String riviewDate) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertReview(String id, String contents) throws SQLException {
		Connection con = null;
		PreparedStatement pr = null;
		int result = 0;
		try{
			con = DBUtil.getConnection();
			pr = con.prepareStatement("insert into review values(REVIEW_NO.nextval,?,?,sysdate)");
			pr.setString(1, id);
			pr.setString(2, contents);
			result = pr.executeUpdate();
		}finally{
			DBUtil.dbClose(con, pr, null);
		}
		return result;
	}

	@Override
	public int deleteReview(String review_id) throws SQLException {
		Connection con = null;
		PreparedStatement pr = null;
		int result = 0;
		try{
			con = DBUtil.getConnection();
			pr = con.prepareStatement("delete from review where review_id = ?");
			pr.setString(1	, review_id);
			result = pr.executeUpdate();
		}finally{
			DBUtil.dbClose(con, pr, null);
		}
		return result;
	}

	@Override
	public int updateReivew(String review_id, String review_contents) throws SQLException {
		Connection con = null;
		PreparedStatement pr = null;
		int result = 0;
		try{
			con = DBUtil.getConnection();
			pr = con.prepareStatement("update review set review_contents = ? where review_id = ?");
			pr.setString(1, review_id);
			pr.setString(2, review_contents);
			result = pr.executeUpdate();
		}finally{
			DBUtil.dbClose(con, pr, null);
		}
		return result;
	}
	
}
