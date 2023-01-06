package Frames;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class Step {
	static List<MyComponent> list = new ArrayList<>();
	MyComponent compo = new MyComponent();
	static final int BLACK = -16777216;
	private int x, y;

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
	public void steps(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void grapPix() throws IOException {
		showGame sg = new showGame();
		BufferedImage img = ImageIO.read(showGame.class.getClassLoader().getResource("step.jpg"));
		for (int i = 0; i < img.getWidth(); i++) {
			int rgb = img.getRGB(i, img.getHeight() - 1);
			if (rgb == BLACK) { // 검정색 이라면?
				System.out.println("발판");
				compo.setBounds(i * 60, 347, 60, 60);
				sg.getContentPane().add(compo); /// 추가하고보이게
				list.add(compo);

			} else {
				System.out.println("발판아님");
			}

		}

	}

	public static void main(String[] args) {

	}
}
