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

public class LogIn extends JFrame {

	private JPanel contentPane;
	private JTextField text_id;
	private JTextField text_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();
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
	public LogIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_id = new JLabel("아이디");
		lbl_id.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lbl_id.setBounds(123, 115, 68, 24);
		contentPane.add(lbl_id);
		
		JLabel lbl_password = new JLabel("비밀번호");
		lbl_password.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lbl_password.setBounds(123, 149, 80, 24);
		contentPane.add(lbl_password);
		
		JPanel panel = new JPanel();
		panel.setBounds(60, 62, 365, 210);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btn_signup = new JButton("회원가입");
		btn_signup.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btn_signup.setBounds(60, 141, 97, 35);
		btn_signup.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new SignUp().showGUI();
				dispose();
				
			}
		});
		panel.add(btn_signup);
		
		JButton btn_login = new JButton("로그인");
		btn_login.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btn_login.setBounds(202, 141, 97, 35);
		btn_login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Menu().showGUI();
				dispose();
				
			}
		});
		panel.add(btn_login);
		
		text_id = new JTextField();
		text_id.setBounds(183, 56, 116, 21);
		panel.add(text_id);
		text_id.setColumns(10);
		
		text_password = new JTextField();
		text_password.setColumns(10);
		text_password.setBounds(183, 87, 116, 21);
		panel.add(text_password);
	}
	public void showGUI() {
		setVisible(true);
	}
}
