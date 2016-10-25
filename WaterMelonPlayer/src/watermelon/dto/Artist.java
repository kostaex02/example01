package watermelon.dto;

public class Artist {
	private String songArtist;
	private String gender;
	private String artistGroup;
	
	public Artist(){}
	public Artist(String songArtist, String gender, String artistGroup) {
		this.songArtist = songArtist;
		this.gender = gender;
		this.artistGroup = artistGroup;
	}
	public String getSongArtist() {
		return songArtist;
	}
	public void setSongArtist(String songArtist) {
		this.songArtist = songArtist;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getArtistGroup() {
		return artistGroup;
	}
	public void setArtistGroup(String artistGroup) {
		this.artistGroup = artistGroup;
	}
}
