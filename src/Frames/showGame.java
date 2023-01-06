package Frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import gameObject.Jelly;
import gameObject.Jellyy;
import gameObject.Obstacle;

public class showGame extends JFrame {
	MyComponent compo = new MyComponent();
	ClassLoader classLoader = getClass().getClassLoader();
	List<MyComponent> list = new ArrayList<>();
	Toolkit kit = Toolkit.getDefaultToolkit();
	Image imC = kit.getImage(classLoader.getResource("original.png"));
	Image imbg = kit.getImage(classLoader.getResource("background.png"));
//   Image jelly = kit.getImage(classLoader.getResource("jelly.png"));

	int whereX;
	int whereY;
	private JPanel contentPnl;
	private JLabel characterIng;
	private Timer timer; // 배경 타이머
	private Timer timerJ; // 젤리 타이머
	private int x;
	static final int BLACK = -16777216;
	private Jelly jellyS;
	private int frameX;

	public int getWhereX() {
		return whereX;
	}

	public void setWhereX(int whereX) {
		this.whereX = whereX;
	}

	public int getWhereY() {
		return whereY;
	}

	public void setWhereY(int whereY) {
		this.whereY = whereY;
	}

	public void grapPix() throws IOException {
		BufferedImage img = ImageIO.read(showGame.class.getClassLoader().getResource("steps.png"));
		for (int i = 0; i < img.getWidth(); i++) {
			int rgb = img.getRGB(i, img.getHeight() - 1);
			if (rgb == BLACK) { // 검정색 이라면?
				compo = new MyComponent(); // 발판만들기
				list.add(compo); // 리스트에 발판추가
				compo.setBounds(i * 15, 349, 60, 60); // 범위설정
				
				getContentPane().add(compo); /// 컴포넌트에 추가하고보이게

			} else {
				// 아니면 아무수행 하지않음
			}

		}
		System.out.println(list.get(1)); // list에 값 담겨있음
		Timer step = new Timer(10, new ActionListener() { // 타이머 1초마다움직이게함
			@Override
			public void actionPerformed(ActionEvent e) {
				for (MyComponent j : list) {
					j.setLocation(j.getX() - 10, j.getY()); // x값-10하기
				}

			}
		});
		step.start(); // 타이머시작

	}

