package gameObject;

import java.awt.Point;
import java.net.URL;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Jellyy {
	private JLabel[] jellys;

	

	public JLabel[] getJellys() {
		return jellys;
	}

	public void setJellys(JLabel[] jellys) {
		this.jellys = jellys;
	}

	public Jellyy() {
	}
	
	public void makeJellyy(JPanel pnl) {
		ClassLoader cl = getClass().getClassLoader();
		URL jellyURL = cl.getResource("info/choco.png");
		ImageIcon jellyIcon = new ImageIcon(jellyURL); 
		
		jellys = new JLabel[6];
		Random r = new Random();
		
		for (int i = 0; i < 3; i++) {
			jellys[i] = new JLabel(jellyIcon);
			int x = 670;
			int y = 180 + r.nextInt(220);
			
			jellys[i].setBounds(x, y, 60, 60);
			pnl.add(jellys[i]);					
		}
		
	}
	
	public void deleteJellyy(JPanel pnl) {
		for (int i = 0; i < 3; i++) {
			pnl.remove(jellys[i]);
		}
		pnl.revalidate();
		pnl.repaint();
	}
	
	public int getY(JLabel jelly) {
		Point pt = jelly.getLocation();
		return (int) pt.getY();
	}
}
