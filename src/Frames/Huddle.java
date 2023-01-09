package Frames;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

class Huddle extends JComponent {
//
//	private Rectangle hitbox;
//	private int x, y;
//	private int width, height;
//	private Image huddle;
//
//	public int getX() {
//		return x;
//	}
//
//	public void setX(int x) {
//		this.x = x;
//	}
//
//	public int getY() {
//		return y;
//	}
//
//	public void setY(int y) {
//		this.y = y;
//	}
//
//	// 장애물좌표값
//	public Huddle(Rectangle hitbox, int x, int y, int width, int height, Image huddle) {
//		super();
//		this.hitbox = hitbox;
//		this.x = x;
//		this.y = y;
//		this.width = width;
//		this.height = height;
//		this.huddle = huddle;
//	}
//
//	public Huddle() {
//	}

	public void paintComponent(Graphics g) {
		g.setColor(null);
		//g.fillRect(0, 0, 50, 50);

		ClassLoader classLoader = getClass().getClassLoader();
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image pepper = kit.getImage(classLoader.getResource("pepper.png"));
		g.drawImage(pepper, 0, 0, null);

		g.dispose();
	}

}
