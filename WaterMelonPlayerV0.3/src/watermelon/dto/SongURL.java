package watermelon.dto;

public class SongURL {
	private String url;
	private int songNo;
	
	public SongURL(){}

	public SongURL(String url, int songNo) {
		super();
		this.url = url;
		this.songNo = songNo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getSongNo() {
		return songNo;
	}

	public void setSongNo(int songNo) {
		this.songNo = songNo;
	}
	
}