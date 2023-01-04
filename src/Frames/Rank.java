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

import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Rank extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rank frame = new Rank();
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
	public Rank() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(65, 54, 349, 71);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_characterA = new JLabel("캐릭터");
		lbl_characterA.setBounds(48, 10, 57, 51);
		panel.add(lbl_characterA);
		
		JLabel lbl_rankA = new JLabel("1등");
		lbl_rankA.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lbl_rankA.setBounds(117, 10, 57, 51);
		panel.add(lbl_rankA);
		
		JLabel lbl_nicknameA = new JLabel("닉네임");
		lbl_nicknameA.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lbl_nicknameA.setBounds(186, 10, 57, 51);
		panel.add(lbl_nicknameA);
		
		JLabel lbl_scoreA = new JLabel("점수");
		lbl_scoreA.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lbl_scoreA.setBounds(255, 10, 57, 51);
		panel.add(lbl_scoreA);
		
		JLabel lbl_characterB = new JLabel("캐릭터");
		lbl_characterB.setBounds(114, 135, 57, 35);
		contentPane.add(lbl_characterB);
		
		JLabel lbl_rankB = new JLabel("2등");
		lbl_rankB.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lbl_rankB.setBounds(183, 135, 57, 35);
		contentPane.add(lbl_rankB);
		
		JLabel lbl_nicknameB = new JLabel("닉네임");
		lbl_nicknameB.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lbl_nicknameB.setBounds(252, 135, 57, 35);
		contentPane.add(lbl_nicknameB);
		
		JLabel lbl_scoreB = new JLabel("점수");
		lbl_scoreB.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lbl_scoreB.setBounds(321, 135, 57, 35);
		contentPane.add(lbl_scoreB);
		
		JLabel lbl_characterC = new JLabel("캐릭터");
		lbl_characterC.setBounds(114, 180, 57, 35);
		contentPane.add(lbl_characterC);
		
		JLabel lbl_rankC = new JLabel("3등");
		lbl_rankC.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lbl_rankC.setBounds(183, 180, 57, 35);
		contentPane.add(lbl_rankC);
		
		JLabel lbl_nicknameC = new JLabel("닉네임");
		lbl_nicknameC.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lbl_nicknameC.setBounds(252, 180, 57, 35);
		contentPane.add(lbl_nicknameC);
		
		JLabel lbl_scoreC = new JLabel("점수");
		lbl_scoreC.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lbl_scoreC.setBounds(321, 180, 57, 35);
		contentPane.add(lbl_scoreC);
		
		JLabel lbl_characterD = new JLabel("캐릭터");
		lbl_characterD.setBounds(114, 225, 57, 35);
		contentPane.add(lbl_characterD);
		
		JLabel lbl_rankD = new JLabel("4등");
		lbl_rankD.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lbl_rankD.setBounds(183, 225, 57, 35);
		contentPane.add(lbl_rankD);
		
		JLabel lbl_nicknameD = new JLabel("닉네임");
		lbl_nicknameD.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lbl_nicknameD.setBounds(252, 225, 57, 35);
		contentPane.add(lbl_nicknameD);
		
		JLabel lbl_scoreD = new JLabel("점수");
		lbl_scoreD.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lbl_scoreD.setBounds(321, 225, 57, 35);
		contentPane.add(lbl_scoreD);
		
		JLabel lbl_characterE = new JLabel("캐릭터");
		lbl_characterE.setBounds(114, 270, 57, 35);
		contentPane.add(lbl_characterE);
		
		JLabel lbl_rankE = new JLabel("5등");
		lbl_rankE.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lbl_rankE.setBounds(183, 270, 57, 35);
		contentPane.add(lbl_rankE);
		
		JLabel lbl_nicknameE = new JLabel("닉네임");
		lbl_nicknameE.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lbl_nicknameE.setBounds(252, 270, 57, 35);
		contentPane.add(lbl_nicknameE);
		
		JLabel lbl_scoreE = new JLabel("점수");
		lbl_scoreE.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lbl_scoreE.setBounds(321, 270, 57, 35);
		contentPane.add(lbl_scoreE);
		
		JButton btn_back = new JButton("뒤로가기");
		btn_back.setBounds(375, 10, 97, 23);
		btn_back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Menu().showGUI();
				dispose();
				
			}
		});
		contentPane.add(btn_back);
		
		JLabel lbl_rank = new JLabel("순위");
		lbl_rank.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lbl_rank.setBounds(12, 14, 75, 23);
		contentPane.add(lbl_rank);
	}
	public void showGUI() {
		setVisible(true);
	}

}
