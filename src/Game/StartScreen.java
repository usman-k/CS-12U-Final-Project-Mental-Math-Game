package Game;

//Importing necessary libraries
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class contains code for starting screen
 * @authors Usman Khan, Sirena Wang, Chris Ng
 *
 */
public class StartScreen extends JFrame {

	/**
	 * This method creates frame and panel with appropriate labels and buttons in position
	 * (See Addition class if more in depth commenting is required)
	 */
	public StartScreen() {

		setTitle("Up Your Math!");
		setSize(800, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBackground(Color.orange);
		add(panel);
		GridBagConstraints m = new GridBagConstraints();
		JLabel title = new JLabel("Up Your Math!");
		title.setFont(new Font("SANS_SERIF", Font.BOLD, 30));
		m.gridx = 1;
		m.gridy = 0;
		m.insets = new Insets(20, 20, 80, 10);
		panel.add(title, m);
		JButton startButton = new JButton("Start");
		m.gridx = 1;
		m.gridy = 1;
		m.insets = new Insets(10, 10, 10, 10);
		panel.add(startButton, m);
		JButton instructionsButton = new JButton("Instructions");
		m.gridx = 1;
		m.gridy = 2;
		panel.add(instructionsButton, m);
		JButton exitButton = new JButton("Exit");
		m.gridx = 1;
		m.gridy = 3;
		panel.add(exitButton, m);
		startButton.addActionListener(new ActionListener() {            //Implements code to start game after start button is pressed by user
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new DifficultyScreen().setVisible(true);
			}
		});
		instructionsButton.addActionListener(new ActionListener() {     //User is sent to InstructionsScreen after instructions button is pressed by user
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new InstructionsScreen().setVisible(true);
			}
		});
		exitButton.addActionListener(new ActionListener() {            //Exits game and shuts application down after exit button is pressed by user
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

	}

}
