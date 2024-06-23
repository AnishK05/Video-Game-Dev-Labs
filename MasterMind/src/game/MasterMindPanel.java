package game;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class MasterMindPanel extends JPanel implements MouseListener {

	private final int HEIGHT = 750, WIDTH = 700, PEGSIZE = 50;

	private Dimension SIZE = new Dimension(WIDTH, HEIGHT);

	private CodePeg[][] codePegs;

	private CodePeg[] keyPegs;

	private CodePeg[][] checkPegs;

	private int guesses, codeLength, widtheightGap, heightGap, currentRow;

	private JLabel backgroundLabel, titleLabel, codeCoverLabel, enterLabel, showHideLabel, winLabel;

	Object[] possibleColors = { "Blue", "Green", "Orange", "Purple", "Red", "Yellow" };

	Random random = new Random();

	private JLabel infoLabel;

	private JLabel refreshLabel;

	private String showHideImage = "show";

	public MasterMindPanel() {

		// set size, show instructions

		setPreferredSize(SIZE);

		setLayout(null);

		instructions();


		// set up code cover label

		codeCoverLabel = new JLabel("");

		codeCoverLabel.setOpaque(true);

		codeCoverLabel.setBackground(new Color(0, 0, 0));

		codeCoverLabel.setBounds(165, 60, 510, 90);

		codeCoverLabel.setVisible(true);

		add(codeCoverLabel);


		// set up title label

		titleLabel = new JLabel("Master Mind");

		titleLabel.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 25));

		titleLabel.setForeground(new Color(255, 255, 255));

		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

		titleLabel.setBounds(300, 10, 185, 35);

		add(titleLabel);


		// set up enter button (label)

		enterLabel = new JLabel("Guess");

		enterLabel.setVerticalAlignment(SwingConstants.TOP);

		enterLabel.setHorizontalAlignment(SwingConstants.CENTER);

		enterLabel.setFont(new Font("Calibri", Font.BOLD, 25));

		enterLabel.setForeground(new Color(128, 128, 128));

		enterLabel.setBackground(new Color(255, 255, 255));

		enterLabel.setBounds(41, 106, 87, 35);

		enterLabel.setOpaque(true);

		enterLabel.addMouseListener(this);

		add(enterLabel);


		// set up show/hide button (label)

		showHideLabel = new JLabel("Show");

		showHideLabel.setVerticalAlignment(SwingConstants.TOP);

		showHideLabel.setHorizontalAlignment(SwingConstants.CENTER);

		showHideLabel.setForeground(new Color(128, 128, 128));

		showHideLabel.setBackground(new Color(255, 255, 255));

		showHideLabel.setFont(new Font("Calibri", Font.BOLD, 25));

		showHideLabel.setBounds(41, 60, 87, 35);

		showHideLabel.setOpaque(true);

		showHideLabel.addMouseListener(this);

		add(showHideLabel);


		// set up info button (label)

		infoLabel = new JLabel("i");

		infoLabel.setVerticalAlignment(SwingConstants.TOP);

		infoLabel.setHorizontalAlignment(SwingConstants.CENTER);

		infoLabel.setFont(new Font("Calibri", Font.BOLD, 30));

		infoLabel.setForeground(new Color(255, 255, 255));

		infoLabel.setBackground(new Color(255, 87, 51));

		infoLabel.setBounds(650, 8, 39, 35);

		infoLabel.setOpaque(true);

		infoLabel.addMouseListener(this);

		add(infoLabel);



		//set up refresh label

		refreshLabel = new JLabel("Restart");

		refreshLabel.setVerticalAlignment(SwingConstants.TOP);

		refreshLabel.setHorizontalAlignment(SwingConstants.CENTER);

		refreshLabel.setFont(new Font("Calibri", Font.BOLD, 25));

		refreshLabel.setForeground(new Color(255, 255, 255));

		refreshLabel.setBackground(new Color(255, 87, 51));

		refreshLabel.setBounds(560, 10, 80, 30);

		refreshLabel.setOpaque(true);

		refreshLabel.addMouseListener(this);

		add(refreshLabel);		


		winLabel = new JLabel();

		winLabel.setVerticalAlignment(SwingConstants.TOP);

		winLabel.setHorizontalAlignment(SwingConstants.CENTER);

		winLabel.setBounds(0, 0, WIDTH, HEIGHT);

		winLabel.setOpaque(false);

		winLabel.addMouseListener(this);

		winLabel.setIcon(new ImageIcon("C:/Users/anish/Documents/VS Code -- Documents/Java/MasterMind/src/images/end2.gif"));

		winLabel.setVisible(false);

		add(winLabel);	



		// create game settings and set up layout

		gameSettings();

		widtheightGap = WIDTH / codeLength - PEGSIZE / 2;

		heightGap = HEIGHT / guesses - PEGSIZE / 2;

		setUpGame();


		// add code pegs

		for (int i = 0; i < guesses; i++) 

		{

			for (int j = 0; j < codeLength; j++) {

				add(codePegs[j][i]);

				add(checkPegs[j][i]);

			}

		}


		// add key pegs

		for (int j = 0; j < codeLength; j++) {

			add(keyPegs[j]);

		}

		backgroundLabel = new JLabel();

		backgroundLabel.setBounds(0, 0, WIDTH, HEIGHT);

		backgroundLabel.setIcon(new ImageIcon("C:/Users/anish/Documents/VS Code -- Documents/Java/MasterMind/src/images/background.jpg"));

		add(backgroundLabel);


		startGame();

	}


	private void instructions() {

		String instructions = "\r\n The name of this game is Mastermind! The goal is to guess the order and color of randomly selected balls."

				+ "\r\n The next window will prompt you to choose the number of guesses -- this will decide how many attempts you get (Number between 1 and 10)."

				+ "\r\n The window after that will prompt you to choose a length -- this length refers to the number of balls that you will guess (Number between 4 and 6)."

				+ "\r\n The game begins with a hidden series of balls that is generated. If you would like to see this series at any time, "

				+ "\r\n click the the show button in the upper left corner. You can hide this series by the clicking the buttom again."

				+ "\r\n Once you are ready to play, click the white circles to choose what color you think is in that position."

				+ "\r\n Start at the bottom row and  to use as your first guess. Once you have filled each circle with what you think, click the guess button in the upper left corner."

				+ "\r\n You will now see a row of balls to the left of where you guessed the colors."

				+ "\r\n A black ball indicates that one of the color's you chose was correct, and is in the correct position."

				+ "\r\n A white ball indicates that you chose the right color, but it is in the wrong position."

				+ "\r\n A grey ball indicates that the color and position is wrong."

				+ "\r\n These balls appear from left to right, and do not coincide with the exact position. For example, if a black ball appears in the first slot, "

				+ "\r\n it is not always referring to the first ball you guessed."

				+ "\r\n If at any point, you have given up, click the restart button to restart."
				
				+ "\r\n If at any point, you want to see the instructions, click the i button in the top right corner."

				+ "\r\n Enjoy!";

		JOptionPane.showInternalMessageDialog(null, instructions, "Instructions", JOptionPane.INFORMATION_MESSAGE);

	}


	private void gameSettings() 

	{

		// find guesses

		while (true) {

			guesses = Integer.parseInt(JOptionPane.showInputDialog(null, "How Many Guesses? (1-10)", "Rows of Guesses",

					JOptionPane.QUESTION_MESSAGE));

			if (guesses >= 1 && guesses <= 10) {

				System.out.println("Guesses: " + guesses);

				break;

			}

		}


		// find length of each code

		while (true) {

			codeLength = Integer.parseInt(JOptionPane.showInputDialog(null, "What Length? (Number of Balls) (4-6) ",

					"Guess Length", JOptionPane.QUESTION_MESSAGE));

			if (codeLength >= 4 && codeLength <= 6) {

				System.out.println("Code Length: " + codeLength);

				break;

			}

		}


		// create code peg array and check peg array

		codePegs = new CodePeg[codeLength][guesses];

		checkPegs = new CodePeg[codeLength][guesses];

		keyPegs = new CodePeg[codeLength];

	}


	private void setUpGame() {

		for (int i = 0; i < guesses; i++) {

			for (int j = 0; j < codeLength; j++) {

				keyPegs[j] = new CodePeg("empty");

				keyPegs[j].setBounds(165 + j * widtheightGap, 80, PEGSIZE, PEGSIZE);


				codePegs[j][i] = new CodePeg("empty");

				codePegs[j][i].setBounds(165 + j * widtheightGap, 160 + i * heightGap, PEGSIZE, PEGSIZE);


				checkPegs[j][i] = new CodePeg("notFound");

				checkPegs[j][i].setBounds(10 + j * (PEGSIZE / 2), 170 + i * heightGap, PEGSIZE / 2, PEGSIZE / 2);

			}


		}

	}


	private void startGame() {

		setCode();

		currentRow = guesses - 1;

		rowClickable(currentRow);

	}


	private void nextRow() {

		rowUnclickable(currentRow);

		if (currentRow == 0) {

			gameOver("Lost");

		}

		currentRow--;

		rowClickable(currentRow);

	}


	private void checkRow(int row) {

		int correctCount = 0, wrongPosCount = 0;

		if (!codeFinished()) 

		{

			System.out.println("Code is not finished");

		}

		String[] temp = new String[codeLength];


		for (int j = 0; j < codeLength; j++) {

			temp[j] = codePegs[j][row].pegColor;

		}


		for (int j = 0; j < codeLength; j++) {

			if (temp[j].equals(keyPegs[j].pegColor)) {

				temp[j] = "correct";

				correctCount++;

			}

		}


		for (int j = 0; j < codeLength; j++) {

			for (int g = 0; g < codeLength; g++) {

				if (temp[j].equals(keyPegs[g].pegColor)) {

					temp[j] = "wrong position";

					wrongPosCount++;

				}

			}

		}


		System.out.println("Wrong Position: " + wrongPosCount);

		System.out.println("Correct: " + correctCount);


		for (int j = 0; j < correctCount; j++) {

			checkPegs[j][currentRow].setColor("correct");

		}

		for (int j = correctCount; j < correctCount + wrongPosCount; j++) {

			checkPegs[j][currentRow].setColor("wrongPosition");

		}

		for (int j = (correctCount + wrongPosCount); j < codeLength; j++) {

			checkPegs[j][currentRow].setColor("notFound");

		}


		if (correctCount == codeLength) {

			gameOver("Won");

			return;

		}


		nextRow();

	}


	private boolean codeFinished() {

		for (int j = 0; j < codeLength; j++) 

		{

			if (codePegs[j][currentRow].pegColor.equals("empty"))

			{

				JOptionPane.showInternalMessageDialog(null, "Enter all the pegs before submitting an answer! You wasted a guess! Begin guessing on the row above!",

						"Submit all pegs", JOptionPane.ERROR_MESSAGE);

				return false;

			}

		}


		return true;

	}


	private void restartGame() {

		for (int i = 0; i < guesses; i++) 

		{

			for (int j = 0; j < codeLength; j++) 

			{

				keyPegs[j].setColor("empty");

				keyPegs[j].setBounds(165 + j * widtheightGap, 60, PEGSIZE, PEGSIZE);


				codePegs[j][i].setColor("empty");

				codePegs[j][i].setBounds(165 + j * widtheightGap, 160 + i * heightGap, PEGSIZE, PEGSIZE);


				checkPegs[j][i].setColor("notFound");

				checkPegs[j][i].setBounds(10 + j * (PEGSIZE / 2), 170 + i * heightGap, PEGSIZE / 2, PEGSIZE / 2);



				winLabel.setVisible(false);

				enterLabel.setVisible(true);

				showHideLabel.setVisible(true);

				refreshLabel.setVisible(true);

				infoLabel.setVisible(true);

			}


		}

		for (int i = 0; i < guesses; i++) 

		{

			rowUnclickable(i);

		}

		setCode();

		repaint();

		startGame();

	}


	private void rowClickable(int row) {

		for (int j = 0; j < codeLength; j++) {

			codePegs[j][row].addMouseListener(this);

		}

		System.out.println("Row " + row + " clickable");

	}


	private void gameOver(String gameMessage) {

		showCode();

		if (gameMessage == "Won")

		{

			winLabel.setIcon(new ImageIcon("C:/Users/anish/Documents/VS Code -- Documents/Java/MasterMind/src/images/end2.gif"));

			refreshLabel.setVisible(false);

			infoLabel.setVisible(false);

			enterLabel.setVisible(false);

			showHideLabel.setVisible(false);

			winLabel.setVisible(true);

		}

		else if (gameMessage == "Lost")

		{

			winLabel.setIcon(new ImageIcon("C:/Users/anish/Documents/VS Code -- Documents/Java/MasterMind/src/images/lose2.gif"));

			refreshLabel.setVisible(false);

			infoLabel.setVisible(false);

			enterLabel.setVisible(false);

			showHideLabel.setVisible(false);

			winLabel.setVisible(true);

		}

		int answer = JOptionPane.showConfirmDialog(null, "Play again?", "You " + gameMessage + "!",

				JOptionPane.YES_NO_OPTION);

		if (answer == 0) 

		{

			hideCode();

			restartGame();

		} else if (answer == 1) {

			System.exit(0);


		}

	}


	private void rowUnclickable(int row) {

		for (int j = 0; j < codeLength; j++) {

			codePegs[j][row].removeMouseListener(this);

		}

		System.out.println("Row " + row + " unclickable");

	}


	private void setCode() {

		int randomNum;

		for (int j = 0; j < codeLength; j++) {

			randomNum = random.nextInt(codeLength);

			keyPegs[j].setColor(((String) possibleColors[randomNum]).toLowerCase());

		}


		// prints out correct code to console

		System.out.println("Correct Code: ");

		for (int j = 0; j < codeLength; j++) {

			System.out.print(keyPegs[j].pegColor + " ");

		}

		System.out.println();

	}


	private void hideCode() {

		codeCoverLabel.setVisible(true);

		showHideImage = "show";

		showHideLabel.setText("Show");

		System.out.println("Code covered");

	}


	private void showCode() {

		codeCoverLabel.setVisible(false);

		showHideImage = "hide";

		showHideLabel.setText("Hide");

		System.out.println("Code shown");

	}


	private String selectColor() {

		Object selectedColor = JOptionPane.showInputDialog(null, "Choose one", "Input", JOptionPane.INFORMATION_MESSAGE,

				null, possibleColors, possibleColors[0]);

		return (String) selectedColor;

	}


	public void mousePressed(MouseEvent e) {

		Object src = e.getSource();

		String temp = "";


		if (enterLabel == src) 

		{

			checkRow(currentRow);

		}


		if (infoLabel == src) {

			instructions();

		}

		if (refreshLabel == src) {

			restartGame();

		}


		if (showHideLabel == src && showHideImage == "show") {

			showCode();

		} else if (showHideLabel == src && showHideImage == "hide") {

			hideCode();

		}


		for (int i = 0; i < guesses; i++) {

			for (int j = 0; j < codeLength; j++) {

				if (codePegs[j][i] == src) {

					temp = selectColor().toLowerCase();

					codePegs[j][i].setColor(temp);

				}

			}

		}

		repaint();

	}


	@Override

	public void mouseClicked(MouseEvent e) {


	}


	@Override

	public void mouseReleased(MouseEvent e) {


	}


	@Override

	public void mouseEntered(MouseEvent e) {


	}


	@Override

	public void mouseExited(MouseEvent e) {


	}

}