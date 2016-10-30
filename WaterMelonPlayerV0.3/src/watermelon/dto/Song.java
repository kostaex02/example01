package watermelon.dto;

public class Song {
	private int songNo;
	private String songName;
	private int artistCode;
	private String genreCode;
	private int albumCode;
	private String albumImgUrl;
	private int songTitle;
	private String aristName;
	private String albumName;
	
	//플레이리스트를 위한 인수값 DB에는 저장 불필요.
	private int isPlay;
	private int isChecked;
	private String url;
	public int getIsChecked() {
		return isChecked;
	}
	public void setIsChecked(int isChecked) {
		this.isChecked = isChecked;
	}
	public int getIsPlay() {
		return isPlay;
	}
	public void setIsPlay(int isPlay) {
		this.isPlay = isPlay;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Song(String songName, String aristName, String albumImgUrl,
			String url, int isPlay, int isChecked) {
		this.songName = songName;
		this.aristName = aristName;
		this.albumImgUrl = albumImgUrl;
		this.url = url;
		this.isPlay = isPlay;
		this.isChecked = isChecked;
	}
	
	
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
	public Song(int songNo, String songName, int artistCode, String genreCode, int albumCode, String albumImgUrl,
			int songTitle, String aristName, String albumName,String url) {
		this.songNo = songNo;
		this.songName = songName;
		this.artistCode = artistCode;
		this.genreCode = genreCode;
		this.albumCode = albumCode;
		this.albumImgUrl = albumImgUrl;
		this.songTitle = songTitle;
		this.aristName = aristName;
		this.albumName = albumName;
		this.url = url;
	}
	

	public String getAristName() {
		return aristName;
	}

	public void setAristName(String aristName) {
		this.aristName = aristName;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
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
