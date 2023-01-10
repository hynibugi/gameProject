package Frames;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import info.UserinfoRepositoryImpl;

public class MyRoom extends JFrame implements ActionListener {
	private LogIn login;
	private JLabel contentPane;
	private JButton[] lock = new JButton[5];
	private JButton[] choice = new JButton[5];
	ClassLoader classLoader = getClass().getClassLoader();
	Toolkit kit = Toolkit.getDefaultToolkit();
	Image mainRoom = kit.getImage(classLoader.getResource("myRoomBack.png"));
	Image lockImage = kit.getImage(classLoader.getResource("lock.png"));
	Image choiceImage = kit.getImage(classLoader.getResource("choice.png"));
	private int myNo;
	private UserinfoRepositoryImpl ur;


	public MyRoom(LogIn login) {
		this.login = login;
		ur = new UserinfoRepositoryImpl();
		setBounds(100, 100, 832, 400);
		
		contentPane = new JLabel();
		contentPane.setIcon(new ImageIcon(mainRoom));
		contentPane.setBorder(null);
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		for (int i = 0; i < lock.length; i++) {
			lock[i] = new JButton();
			lock[i].setIcon(new ImageIcon(lockImage));
			lock[i].setBorder(null);
			lock[i].setBounds(32 + i * 160, 160, 118, 125);
			lock[i].setContentAreaFilled(false);
			contentPane.add(lock[i]);
		}
		
		for (int i = 0; i < lock.length; i++) {
			choice[i] = new JButton();
			choice[i].setBorder(null);
			choice[i].setBounds(32 + i * 160, 160, 118, 125);
			choice[i].setContentAreaFilled(false);
			choice[i].addActionListener(this);
			contentPane.add(choice[i]);
		}
		choice[0].setIcon(new ImageIcon(choiceImage));
		
		myNo = ur.getMyNo(login.getMyId());
		
		for ( int i = 0; i < lock.length; i++) {
			int haveResult = ur.haveCharacter(myNo, i + 1);
			if (haveResult == 1) {
				lock[i].setVisible(false);
			}
		}
		
	}
	public void showGUI() {
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < choice.length; i++) {
			if(e.getSource() == choice[i]) {
					int haveResult = ur.haveCharacter(myNo, i + 1);
					if (haveResult == 1) {
						choice[i].setIcon(new ImageIcon(choiceImage));
						ur.choiceCharacte(myNo, i + 1);
				}
			} else {
				choice[i].setIcon(null);
			}
		}
		
	}
}
