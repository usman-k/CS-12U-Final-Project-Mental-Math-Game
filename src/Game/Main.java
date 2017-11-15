package Game;

import javax.swing.JFrame;

public class Main extends JFrame {

	/**
	 * This class in the main class which directs the system towards the starting screen and initializes the starting screen
	 * References:
	 * JFrames: https://docs.oracle.com/javase/tutorial/uiswing/components/frame.html
	 * Checking textfield against string: https://stackoverflow.com/questions/16002647/checking-if-text-in-a-textbox-matches-a-string-once-a-button-has-been-pressed
	 * JButtons: https://www.youtube.com/watch?v=jEXxaPQ_fQo
	 * GridBagLayout learned from: https://www.youtube.com/watch?v=FB_wJpIdA8k&t=1s
	 * Calling JFrame from another class: https://stackoverflow.com/questions/17637195/how-to-make-a-jframe-button-open-another-jframe-class-in-netbeans
	 * @authors Usman Khan, Sirena Wang, Chris Ng
	 */
	public static void main(String[] args) {

		new StartScreen().setVisible(true);

	}

}
