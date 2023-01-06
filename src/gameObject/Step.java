package gameObject;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Frames.showGame;

public class Step {
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

		BufferedImage img = ImageIO.read(showGame.class.getClassLoader().getResource("step.jpg"));
		for (int i = 0; i < img.getWidth(); i++) {
			int rgb = img.getRGB(i, img.getHeight() - 1);

			if (rgb == BLACK) { // 검정색 이라면?
				MyComponent compo = new MyComponent();
				System.out.println("발판");
				compo.setBounds(i * 60, 347, 60, 60);
				contentPane.add(compo); /// 추가하고보이게
			} else {
				System.out.println("발판아님");
			}

		}

	}
}
