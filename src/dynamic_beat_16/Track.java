package dynamic_beat_16;

public class Track {
	
	private String titleImage; //제목부분 이미지
	private String startImage; // 게임 선택 창 표지 
	private String gameImage;  // 해당 곡을 실행했을때 표지 이미지
	private String gameMusic; // 해당 곡을 실행했을 때 음악 
	private String startMusic; // 게임 선택 창 음악 
	private String titleName; // 곡 제목 
	
	public String getStartMusic() {
		return startMusic;
	}
	public void setStartMusic(String startMusic) {
		this.startMusic = startMusic;
	}
	public String getTitleImage() {
		return titleImage;
	}
	public void setTitleImage(String titleImage) {
		this.titleImage = titleImage;
	}
	public String getStartImage() {
		return startImage;
	}
	public void setStartImage(String startImage) {
		this.startImage = startImage;
	}
	public String getGameImage() {
		return gameImage;
	}
	public void setGameImage(String gameImage) {
		this.gameImage = gameImage;
	}
	public String getGameMusic() {
		return gameMusic;
	}
	public void setGameMusic(String gameMusic) {
		this.gameMusic = gameMusic;
	}
	
	public String getTitleName() {
		return titleName;
	}
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}
	
	public Track(String titleImage, String startImage, String gameImage, String gameMusic, String startMusic, String titleName) {
		super();
		this.titleImage = titleImage;
		this.startImage = startImage;
		this.gameImage = gameImage;
		this.gameMusic = gameMusic;
		this.startMusic = startMusic;
		this.titleName = titleName;
	}
	
	
}
