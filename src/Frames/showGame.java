package Frames;
import java.awt.EventQueue;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class showGame extends JFrame {
	
	Huddle huddle = new Huddle();
	ClassLoader classLoader = getClass().getClassLoader();
	List<Huddle> huddlelist = new ArrayList<>();
	Toolkit kit = Toolkit.getDefaultToolkit();
	Image imC = kit.getImage(classLoader.getResource("stand.png"));
	Image imbg = kit.getImage(classLoader.getResource("background.png"));
	Image pepper = kit.getImage(classLoader.getResource("pepper.png"));

	int whereX;
	int whereY;
	private JPanel contentPnl;
	private JLabel characterIng;
	private Timer score; // 점수 타이머
	private int score1 = 0;
	private JLabel lbl_score;
	private Timer timer; // 배경 타이머

	private int x = 0;
	static final int BLACK = -16777216;
	private Timer step;
	private Timer down;
	
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
		BufferedImage img = ImageIO.read(showGame.class.getClassLoader().getResource("huddle.png"));

		for (int i = 0; i < img.getWidth(); i++) {
			int ww = img.getRGB(i, img.getHeight() - 15);

			if (ww == -1237980) {
				huddle = new Huddle();
				huddlelist.add(huddle);
				huddle.setBounds(i * 10, 320, 50, 50);
				huddle.imageUpdate(pepper, i * 10, 320, 50, 40, 20);
				getContentPane().add(huddle);

			}
		}

		step = new Timer(80, new ActionListener() { // 이동속도 변경
			@Override
			public void actionPerformed(ActionEvent e) {
				for (Huddle j : huddlelist) {
					j.setLocation(j.getX() - 10, j.getY()); // x값-10하기
					for (int i = 45 ; i < 84 ; i++) {
						if (j.getX() == i && 280 == getWhereY()) {
							System.out.println(j.getX() +" // "+ getWhereY());
							j.setVisible(false);
							step.stop();
							timer.stop();
							score.stop();
						}
					}
				}
			}
		});
		step.start(); // 타이머시작

	}

	public showGame() {
		contentPnl = new JPanel();
		setContentPane(contentPnl);
		contentPnl.setBorder(null);
		contentPnl.setLayout(null);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 437);

		JLabel bgIng = new JLabel(""); // 배경
		bgIng.setIcon(new ImageIcon(imbg));
		bgIng.setBounds(0, 0, 100000, 400);
		
		timer = new Timer(25, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				x -= 4;
				if (x <= -15700) {
					timer.stop();
					x = 0;
					// resultPanel.setVisible(true);
				} else {
					bgIng.setLocation(x, 0);
				}
			}
		});
		timer.start();

		characterIng = new JLabel(""); // 게임중인 캐릭터
		whereX = 50;
		whereY = 280;
		characterIng.setFocusable(true);
		characterIng.setIcon(new ImageIcon(imC));
		characterIng.setBounds(whereX, whereY, 68, 80);
		characterIng.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				down.start();
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					whereY = 220;
					characterIng.setBounds(whereX, whereY, 68, 80);
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					whereY = 280;
					characterIng.setBounds(whereX, whereY, 68, 80);
				}
			}
		});

		down = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (whereY == 220) {
					setWhereX(50);
					setWhereY(280);
					characterIng.setBounds(whereX, whereY, 68, 80);
					System.out.println("자동 내려오기");
					down.stop();
				} 
			}
		});

		try {
			grapPix();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		lbl_score = new JLabel(String.valueOf(score1));
		lbl_score.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lbl_score.setBounds(583, 10, 90, 31);

		score1 = 0;
		score = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("10점씩 증가");
				System.out.println(score1);
				score1 += 10;
				lbl_score.setText(String.valueOf(score1));
			}
		});
		score.start();

		contentPnl.add(lbl_score);
		contentPnl.add(characterIng);
		contentPnl.add(bgIng);

	}

}