package dynamic_beat_16;

public class Beat {
	// 노트의 종류의 대한 데이터를 담을수있는 클래스 
	private int time;
	private String noteName;
	
	public Beat(int time, String noteName) {
		super();
		this.time = time;
		this.noteName = noteName;
	}
	
	public int getTime() {
		return time;
	}
	
	public void setTime(int time) {
		this.time = time;
	}
	
	public String getNoteName() {
		return noteName;
	}
	
	public void setNoteName(String noteName) {
		this.noteName = noteName;
	}
	
	

}
