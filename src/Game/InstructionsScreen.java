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

public class InstructionsScreen extends JFrame {

	/**
	 * This method creates frame and panel with appropriate labels and buttons in position
	 * (See Addition class if more in depth commenting is required)
	 */
	public InstructionsScreen() {
		setTitle("Instructions Screen");
		setSize(800, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints m = new GridBagConstraints();
		panel.setBackground(Color.pink);
		add(panel);
		JLabel choose = new JLabel("Instructions");
		choose.setFont(new Font("SANS_SERIF", Font.BOLD, 30));
		m.gridx = 1;
		m.gridy = 0;
		panel.add(choose, m);
		choose.setFont(new Font("Arial", Font.PLAIN, 30));
		JLabel one = new JLabel("This game is an educational, but fun, game!");
		m.gridx = 1;
		m.gridy = 2;
		m.insets = new Insets(10, 10, 10, 10);
		panel.add(one, m);
		JLabel two = new JLabel("First the player chooses difficulty between 1 and 4 --> 1 being easiest.");
		m.gridx = 1;
		m.gridy = 3;
		panel.add(two, m);
		JLabel three = new JLabel("Then, the player chooses what type of math problems they would like to solve!");
		m.gridx = 1;
		m.gridy = 4;
		panel.add(three, m);
		JLabel four = new JLabel("The player will then be lead to a screen where math questions will pop up.");
		m.gridx = 1;
		m.gridy = 5;
		panel.add(four, m);
		JLabel five = new JLabel(
				"The player should type the answers as fast as possible and press enter to go to next question!");
		m.gridx = 1;
		m.gridy = 6;
		panel.add(five, m);
		JLabel six = new JLabel("The goal is to answer the questions as fast as possible and set a new highscore!");
		m.gridx = 1;
		m.gridy = 7;
		panel.add(six, m);
		JButton backButton = new JButton("Back");
		m.gridx = 3;
		m.gridy = 8;
		m.insets = new Insets(80, 50, 10, 10);
		panel.add(backButton, m);
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new StartScreen().setVisible(true);
			}
		});
	}

}
