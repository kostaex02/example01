package watermelon.dto;

public class Song {
	private int songNo;
	private String songName;
	private int artistCode;
	private String genreCode;
	private int albumCode;
	private String albumImgUrl;
	private int songTitle;
	
	public Song(){}

	public Song(int songNo, String songName, int artistCode, String genreCode, int albumCode, String albumImgUrl,
			int songTitle) {
		this.songNo = songNo;
		this.songName = songName;
		this.artistCode = artistCode;
		this.genreCode = genreCode;
		this.albumCode = albumCode;
		this.albumImgUrl = albumImgUrl;
		this.songTitle = songTitle;
	}

	public int getSongNo() {
		return songNo;
	}

	public void setSongNo(int songNo) {
		this.songNo = songNo;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public int getArtistCode() {
		return artistCode;
	}

	public void setArtistCode(int artistCode) {
		this.artistCode = artistCode;
	}

	public String getGenreCode() {
		return genreCode;
	}

	public void setGenreCode(String genreCode) {
		this.genreCode = genreCode;
	}

	public int getAlbumCode() {
		return albumCode;
	}

	public void setAlbumCode(int albumCode) {
		this.albumCode = albumCode;
	}

	public String getAlbumImgUrl() {
		return albumImgUrl;
	}

	public void setAlbumImgUrl(String albumImgUrl) {
		this.albumImgUrl = albumImgUrl;
	}

	public int getSongTitle() {
		return songTitle;
	}

	public void setSongTitle(int songTitle) {
		this.songTitle = songTitle;
	}
	
}
