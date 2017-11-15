package Game;

//Importing necessary libraries
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class contains code for reading and writing high scores file and displaying it on screen
 * @authors Usman Khan, Sirena Wang, Chris Ng
 *
 */
public class HighScoresSubtraction3 {

	//Creating global variables
	public static boolean newHigh;
	static double ar[] = new double[5];
	static double newTime;
	static int type;
	static double secs;
	static JFrame js = new JFrame();
	
	public void main(String args[]) {
		//This method is not used
	}
	
	/**
	 * This method creates frame and panel with appropriate labels and buttons in position
	 * Adds new high score (if time is faster) and sorts high scores
	 * (See Addition class if more in depth commenting is required)
	 */
	public static void work() {
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints m = new GridBagConstraints();
		panel.setBackground(Color.PINK.brighter());
		js.add(panel);
		
		double temp;
		
		try {
			readFile("HighScoresSubtraction3.txt");
		}catch (IOException e) {
			
		}
		
		Subtraction s = new Subtraction();
		secs = (double) s.getDouble();
		s.setVisible(false);
		s.dispose();  
		
		newTime = (Math.round(secs * 100.0) / 100.0);

		if (newTime <= ar[4]) {
			ar[4] = newTime;
			newHigh = true;
			for (int i = 1; i <= (ar.length - 1); i++) {
				for (int j = 0; j <= (ar.length - i - 1); j++) {
					if (ar[j] > ar[j+1]) {
						temp = ar[j];
						ar[j] = ar[j+1];
						ar[j+1] = temp; 
					}
				}
			}
		}
		
		JLabel info = new JLabel("HIGHSCORES - THESE ARE THE FASTEST TIMES FOR SUBTRACTION DIFFICULTY 3!");
		m.gridx = 1;
		m.gridy = 0;
		panel.add(info, m);
		JLabel p1 = new JLabel("1. " + ar[0]);
		m.gridx = 1;
		m.gridy = 1;
		panel.add(p1, m);
		JLabel p2 = new JLabel("2. " + ar[1]);
		m.gridx = 1;
		m.gridy = 2;
		panel.add(p2, m);
		JLabel p3 = new JLabel("3. " + ar[2]);
		m.gridx = 1;
		m.gridy = 3;
		panel.add(p3, m);
		JLabel p4 = new JLabel("4. " + ar[3]);
		m.gridx = 1;
		m.gridy = 4;
		panel.add(p4, m);
		JLabel p5 = new JLabel("5. " + ar[4]);
		m.gridx = 1;
		m.gridy = 5;
		panel.add(p5, m);
		if(newHigh == true) {
			JLabel msg = new JLabel("YOU GOT ON THE BOARDS WITH A TIME OF " + newTime + " SECONDS! GREAT JOB!!!");
			m.gridx = 1;
			m.gridy = 7;
			m.insets = new Insets(10, 10, 10, 10);
			panel.add(msg, m);
		}
		else if(newHigh == false) {
			JLabel msg = new JLabel("Nice try but you weren't fast enough! Your time was " + newTime + " seconds");
			m.gridx = 1;
			m.gridy = 7;
			m.insets = new Insets(10, 10, 10, 10);
			panel.add(msg, m);
		}
		
		try {
			writeFile();
		}
		catch (IOException e) {
			System.out.println("Error writing the file");
		}
		
		JButton backButton = new JButton("Back to Start");
		m.gridx = 3;
		m.gridy = 8;
		panel.add(backButton, m);
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				js.dispose();
				new StartScreen().setVisible(true);
			}
		});
		JButton exitButton = new JButton("Exit");
		m.gridx = 3;
		m.gridy = 9;
		panel.add(exitButton, m);
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				js.dispose();
			}
		});
		
	}
	
	/**
	 * This method reads high scores file and stores the five values into an array
	 */
	private static void readFile(String fileName) throws IOException {
		
		File dir = new File(".");
		File HighScores = new File(dir.getCanonicalPath() + File.separator + fileName);
		
		Scanner input = new Scanner(HighScores);
		
		int counter = 0;
		input = new Scanner(HighScores);
		while(input.hasNext() == true) {
			ar[counter] = input.nextDouble();
			counter++;	 
		}
	}
	
	/**
	 * This method writes to the high scores file and stores the five high scores (whether a new high score is created or not) into the high scores file
	 */
	public static void writeFile() throws IOException {
		PrintWriter pw = new PrintWriter(new FileWriter("HighScoresSubtraction3.txt"));
		
		for(int k = 0; k < ar.length; k++) {
			pw.println(ar[k]);
		}
		
		pw.close();
		
	}
	
	/**
	 * This method returns JFrame (since this class doesn't extend JFrame and so another way (i.e. this method) of calling/setting the JFrame in this class to visible from the previous screen is needed)
	 */
	public JFrame getJFrame() {
		return js;
	}
}