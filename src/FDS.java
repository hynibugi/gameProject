import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class FDS extends JFrame {
	public static void main(String[] args) {
		JFrame frame = new JFrame("창");
		frame.setSize(500, 500);
		frame.setVisible(true);
		JPanel jp = new JPanel();
		jp.setLayout(null);
		frame.add(jp);
		JButton j1 = new JButton("버튼1");
		j1.setBounds(150, 0, 50, 50);
		jp.add(j1);
		JButton j2 = new JButton("2");
		j2.setBounds(200, 0, 50, 50);
		jp.add(j2);
		JButton j3 = new JButton("3");
		j3.setBounds(250, 0, 50, 50);
		jp.add(j3);
		List<JComponent> list = new ArrayList<>();
		list.add(j1);
		list.add(j2);
		list.add(j3);
		Timer timer = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (JComponent j : list) {
					j.setLocation(j.getX() - 10, j.getY());
				}
			}
		});
		timer.start();
	}
}



