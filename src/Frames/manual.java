package Frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;

public class manual extends JFrame {
	ClassLoader classLoader = getClass().getClassLoader();
	Toolkit kit = Toolkit.getDefaultToolkit();
	Image keyboard = kit.getImage(classLoader.getResource("key.png"));
	Image pepper = kit.getImage(classLoader.getResource("pepper.png"));
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					manual frame = new manual();
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
	public manual() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\uC124\uBA85\uC11C");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel.setBounds(12, 10, 77, 53);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(22, 73, 136, 90);
		lblNewLabel_1.setIcon(new ImageIcon(keyboard));

		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel(" : JUMP");
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_2.setBounds(131, 73, 65, 43);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setBounds(321, 73, 65, 58);
		lblNewLabel_1_1.setIcon(new ImageIcon(pepper));
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(301, 120, 91, 43);
		contentPane.add(lblNewLabel_2_1);
	}

}
