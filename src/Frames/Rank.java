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
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import info.UserinfoRankingImpl;

public class Rank extends JFrame {
	
	ClassLoader classLoader = getClass().getClassLoader();
	Toolkit kit = Toolkit.getDefaultToolkit();
	
	Image c1 = kit.getImage(classLoader.getResource("c1.png"));
	Image c2 = kit.getImage(classLoader.getResource("c2.png"));
	Image c3 = kit.getImage(classLoader.getResource("c3.png"));
	Image c4 = kit.getImage(classLoader.getResource("c4.png"));
	Image c5 = kit.getImage(classLoader.getResource("c5.png"));
	
	final Image[] imageC = {c1, c2, c3, c4, c5};
	
	final String[] imagetTitle = {"c1", "c2", "c3", "c4", "c5"};

	final String[] rankTitle = {"1 등", "2 등", "3 등", "4 등", "5 등"};
	
	private JPanel contentPane;
	private JLabel[] whatRank = new JLabel[rankTitle.length];
	private JLabel[] whoNic = new JLabel[5];
	private JLabel[] whoScore = new JLabel[5];
	private JLabel[] whoCharacter = new JLabel[5];
	

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
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 420);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		//panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(new Color(144, 204, 255));
		panel.setBounds(65, 54, 349, 71);
		contentPane.add(panel);
		panel.setLayout(null);
		
		// 캐릭터 -------------------------------------------------------
		
		UserinfoRankingImpl uRank = new UserinfoRankingImpl();
		int bestCha = uRank.getBestcharacter(1);
		
		JLabel lbl_characterA = new JLabel("");
		lbl_characterA.setIcon(new ImageIcon(imageC[bestCha]));
		lbl_characterA.setBounds(39, 10, 57, 51);
		panel.add(lbl_characterA);
		
		
		
		for (int i = 1; i < whoCharacter.length; i++) {
			int orderByCha = uRank.getBestcharacter(i + 1);
			System.out.println(orderByCha);
			whoCharacter[i] = new JLabel("");
			whoCharacter[i].setIcon(new ImageIcon(imageC[orderByCha - 1]));
			whoCharacter[i].setBounds(100, 134 + (i - 1) * 55 , 50, 50);
			contentPane.add(whoCharacter[i]);			
		}
		
		
		// 등수 -------------------------------------------------------
		
		JLabel lbl_rankA = new JLabel(rankTitle[0]);
		lbl_rankA.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lbl_rankA.setBounds(117, 10, 57, 51);
		panel.add(lbl_rankA);
		
		for (int i = 1; i < whatRank.length; i++) {
			whatRank[i] = new JLabel(rankTitle[i]);
			whatRank[i].setFont(new Font("맑은 고딕", Font.BOLD, 14));
			whatRank[i].setBounds(183, 141 + (i - 1) * 56 , 57, 35);
			contentPane.add(whatRank[i]);
		}
	
		// 닉네임 -------------------------------------------------------
		
		String bestNic = uRank.getBestNic(1);
		JLabel lbl_nicknameA = new JLabel(bestNic);
		lbl_nicknameA.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lbl_nicknameA.setBounds(186, 10, 57, 51);
		panel.add(lbl_nicknameA);
		
		for (int i = 1; i < whoNic.length; i++) {
			String orderByNic = uRank.getBestNic(i + 1);
			whoNic[i] = new JLabel(orderByNic);
			whoNic[i].setFont(new Font("맑은 고딕", Font.BOLD, 13));
			whoNic[i].setBounds(252, 141 + (i - 1) * 56 , 57, 35);
			contentPane.add(whoNic[i]);
			
		}
		
		// 점수 -------------------------------------------------------
		
		String bestScore = String.valueOf(uRank.getBestScore(1));
		
		JLabel lbl_scoreA = new JLabel(bestScore);
		lbl_scoreA.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lbl_scoreA.setBounds(255, 10, 57, 51);
		panel.add(lbl_scoreA);
		
		for (int i = 1; i < whoScore.length; i++) {
			
			String orderByS = String.valueOf(uRank.getBestScore(i + 1));
			
			whoScore[i] = new JLabel(orderByS);
			whoScore[i].setFont(new Font("맑은 고딕", Font.BOLD, 13));
			whoScore[i].setBounds(325, 141 + (i - 1) * 56 , 57, 35);
			contentPane.add(whoScore[i]);
		}
		
		
		//--------------------------------------------------------------------
		
		
		
		JLabel lbl_rank = new JLabel("순위");
		lbl_rank.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lbl_rank.setBounds(12, 10, 75, 23);
		contentPane.add(lbl_rank);
	}
	public void showGUI() {
		setVisible(true);
	}

}
