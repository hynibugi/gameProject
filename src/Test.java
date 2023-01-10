import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Frames.showGame;

public class Test {
	public static void main(String[] args) throws IOException {
		BufferedImage img = ImageIO.read(showGame.class.getClassLoader().getResource("steps.png"));

		for (int i = 0; i < img.getWidth(); i++) {
			int ww = img.getRGB(i, img.getHeight() - 15);
			if (ww == -1237980) {
				System.out.println(i);
			}
		}
	}
}
