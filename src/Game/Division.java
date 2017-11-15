package Game;

//Importing necessary libraries
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This class contains code for the division problem solving and window
 * (See addition class if more in-depth commenting needed)
 * @author Usman Khan, Sirena Wang, Chris Ng
 *
 */
public class Division extends JFrame implements KeyListener {

	//Creating Global Variables
	boolean answered = false;
	String user;
	String answer;
	int difChoice = 0;
	int counter = 0;
	int[] randomNum = new int[40];
	JLabel choose = new JLabel();
	JTextField userAnswer = new JTextField(10);
	long t1;
	double ans;
	static double seconds;

	/**
	 * Creates frame and panel with labels according to commands given
	 * Creates random numbers for the problem solving differentiating in range based on difficulty chosen
	 */
	public Division() {
		setTitle("Up Your Math! Division Problems!");
		setSize(800, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		t1 = System.nanoTime();

		DifficultyScreen diff = new DifficultyScreen();
		diff.setVisible(false);
		int difChoice = diff.getDiff();
		diff.dispose();

		switch (difChoice) {
		case 1:
			for (int i = 0; i < randomNum.length; i++) {
				randomNum[i] = (int) (Math.random() * 10) + 1;
			}
			break;
		case 2:
			for (int i = 0; i < randomNum.length; i++) {
				randomNum[i] = (int) (Math.random() * 20) + 1;
			}
			break;
		case 3:
			for (int i = 0; i < randomNum.length; i++) {
				randomNum[i] = (int) (Math.random() * 100) + 1;
			}
			break;
		case 4:
			for (int i = 0; i < randomNum.length; i++) {
				randomNum[i] = (int) (Math.random() * 200) - 99;
			}
			break;
		}

		answered = false;
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints m = new GridBagConstraints();
		panel.setBackground(Color.gray.brighter());
		add(panel);
		JLabel info = new JLabel(
				"Answer to two decimal places (unless second decimal is zero, then answer to one decimal)");
		m.gridx = 1;
		m.gridy = 0;
		panel.add(info, m);
		choose.setText("What is " + randomNum[counter] + " ÷ " + randomNum[counter + 1]);
		choose.setFont(new Font("SERIF", Font.BOLD, 24));
		choose.setForeground(Color.WHITE);
		m.gridx = 1;
		m.gridy = 1;
		panel.add(choose, m);
		m.gridx = 1;
		m.gridy = 4;
		panel.add(userAnswer, m);
		JLabel on = new JLabel(user);
		m.gridx = 1;
		m.gridy = 6;
		// panel.add(on, m);
		// m.gridy = 7;
		// panel.add(a, m);
		userAnswer.addKeyListener(this);

	}

	/**
	 * Method implements code after enter key is pressed to check if user answer is correct
	 * After all questions have been answered, user is sent to the corresponding high scores screen
	 */
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if ((keyCode == KeyEvent.VK_ENTER)) {
			user = userAnswer.getText();
			ans = (double) (randomNum[counter]) / (randomNum[counter + 1]);
			// a.setText(Double.toString(ans));
			answer = Double.toString((Math.round(ans * 100.0) / 100.0));
			userAnswer.setText("");
			if (user.equals(answer)) {
				counter += 2;
				if (counter < 39) {
					choose.setText("What is " + randomNum[counter] + " ÷ " + randomNum[counter + 1]);
				} else if (counter == 40) {
					dispose();
					long t2 = System.nanoTime();
					long timeTaken = t2 - t1;
					seconds = (double) timeTaken / 1000000000.0;
					DifficultyScreen dif = new DifficultyScreen();
					dif.setVisible(false);
					int diffChoice = dif.getDiff();
					dif.dispose();
					if (diffChoice == 1) {
						HighScoresDivision1 hs1 = new HighScoresDivision1();
						hs1.getJFrame().setVisible(true);
						hs1.getJFrame().setTitle("Up Your Math! Highscores");
						hs1.getJFrame().setSize(800, 600);
						hs1.getJFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						hs1.work();
					}
					if (diffChoice == 2) {
						HighScoresDivision2 hs2 = new HighScoresDivision2();
						hs2.getJFrame().setVisible(true);
						hs2.getJFrame().setTitle("Up Your Math! Highscores");
						hs2.getJFrame().setSize(800, 600);
						hs2.getJFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						hs2.work();
					}
					if (diffChoice == 3) {
						HighScoresDivision3 hs3 = new HighScoresDivision3();
						hs3.getJFrame().setVisible(true);
						hs3.getJFrame().setTitle("Up Your Math! Highscores");
						hs3.getJFrame().setSize(800, 600);
						hs3.getJFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						hs3.work();
					}
					if (diffChoice == 4) {
						HighScoresDivision4 hs4 = new HighScoresDivision4();
						hs4.getJFrame().setVisible(true);
						hs4.getJFrame().setTitle("Up Your Math! Highscores");
						hs4.getJFrame().setSize(800, 600);
						hs4.getJFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						hs4.work();
					}
				}
			}
		}
	}

	/**
	 * Following method is not used, it is a methods included in the implemented Key listener that was not necessary in this case
	 */
	@Override
	public void keyReleased(KeyEvent arg0) {
		// Method not used

	}

	/**
	 * Following method is not used, it is a methods included in the implemented Key listener that was not necessary in this case
	 */
	@Override
	public void keyTyped(KeyEvent arg0) {
		// Method not used

	}
	
	/**
	 * Method returns seconds value
	 */
	public double getDouble() {
		return seconds;
	}

}