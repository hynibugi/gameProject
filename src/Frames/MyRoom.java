package Frames;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class MyRoom extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyRoom frame = new MyRoom();
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
	public MyRoom() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(183, 76, -151, 242);
		panel_1.setBackground(Color.GRAY);
		contentPane.add(panel_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(462, 43, -257, 308);
		contentPane.add(panel);
		
		JButton btn_back = new JButton("뒤로가기");
		btn_back.setBounds(375, 10, 97, 23);
		btn_back.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btn_back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Menu().showGUI();
				dispose();
				
			}
		});
		contentPane.add(btn_back);
		
		JLabel lbl_characterA = new JLabel("캐릭터");
		lbl_characterA.setBounds(217, 43, 110, 120);
		contentPane.add(lbl_characterA);
		
		JLabel lbl_characterB = new JLabel("캐릭터");
		lbl_characterB.setBounds(340, 43, 110, 120);
		contentPane.add(lbl_characterB);
		
		JButton btn_selectA = new JButton("선택");
		btn_selectA.setBounds(217, 173, 110, 23);
		btn_selectA.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		contentPane.add(btn_selectA);
		
		JButton btn_selectB = new JButton("선택");
		btn_selectB.setBounds(340, 173, 110, 23);
		btn_selectB.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		contentPane.add(btn_selectB);
		
		JLabel lbl_characterC = new JLabel("캐릭터");
		lbl_characterC.setBounds(217, 198, 110, 120);
		contentPane.add(lbl_characterC);
		
		JButton btn_selectC = new JButton("선택");
		btn_selectC.setBounds(217, 328, 110, 23);
		btn_selectC.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		contentPane.add(btn_selectC);
		
		JLabel lbl_characterD = new JLabel("캐릭터");
		lbl_characterD.setBounds(340, 198, 110, 120);
		contentPane.add(lbl_characterD);
		
		JButton btn_selectD = new JButton("선택");
		btn_selectD.setBounds(340, 328, 110, 23);
		btn_selectD.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		contentPane.add(btn_selectD);
		
		JLabel lbl_MyRoom = new JLabel("My Room");
		lbl_MyRoom.setBounds(12, 14, 83, 23);
		lbl_MyRoom.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		contentPane.add(lbl_MyRoom);
		
		JLabel lbl_selectedCharacter = new JLabel("선택된 캐릭터");
		lbl_selectedCharacter.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lbl_selectedCharacter.setBounds(44, 110, 127, 156);
		contentPane.add(lbl_selectedCharacter);
		
		JLabel lbl_currentSelection = new JLabel("현재선택");
		lbl_currentSelection.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lbl_currentSelection.setBounds(52, 279, 110, 15);
		contentPane.add(lbl_currentSelection);
		
		JLabel lbl_characterChange = new JLabel("캐릭터 변경");
		lbl_characterChange.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lbl_characterChange.setBounds(107, 18, 74, 15);
		contentPane.add(lbl_characterChange);
	}
	public void showGUI() {
		setVisible(true);
	}
}
