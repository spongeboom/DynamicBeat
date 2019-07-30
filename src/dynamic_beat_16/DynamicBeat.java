package dynamic_beat_16;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DynamicBeat extends JFrame{
	
	private Image screenImage;
	private Graphics screenGraphic;
	private Image Background = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();
	
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitIconEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitIconBasic.png"));
	private ImageIcon startBtnEntered = new ImageIcon(Main.class.getResource("../images/startButtonEntered.png"));
	private ImageIcon startBtnBasic = new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));
	private ImageIcon quitBtnEntered = new ImageIcon(Main.class.getResource("../images/quitButtonEntered.png"));
	private ImageIcon quitBtnBasic = new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png"));
	private ImageIcon leftBtnBasic = new ImageIcon(Main.class.getResource("../images/leftButtonBasic.png"));
	private ImageIcon leftBtnEntered = new ImageIcon(Main.class.getResource("../images/leftButtonEntered.png"));
	private ImageIcon rightBtnBasic = new ImageIcon(Main.class.getResource("../images/rightButtonBasic.png"));
	private ImageIcon rightBtnEntered = new ImageIcon(Main.class.getResource("../images/rightButtonEntered.png"));
	private ImageIcon easyBtnBasic = new ImageIcon(Main.class.getResource("../images/easyButtonBasic.png"));
	private ImageIcon easyBtnEntered = new ImageIcon(Main.class.getResource("../images/easyButtonEntered.png"));
	private ImageIcon hardBtnBasic = new ImageIcon(Main.class.getResource("../images/hardButtonBasic.png"));
	private ImageIcon hardBtnEntered = new ImageIcon(Main.class.getResource("../images/hardButtonEntered.png"));
	private ImageIcon backBtnBasic = new ImageIcon(Main.class.getResource("../images/backbtnBasic.png"));
	private ImageIcon backBtnEntered = new ImageIcon(Main.class.getResource("../images/backbtnEntered.png"));
	
	
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
	private Image judgementImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();
	private Image noteRouteImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/note.png")).getImage();
	
	
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	
	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startBtnBasic);
	private JButton quitButton = new JButton(quitBtnBasic);
	private JButton leftButton = new JButton(leftBtnBasic);
	private JButton rightButton = new JButton(rightBtnBasic);
	private JButton easyButton = new JButton(easyBtnBasic);
	private JButton hardButton = new JButton(hardBtnBasic);
	private JButton backButton = new JButton(backBtnBasic);
	
	
	private int mouseX, mouseY;
	
	private boolean isMainScreen = false;
	private boolean isGameScreen = false;
	
	ArrayList<Track> trackList = new ArrayList<Track>();
	
	private Image titleImage;
	private Image selectedImg;
	
	private Music selectedMusic;
	Music introMusic = new Music("introMusic.mp3", true);// 시작화면에서 음악이 무한재생될수있게 두번째 매개변수로 true를 주었기 떄문에 사용자가 직접 종료전까지 무한재생 
	
	private int nowSelected = 0;  // 선택된 트랙의 번호 
	
	public static Game game;
	
	public DynamicBeat() {
		
		trackList.add(new Track("shapeofyouTitle.png","Shape Of You Start Image.png"
				,"Shape Of You Game Image.jpg", "Shape Of You (noma Remix).mp3","ShapeofyouSelect.mp3","Shape Of You (noma Remix)"));
		trackList.add(new Track("spectreTitle.png","Spectre Start Image.png"
				,"Spectre Game Image.png", "Alan Walker - Spectre(Remix).mp3","SpectreSelect.mp3","Alan Walker - Spectre(Remix)"));
		trackList.add(new Track("uptownfunkTitle.png","Uptown Funk Start Image.png"
				,"Uptown Funk Game Image.jpg", "Mark Ronson feat. Bruno Mars - Uptown Funk (Fresh Kiwi Bootleg).mp3","UptownFunkSelect.mp3","Mark Ronson feat. Bruno Mars - Uptown Funk (Fresh Kiwi Bootleg)"));
		
		setUndecorated(true); // 기본적으로 존재했던 메뉴바 안보이게 
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0,0,0,0));
		setLayout(null);
		addKeyListener(new KeyListener());
		
		introMusic.start();
		
		exitButton.setBounds(1250,0,30,30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 커서 이미지 변경 
				// 효과음 
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) { // 해당 버튼에서 마우스가 벗어났을때 
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// 효과음 
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
				buttonPressedMusic.start();
				// 버튼이 눌려서 바로종료되는 것이기 때문에 효과음을 들을수 없기 때문에 1초뒤에 종료
				try { 
					Thread.sleep(1000);
				}catch (InterruptedException ie) {
					ie.printStackTrace();
					// TODO: handle exception
				}
				System.exit(0);
			}
		});
		
		add(exitButton);
		
		startButton.setBounds(40,200,400,100);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startBtnEntered);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 커서 이미지 변경 
				// 효과음 
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) { // 해당 버튼에서 마우스가 벗어났을때 
				startButton.setIcon(startBtnBasic);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// 효과음 
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
				buttonPressedMusic.start();
				// 버튼이 눌려서 바로종료되는 것이기 때문에 효과음을 들을수 없기 때문에 1초뒤에 종료
				// 게임시작 이벤트가 발생
				enterMain();
			}
		});
		
		add(startButton);
		
		
		quitButton.setBounds(40,330,400,100);
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(quitBtnEntered);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 커서 이미지 변경 
				// 효과음 
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) { // 해당 버튼에서 마우스가 벗어났을때 
				quitButton.setIcon(quitBtnBasic);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
				buttonPressedMusic.start();	
				
				try { 
					Thread.sleep(1000);
				}catch (InterruptedException ie) {
					ie.printStackTrace();
					// TODO: handle exception
				}
				System.exit(0);
			}
		});
		add(quitButton);
		
		leftButton.setVisible(false);
		leftButton.setBounds(140,310,60,60);
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				leftButton.setIcon(leftBtnEntered);
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 커서 이미지 변경 
				// 효과음 
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) { // 해당 버튼에서 마우스가 벗어났을때 
				leftButton.setIcon(leftBtnBasic);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
				buttonPressedMusic.start();	
				// 왼쪽버튼 이벤트 
				selectLeft();
			
			}
		});
		add(leftButton);
		
		rightButton.setVisible(false);
		rightButton.setBounds(1080,310,60,60);
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rightButton.setIcon(rightBtnEntered);
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 커서 이미지 변경 
				// 효과음 
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) { // 해당 버튼에서 마우스가 벗어났을때 
				rightButton.setIcon(rightBtnBasic);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
				buttonPressedMusic.start();	
				// 오른쪽버튼 이벤트 
				selectRight();
			}
		});
		add(rightButton);
		
		easyButton.setVisible(false);
		easyButton.setBounds(375,580,250,67);
		easyButton.setBorderPainted(false);
		easyButton.setContentAreaFilled(false);
		easyButton.setFocusPainted(false);
		easyButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				easyButton.setIcon(easyBtnEntered);
				easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 커서 이미지 변경 
				// 효과음 
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) { // 해당 버튼에서 마우스가 벗어났을때 
				easyButton.setIcon(easyBtnBasic);
				easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
				buttonPressedMusic.start();	
				// 난이도 easy 이벤트 
				gameStart(nowSelected, "Easy");
			}
		});
		add(easyButton);
		
		hardButton.setVisible(false);
		hardButton.setBounds(655,580,250,67);
		hardButton.setBorderPainted(false);
		hardButton.setContentAreaFilled(false);
		hardButton.setFocusPainted(false);
		hardButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				hardButton.setIcon(hardBtnEntered);
				hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 커서 이미지 변경 
				// 효과음 
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) { // 해당 버튼에서 마우스가 벗어났을때 
				hardButton.setIcon(hardBtnBasic);
				hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
				buttonPressedMusic.start();	
				// 난이도 hard 이벤트 
				gameStart(nowSelected, "Hard");
			}
		});
		add(hardButton);
		
		backButton.setVisible(false); 
		backButton.setBounds(20,50,60,60);
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				backButton.setIcon(backBtnEntered);
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 커서 이미지 변경 
				// 효과음 
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) { // 해당 버튼에서 마우스가 벗어났을때 
				backButton.setIcon(backBtnBasic);
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
				buttonPressedMusic.start();	
				// 메인 화면으로 돌아가는 이벤트 
				backMain();
			}
		});
		add(backButton);
		
		menuBar.setBounds(0,0,1280,30); // jframe 에 메뉴바 추가 
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x =e.getXOnScreen();
				int y =e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menuBar);	
		
	}

	// 전체화면 이미지를 프로그램이 종료되는 순간까지 계속 반복되면서 그려주는것 
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw((Graphics2D)(screenGraphic));
		g.drawImage(screenImage,0,0,null);
	}
	
	public void screenDraw(Graphics2D g) {
		g.drawImage(Background, 0, 0, null); // 단순한 이미지 그리는 용도 
		if(isMainScreen) {
			g.drawImage(selectedImg, 340,100,null);
			g.drawImage(titleImage, 340, 70,null);
		}
		if(isGameScreen) {
			game.screenDraw(g);
		}
		paintComponents(g);
		try {
			Thread.sleep(5);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		this.repaint();
	}
	
	public void selectedTrack(int nowSelected) { // 현재 선택된 곡의 번호를 넣어주고 선택된 곡을 알려주는 함수 
		if(selectedMusic != null)
			selectedMusic.close();
		// 현재 선택된 트랙 , 현재 선택된 곡이 가지고 있는 타이틀 이미지 값 을 넣어준다. 
		titleImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getTitleImage())).getImage();
		selectedImg = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getStartImage())).getImage();
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
		selectedMusic.start();
	}
	
	public void selectLeft() {
		if(nowSelected == 0) 
			nowSelected = trackList.size() - 1; // 0번째에서 왼쪽으로 누르면 2번째 항목이 나와야 하기 때문에 
		else
			nowSelected--;
		selectedTrack(nowSelected);
	}
	
	public void selectRight() {
		if(nowSelected == trackList.size() -1) 
			nowSelected = 0; // 마지막 항목에서 오른쪽으로 누르면 0번째 항목으로
		else
			nowSelected++;
		selectedTrack(nowSelected);
	}
	
	public void gameStart(int nowSelected, String difficulty) { 
		if(selectedMusic != null) 
			selectedMusic.close(); 
		isMainScreen = false; // 메인화면 없애기
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		easyButton.setVisible(false);
		hardButton.setVisible(false);
		Background =  new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getGameImage())).getImage();
		backButton.setVisible(true);
		isGameScreen = true;	
		game =new Game(trackList.get(nowSelected).getTitleName(), difficulty,trackList.get(nowSelected).getGameMusic());
		game.start();
		setFocusable(true);
	}
	
	public void backMain() {
		isMainScreen = true;
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		Background =  new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();
		backButton.setVisible(false);
		selectedTrack(nowSelected); // 다시 선택된 트랙을 보여주고 하이라이트 재생 
		isGameScreen = false;
		game.close(); // 게임 종료 다른곡선택 
	}
	
	public void enterMain() {	
		startButton.setVisible(false); // start,quit btn 안보이게 set 하고 백그라운드 이미지 변경 
		quitButton.setVisible(false);
		Background =  new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();
		isMainScreen = true;
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		introMusic.close();
		selectedTrack(0); // 첫번째 곡으로 셋팅 
	}
}
