package Frames;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import info.CheckRegexImpl;
import info.UserinfoRepositoryImpl;

public class SignUp extends JFrame implements KeyListener {

	private JPanel contentPane;
	private String[] whatInfoTitle = {"아이디", "비밀번호", "비밀번호 재확인", "닉네임"};
	private JLabel[] whatInfo = new JLabel[whatInfoTitle.length];
	private JLabel[] countResult = new JLabel[4];
	private JTextField[] text_info = new JTextField[2];
	private JPasswordField[] pw_info = new JPasswordField[2];
	private JButton[] countBtn = new JButton[2];

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

	public SignUp() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_SignUp = new JLabel("회원가입");
		lbl_SignUp.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lbl_SignUp.setBounds(12, 10, 68, 21);
		contentPane.add(lbl_SignUp);
		
		JLabel infoID = new JLabel("(영소문자 및 숫자 8자 이하)");
		infoID.setFont(new Font("맑은 고딕", Font.BOLD, 11));
		infoID.setBounds(45, 85, 200, 21);
		contentPane.add(infoID);
		
		JLabel infoPW = new JLabel("(영소문자 및 숫자 16자 이하)");
		infoPW.setFont(new Font("맑은 고딕", Font.BOLD, 11));
		infoPW.setBounds(45, 140, 200, 21);
		contentPane.add(infoPW);
		
		JLabel infoNn = new JLabel("(한글 5자 이하)");
		infoNn.setFont(new Font("맑은 고딕", Font.BOLD, 11));
		infoNn.setBounds(45, 250, 200, 21);
		contentPane.add(infoNn);
		

		for (int i = 0; i < whatInfo.length; i++) {
			whatInfo[i] = new JLabel(whatInfoTitle[i]);
			whatInfo[i].setFont(new Font("맑은 고딕", Font.BOLD, 12));
			whatInfo[i].setBounds(45, 60 + i * 56, 110, 28);
			contentPane.add(whatInfo[i]);
		}	
		
		for (int i = 0; i < 4; i++) { 
			countResult[i] = new JLabel("");
			countResult[i].setFont(new Font("맑은 고딕", Font.BOLD, 12));
			countResult[i].setBounds(410, 62 + i * 56, 89, 23);
			contentPane.add(countResult[i]);
		}
	
		for (int i = 0; i < 2; i++) {
			text_info[i] = new JTextField(15);
			text_info[i].setBounds(170, 65 + i * 168, 150, 21);
			text_info[i].addKeyListener(this);
			contentPane.add(text_info[i]);
		}

		for (int i = 0; i < 2; i++) {
			pw_info[i] = new JPasswordField(15);
			pw_info[i].setBounds(170, 120 + i * 57, 150, 21);
			pw_info[i].addKeyListener(this);
			contentPane.add(pw_info[i]);
		}
	
		// -----------------------------------------------------
		
		UserinfoRepositoryImpl ur = new UserinfoRepositoryImpl();
		CheckRegexImpl cr = new CheckRegexImpl();
				
		for (int i = 0; i < 2; i++) {
			countBtn[i] = new JButton("중복확인");
			countBtn[i].setFont(new Font("맑은 고딕", Font.BOLD, 12));
			countBtn[i].setBorder(null);
			countBtn[i].setBounds(340, 63 + i * 169, 60, 23);
			contentPane.add(countBtn[i]);
		}
			
		countBtn[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String inputId = text_info[0].getText();
				int a = ur.countByID(inputId);
				int b = cr.checkIdByRegex(inputId);
				
				if (a != 1 && b  == 1) {
					countResult[0].setText("사용가능");
				} else {
					countResult[0].setText("사용불가");
				}
			}			
		});
		countBtn[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String inputNickname = text_info[1].getText();
				int a = ur.countByNickName(inputNickname);
				int b = cr.checkNnByRegex(inputNickname);
				if (a != 1 && b  == 1) {
					countResult[3].setText("사용가능");
				} else {
					countResult[3].setText("사용불가");
				}
			}
		});
		// -----------------------------------------------------
		
		JButton btn_signup = new JButton("회원가입");
		btn_signup.setBounds(109, 300, 97, 23);
		btn_signup.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				boolean signUpResult = false;
				
				String inputId = text_info[0].getText();
				String inputPassword = pw_info[1].getText();
				String inputNickname = text_info[1].getText();
				
				if (ur.countByID(inputId) == 0 
						&& ur.countByNickName(inputNickname) == 0 
						&& cr.checkIdByRegex(inputId) == 1
						&& cr.checkPwByRegex(inputPassword) == 1
						&& cr.checkNnByRegex(inputNickname) == 1) {
					signUpResult = true;
				} 
				
				if (signUpResult) {
					int result = ur.insert(inputId, inputPassword, inputNickname);
					int lastNo = ur.lastNo();
					int standardCharacter = ur.standardCharacter(lastNo);
					new SuccessSignUp().showGUI();
					System.out.println(result + "명 회원가입 성공");
					System.out.println(lastNo + " : 마지막 회원가입 No");
					System.out.println(standardCharacter + ": 마지막 가입자 캐릭터 부여");
				} else {
					System.out.println("실패");
				}

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

	@Override
	public void keyPressed(KeyEvent e) {
		for(int i = 0; i < 2; i++) {
			if (e.getSource() == text_info[i]) {
				countResult[i + (i * 2)].setText("");		
			}
			
		}
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public void keyReleased(KeyEvent e) {
		CheckRegexImpl cr = new CheckRegexImpl();
		
		String pwfirst = pw_info[0].getText();
		String pwSecond = pw_info[1].getText();
		
		if (e.getSource() == pw_info[0] || e.getSource() == pw_info[1] ) {
			
			System.out.println(pwfirst + "//" + pwSecond);	
			
			int a = cr.checkPwByRegex(pwfirst);
			int b = cr.checkPwByRegex(pwSecond);
			System.out.println(a +"//"+ b);
			
			if (a == 1 && b == 1) {
				if (pwfirst != null || pwSecond != null) {	
					if(pwfirst.equals(pwSecond)) {
						countResult[2].setText("사용가능");	
					} else {
						countResult[2].setText("사용불가");	
					}			
				} else {
					countResult[2].setText("");	
				}
			} else {
				countResult[2].setText("");	
			}
		} 
	}

	@Override
	public void keyTyped(KeyEvent e) {
	
	}
}
