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


public class SuccessSignUp extends JFrame {
	
	ClassLoader classLoader = getClass().getClassLoader();
	Toolkit kit = Toolkit.getDefaultToolkit();
	Image mainLogin = kit.getImage(classLoader.getResource("signUp.png"));
	Image btnPng = kit.getImage(classLoader.getResource("btnSignUpPage.png"));

	
	private JLabel contentPane; 
	
	public SuccessSignUp(SignUp signUp) {
		signUp.dispose();
		
		setBounds(100, 100, 505, 405);
		dispose();
		contentPane = new JLabel();		
		contentPane.setBorder(null);
		contentPane.setIcon(new ImageIcon(mainLogin));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton jbt = new JButton();
		jbt.setIcon(new ImageIcon(btnPng));
		jbt.setBorder(null);
		jbt.setBounds(193, 210, 97, 35);
		contentPane.add(jbt);
		jbt.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("사용설명서 추가");
				manual mn = new manual();
				mn.setVisible(true);
			}
		});
	}
	public void showGUI() {
		setVisible(true);
	}
}
