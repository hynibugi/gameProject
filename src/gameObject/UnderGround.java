package gameObject;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class UnderGround {
	
	ClassLoader classLoader = getClass().getClassLoader();
	Toolkit kit = Toolkit.getDefaultToolkit();
	Image img = kit.getImage(classLoader.getResource("groundSmall.jpg"));
	
	public static void main(String[] args) {
			
			System.out.println("프로그램 시작");
	}
}
