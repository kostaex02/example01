package watermelon.dto;

public class Artist {
	private String songArtist;
	private String ArtistImgUrl;
	
	
	public Artist(String songArtist, String artistImgUrl) {
		this.songArtist = songArtist;
		this.ArtistImgUrl = artistImgUrl;
	}


	public String getSongArtist() {
		return songArtist;
	}


	public void setSongArtist(String songArtist) {
		this.songArtist = songArtist;
	}


	public String getArtistImgUrl() {
		return ArtistImgUrl;
	}


	public void setArtistImgUrl(String artistImgUrl) {
		ArtistImgUrl = artistImgUrl;
	}
	
	
}
