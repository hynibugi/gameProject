package Frames;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField text_id;
	private JTextField text_password;
	private JTextField text_Re_password;
	private JTextField text_nickname;

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
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_SignUp = new JLabel("회원가입");
		lbl_SignUp.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lbl_SignUp.setBounds(12, 10, 68, 21);
		contentPane.add(lbl_SignUp);
		
		JLabel lbl_id = new JLabel("아이디");
		lbl_id.setFont(new Font("굴림", Font.BOLD, 13));
		lbl_id.setBounds(58, 83, 57, 28);
		contentPane.add(lbl_id);
		
		JLabel lbl_password = new JLabel("비밀번호");
		lbl_password.setFont(new Font("굴림", Font.BOLD, 13));
		lbl_password.setBounds(58, 121, 57, 28);
		contentPane.add(lbl_password);
		
		JLabel lbl_Re_password = new JLabel("비밀번호 재확인");
		lbl_Re_password.setFont(new Font("굴림", Font.BOLD, 13));
		lbl_Re_password.setBounds(58, 159, 103, 28);
		contentPane.add(lbl_Re_password);
		
		JLabel lbl_nickname = new JLabel("닉네임");
		lbl_nickname.setFont(new Font("굴림", Font.BOLD, 13));
		lbl_nickname.setBounds(58, 197, 57, 28);
		contentPane.add(lbl_nickname);
		
		text_id = new JTextField();
		text_id.setBounds(218, 87, 116, 21);
		contentPane.add(text_id);
		text_id.setColumns(10);
		
		text_password = new JTextField();
		text_password.setColumns(10);
		text_password.setBounds(218, 125, 116, 21);
		contentPane.add(text_password);
		
		text_Re_password = new JTextField();
		text_Re_password.setColumns(10);
		text_Re_password.setBounds(218, 163, 116, 21);
		contentPane.add(text_Re_password);
		
		text_nickname = new JTextField();
		text_nickname.setColumns(10);
		text_nickname.setBounds(218, 201, 116, 21);
		contentPane.add(text_nickname);
		
		JButton btn_doubleCheckA = new JButton("중복확인");
		btn_doubleCheckA.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btn_doubleCheckA.setBounds(348, 86, 89, 23);
		contentPane.add(btn_doubleCheckA);
		
		JButton btn_doubleCheckB = new JButton("중복확인");
		btn_doubleCheckB.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btn_doubleCheckB.setBounds(348, 200, 89, 23);
		contentPane.add(btn_doubleCheckB);
		
		JButton btn_signup = new JButton("회원가입");
		btn_signup.setBounds(109, 272, 97, 23);
		btn_signup.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new LogIn().showGUI();
				dispose();
				
			}
		});
		contentPane.add(btn_signup);
		
		JButton btn_back = new JButton("뒤로가기");
		btn_back.setBounds(257, 272, 97, 23);
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
