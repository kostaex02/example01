package watermelon.dto;

public class Artist {
	private int artistNo;
	private String artistName;
	private int artistGender;
	private int artistGroup;
	
	public Artist(){}

	public Artist(int artistNo, String artistName, int artistGender, int artistGroup) {
		this.artistNo = artistNo;
		this.artistName = artistName;
		this.artistGender = artistGender;
		this.artistGroup = artistGroup;
	}

	public int getArtistNo() {
		return artistNo;
	}

	public void setArtistNo(int artistNo) {
		this.artistNo = artistNo;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public int getArtistGender() {
		return artistGender;
	}

	public void setArtistGender(int artistGender) {
		this.artistGender = artistGender;
	}

	public int getArtistGroup() {
		return artistGroup;
	}

	public void setArtistGroup(int artistGroup) {
		this.artistGroup = artistGroup;
	}
	
}
