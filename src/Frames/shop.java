package Frames;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class shop extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public shop() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 60, 460, 250);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_characterA = new JLabel("훈이");
		lbl_characterA.setBounds(12, 10, 130, 174);
		panel.add(lbl_characterA);
		
		JLabel lbl_characterB = new JLabel("유리");
		lbl_characterB.setBounds(164, 10, 130, 174);
		panel.add(lbl_characterB);
		
		JLabel lbl_characterC = new JLabel("철수");
		lbl_characterC.setBounds(318, 10, 130, 174);
		panel.add(lbl_characterC);
		
		JLabel lbl_HoldingsA = new JLabel("보유금액");
		lbl_HoldingsA.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lbl_HoldingsA.setBounds(12, 225, 57, 15);
		panel.add(lbl_HoldingsA);
		
		JLabel lbl_HoldingsB = new JLabel("보유금액");
		lbl_HoldingsB.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lbl_HoldingsB.setBounds(164, 225, 57, 15);
		panel.add(lbl_HoldingsB);
		
		JLabel lbl_HoldingsC = new JLabel("보유금액");
		lbl_HoldingsC.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lbl_HoldingsC.setBounds(318, 225, 57, 15);
		panel.add(lbl_HoldingsC);
		
		JLabel lbl_moneyA = new JLabel("10000원");
		lbl_moneyA.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lbl_moneyA.setBounds(85, 225, 57, 15);
		panel.add(lbl_moneyA);
		
		
		JLabel lbl_moneyB = new JLabel("10000원");
		lbl_moneyB.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lbl_moneyB.setBounds(237, 225, 57, 15);
		panel.add(lbl_moneyB);
		
		JLabel lbl_moneyC = new JLabel("10000원");
		lbl_moneyC.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lbl_moneyC.setBounds(391, 225, 57, 15);
		panel.add(lbl_moneyC);
		
		
		JButton btn_back = new JButton("뒤로가기");
		btn_back.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btn_back.setBounds(375, 10, 97, 23);
		btn_back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Menu().showGUI();
				dispose();
				
			}
		});
		contentPane.add(btn_back);
		
		JLabel lbl_shop = new JLabel("Shop");
		lbl_shop.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lbl_shop.setBounds(12, 10, 57, 23);
		contentPane.add(lbl_shop);
	}
	public void showGUI() {
		setVisible(true);
	}

}
