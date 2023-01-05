package Frames;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import gameObject.Jelly;
import gameObject.Jellyy;
import gameObject.Obstacle;

public class showGame extends JFrame {

	ClassLoader classLoader = getClass().getClassLoader();
	Toolkit kit = Toolkit.getDefaultToolkit();
	Image imC = kit.getImage(classLoader.getResource("original.png"));
	Image imbg = kit.getImage(classLoader.getResource("background.png"));
//	Image jelly = kit.getImage(classLoader.getResource("jelly.png"));

	int whereX;
	int whereY;
	private JPanel contentPane;
	private JLabel characterIng;
	private Timer timer; // 배경 타이머
	private Timer timerJ; // 젤리 타이머
	private int x;
	final int BLACK = -16777216;
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

		BufferedImage img = ImageIO.read(showGame.class.getClassLoader().getResource("step.jpg"));
		for (int i = 0; i < img.getWidth(); i++) {
			int rgb = img.getRGB(i, img.getHeight() - 1);

			if (rgb == BLACK) { // 검정색 이라면?
				System.out.println("발판");
				MyComponent compo = new MyComponent();
				compo.setBounds(i * 60, 347, 60, 60);
				contentPane.add(compo); /// 추가하고보이게
			} else {
				System.out.println("발판아님");
			}

		}

	}

	public showGame() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Obstacle ob = new Obstacle(500, 300, 50, 50);
		ob.setBounds(ob.getX(), ob.getY(), 100, 100);

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
				} else {
					bgIng.setLocation(x, 0);
					ob.updatePosition(-10, 0);

				}
			}
		});
		timer.start();

//		jellyS = new Jelly(700, 300, jelly);
//		JLabel jIng = new JLabel("");
//		jIng.setIcon(new ImageIcon(jellyS.getImJelly()));
//		jIng.setBounds(jellyS.getJellyX(), jellyS.getJellyY(), 50, 50);

		Jellyy jellyy = new Jellyy();
		jellyy.makeJellyy(contentPane);
		
		frameX = 670;
		
		timerJ = new Timer(48, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frameX -= 5;
				for (int i = 0; i < 3; i++) {
					jellyy.getJellys()[i].setLocation(frameX, jellyy.getY(jellyy.getJellys()[i]));
				}
				if (frameX <= 120) {
					jellyy.deleteJellyy(contentPane);
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
						System.out.println("1단점프");
						System.out.println("(x, y) = " + getWhereX() + ", " + getWhereY());
					}

					if (count == 2) {
						System.out.println("2단점프");
						whereY = 180;
						characterIng.setBounds(whereX, whereY, 100, 100);
						System.out.println("(x, y) = " + getWhereX() + ", " + getWhereY());
						count--;
					}
				}
				if (key == KeyEvent.VK_DOWN) {
					System.out.println("슬라이드");
					count = 0;
					whereY = 280;
					characterIng.setBounds(whereX, whereY, 100, 100);
					System.out.println("(x, y) = " + getWhereX() + ", " + getWhereY());
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
		contentPane.add(ob);
		contentPane.add(characterIng);
		contentPane.add(bgIng);
	}

	class MyComponent extends JComponent {
		public void paintComponent(Graphics g) {
			g.setColor(Color.black);
			g.fillRect(0, 0, 60, 60);
			g.dispose();
		}
	}

}