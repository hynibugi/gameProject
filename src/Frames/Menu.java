package Frames;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//----------------------------------------------- 
		
		JButton btn_gameStart = new JButton("게임시작");
		btn_gameStart.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btn_gameStart.setBorder(new EmptyBorder(5, 5, 5, 5));
		btn_gameStart.setBackground(new Color(153, 204, 255));
		btn_gameStart.setBounds(94, 89, 118, 67);
		btn_gameStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//new showGame().showGUI();
				//dispose();
				
			}
		});
		contentPane.add(btn_gameStart);
		
		JButton btn_Shop = new JButton("상점");
		btn_Shop.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btn_Shop.setBorder(new EmptyBorder(5, 5, 5, 5));
		btn_Shop.setBackground(new Color(153, 204, 255));
		btn_Shop.setBounds(290, 89, 118, 67);
		btn_Shop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new shop().showGUI();
				dispose();
				
			}
		});
		contentPane.add(btn_Shop);
		
		JButton btn_Rank = new JButton("순위");
		btn_Rank.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btn_Rank.setBorder(new EmptyBorder(5, 5, 5, 5));
		btn_Rank.setBackground(new Color(153, 204, 255));
		btn_Rank.setBounds(94, 202, 118, 67);
		btn_Rank.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Rank().showGUI();
				dispose();
				
			}
		});
		contentPane.add(btn_Rank);
		
		JButton btn_MyRoom = new JButton("마이룸");
		btn_MyRoom.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btn_MyRoom.setBorder(new EmptyBorder(5, 5, 5, 5));
		btn_MyRoom.setBackground(new Color(153, 204, 255));
		btn_MyRoom.setBounds(290, 202, 118, 67);
		btn_MyRoom.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new MyRoom().showGUI();
				dispose();
				
			}
		});
		contentPane.add(btn_MyRoom);
	}
	
	public void showGUI() {
		setVisible(true);
	}

}
