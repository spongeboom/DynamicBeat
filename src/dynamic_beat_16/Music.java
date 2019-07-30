package dynamic_beat_16;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread{
	
	private Player player; // javazoom lib 
	private boolean isLoop; // 한번재생 or 무한반복 
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name , boolean isLoop) {
		try {
			this.isLoop = isLoop;
			file = new File(Main.class.getResource("../music/" + name).toURI());
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	// 현재 실행되고있는 음악이 어떤 부분에서 실행되고 있는지 
	public int getTime() {
		if (player == null)
			return 0;
		return player.getPosition();
	}
	
	// 음악이 언제실행되고 있던간에 항상 종료할수 있게 하는 함수(안정적으로) 
	public void close() {
		isLoop = false;
		player.close();
		this.interrupt(); // 스레드 중지 
	}
	
	@Override
	public void run() {
		try {
			do {
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			}while(isLoop); // isLoop가 true를 가지면 무한반복 
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
