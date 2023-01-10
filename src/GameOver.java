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
import javax.swing.JButton;

public class GameOver extends JFrame {

	ClassLoader classLoader = getClass().getClassLoader();
	Toolkit kit = Toolkit.getDefaultToolkit();
	Image gameover = kit.getImage(classLoader.getResource("GameOver.png"));
	Image retry = kit.getImage(classLoader.getResource("retry.png"));
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameOver frame = new GameOver();
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
	public GameOver() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();

		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel(" ");
		lblNewLabel.setBounds(-26, -28, 769, 493);
		lblNewLabel.setIcon(new ImageIcon(gameover));
		panel.add(lblNewLabel);

		JButton btnNewButton = new JButton(" ");
		btnNewButton.setBounds(532, 340, 185, 66);
		btnNewButton.setIcon(new ImageIcon(retry));
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel.add(btnNewButton);

	}
}
