package Frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Frames.showGame;

import javax.swing.JButton;
import java.awt.Font;

public class GameOver extends JFrame {

	ClassLoader classLoader = getClass().getClassLoader();
	Toolkit kit = Toolkit.getDefaultToolkit();
	Image gameover = kit.getImage(classLoader.getResource("GameOver.png"));
	private JPanel contentPane;
	showGame sg;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameOver frame = new GameOver(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @param showGame
	 */
	public GameOver(showGame showGame) {
		sg = showGame;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();

		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel scoreResult = new JLabel("" + sg.getScoreResult());
		scoreResult.setFont(new Font("맑은 고딕", Font.BOLD, 29));
		scoreResult.setBounds(390, 252, 171, 61);
		panel.add(scoreResult);

		JLabel starScore = new JLabel("" + sg.getStarScore());
		starScore.setFont(new Font("맑은 고딕", Font.BOLD, 29));
		starScore.setBounds(390, 170, 171, 61);
		panel.add(starScore);

		JLabel backgroundIm = new JLabel(" ");
		backgroundIm.setFont(new Font("맑은 고딕", Font.BOLD, 29));
		backgroundIm.setBounds(-26, -28, 769, 493);
		backgroundIm.setIcon(new ImageIcon(gameover));
		panel.add(backgroundIm);

	}
}
