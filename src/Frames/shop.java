package Frames;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import info.UserinfoRepositoryImpl;

public class shop extends JFrame implements ActionListener {
	private LogIn login;
	private JLabel contentPane;
	ClassLoader classLoader = getClass().getClassLoader();
	Toolkit kit = Toolkit.getDefaultToolkit();
	Image shopImage = kit.getImage(classLoader.getResource("showShop.png"));
	Image lockImage = kit.getImage(classLoader.getResource("lock.png"));
	
	
	private JLabel[] price = new JLabel[4];
	private JButton[] lock = new JButton[5];
	private int[] characterPrice = {3000, 5000, 7000, 9000};
	private JLabel myMoney;
	

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					shop frame = new shop();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public shop(LogIn login) {
		this.login = login;
		UserinfoRepositoryImpl ur = new UserinfoRepositoryImpl();
		
		setBounds(100, 100, 662, 400);
		contentPane = new JLabel();
		contentPane.setBorder(null);
		contentPane.setIcon(new ImageIcon(shopImage));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		for (int i = 1; i < lock.length; i++) {
			lock[i] = new JButton();
			lock[i].setIcon(new ImageIcon(lockImage));
			lock[i].setBorder(null);
			lock[i].setBounds(32 + (i - 1) * 160, 160, 118, 125);
			lock[i].setContentAreaFilled(false);
			lock[i].addActionListener(this);
			contentPane.add(lock[i]);
		}
		
		int myNo = ur.getMyNo(login.getMyId());
		
		for ( int i = 1; i < lock.length; i++) {
			int haveResult = ur.haveCharacter(myNo, i + 1);
			if (haveResult == 1) {
				lock[i].setVisible(false);
			}
		}
		
		for (int i = 0; i < price.length; i++) {
			price[i] = new JLabel(String.valueOf(characterPrice[i]) + " 원");
			price[i].setFont(new Font("맑은 고딕", Font.BOLD, 12));
			price[i].setBounds(100 + i * 160, 315, 50, 15);
			contentPane.add(price[i]);	
		}
		
		
		String inputId = login.getMyId();
		System.out.println("로그인 ? " + inputId);
		String money = String.valueOf(ur.countMoney(inputId));
		
		myMoney = new JLabel(money + " 원");
		myMoney.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		myMoney.setHorizontalAlignment(SwingConstants.RIGHT);
		myMoney.setBounds(150, 55, 60, 23);
		contentPane.add(myMoney);
		
	}
	public void showMoney(String money) {
		myMoney.setText(money + "원");
	}
	public void showGUI() {
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int whatCharacter = 0;
		UserinfoRepositoryImpl ur = new UserinfoRepositoryImpl();
		String inputId = login.getMyId();
		
		for (int i = 1; i < lock.length; i++) {
			if (e.getSource() == lock[i]) {
				if(ur.countMoney(inputId) >= characterPrice[i-1]) {
					ur.changeMoney(inputId, characterPrice[i-1]);
					whatCharacter = i + 1;
					lock[i].setIcon(null);
					lock[i].setEnabled(false);
					String changeMoney = String.valueOf(ur.countMoney(inputId));
					myMoney.setText(changeMoney + "원");
				}
			}
		}
		System.out.println("로그인?? : " + inputId);
		ur.buyCharacter(inputId, whatCharacter);
		System.out.println(inputId);
		System.out.println(whatCharacter + 1);
	}
}




