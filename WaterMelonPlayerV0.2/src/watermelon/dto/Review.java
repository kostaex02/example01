package watermelon.dto;

public class Review {
	private int reviewNo;
	private String reviewId;
	private String reviewContents;
	private String reviewDate;
	
	public Review(){}
	public Review(int reviewNo, String reviewId, String reviewContents, String reviewDate) {
		this.reviewNo = reviewNo;
		this.reviewId = reviewId;
		this.reviewContents = reviewContents;
		this.reviewDate = reviewDate;
	}
	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public String getReviewId() {
		return reviewId;
	}
	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}
	public String getReviewContents() {
		return reviewContents;
	}
	public void setReviewContents(String reviewContents) {
		this.reviewContents = reviewContents;
	}
	public String getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}
	
}
