package watermelon.dto;

public class ArtistImage {
	private String artistImgUrl;
	private String artistNo;
	
	public ArtistImage(){}
	public ArtistImage(String artistImgUrl, String artistNo) {
		this.artistImgUrl = artistImgUrl;
		this.artistNo = artistNo;
	}
	public String getArtistImgUrl() {
		return artistImgUrl;
	}
	public void setArtistImgUrl(String artistImgUrl) {
		this.artistImgUrl = artistImgUrl;
	}
	public String getArtistNo() {
		return artistNo;
	}
	public void setArtistNo(String artistNo) {
		this.artistNo = artistNo;
	}
	
}
