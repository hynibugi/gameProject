package Frames;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
//발판그림그리기
class MyComponent extends JComponent {
		public void paintComponent(Graphics g) {
			g.setColor(Color.black);
			g.fillRect(0, 0, 60, 60);
			g.dispose();
		}
	}

