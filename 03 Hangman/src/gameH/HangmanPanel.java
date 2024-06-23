package gameH;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class HangmanPanel extends JPanel implements ActionListener  //HangmanPanel extends JPanel means HangmanPanel can do anything JPanel does. HangmanPanel implements ActionListener means we have to use all the methods in ActionListener. We can only extend one thing, but we can implement however many we want. 
{
	//DIFFERENCE between argument and parameters: You are sending the argument, and getting the parameter! KEY DISTINCTION!
	//Declare Global Variables -- Instance Variables; Can be used in entire class.
	
	private int WIDTH = 700;
	private int HEIGTH = 540;
	private Dimension SIZE = new Dimension(WIDTH,HEIGTH);
	private JLabel titleLabel;
	private JLabel hangmanLabel;
	private JLabel wordLabel;
	private JLabel asterisksLabel;
	private JLabel pickLabel;
	private JTextField textField;
	private JLabel lgLabel; //letters guessed variable -- "lg"
	private JLabel guessedLabel;
	private JLabel updatesLabel;
	private String guessedLetters = ""; //Will store the letters guessed by the user as a string value. 
	private String solved; 
	private String asterisks = "";
	private String alphabet = "abcdefghijklmnopqrstuvwxyz"; //Compare if what the user guesses is a string value -- part of the alphabet.  
	private int numberWrongGuesses = 0; //Number of incorrect guesses. 
	
	//Image Icon Variables:
	
	private ImageIcon win = new ImageIcon("C:/Users/anish/Documents/VS Code -- Documents/Java/03 Hangman/src/filesH/trophy.png");
	private ImageIcon rip = new ImageIcon("C:/Users/anish/Documents/VS Code -- Documents/Java/03 Hangman/src/filesH/RIP.jpg");
	
	
	public HangmanPanel() 
	{
		setPreferredSize(SIZE);
		this.setBackground(Color.ORANGE);
		setLayout(null);
		
		solved = GetWord.guessWord(); //Call the GetWord class -- call the method inside the class -- this method gives the user the "random word" to guess.
		System.out.println(solved);
		//code to make sure the asterisks are the same amount as the number of letters in the word 
		for (int i=0; i<solved.length(); i++)
		{
			asterisks += "*"; 
		}
		
		titleLabel = new JLabel("Hangman");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 40));
		titleLabel.setBounds(0, 20, 350, 54);
		add(titleLabel);
		
		hangmanLabel = new JLabel("");
		hangmanLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		hangmanLabel.setHorizontalAlignment(SwingConstants.CENTER);
		hangmanLabel.setBounds(350, 0, 350, 541);
		hangmanLabel.setIcon(new ImageIcon("C:/Users/anish/Documents/VS Code -- Documents/Java/03 Hangman/src/filesH/0.jpg"));
		add(hangmanLabel);
		
		wordLabel = new JLabel("Word to Guess");
		wordLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		wordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		wordLabel.setBounds(0, 85, 350, 31);
		add(wordLabel);
		
		asterisksLabel = new JLabel("New label");
		asterisksLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		asterisksLabel.setHorizontalAlignment(SwingConstants.CENTER);
		asterisksLabel.setBounds(0, 118, 350, 31);
		asterisksLabel.setText(asterisks);
		add(asterisksLabel);
		
		pickLabel = new JLabel("Please Pick a Letter");
		pickLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pickLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		pickLabel.setBounds(0, 179, 350, 31);
		add(pickLabel);
		
		textField = new JTextField();
		textField.setBounds(148, 221, 15, 20);
		textField.addActionListener(this);
		textField.setColumns(10);
		add(textField);
		
		
		lgLabel = new JLabel("Letters Guessed");
		lgLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lgLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lgLabel.setBounds(0, 267, 350, 31);
		add(lgLabel);
		
		guessedLabel = new JLabel("");
		guessedLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		guessedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		guessedLabel.setBounds(0, 297, 350, 31);
		add(guessedLabel);
		
		updatesLabel = new JLabel("");
		updatesLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		updatesLabel.setBounds(0, 351, 350, 190);
		add(updatesLabel);
	}
	
	//Creating Methods
	
	private void checkGuess(String temp)
	{
		if (alphabet.indexOf(temp) >= 0) //Checks if the guess is in the alphabet (is a letter)
		{
			if (guessedLetters.indexOf(temp) == -1) //Looks at whether the letter has been guessed before. -1 means that the character (temp) is not found in the guessedLetters string and thus must be added to the total guessedLetters.
			{
				guessedLetters += temp;
			}
			if (solved.indexOf(temp) >= 0) //Code for what to do if the character (temp) is found inside the word that is being guessed. 
			{
				for (int i=0; i<solved.length(); i++) //We are using a for loop because if a word has the same letter more than once, we need to repeat the iteration of changing the asterisks. 
				{
					if ( solved.charAt(i) == temp.charAt(0) ) //Even though temp itself is one character, it is stored as a string, and thus, we must use the charAt method to be able to compare the characters.
					{
						asterisks = asterisks.substring(0,i) + temp + asterisks.substring(i+1); //This line may seem confusing. Take a minute to understand what it is saying. 
					}
				}
			}
			else //if the guessed letter is not found in the word, then we add one to the number of wrong guesses. We will use this integer to change the hangman screen.  
			{
				numberWrongGuesses++;
			}
		}
	}

	private boolean checkGameOver()
	{
		if (solved.equals(asterisks))
		{
			updatesLabel.setIcon(win);
			return true;
		}
		else if (numberWrongGuesses == 7)
		{
			updatesLabel.setIcon(rip);
			return true;
		}
		return false;
	}
	
	private void gameRestart()
	{
		solved = GetWord.guessWord();
		numberWrongGuesses = 0;
		asterisks = "";
		guessedLetters = "";
		for (int i = 0; i<solved.length(); i++)
		{
			asterisks += "*";
		}
		System.out.println(solved);
		hangmanLabel.setIcon(new ImageIcon("C:/Users/anish/Documents/VS Code -- Documents/Java/03 Hangman/src/filesH/" + numberWrongGuesses + ".jpg"));
		asterisksLabel.setText(asterisks);
		guessedLabel.setText(guessedLetters);
		updatesLabel.setIcon(null);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) //Will listen for keyboard actions.
	{
		//This piece of code is taking the user input, evaluating it, and updating the screen based on what was entered. 
		String guess = textField.getText().toLowerCase();
		if (guess.length()>0)
		{
			checkGuess(guess.substring(0, 1)); //We use a substring in case the user types more than one letter! This way, the input will only accept the first letter of whatever the user typed.
		}
		hangmanLabel.setIcon(new ImageIcon("C:/Users/anish/Documents/VS Code -- Documents/Java/03 Hangman/src/filesH/" + numberWrongGuesses + ".jpg")); //changes the image of the label based on what the user guesses. 
		asterisksLabel.setText(asterisks);
		guessedLabel.setText(guessedLetters);
		textField.setText("");
		
		//This piece of code checks if the game is over. 
		if (checkGameOver())
		{
			int restart = JOptionPane.showConfirmDialog(null, "Would you Like to Play Again?", "Game Over", JOptionPane.YES_NO_OPTION); //Hover your mouse over the showConfirmDialog to see the syntax of this piece of code. 
			if (restart == 0)
			{
				gameRestart();
			}
			else 
			{
				System.exit(0); //Normal syntax to exit the program and end it. 
			}
		}
		
	}
}