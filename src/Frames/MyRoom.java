package Frames;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class MyRoom extends JFrame {

	private JLabel contentPane;
	ClassLoader classLoader = getClass().getClassLoader();
	Toolkit kit = Toolkit.getDefaultToolkit();
	Image mainRoom = kit.getImage(classLoader.getResource("myRoomBack.png"));


	public MyRoom() {
		setBounds(100, 100, 832, 400);
		contentPane = new JLabel();
		contentPane.setIcon(new ImageIcon(mainRoom));
		contentPane.setBorder(null);

		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(183, 76, -151, 242);
		panel_1.setBackground(Color.GRAY);
		contentPane.add(panel_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(462, 43, -257, 308);
		contentPane.add(panel);
		
		
	}
	public void showGUI() {
		setVisible(true);
	}
}
