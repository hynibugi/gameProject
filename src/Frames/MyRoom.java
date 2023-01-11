package Frames;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import info.UserinfoRepositoryImpl;

public class MyRoom extends JFrame implements ActionListener {
	
	ClassLoader classLoader = getClass().getClassLoader();
	Toolkit kit = Toolkit.getDefaultToolkit();
	Image mainRoom = kit.getImage(classLoader.getResource("bgMyRoom.png"));
	Image lockImage = kit.getImage(classLoader.getResource("lock.png"));
	Image choiceImage = kit.getImage(classLoader.getResource("choice.png"));
	
	Image c1 = kit.getImage(classLoader.getResource("c1.gif"));
	Image c2 = kit.getImage(classLoader.getResource("c2.gif"));
	Image c3 = kit.getImage(classLoader.getResource("c3.gif"));
	Image c4 = kit.getImage(classLoader.getResource("c4.gif"));
	Image c5 = kit.getImage(classLoader.getResource("c5.gif"));
	private Image[] cImage = {c1, c2, c3, c4, c5};
	
	private String[] cImageName = {"달리는 짱구", "자전거 짱구", "시골의 짱구", "눈사람 짱구", "우비쓴 짱구" };
	private JLabel[] cImageNamelbl = new JLabel[5];
	private JLabel[] cImagelbl = new JLabel[5];
	private JLabel contentPane;
	private JButton[] lock = new JButton[5];
	private JButton[] choice = new JButton[5];
	
	private LogIn login;
	private int myNo;
	private UserinfoRepositoryImpl ur; 


	public MyRoom(LogIn logIn) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Menu menu = new Menu(login);
				menu.showGUI();
			}
		});
		this.login = logIn;
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
			choice[i].setBounds(75 + i * 160, 200, 118, 125);
			choice[i].setContentAreaFilled(false);
			contentPane.add(choice[i]);
			choice[i].addActionListener(this);
		}
		int findC = ur.findCharacte(login.getMyId()) - 1;
		System.out.println("내캐릭터" + findC);
		choice[findC].setIcon(new ImageIcon(choiceImage));
		
		for (int i = 0; i < cImagelbl.length; i++) {
			cImagelbl[i] = new JLabel();
			cImagelbl[i].setIcon(new ImageIcon(cImage[i]));
			cImagelbl[i].setFocusable(false);
			cImagelbl[i].setBorder(null);
			cImagelbl[i].setBounds(45 + i * 160, 160, 118, 125);
			contentPane.add(cImagelbl[i]);
		}
		
		for (int i = 0; i < cImageNamelbl.length; i++) {
			cImageNamelbl[i] = new JLabel(cImageName[i]);
			cImageNamelbl[i].setBorder(null);
			cImageNamelbl[i].setBounds(58 + i * 159, 260, 118, 125);
			contentPane.add(cImageNamelbl[i]);
		}
		
		myNo = ur.getMyNo(login.getMyId());
		System.out.println(myNo + ": myNo");
		
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
						login.setMyCharacter(i + 1);
					}
			} else {
				choice[i].setIcon(null);
			}
		}
		
	}
}
