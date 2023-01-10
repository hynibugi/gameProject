package Frames;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JComponent;

class Huddle extends JComponent {

	private Image image;	
	public Huddle(Image image) {
		super();
		this.image = image;
	}

	public void paintComponent(Graphics g) {
		g.setColor(null);
		g.drawImage(image, 0, 0, null);
		g.dispose();
	}
}
