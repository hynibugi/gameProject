package Frames;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

class Jelly extends JComponent {

	public void paintComponent(Graphics g) {
		g.setColor(Color.pink);
		g.fillRect(24, 40, 40, 40);
		g.dispose();
	}
}
