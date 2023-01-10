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
import javax.swing.JPanel;

class Huddle extends JComponent {

	
	public void paintComponent(Graphics g) {
		g.setColor(null);

		ClassLoader classLoader = getClass().getClassLoader();
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image pepper = kit.getImage(classLoader.getResource("pepper.png"));
		g.drawImage(pepper, 0, 0, null);

		g.dispose();
	}

}