	public showGame() {
		contentPnl = new JPanel();
		setContentPane(contentPnl);
		contentPnl.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPnl.setLayout(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 437);

		Obstacle ob = new Obstacle(500, 300, 50, 50);
		ob.setBounds(ob.getX(), ob.getY(), 100, 100);

		JLabel lbl_picture = new JLabel("짱구야 오늘도 달려보자앗 ~");
		lbl_picture.setBackground(Color.LIGHT_GRAY);
		lbl_picture.setBounds(12, 10, 661, 112);
		lbl_picture.setVisible(true);
		contentPnl.add(lbl_picture);

		JPanel resultPanel = new JPanel();
		resultPanel.setBackground(new Color(0, 0, 25, 25));
		resultPanel.setBounds(134, 62, 446, 253);
		contentPnl.add(resultPanel);
		resultPanel.setVisible(false);
		resultPanel.setLayout(null);

		JLabel lbl_gameResult = new JLabel("게임결과");
		lbl_gameResult.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lbl_gameResult.setBounds(167, 10, 107, 43);
		lbl_gameResult.setHorizontalAlignment(JLabel.CENTER);
		resultPanel.add(lbl_gameResult);

		JLabel lbl_nickname = new JLabel("닉네임 :");
		lbl_nickname.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lbl_nickname.setBounds(12, 65, 57, 25);
		lbl_nickname.setHorizontalAlignment(JLabel.RIGHT);
		resultPanel.add(lbl_nickname);

		JLabel lbl_nicknameA = new JLabel("짱구");
		lbl_nicknameA.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lbl_nicknameA.setBounds(80, 65, 57, 25);
		lbl_nicknameA.setHorizontalAlignment(JLabel.LEFT);
		resultPanel.add(lbl_nicknameA);

		JLabel lbl_score = new JLabel("점수 :");
		lbl_score.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lbl_score.setBounds(12, 100, 57, 25);
		lbl_score.setHorizontalAlignment(JLabel.RIGHT);
		resultPanel.add(lbl_score);

		JLabel lbl_scoreA = new JLabel("100000점");
		lbl_scoreA.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lbl_scoreA.setBounds(80, 100, 67, 25);
		lbl_scoreA.setHorizontalAlignment(JLabel.CENTER);
		resultPanel.add(lbl_scoreA);

		JLabel lbl_random = new JLabel("○○○ :");
		lbl_random.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_random.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lbl_random.setBounds(12, 135, 57, 25);
		resultPanel.add(lbl_random);

		JLabel lbl_randomA = new JLabel("○○○");
		lbl_randomA.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_randomA.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lbl_randomA.setBounds(80, 135, 67, 25);
		resultPanel.add(lbl_randomA);

		JLabel lbl_random_B = new JLabel("○○○ :");
		lbl_random_B.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_random_B.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lbl_random_B.setBounds(12, 170, 57, 25);
		resultPanel.add(lbl_random_B);

		JLabel lbl_randomD = new JLabel("○○○");
		lbl_randomD.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_randomD.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lbl_randomD.setBounds(80, 170, 67, 25);
		resultPanel.add(lbl_randomD);

		JLabel bgIng = new JLabel(""); // 배경
		bgIng.setIcon(new ImageIcon(imbg));
		bgIng.setBounds(0, 0, 100000, 400);
		x = 0;
		timer = new Timer(16, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				x -= 10;
				if (x <= -15700) {
					timer.stop();
					x = 0;
					resultPanel.setVisible(true);
				} else {
					bgIng.setLocation(x, 0);
					ob.updatePosition(-10, 0);

				}
			}
		});
		timer.start();

		Timer timer2 = new Timer(3000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("11");
				lbl_picture.setVisible(false);
			}
		});
		timer2.start();
//      jellyS = new Jelly(700, 300, jelly);
//      JLabel jIng = new JLabel("");
//      jIng.setIcon(new ImageIcon(jellyS.getImJelly()));
//      jIng.setBounds(jellyS.getJellyX(), jellyS.getJellyY(), 50, 50);

		Jellyy jellyy = new Jellyy();
		jellyy.makeJellyy(contentPnl);

		frameX = 670;

		timerJ = new Timer(48, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frameX -= 5;
				for (int i = 0; i < 3; i++) {
					jellyy.getJellys()[i].setLocation(frameX, jellyy.getY(jellyy.getJellys()[i]));
				}
				if (frameX <= 120) {
					jellyy.deleteJellyy(contentPnl);
				}

			}
		});
		timerJ.start();

		characterIng = new JLabel(""); // 게임중인 캐릭터
		whereX = 50;
		whereY = 260;
		characterIng.setFocusable(true);
		characterIng.setBounds(whereX, whereY, 100, 100);
		characterIng.addKeyListener(new KeyListener() {
			private int count = 0;

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_UP) {
					whereY = 220;
					characterIng.setBounds(whereX, whereY, 100, 100);
					count++;
					if (count == 1) {
//                  System.out.println("1단점프");
						System.out.println("(x, y) = " + getWhereX() + ", " + getWhereY());
					}

					if (count == 2) {
//                  System.out.println("2단점프");
						whereY = 180;
						characterIng.setBounds(whereX, whereY, 100, 100);
						System.out.println("(x, y) = " + getWhereX() + ", " + getWhereY());
						count--;
					}
				}
				if (key == KeyEvent.VK_DOWN) {
//               System.out.println("슬라이드");
					count = 0;
					whereY = 280;
					characterIng.setBounds(whereX, whereY, 100, 100);
//               System.out.println("(x, y) = " + getWhereX() + ", " + getWhereY());
				}
			}
		});
		characterIng.setIcon(new ImageIcon(imC));
		try {
			grapPix();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		characterIng.setIcon(new ImageIcon(imC));
		contentPnl.add(ob);
		contentPnl.add(characterIng);
		contentPnl.add(bgIng);
	}

}