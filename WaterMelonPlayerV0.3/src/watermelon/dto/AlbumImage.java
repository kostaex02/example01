package watermelon.dto;

public class AlbumImage {
	private String albumImageUrl;
	private int albumNo;
	
	public AlbumImage(){}

	public AlbumImage(String albumImageUrl, int albumNo) {
		this.albumImageUrl = albumImageUrl;
		this.albumNo = albumNo;
	}

	public String getAlbumImageUrl() {
		return albumImageUrl;
	}

	public void setAlbumImageUrl(String albumImageUrl) {
		this.albumImageUrl = albumImageUrl;
	}

	public int getAlbumNo() {
		return albumNo;
	}

	public void setAlbumNo(int albumNo) {
		this.albumNo = albumNo;
	}
	
}
