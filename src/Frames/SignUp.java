package Frames;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import info.UserinfoRepositoryImpl;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private String[] whatInfoTitle = {"아이디", "비밀번호", "비밀번호 재확인", "닉네임"};
	private JLabel[] countResult = new JLabel[2];
	private JLabel[] whatInfo = new JLabel[whatInfoTitle.length];
	private JTextField[] text_info = new JTextField[4];
	private JButton[] countBtn = new JButton[2];
	private int cResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_SignUp = new JLabel("회원가입");
		lbl_SignUp.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lbl_SignUp.setBounds(12, 10, 68, 21);
		contentPane.add(lbl_SignUp);
		
		// -----------------------------------------------------
		
		
		for (int i = 0; i < whatInfo.length; i++) {
			whatInfo[i] = new JLabel(whatInfoTitle[i]);
			whatInfo[i].setFont(new Font("맑은 고딕", Font.BOLD, 14));
			whatInfo[i].setBounds(30, 78 + i * 38, 110, 28);
			contentPane.add(whatInfo[i]);
		}
		
		// -----------------------------------------------------
		
		for (int i = 0; i < 4; i++) {
			text_info[i] = new JTextField();
			text_info[i].setBounds(145, 83 + i * 38, 150, 21);
			text_info[i].setColumns(20);
			contentPane.add(text_info[i]);
		}
		
		// -----------------------------------------------------
		
		UserinfoRepositoryImpl ur = new UserinfoRepositoryImpl();
		
		cResult = 0;
		
		for (int i = 0; i < 2; i++) {
			countBtn[i] = new JButton("중복확인");
			countBtn[i].setFont(new Font("맑은 고딕", Font.BOLD, 12));
			countBtn[i].setBounds(309, 82 + i * 114, 89, 23);
			contentPane.add(countBtn[i]);
			if (i == 0) {
				countBtn[i].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						String inputId = text_info[0].getText();
						System.out.println(inputId);
						int a = ur.countByID(inputId);
						System.out.println(a);
						if (a == 1) {
							System.out.println("중복된 id");
							countResult[0].setText("사용불가");
						}
					}
					
				});
			} else {
				countBtn[i].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						String inputNickname = text_info[3].getText();
						System.out.println(inputNickname);
						int a = ur.countByNickName(inputNickname);
						System.out.println(a);
						if (a == 1) {
							
							System.out.println("중복된 id");
							countResult[1].setText("사용불가");
						}
					}
					
				});
			}
		}
	
		for (int i = 0; i < 2; i++) { 
				countResult[i] = new JLabel("");
				countResult[i].setFont(new Font("맑은 고딕", Font.BOLD, 12));
				countResult[i].setBounds(410, 82 + i * 114, 89, 23);
				contentPane.add(countResult[i]);
		}
			
		// -----------------------------------------------------
		
		
		
		JButton btn_signup = new JButton("회원가입");
		btn_signup.setBounds(109, 300, 97, 23);
		btn_signup.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new LogIn().showGUI();
				dispose();
				
			}
		});
		contentPane.add(btn_signup);
		
		JButton btn_back = new JButton("뒤로가기");
		btn_back.setBounds(257, 300, 97, 23);
		btn_back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new LogIn().showGUI();
				dispose();
				
			}
		});
		contentPane.add(btn_back);
		
	}
	public void showGUI() {
		setVisible(true);
	}
}
