package watermelon.dto;

public class SongGenre {
	private String genreCode;
	private String genreName;
	
	public SongGenre(){}

	public SongGenre(String genreCode, String genreName) {
		super();
		this.genreCode = genreCode;
		this.genreName = genreName;
	}

	public String getGenreCode() {
		return genreCode;
	}

	public void setGenreCode(String genreCode) {
		this.genreCode = genreCode;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}
	
}
