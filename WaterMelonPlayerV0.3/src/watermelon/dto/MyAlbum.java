package watermelon.dto;

public class MyAlbum {
	private int myAlbumNo;
	private String userId;
	private int songNo;
	private String songName;
	private String artistName;
	private String albumName;
	private String songUrl;
	private String imgUrl;
	
	public MyAlbum(){}
	public MyAlbum(int myAlbumNo, String userId, int songNo, String songName, String artistName, String albumName, String songUrl,
			String imgUrl) {
		this.myAlbumNo = myAlbumNo;
		this.userId = userId;
		this.songNo = songNo;
		this.songName = songName;
		this.artistName = artistName;
		this.albumName = albumName;
		this.songUrl = songUrl;
		this.imgUrl = imgUrl;
	}

	public int getMyAlbumNo() {
		return myAlbumNo;
	}

	public void setMyAlbumNo(int myAlbumNo) {
		this.myAlbumNo = myAlbumNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public String getSongUrl() {
		return songUrl;
	}

	public void setSongUrl(String songUrl) {
		this.songUrl = songUrl;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public int getSongNo() {
		return songNo;
	}
	public void setSongNo(int songNo) {
		this.songNo = songNo;
	}
}
