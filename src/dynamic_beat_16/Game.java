package dynamic_beat_16;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import dynamic_beat_16.Beat;
import dynamic_beat_16.Main;

public class Game extends Thread {
	
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
	private Image judgementImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image blueFlareImage;
	private Image judgeImage;
	private Image keyPadSImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadDImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadFImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadSpace1Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadSpace2Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadJImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadKImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadLImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	
	
	
	private String titleName; // 실행할 곡의 이름 
	private String difficulty;
	private String musicTitle;
	private Music gameMusic;
	private int score,combo2 = 0;  
	ArrayList<Note> noteList = new ArrayList<Note>(); // 노트들을 생성되는 순간만다 관리하기 위해서 
	ArrayList<Boolean> combo = new ArrayList<Boolean>();
	
	public Game(String titleName,String difficulty, String musicTitle) {
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false); // 한번만 재생되게 
	}
	
	// 게임이 시작되면 게임에서 생성된 인스턴스 변수를 이용해 게임을 컨트롤할수있게 
	public void screenDraw(Graphics2D g) {
		g.drawImage(noteRouteSImage, 228,30,null);
		g.drawImage(noteRouteDImage, 332,30,null);
		g.drawImage(noteRouteFImage, 436,30,null);
		g.drawImage(noteRouteSpace1Image, 540,30,null);
		g.drawImage(noteRouteSpace2Image, 640,30,null);
		g.drawImage(noteRouteJImage, 744,30,null);
		g.drawImage(noteRouteKImage, 848,30,null);
		g.drawImage(noteRouteLImage, 952,30,null);
		g.drawImage(noteRouteLineImage, 224,30,null);
		g.drawImage(noteRouteLineImage, 328,30,null);
		g.drawImage(noteRouteLineImage, 432,30,null);
		g.drawImage(noteRouteLineImage, 536,30,null);
		g.drawImage(noteRouteLineImage, 740,30,null);
		g.drawImage(noteRouteLineImage, 844,30,null);
		g.drawImage(noteRouteLineImage, 948,30,null);
		g.drawImage(noteRouteLineImage, 1052,30,null);
		g.drawImage(gameInfoImage, 0,660,null);
		g.drawImage(judgementImage, 0,580,null);
		
		// 노트들을 불러와 각각의 노트들을 그려준다.
				for(int i=0; i< noteList.size(); i++) {
					Note note = noteList.get(i);
					if(note.getY() > 620) {
						judgeImage = new ImageIcon(Main.class.getResource("../images/MissImg.png")).getImage();
						combo2 = 0; 
						score -=20;
					}
					if(!note.isProcessded()) { // 현재노트가 작동하고있는 상태가아니면 삭제
						noteList.remove(i);
						i--;
					}else {
						note.screenDraw(g);
					}
				}
				
		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString(titleName, 20, 702);
		g.drawString(difficulty, 1190, 702);
		g.setFont(new Font("Arial", Font.PLAIN, 26));
		g.setColor(Color.DARK_GRAY);
		g.drawString("S", 270, 609);
		g.drawString("D", 374, 609);
		g.drawString("F", 478, 609);
		g.drawString("Space Bar", 580, 609);
		g.drawString("J", 784, 609);
		g.drawString("K", 889, 609);
		g.drawString("L", 993, 609);
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(new Font("Elephant", Font.BOLD, 30));
		g.drawImage(blueFlareImage, 380, 270, null);
		g.drawImage(judgeImage, 460, 420, null);
		g.drawImage(keyPadSImage, 228, 580, null);
		g.drawImage(keyPadDImage, 332, 580, null);
		g.drawImage(keyPadFImage, 436, 580, null);
		g.drawImage(keyPadSpace1Image, 540, 580, null);
		g.drawImage(keyPadSpace2Image, 640, 580, null);
		g.drawImage(keyPadJImage, 744, 580, null);
		g.drawImage(keyPadKImage, 848, 580, null);	
		g.drawImage(keyPadLImage, 952, 580, null);

		if(score <= 0) {
			score = 0;
		}
		
		g.drawString("Score: "+score, 585, 702);

		if(combo2 != 0) {
			g.setFont(new Font("Arial", Font.BOLD, 30));
			g.drawString(combo2 + " Combo!", 1100, 300);
		}
		
	}
	
	public void pressS() {
		judge("S");
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();	
		keyPadSImage = new ImageIcon(Main.class.getResource("../images/keyPressed.png")).getImage();	
		new Music("drum1.mp3", false).start();
	}
	
	public void releaseS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadSImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();	
		
	}
	public void pressD() {
		judge("D");
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();	
		keyPadDImage = new ImageIcon(Main.class.getResource("../images/keyPressed.png")).getImage();	
		
		new Music("drum1.mp3", false).start();
	}
	
	public void releaseD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadDImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();	
		
	}
	public void pressF() {	
		judge("F");
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();	
		keyPadFImage = new ImageIcon(Main.class.getResource("../images/keyPressed.png")).getImage();	
		
		new Music("drum1.mp3", false).start();
	}
	
	public void releaseF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadFImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();	
		
	}
	public void pressSpace() {
		judge("Space");
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadSpace1Image = new ImageIcon(Main.class.getResource("../images/keyPressed.png")).getImage();	
		keyPadSpace2Image = new ImageIcon(Main.class.getResource("../images/keyPressed.png")).getImage();		
		new Music("drum4.mp3", false).start();
	}
	
	public void releaseSpace() {
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	
		keyPadSpace1Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();	
		keyPadSpace2Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();		
	}
	
	public void pressJ() {
		judge("J");
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();	
		keyPadJImage = new ImageIcon(Main.class.getResource("../images/keyPressed.png")).getImage();	
		
		new Music("drum1.mp3", false).start();
	}
	
	public void releaseJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadJImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();	
		
	}
	public void pressK() {
		judge("K");
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();	
		keyPadKImage = new ImageIcon(Main.class.getResource("../images/keyPressed.png")).getImage();			
		new Music("drum1.mp3", false).start();
	}
	
	public void releaseK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadKImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();	
		
	}
	public void pressL() {
		judge("L");
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();	
		keyPadLImage = new ImageIcon(Main.class.getResource("../images/keyPressed.png")).getImage();	
		new Music("drum1.mp3", false).start();
	}
	
	public void releaseL() {
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadLImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();	
		
	}
	
	@Override
	public void run() {
		dropNotes(this.titleName);
	}
	
	public void close() {
		gameMusic.close();
		this.interrupt();
	}
	
	public void dropNotes(String titleName) {
		Beat[] beats = null;
		if(titleName.equals("Shape Of You (noma Remix)") && difficulty.equals("Easy")) {
			int startTime = 3460 - Main.REACH_TIME *1000;
			int gap = 200;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
					new Beat(startTime+gap * 4, "D"),
					new Beat(startTime+gap *4, "S"),	
					new Beat(startTime+gap * 8, "D"),
					new Beat(startTime+gap *8, "F"),	
					new Beat(startTime + gap * 13, "D"),
					new Beat(startTime + gap * 15, "D"),
					new Beat(startTime + gap * 18, "Space"),
					new Beat(startTime + gap * 22, "F"),
					new Beat(startTime + gap * 25, "J"),
					new Beat(startTime + gap * 28, "K"),
					new Beat(startTime + gap * 35, "Space"),
					new Beat(startTime + gap * 39, "Space"),
					new Beat(startTime + gap * 43, "S"),
					new Beat(startTime + gap * 48, "D"),
					new Beat(startTime + gap * 50, "S"),
					new Beat(startTime + gap * 53, "D"),
					new Beat(startTime + gap * 56, "F"),
					new Beat(startTime + gap * 59, "L"),
					new Beat(startTime + gap * 60, "K"),
					new Beat(startTime + gap * 60, "L"),
					new Beat(startTime + gap * 62, "J"),
					new Beat(startTime + gap * 62, "K"),
					new Beat(startTime + gap * 64, "Space"),
					new Beat(startTime + gap * 68, "D"),
					new Beat(startTime + gap * 70, "K"),
					new Beat(startTime + gap * 72, "K"),
					new Beat(startTime + gap * 74, "L"),
					new Beat(startTime + gap * 76, "S"),
					new Beat(startTime + gap * 80, "F"),
					new Beat(startTime + gap * 84, "F"),
					new Beat(startTime + gap * 86, "D"),
					new Beat(startTime + gap * 88, "L"),
					new Beat(startTime + gap * 90, "J"),
					new Beat(startTime + gap * 95, "D"),
					new Beat(startTime + gap * 99, "S"),
					new Beat(startTime + gap * 104, "Space"),
					new Beat(startTime + gap * 110, "J"),
					new Beat(startTime + gap * 112, "S"),
					new Beat(startTime + gap * 114, "D"),
					new Beat(startTime + gap * 116, "J"),
					new Beat(startTime + gap * 118, "D"),
					new Beat(startTime + gap * 120, "S"),
					new Beat(startTime + gap * 130, "F"),
					new Beat(startTime + gap * 136, "F"),
					new Beat(startTime + gap * 139, "D"),
					new Beat(startTime + gap * 142, "L"),
					new Beat(startTime + gap * 146, "J"),
					new Beat(startTime + gap * 150, "D"),		
					new Beat(startTime + gap * 154, "S"),
					new Beat(startTime + gap * 160, "F"),
					new Beat(startTime + gap * 166, "F"),
					new Beat(startTime + gap * 170, "D"),
					new Beat(startTime + gap * 174, "L"),
					new Beat(startTime + gap * 178, "J"),
					new Beat(startTime + gap * 185, "D"),
					new Beat(startTime + gap * 187, "D"),
					new Beat(startTime + gap * 189, "S"),
					new Beat(startTime + gap * 192, "F"),
					new Beat(startTime + gap * 194, "F"),
					new Beat(startTime + gap * 198, "D"),
					new Beat(startTime + gap * 200, "L"),
					new Beat(startTime + gap * 202, "J"),
					new Beat(startTime + gap * 204, "K"),		
					new Beat(startTime + gap * 206, "L"),
					new Beat(startTime + gap * 210, "F"),
					new Beat(startTime + gap * 213, "F"),
					new Beat(startTime + gap * 215, "D"),
					new Beat(startTime + gap * 215, "L"),
					new Beat(startTime + gap * 220, "J"),
					new Beat(startTime + gap * 222, "D"),
					new Beat(startTime + gap * 224, "D"),
					new Beat(startTime + gap * 226, "Space"),
					new Beat(startTime + gap * 228, "F"),
					new Beat(startTime + gap * 230, "J"),
					new Beat(startTime + gap * 230, "K"),
					new Beat(startTime + gap * 233, "Space"),
					new Beat(startTime + gap * 236, "Space"),
					new Beat(startTime + gap * 238, "S"),
					new Beat(startTime + gap * 240, "D"),
					new Beat(startTime + gap * 243, "S"),
					new Beat(startTime + gap * 246, "D"),
					new Beat(startTime + gap * 248, "F"),
					new Beat(startTime + gap * 250, "L"),
					new Beat(startTime + gap * 250, "J"),
					new Beat(startTime + gap * 252, "D"),
					new Beat(startTime + gap * 254, "S"),
					new Beat(startTime + gap * 256, "F"),
					new Beat(startTime + gap * 258, "Space"),
					new Beat(startTime + gap * 260, "S"),
					new Beat(startTime + gap * 263, "S"),
					new Beat(startTime + gap * 266, "F"),
					new Beat(startTime + gap * 268, "Space"),
					new Beat(startTime + gap * 270, "Space"),
					new Beat(startTime + gap * 272, "F"),
					new Beat(startTime + gap * 274, "F"),
					new Beat(startTime + gap * 276, "D"),
					new Beat(startTime + gap * 278, "L"),
					new Beat(startTime + gap * 278, "D"),
					new Beat(startTime + gap * 278, "F"),
					new Beat(startTime + gap * 280, "S"),
					new Beat(startTime + gap * 280, "D"),
					new Beat(startTime + gap * 280, "F"),
					new Beat(startTime + gap * 284, "F"),
					new Beat(startTime + gap * 284, "J"),
					new Beat(startTime + gap * 288, "S"),
					new Beat(startTime + gap * 288, "D"),
					new Beat(startTime + gap * 288, "F"),
					new Beat(startTime + gap * 290, "Space"),
					new Beat(startTime + gap * 292, "Space"),
					new Beat(startTime + gap * 295, "J"),
					new Beat(startTime + gap * 298, "F"),
					new Beat(startTime + gap * 298, "Space"),
					new Beat(startTime + gap * 302, "S"),
					
					
			};
		}else if(titleName.equals("Shape Of You (noma Remix)") && difficulty.equals("Hard")) {
			int startTime = 1000;
			int gap = 125;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
					new Beat(startTime+gap * 2, "D"),
					new Beat(startTime+gap *2, "F"),	
					new Beat(startTime+gap * 4, "D"),
					new Beat(startTime+gap *4, "S"),	
					new Beat(startTime+gap * 8, "D"),
					new Beat(startTime+gap *8, "F"),	
					new Beat(startTime+gap * 10, "D"),
					new Beat(startTime+gap *10, "S"),	
					new Beat(startTime + gap * 13, "D"),
					new Beat(startTime + gap * 15, "D"),
					new Beat(startTime + gap * 18, "Space"),
					new Beat(startTime + gap * 22, "F"),
					new Beat(startTime + gap * 25, "J"),
					new Beat(startTime + gap * 28, "K"),
					new Beat(startTime + gap * 35, "Space"),
					new Beat(startTime + gap * 39, "Space"),
					new Beat(startTime + gap * 43, "S"),
					new Beat(startTime + gap * 48, "D"),
					new Beat(startTime + gap * 50, "S"),
					new Beat(startTime + gap * 53, "D"),
					new Beat(startTime + gap * 56, "F"),
					new Beat(startTime + gap * 59, "L"),
					new Beat(startTime + gap * 60, "K"),
					new Beat(startTime + gap * 60, "L"),
					new Beat(startTime + gap * 62, "J"),
					new Beat(startTime + gap * 62, "K"),
					new Beat(startTime + gap * 64, "Space"),
					new Beat(startTime + gap * 68, "D"),
					new Beat(startTime + gap * 70, "K"),
					new Beat(startTime + gap * 72, "K"),
					new Beat(startTime + gap * 74, "L"),
					new Beat(startTime + gap * 76, "S"),
					new Beat(startTime + gap * 80, "F"),
					new Beat(startTime + gap * 84, "F"),
					new Beat(startTime + gap * 86, "D"),
					new Beat(startTime + gap * 88, "L"),
					new Beat(startTime + gap * 90, "J"),
					new Beat(startTime + gap * 95, "D"),
					new Beat(startTime + gap * 99, "S"),
					new Beat(startTime + gap * 104, "Space"),
					new Beat(startTime + gap * 110, "J"),
					new Beat(startTime + gap * 112, "S"),
					new Beat(startTime + gap * 114, "D"),
					new Beat(startTime + gap * 116, "J"),
					new Beat(startTime + gap * 118, "D"),
					new Beat(startTime + gap * 120, "S"),
					new Beat(startTime + gap * 130, "F"),
					new Beat(startTime + gap * 136, "F"),
					new Beat(startTime + gap * 139, "D"),
					new Beat(startTime + gap * 142, "L"),
					new Beat(startTime + gap * 146, "J"),
					new Beat(startTime + gap * 150, "D"),		
					new Beat(startTime + gap * 154, "S"),
					new Beat(startTime + gap * 160, "F"),
					new Beat(startTime + gap * 166, "F"),
					new Beat(startTime + gap * 170, "D"),
					new Beat(startTime + gap * 174, "L"),
					new Beat(startTime + gap * 178, "J"),
					new Beat(startTime + gap * 185, "D"),
					new Beat(startTime + gap * 187, "D"),
					new Beat(startTime + gap * 189, "S"),
					new Beat(startTime + gap * 192, "F"),
					new Beat(startTime + gap * 194, "F"),
					new Beat(startTime + gap * 198, "D"),
					new Beat(startTime + gap * 200, "L"),
					new Beat(startTime + gap * 202, "J"),
					new Beat(startTime + gap * 204, "K"),		
					new Beat(startTime + gap * 206, "L"),
					new Beat(startTime + gap * 210, "F"),
					new Beat(startTime + gap * 213, "F"),
					new Beat(startTime + gap * 215, "D"),
					new Beat(startTime + gap * 215, "L"),
					new Beat(startTime + gap * 220, "J"),
					new Beat(startTime + gap * 222, "D"),
					new Beat(startTime + gap * 224, "D"),
					new Beat(startTime + gap * 226, "Space"),
					new Beat(startTime + gap * 228, "F"),
					new Beat(startTime + gap * 230, "J"),
					new Beat(startTime + gap * 230, "K"),
					new Beat(startTime + gap * 233, "Space"),
					new Beat(startTime + gap * 236, "Space"),
					new Beat(startTime + gap * 238, "S"),
					new Beat(startTime + gap * 240, "D"),
					new Beat(startTime + gap * 243, "S"),
					new Beat(startTime + gap * 246, "D"),
					new Beat(startTime + gap * 248, "F"),
					new Beat(startTime + gap * 250, "L"),
					new Beat(startTime + gap * 250, "J"),
					new Beat(startTime + gap * 252, "D"),
					new Beat(startTime + gap * 254, "S"),
					new Beat(startTime + gap * 256, "F"),
					new Beat(startTime + gap * 258, "Space"),
					new Beat(startTime + gap * 260, "S"),
					new Beat(startTime + gap * 263, "S"),
					new Beat(startTime + gap * 266, "F"),
					new Beat(startTime + gap * 268, "Space"),
					new Beat(startTime + gap * 270, "Space"),
					new Beat(startTime + gap * 272, "F"),
					new Beat(startTime + gap * 274, "F"),
					new Beat(startTime + gap * 276, "D"),
					new Beat(startTime + gap * 278, "L"),
					new Beat(startTime + gap * 278, "D"),
					new Beat(startTime + gap * 278, "F"),
					new Beat(startTime + gap * 280, "S"),
					new Beat(startTime + gap * 280, "D"),
					new Beat(startTime + gap * 280, "F"),
					new Beat(startTime + gap * 284, "F"),
					new Beat(startTime + gap * 284, "J"),
					new Beat(startTime + gap * 288, "S"),
					new Beat(startTime + gap * 288, "D"),
					new Beat(startTime + gap * 288, "F"),
					new Beat(startTime + gap * 290, "Space"),
					new Beat(startTime + gap * 292, "Space"),
					new Beat(startTime + gap * 295, "J"),
					new Beat(startTime + gap * 298, "F"),
					new Beat(startTime + gap * 298, "Space"),
					new Beat(startTime + gap * 302, "S"),
					
					
			};
		}else if(titleName.equals("Alan Walker - Spectre(Remix)") && difficulty.equals("Easy")) {
			int startTime = 1000;
			int gap = 200;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
					new Beat(startTime+gap * 4, "D"),
					new Beat(startTime+gap *4, "S"),	
					new Beat(startTime+gap * 8, "D"),
					new Beat(startTime+gap *8, "F"),	
					new Beat(startTime + gap * 13, "D"),
					new Beat(startTime + gap * 15, "D"),
					new Beat(startTime + gap * 18, "Space"),
					new Beat(startTime + gap * 22, "F"),
					new Beat(startTime + gap * 25, "J"),
					new Beat(startTime + gap * 28, "K"),
					new Beat(startTime + gap * 35, "Space"),
					new Beat(startTime + gap * 39, "Space"),
					new Beat(startTime + gap * 43, "S"),
					new Beat(startTime + gap * 48, "D"),
					new Beat(startTime + gap * 50, "S"),
					new Beat(startTime + gap * 53, "D"),
					new Beat(startTime + gap * 56, "F"),
					new Beat(startTime + gap * 59, "L"),
					new Beat(startTime + gap * 60, "K"),
					new Beat(startTime + gap * 60, "L"),
					new Beat(startTime + gap * 62, "J"),
					new Beat(startTime + gap * 62, "K"),
					new Beat(startTime + gap * 64, "Space"),
					new Beat(startTime + gap * 68, "D"),
					new Beat(startTime + gap * 70, "K"),
					new Beat(startTime + gap * 72, "K"),
					new Beat(startTime + gap * 74, "L"),
					new Beat(startTime + gap * 76, "S"),
					new Beat(startTime + gap * 80, "F"),
					new Beat(startTime + gap * 84, "F"),
					new Beat(startTime + gap * 86, "D"),
					new Beat(startTime + gap * 88, "L"),
					new Beat(startTime + gap * 90, "J"),
					new Beat(startTime + gap * 95, "D"),
					new Beat(startTime + gap * 99, "S"),
					new Beat(startTime + gap * 104, "Space"),
					new Beat(startTime + gap * 110, "J"),
					new Beat(startTime + gap * 112, "S"),
					new Beat(startTime + gap * 114, "D"),
					new Beat(startTime + gap * 116, "J"),
					new Beat(startTime + gap * 118, "D"),
					new Beat(startTime + gap * 120, "S"),
					new Beat(startTime + gap * 130, "F"),
					new Beat(startTime + gap * 136, "F"),
					new Beat(startTime + gap * 139, "D"),
					new Beat(startTime + gap * 142, "L"),
					new Beat(startTime + gap * 146, "J"),
					new Beat(startTime + gap * 150, "D"),		
					new Beat(startTime + gap * 154, "S"),
					new Beat(startTime + gap * 160, "F"),
					new Beat(startTime + gap * 166, "F"),
					new Beat(startTime + gap * 170, "D"),
					new Beat(startTime + gap * 174, "L"),
					new Beat(startTime + gap * 178, "J"),
					new Beat(startTime + gap * 185, "D"),
					new Beat(startTime + gap * 187, "D"),
					new Beat(startTime + gap * 189, "S"),
					new Beat(startTime + gap * 192, "F"),
					new Beat(startTime + gap * 194, "F"),
					new Beat(startTime + gap * 198, "D"),
					new Beat(startTime + gap * 200, "L"),
					new Beat(startTime + gap * 202, "J"),
					new Beat(startTime + gap * 204, "K"),		
					new Beat(startTime + gap * 206, "L"),
					new Beat(startTime + gap * 210, "F"),
					new Beat(startTime + gap * 213, "F"),
					new Beat(startTime + gap * 215, "D"),
					new Beat(startTime + gap * 215, "L"),
					new Beat(startTime + gap * 220, "J"),
					new Beat(startTime + gap * 222, "D"),
					new Beat(startTime + gap * 224, "D"),
					new Beat(startTime + gap * 226, "Space"),
					new Beat(startTime + gap * 228, "F"),
					new Beat(startTime + gap * 230, "J"),
					new Beat(startTime + gap * 230, "K"),
					new Beat(startTime + gap * 233, "Space"),
					new Beat(startTime + gap * 236, "Space"),
					new Beat(startTime + gap * 238, "S"),
					new Beat(startTime + gap * 240, "D"),
					new Beat(startTime + gap * 243, "S"),
					new Beat(startTime + gap * 246, "D"),
					new Beat(startTime + gap * 248, "F"),
					new Beat(startTime + gap * 250, "L"),
					new Beat(startTime + gap * 250, "J"),
					new Beat(startTime + gap * 252, "D"),
					new Beat(startTime + gap * 254, "S"),
					new Beat(startTime + gap * 256, "F"),
					new Beat(startTime + gap * 258, "Space"),
					new Beat(startTime + gap * 260, "S"),
					new Beat(startTime + gap * 263, "S"),
					new Beat(startTime + gap * 266, "F"),
					new Beat(startTime + gap * 268, "Space"),
					new Beat(startTime + gap * 270, "Space"),
					new Beat(startTime + gap * 272, "F"),
					new Beat(startTime + gap * 274, "F"),
					new Beat(startTime + gap * 276, "D"),
					new Beat(startTime + gap * 278, "L"),
					new Beat(startTime + gap * 278, "D"),
					new Beat(startTime + gap * 278, "F"),
					new Beat(startTime + gap * 280, "S"),
					new Beat(startTime + gap * 280, "D"),
					new Beat(startTime + gap * 280, "F"),
					new Beat(startTime + gap * 284, "F"),
					new Beat(startTime + gap * 284, "J"),
					new Beat(startTime + gap * 288, "S"),
					new Beat(startTime + gap * 288, "D"),
					new Beat(startTime + gap * 288, "F"),
					new Beat(startTime + gap * 290, "Space"),
					new Beat(startTime + gap * 292, "Space"),
					new Beat(startTime + gap * 295, "J"),
					new Beat(startTime + gap * 298, "F"),
					new Beat(startTime + gap * 298, "Space"),
					new Beat(startTime + gap * 302, "S"),
					
					
			};
		}else if(titleName.equals("Mark Ronson feat. Bruno Mars - Uptown Funk (Fresh Kiwi Bootleg)") && difficulty.equals("Easy")) {
			int startTime = 1000;
			int gap = 200;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
					new Beat(startTime+gap * 4, "D"),
					new Beat(startTime+gap *4, "S"),	
					new Beat(startTime+gap * 8, "D"),
					new Beat(startTime+gap *8, "F"),	
					new Beat(startTime + gap * 13, "D"),
					new Beat(startTime + gap * 15, "D"),
					new Beat(startTime + gap * 18, "Space"),
					new Beat(startTime + gap * 22, "F"),
					new Beat(startTime + gap * 25, "J"),
					new Beat(startTime + gap * 28, "K"),
					new Beat(startTime + gap * 35, "Space"),
					new Beat(startTime + gap * 39, "Space"),
					new Beat(startTime + gap * 43, "S"),
					new Beat(startTime + gap * 48, "D"),
					new Beat(startTime + gap * 50, "S"),
					new Beat(startTime + gap * 53, "D"),
					new Beat(startTime + gap * 56, "F"),
					new Beat(startTime + gap * 59, "L"),
					new Beat(startTime + gap * 60, "K"),
					new Beat(startTime + gap * 60, "L"),
					new Beat(startTime + gap * 62, "J"),
					new Beat(startTime + gap * 62, "K"),
					new Beat(startTime + gap * 64, "Space"),
					new Beat(startTime + gap * 68, "D"),
					new Beat(startTime + gap * 70, "K"),
					new Beat(startTime + gap * 72, "K"),
					new Beat(startTime + gap * 74, "L"),
					new Beat(startTime + gap * 76, "S"),
					new Beat(startTime + gap * 80, "F"),
					new Beat(startTime + gap * 84, "F"),
					new Beat(startTime + gap * 86, "D"),
					new Beat(startTime + gap * 88, "L"),
					new Beat(startTime + gap * 90, "J"),
					new Beat(startTime + gap * 95, "D"),
					new Beat(startTime + gap * 99, "S"),
					new Beat(startTime + gap * 104, "Space"),
					new Beat(startTime + gap * 110, "J"),
					new Beat(startTime + gap * 112, "S"),
					new Beat(startTime + gap * 114, "D"),
					new Beat(startTime + gap * 116, "J"),
					new Beat(startTime + gap * 118, "D"),
					new Beat(startTime + gap * 120, "S"),
					new Beat(startTime + gap * 130, "F"),
					new Beat(startTime + gap * 136, "F"),
					new Beat(startTime + gap * 139, "D"),
					new Beat(startTime + gap * 142, "L"),
					new Beat(startTime + gap * 146, "J"),
					new Beat(startTime + gap * 150, "D"),		
					new Beat(startTime + gap * 154, "S"),
					new Beat(startTime + gap * 160, "F"),
					new Beat(startTime + gap * 166, "F"),
					new Beat(startTime + gap * 170, "D"),
					new Beat(startTime + gap * 174, "L"),
					new Beat(startTime + gap * 178, "J"),
					new Beat(startTime + gap * 185, "D"),
					new Beat(startTime + gap * 187, "D"),
					new Beat(startTime + gap * 189, "S"),
					new Beat(startTime + gap * 192, "F"),
					new Beat(startTime + gap * 194, "F"),
					new Beat(startTime + gap * 198, "D"),
					new Beat(startTime + gap * 200, "L"),
					new Beat(startTime + gap * 202, "J"),
					new Beat(startTime + gap * 204, "K"),		
					new Beat(startTime + gap * 206, "L"),
					new Beat(startTime + gap * 210, "F"),
					new Beat(startTime + gap * 213, "F"),
					new Beat(startTime + gap * 215, "D"),
					new Beat(startTime + gap * 215, "L"),
					new Beat(startTime + gap * 220, "J"),
					new Beat(startTime + gap * 222, "D"),
					new Beat(startTime + gap * 224, "D"),
					new Beat(startTime + gap * 226, "Space"),
					new Beat(startTime + gap * 228, "F"),
					new Beat(startTime + gap * 230, "J"),
					new Beat(startTime + gap * 230, "K"),
					new Beat(startTime + gap * 233, "Space"),
					new Beat(startTime + gap * 236, "Space"),
					new Beat(startTime + gap * 238, "S"),
					new Beat(startTime + gap * 240, "D"),
					new Beat(startTime + gap * 243, "S"),
					new Beat(startTime + gap * 246, "D"),
					new Beat(startTime + gap * 248, "F"),
					new Beat(startTime + gap * 250, "L"),
					new Beat(startTime + gap * 250, "J"),
					new Beat(startTime + gap * 252, "D"),
					new Beat(startTime + gap * 254, "S"),
					new Beat(startTime + gap * 256, "F"),
					new Beat(startTime + gap * 258, "Space"),
					new Beat(startTime + gap * 260, "S"),
					new Beat(startTime + gap * 263, "S"),
					new Beat(startTime + gap * 266, "F"),
					new Beat(startTime + gap * 268, "Space"),
					new Beat(startTime + gap * 270, "Space"),
					new Beat(startTime + gap * 272, "F"),
					new Beat(startTime + gap * 274, "F"),
					new Beat(startTime + gap * 276, "D"),
					new Beat(startTime + gap * 278, "L"),
					new Beat(startTime + gap * 278, "D"),
					new Beat(startTime + gap * 278, "F"),
					new Beat(startTime + gap * 280, "S"),
					new Beat(startTime + gap * 280, "D"),
					new Beat(startTime + gap * 280, "F"),
					new Beat(startTime + gap * 284, "F"),
					new Beat(startTime + gap * 284, "J"),
					new Beat(startTime + gap * 288, "S"),
					new Beat(startTime + gap * 288, "D"),
					new Beat(startTime + gap * 288, "F"),
					new Beat(startTime + gap * 290, "Space"),
					new Beat(startTime + gap * 292, "Space"),
					new Beat(startTime + gap * 295, "J"),
					new Beat(startTime + gap * 298, "F"),
					new Beat(startTime + gap * 298, "Space"),
					new Beat(startTime + gap * 302, "S"),
			};
		}
	
		int i = 0;
		gameMusic.start(); // 음악재생 
		while(i < beats.length && !isInterrupted()) {
			boolean dropped = false;
			if(beats[i].getTime() <= gameMusic.getTime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
				dropped = true;
			}
			if(!dropped) {
				try {
					Thread.sleep(5);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void judge(String input) {
		for(int i = 0; i< noteList.size(); i++) {
			Note note = noteList.get(i);
			if(input.equals(note.getNoteType())) {
				judgeEvent(note.judge());
				break;
			}
				
		}
	}
	
	public void judgeEvent(String judge) {
		if(!judge.equals("None")) {
			blueFlareImage = new ImageIcon(Main.class.getResource("../images/flare.png")).getImage();
		}
		if(judge.equals("Miss")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/MissImg.png")).getImage();
			if(score < 0) {
				score = 0;
			}
			combo2 = 0;
		}else if(judge.equals("Late")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/LateImg.png")).getImage();
			combo2 = 0;
		}else if(judge.equals("Good")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/goodImg.png")).getImage();
			score += 20;
			combo2 += 1;
		}else if(judge.equals("Great")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/greatImg.png")).getImage();
			score += 30;
			combo2 += 1;
		}else if(judge.equals("Perfect")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/PerfectImg.png")).getImage();
			score += 40;
			combo2 += 1;
		}else if(judge.equals("Early")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/EarlyImg.png")).getImage();
			combo2 = 0;
		}
	}
}
