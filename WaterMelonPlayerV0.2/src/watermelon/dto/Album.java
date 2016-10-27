package watermelon.dto;

import java.util.Date;

public class Album {
	private int albumNo;
	private String albumName;
	private String albumArtist;
	private String debutDate;
	private String genreCode;
	
	public Album(){}

	public Album(int albumNo, String albumName, String albumArtist, String debutDate, String genreCode) {
		this.albumNo = albumNo;
		this.albumName = albumName;
		this.albumArtist = albumArtist;
		this.debutDate = debutDate;
		this.genreCode = genreCode;
	}

	public int getAlbumNo() {
		return albumNo;
	}

	public void setAlbumNo(int albumNo) {
		this.albumNo = albumNo;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public String getAlbumArtist() {
		return albumArtist;
	}

	public void setAlbumArtist(String albumArtist) {
		this.albumArtist = albumArtist;
	}

	public String getDebutDate() {
		return debutDate;
	}

	public void setDebutDate(String debutDate) {
		this.debutDate = debutDate;
	}

	public String getGenreCode() {
		return genreCode;
	}

	public void setGenreCode(String genreCode) {
		this.genreCode = genreCode;
	}
	
	
}
