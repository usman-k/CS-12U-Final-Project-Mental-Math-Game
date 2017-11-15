package Game;

//Importing necessary libraries
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This class contains code for the addition problem solving and window
 * 
 * @author Usman Khan, Sirena Wang, Chris Ng
 *
 */
public class Addition extends JFrame implements KeyListener {

	//Creating global variables
	boolean answered = false;
	String user;
	String answer;
	static int difChoice = 0;
	int counter = 0;
	int[] randomNum = new int[40];
	JLabel choose = new JLabel();
	JTextField userAnswer = new JTextField(10);
	long t1;
	static double seconds;

	/**
	 * Creates frame and panel with labels according to commands given
	 * Creates random numbers for the problem solving differentiating in range based on difficulty chosen
	 */
	public Addition() {
		setTitle("Up Your Math! Addition Problems!");      //Adds title to the JFrame
		setSize(800, 600);									//Sets the hor and ver size of the JFrame
		setVisible(true);									//Set to true to allow user to see the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//Exits application when close button on window is pressed

		t1 = System.nanoTime();                             //Used to measure time at the beginning of the problem solving
 
		DifficultyScreen diff = new DifficultyScreen();    //Call DifficultyScreen to create a variable that holds the difficulty value chosen by user
		diff.setVisible(false);
		int difChoice = diff.getDiff();
		diff.dispose();

		switch (difChoice) {                                       //Switch case statement randomizes numbers based on difficulty chosen by user
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
		JPanel panel = new JPanel(new GridBagLayout());             //Adding a panel on the frame with GridBagLayout allows us to add labels and buttons in a layout
		GridBagConstraints m = new GridBagConstraints();
		panel.setBackground(Color.GRAY);
		add(panel);
		choose.setText("What is " + randomNum[counter] + " + " + randomNum[counter + 1]);
		choose.setFont(new Font("SERIF", Font.BOLD, 24));
		choose.setForeground(Color.WHITE);
		m.gridx = 1;												//Setting the gridbagconstraints to certain x and y values before adding labels/buttons on the panel allows for positioning of the label
		m.gridy = 0;
		panel.add(choose, m);										//Adds the label onto the panel at position m on the grid so user can view
		m.gridx = 1;
		m.gridy = 3;
		panel.add(userAnswer, m);
		JLabel on = new JLabel(user);
		m.gridx = 1;
		m.gridy = 5;
		panel.add(on, m);
		userAnswer.addKeyListener(this);                           //Adding keyListener

	}

	/**
	 * Method implements code after enter key is pressed to check if user answer is correct
	 * After all questions have been answered, user is sent to the corresponding high scores screen
	 */
	public void keyPressed(KeyEvent e) {                           //KeyListener allows for code to be implemented after key is pressed
		int keyCode = e.getKeyCode();
		if ((keyCode == KeyEvent.VK_ENTER)) {                      //The code will be implemented if the user presses the enter key
			user = userAnswer.getText();						   //Sets String user to be equal to whatever user entered into text field userAnswer
			answer = Integer.toString((randomNum[counter] + randomNum[counter + 1]));      //Creating a string of the correct answer
			userAnswer.setText("");
			if (user.equals(answer)) {                            //Checks user answer against the correct answer and implements code if they match
				counter += 2;									  //Counter is incremented by two so that the next two numbers in the array will show up
				if (counter < 39) {								  //Implements until counter is 39 or greater (since when it is at 38, it displays the last two numbers of the array and so it needs to stop after that)
					choose.setText("What is " + randomNum[counter] + " + " + randomNum[counter + 1]);     //Sets the label on panel to the next question (with the next set of numbers)
				} else if (counter == 40) {                       //Implements after counter reaches 40 (so after 38, since counter increments by 2)
					dispose();                                    //Disposes the JFrame
					long t2 = System.nanoTime();                  //Measures time after user completes game
					long timeTaken = t2 - t1;					  //Calculates time difference between start and finish (time user took to answer questions)
					seconds = (double) timeTaken / 1000000000.0;  //Converts long to double and the milliseconds to seconds
					DifficultyScreen dif = new DifficultyScreen();        //Calling difficulty screen to get the difficulty chosen to head to correct high score screen
					dif.setVisible(false);                                //Setting DifficultyScreen to invisible and disposing it since it isn't needed (since calling the class will create a frame since the class extends JFrame)
					int diffChoice = dif.getDiff();
					dif.dispose();
					if (diffChoice == 1) {                                //If difficulty chosen was one, the high scores for that difficulty are shown by calling the respective class and method
						HighScoresAddition1 hs1 = new HighScoresAddition1();
						hs1.getJFrame().setVisible(true);
						hs1.getJFrame().setTitle("Up Your Math! Highscores");
						hs1.getJFrame().setSize(800, 600);
						hs1.getJFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						hs1.work();
					}
					if (diffChoice == 2) {                               //If difficulty chosen was two, the high scores for that difficulty are shown by calling the respective class and method
						HighScoresAddition2 hs2 = new HighScoresAddition2();
						hs2.getJFrame().setVisible(true);
						hs2.getJFrame().setTitle("Up Your Math! Highscores");
						hs2.getJFrame().setSize(800, 600);
						hs2.getJFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						hs2.work();
					}
					if (diffChoice == 3) {                               //If difficulty chosen was three, the high scores for that difficulty are shown by calling the respective class and method
						HighScoresAddition3 hs3 = new HighScoresAddition3();
						hs3.getJFrame().setVisible(true);
						hs3.getJFrame().setTitle("Up Your Math! Highscores");
						hs3.getJFrame().setSize(800, 600);
						hs3.getJFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						hs3.work();
					}
					if (diffChoice == 4) {                               //If difficulty chosen was four, the high scores for that difficulty are shown by calling the respective class and method
						HighScoresAddition4 hs4 = new HighScoresAddition4();
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