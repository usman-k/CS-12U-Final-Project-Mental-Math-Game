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
import javax.swing.JTextField;

public class ProblemTypeScreen extends JFrame {

	//Creating global variables
	boolean addition = false;
	boolean subtraction = false;
	boolean multiplication = false;
	boolean division = false;
	static int type;
	
	/**
	 * This method creates frame and panel with appropriate labels and buttons in position
	 * (See Addition class if more in depth commenting is required)
	 */
	public ProblemTypeScreen() {
		setTitle("Problem Type Screen");
		setSize(800, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints m = new GridBagConstraints();
		panel.setBackground(Color.GRAY);
		add(panel);
		JLabel choose = new JLabel("Choose What Type of Problems You Would Like To Solve");
		choose.setFont(new Font("SERIF", Font.BOLD, 18));
		choose.setForeground(Color.WHITE);
		m.gridx = 1;
		m.gridy = 0;
		panel.add(choose, m);
		JButton additionButton = new JButton("Addition");
		m.gridx = 1;
		m.gridy = 1;
		m.insets = new Insets(10, 10, 10, 10);
		panel.add(additionButton, m);
		JButton subtractionButton = new JButton("Subtraction");
		m.gridx = 1;
		m.gridy = 2;
		panel.add(subtractionButton, m);
		JButton multiplicationButton = new JButton("Multiplication");
		m.gridx = 1;
		m.gridy = 3;
		panel.add(multiplicationButton, m);
		JButton divisionButton = new JButton("Division");
		m.gridx = 1;
		m.gridy = 4;
		panel.add(divisionButton, m);
		JButton backButton = new JButton("Back");
		m.gridx = 3;
		m.gridy = 8;
		panel.add(backButton, m);
		additionButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addition = true;
				type = 1;
				dispose();
				new Addition().setVisible(true);
			}
		});
		subtractionButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				subtraction = true;
				type = 2;
				dispose();
				new Subtraction().setVisible(true);
			}
		});
		multiplicationButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				multiplication = true;
				type = 3;
				dispose();
				new Multiplication().setVisible(true);
			}
		});
		divisionButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				division = true;
				type = 4;
				dispose();
				new Division().setVisible(true);
			}
		});
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new DifficultyScreen().setVisible(true);
			}
		});
	}
	
	/**
	 * Returns type of problems chosen in number form
	 * @return
	 */
	public int getInt() {
		return type;
	}

}
