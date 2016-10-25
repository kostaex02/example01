package watermelon.dto;

public class Song {
	private String songName;
	private String songArtist;
	private String genreCode;
	private String songAlbum;
	private String songUrl;
	private String songImgUrl;
	private int songTitle;
	
	public Song(){}
	
	public Song(String songName, String songArtist, String genreCode, String songAlbum, String songUrl,
			String songImgUrl, int songTitle) {
		this.songName = songName;
		this.songArtist = songArtist;
		this.genreCode = genreCode;
		this.songAlbum = songAlbum;
		this.songUrl = songUrl;
		this.songImgUrl = songImgUrl;
		this.songTitle = songTitle;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getSongArtist() {
		return songArtist;
	}

	public void setSongArtist(String songArtist) {
		this.songArtist = songArtist;
	}

	public String getGenreCode() {
		return genreCode;
	}

	public void setGenreCode(String genreCode) {
		this.genreCode = genreCode;
	}

	public String getSongAlbum() {
		return songAlbum;
	}

	public void setSongAlbum(String songAlbum) {
		this.songAlbum = songAlbum;
	}

	public String getSongUrl() {
		return songUrl;
	}

	public void setSongUrl(String songUrl) {
		this.songUrl = songUrl;
	}

	public String getSongImgUrl() {
		return songImgUrl;
	}

	public void setSongImgUrl(String songImgUrl) {
		this.songImgUrl = songImgUrl;
	}

	public int getSongTitle() {
		return songTitle;
	}

	public void setSongTitle(int songTitle) {
		this.songTitle = songTitle;
	}
	
	
}
