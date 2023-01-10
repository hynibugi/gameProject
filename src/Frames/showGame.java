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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class showGame extends JFrame {
	MyComponent compo = new MyComponent();
	Huddle huddle = new Huddle();
	ClassLoader classLoader = getClass().getClassLoader();
	List<MyComponent> list = new ArrayList<>();
	List<Huddle> huddlelist = new ArrayList<>();
	Toolkit kit = Toolkit.getDefaultToolkit();
	Image imC = kit.getImage(classLoader.getResource("original.png"));
	Image imbg = kit.getImage(classLoader.getResource("background.png"));
	Image pepper = kit.getImage(classLoader.getResource("pepper.png"));

	int whereX;
	int whereY;
	private JPanel contentPnl;
	private JLabel characterIng;
	private Timer timer; // 배경 타이머

	private int x;
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
					if (j.getX() == 120 && 280 == getWhereY()) {
						j.setVisible(false);
						step.stop();
						timer.stop();
					}

				}
			}
		});
		step.start(); // 타이머시작

	}

	public void showJelly() {

	}

	public showGame() {
		contentPnl = new JPanel();
		setContentPane(contentPnl);
		contentPnl.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPnl.setLayout(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 437);

		JLabel bgIng = new JLabel(""); // 배경
		bgIng.setIcon(new ImageIcon(imbg));
		bgIng.setBounds(0, 0, 100000, 400);
		x = 0;
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
		characterIng.setBounds(whereX, whereY, 350, 153);
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
// 					자동내려오기
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

		down = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (whereY == 220) {
					setWhereX(50);
					setWhereY(280);
					characterIng.setBounds(whereX, whereY, 100, 100);
					System.out.println("자동 내려오기");
				} else
					down.stop();
			}
		});
		down.start();

		characterIng.setIcon(new ImageIcon(imC));
		try {
			grapPix();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		characterIng.setIcon(new ImageIcon(imC));
		contentPnl.add(characterIng);
		contentPnl.add(bgIng);
	}

}