package gameObject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.JComponent;

public class Obstacle extends JComponent {
	private Rectangle hitbox;
	private int x, y;
	private int width, height;
	private Image huddle;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	// 장애물의 좌표값
	public Obstacle(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.hitbox = new Rectangle(x, y, width, height);
	}

	// 장애물 위치이동
	public void updatePosition(int dx, int dy) {
		x += dx;
		y += dy;
		hitbox.setLocation(x, y);
	}

	// 충돌확인
	public boolean collidesWith(Rectangle r) {
		return hitbox.intersects(r);
	}

	@Override
	protected void paintComponent(Graphics g) {
//		super.paintComponent(g);
		g.setColor(Color.black);
		g.fillRect(0, 0, width, height);
		g.dispose();
	}

}