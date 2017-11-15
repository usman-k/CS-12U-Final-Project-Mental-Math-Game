package Game;

//Importing necessary libraries
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This class contains code for difficulty screen
 * @authors Usman Khan, Sirena Wang, Chris Ng
 *
 */
public class DifficultyScreen extends JFrame {

	//Global variables
	static int difficulty;

	/**
	 * This method creates frame and panel with appropriate labels and buttons in position
	 * (See Addition class if more in depth commenting is required)
	 */
	public DifficultyScreen() {
		setTitle("Difficulty Screen");
		setSize(800, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints m = new GridBagConstraints();
		panel.setBackground(Color.PINK);
		add(panel);
		JLabel choose = new JLabel("Choose Difficulty");
		m.gridx = 1;
		m.gridy = 0;
		panel.add(choose, m);
		JButton level1Button = new JButton("1");
		m.gridx = 1;
		m.gridy = 1;
		m.insets = new Insets(10, 10, 10, 10);
		panel.add(level1Button, m);
		JButton level2Button = new JButton("2");
		m.gridx = 1;
		m.gridy = 2;
		panel.add(level2Button, m);
		JButton level3Button = new JButton("3");
		m.gridx = 1;
		m.gridy = 3;
		panel.add(level3Button, m);
		JButton level4Button = new JButton("4");
		m.gridx = 1;
		m.gridy = 4;
		panel.add(level4Button, m);
		JButton backButton = new JButton("Back");
		m.gridx = 3;
		m.gridy = 8;
		panel.add(backButton, m);
		level1Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				difficulty = 1;
				dispose();
				new ProblemTypeScreen().setVisible(true);
			}
		});
		level2Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				difficulty = 2;
				dispose();
				new ProblemTypeScreen().setVisible(true);
			}
		});
		level3Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				difficulty = 3;
				dispose();
				new ProblemTypeScreen().setVisible(true);
			}
		});
		level4Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				difficulty = 4;
				dispose();
				new ProblemTypeScreen().setVisible(true);
			}
		});
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new StartScreen().setVisible(true);
			}
		});
	}

	/**
	 * This method returns difficulty chosen by user
	 * @return
	 */
	public int getDiff() {
		return difficulty;
	}

}
