package Frames;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import info.UserinfoRepositoryImpl;

public class shop extends JFrame {

	private JLabel contentPane;
	ClassLoader classLoader = getClass().getClassLoader();
	Toolkit kit = Toolkit.getDefaultToolkit();
	Image shopImage = kit.getImage(classLoader.getResource("shop.png"));
	
	private JLabel[] price = new JLabel[3];

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					shop frame = new shop();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public shop() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JLabel();
		contentPane.setBorder(null);
		contentPane.setIcon(new ImageIcon(shopImage));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		for (int i = 0; i < price.length; i++) {
			price[i] = new JLabel("1000원");
			price[i].setFont(new Font("맑은 고딕", Font.BOLD, 12));
			price[i].setBounds(69 + i * 160, 290, 50, 15);
			contentPane.add(price[i]);	
		}
		
		UserinfoRepositoryImpl ur = new UserinfoRepositoryImpl();
		LogIn lg = new LogIn();
		
		String inputId = lg.getMyId();
		String money = String.valueOf(ur.countMoney(inputId));
		
		JLabel myMoney = new JLabel(money);
		myMoney.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		myMoney.setBounds(12, 10, 57, 23);
		contentPane.add(myMoney);
		
	}
	public void showGUI() {
		setVisible(true);
	}

}
