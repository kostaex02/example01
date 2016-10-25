package watermelon.dto;

import java.util.Date;

public class Album {
	private String songAlbum;
	private String songArtist;
	private Date debutDate;
	private String genreCode;
	
	public Album(){}
	public Album(String songAlbum, String songArtist, Date debutDate, String genreCode) {
		super();
		this.songAlbum = songAlbum;
		this.songArtist = songArtist;
		this.debutDate = debutDate;
		this.genreCode = genreCode;
	}
	
	public String getSongAlbum() {
		return songAlbum;
	}
	public void setSongAlbum(String songAlbum) {
		this.songAlbum = songAlbum;
	}
	public String getSongArtist() {
		return songArtist;
	}
	public void setSongArtist(String songArtist) {
		this.songArtist = songArtist;
	}
	public Date getDebutDate() {
		return debutDate;
	}
	public void setDebutDate(Date debutDate) {
		this.debutDate = debutDate;
	}
	public String getGenreCode() {
		return genreCode;
	}
	public void setGenreCode(String genreCode) {
		this.genreCode = genreCode;
	}
	
}
