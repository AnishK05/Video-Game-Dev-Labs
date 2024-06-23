package gameRPS;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class RPSPanel extends JPanel implements MouseListener 
{
	private int WIDTH = 800;
	private int HEIGHT = 700;
	private Dimension SIZE = new Dimension(WIDTH, HEIGHT);
	private String computerChoice = " ";

	private ImageIcon rock = new ImageIcon("C:/Users/anish/Documents/VS Code -- Documents/Java/Test2-RockPaperScissors/src/filesRPS/rock.png");
	private ImageIcon paper = new ImageIcon("C:/Users/anish/Documents/VS Code -- Documents/Java/Test2-RockPaperScissors/src/filesRPS/paper.jpg");
	private ImageIcon scissors = new ImageIcon("C:/Users/anish/Documents/VS Code -- Documents/Java/Test2-RockPaperScissors/src/filesRPS/scissors.jpg");

	private ImageIcon winner = new ImageIcon("C:/Users/anish/Documents/VS Code -- Documents/Java/Test2-RockPaperScissors/src/filesRPS/winner.png");
	private ImageIcon loser = new ImageIcon("C:/Users/anish/Documents/VS Code -- Documents/Java/Test2-RockPaperScissors/src/filesRPS/loser.jpg");
	private ImageIcon tie = new ImageIcon("C:/Users/anish/Documents/VS Code -- Documents/Java/Test2-RockPaperScissors/src/filesRPS/tie.png");

	JLabel titleLabel = new JLabel("Rock, Paper, Scissors, Shoot!");
	JLabel instructions1Label = new JLabel("Click to Play! Click an image from the left column to represent your choice! Let's see if you can beat the computer! Good luck!");
	JLabel rockLabelP = new JLabel("");
	JLabel paperLabelP = new JLabel("");
	JLabel scissorsLabelP = new JLabel("");

	JLabel rockLabelC = new JLabel("");
	JLabel paperLabelC = new JLabel("");
	JLabel scissorsLabelC = new JLabel("");

	private Border border;
	Random random = new Random();

	JLabel winnerLabel = new JLabel("");
	JLabel playerChoiceLabel = new JLabel("Player Choice");
	JLabel computerChoiceLabel = new JLabel("Computer Choice");

	JLabel playerPointCounterLabel = new JLabel("Player: ");
	JLabel compPointCounterLabel = new JLabel("Computer:");

	JLabel winnerImageLabel = new JLabel("");

	private int playerCounter = 0;
	private int computerCounter = 0;

	JLabel scoreLabel = new JLabel("Score:");

	JLabel instructions2Label = new JLabel("Remember, rock beats scissors, scissors beats paper, and paper beats rock!");

	JLabel startOverLabel = new JLabel("Click Me To Start Over!");

	public RPSPanel()
	{
		setPreferredSize(SIZE);
		setLayout(null);
		this.setBackground(Color.GREEN);

		titleLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		titleLabel.setBounds(226, 11, 368, 34);
		add(titleLabel);

		instructions1Label.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		instructions1Label.setBounds(21, 45, 769, 43);
		add(instructions1Label);

		rockLabelP.setBounds(58, 150, 150, 150);
		rockLabelP.setIcon(rock);
		add(rockLabelP);
		rockLabelP.addMouseListener(this);

		paperLabelP.setBounds(58, 350, 150, 150);
		paperLabelP.setIcon(paper);
		add(paperLabelP);
		paperLabelP.addMouseListener(this);

		scissorsLabelP.setBounds(63, 550, 150, 150);
		scissorsLabelP.setIcon(scissors);
		add(scissorsLabelP);
		scissorsLabelP.addMouseListener(this);

		rockLabelC.setBounds(592, 150, 150, 150);
		rockLabelC.setIcon(rock);
		add(rockLabelC);

		paperLabelC.setBounds(592, 350, 150, 150);
		paperLabelC.setIcon(paper);
		add(paperLabelC);

		scissorsLabelC.setBounds(592, 550, 150, 150);
		scissorsLabelC.setIcon(scissors);
		add(scissorsLabelC);
		winnerLabel.setHorizontalAlignment(SwingConstants.CENTER);

		winnerLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		winnerLabel.setBounds(311, 335, 150, 150);
		add(winnerLabel);

		playerChoiceLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		playerChoiceLabel.setBounds(63, 130, 100, 18);
		add(playerChoiceLabel);

		computerChoiceLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		computerChoiceLabel.setBounds(576, 130, 115, 18);
		add(computerChoiceLabel);

		playerPointCounterLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		playerPointCounterLabel.setBounds(350, 573, 89, 26);
		add(playerPointCounterLabel);

		compPointCounterLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		compPointCounterLabel.setBounds(350, 598, 115, 34);
		add(compPointCounterLabel);

		winnerImageLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		winnerImageLabel.setBounds(338, 201, 162, 217);
		add(winnerImageLabel);

		scoreLabel.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		scoreLabel.setBounds(350, 536, 89, 26);
		add(scoreLabel);

		instructions2Label.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		instructions2Label.setBounds(180, 86, 454, 33);
		add(instructions2Label);

		startOverLabel.setForeground(Color.RED);
		startOverLabel.setBackground(Color.MAGENTA);
		startOverLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		startOverLabel.setBounds(294, 643, 237, 14);
		add(startOverLabel);
		startOverLabel.addMouseListener(this);

		this.computerSelection();

	}

	private void computerSelection ()
	{
		int randNum = random.nextInt(3);

		if (randNum == 0)
		{
			computerChoice = "Rock";
		}
		else if (randNum == 1)
		{
			computerChoice = "Paper";
		}
		else
		{
			computerChoice = "Scissors";
		}
	}


	@Override
	public void mouseClicked(MouseEvent e)
	{
		Object src = e.getSource();

		if (src == startOverLabel)
		{
			playerCounter = 0;
			computerCounter = 0;

			playerPointCounterLabel.setText("Player: " + playerCounter);
			compPointCounterLabel.setText("Computer: " + computerCounter);

			rockLabelP.setBorder(null);
			paperLabelP.setBorder(null);
			scissorsLabelP.setBorder(null);
			rockLabelC.setBorder(null);
			paperLabelC.setBorder(null);
			scissorsLabelC.setBorder(null);

			winnerLabel.setText("");
			winnerImageLabel.setIcon(null);

		}


		if (src == rockLabelP)
		{
			if (computerChoice == "Scissors")
			{
				scissorsLabelC.setBorder(BorderFactory.createTitledBorder(border, "Scissors", TitledBorder.CENTER, TitledBorder.TOP, getFont(), Color.BLACK));
				rockLabelC.setBorder(null);
				paperLabelC.setBorder(null);
				winnerLabel.setText("Player Wins!");
				playerCounter++;

				playerPointCounterLabel.setText("Player: " + playerCounter);
				compPointCounterLabel.setText("Computer: " + computerCounter);

				winnerImageLabel.setIcon(winner);

			}
			else if (computerChoice == "Paper")
			{
				paperLabelC.setBorder(BorderFactory.createTitledBorder(border, "Paper", TitledBorder.CENTER, TitledBorder.TOP, getFont(), Color.BLACK));
				rockLabelC.setBorder(null);
				scissorsLabelC.setBorder(null);
				winnerLabel.setText("Computer Wins!");
				computerCounter++;

				playerPointCounterLabel.setText("Player: " + playerCounter);
				compPointCounterLabel.setText("Computer: " + computerCounter);

				winnerImageLabel.setIcon(loser);
			}
			else
			{
				rockLabelC.setBorder(BorderFactory.createTitledBorder(border, "Rock", TitledBorder.CENTER, TitledBorder.TOP, getFont(), Color.BLACK));
				paperLabelC.setBorder(null);
				scissorsLabelC.setBorder(null);
				winnerLabel.setText("Tie!");

				playerPointCounterLabel.setText("Player: " + playerCounter);
				compPointCounterLabel.setText("Computer: " + computerCounter);

				winnerImageLabel.setIcon(tie);
			}
		}

		if (src == paperLabelP)
		{
			if (computerChoice == "Rock")
			{
				rockLabelC.setBorder(BorderFactory.createTitledBorder(border, "Rock", TitledBorder.CENTER, TitledBorder.TOP, getFont(), Color.BLACK));
				paperLabelC.setBorder(null);
				scissorsLabelC.setBorder(null);
				winnerLabel.setText("Player Wins!");
				playerCounter++;

				playerPointCounterLabel.setText("Player: " + playerCounter);
				compPointCounterLabel.setText("Computer: " + computerCounter);

				winnerImageLabel.setIcon(winner);
			}
			else if (computerChoice == "Scissors")
			{
				scissorsLabelC.setBorder(BorderFactory.createTitledBorder(border, "Scissors", TitledBorder.CENTER, TitledBorder.TOP, getFont(), Color.BLACK));
				rockLabelC.setBorder(null);
				paperLabelC.setBorder(null);
				winnerLabel.setText("Computer Wins!");
				computerCounter++;

				playerPointCounterLabel.setText("Player: " + playerCounter);
				compPointCounterLabel.setText("Computer: " + computerCounter);

				winnerImageLabel.setIcon(loser);
			}
			else
			{
				paperLabelC.setBorder(BorderFactory.createTitledBorder(border, "Paper", TitledBorder.CENTER, TitledBorder.TOP, getFont(), Color.BLACK));
				rockLabelC.setBorder(null);
				scissorsLabelC.setBorder(null);
				winnerLabel.setText("Tie!");

				playerPointCounterLabel.setText("Player: " + playerCounter);
				compPointCounterLabel.setText("Computer: " + computerCounter);

				winnerImageLabel.setIcon(tie);
			}
		}

		if (src == scissorsLabelP)
		{
			if (computerChoice == "Paper")
			{
				paperLabelC.setBorder(BorderFactory.createTitledBorder(border, "Paper", TitledBorder.CENTER, TitledBorder.TOP, getFont(), Color.BLACK));
				rockLabelC.setBorder(null);
				scissorsLabelC.setBorder(null);
				winnerLabel.setText("Player Wins!");
				playerCounter++;

				playerPointCounterLabel.setText("Player: " + playerCounter);
				compPointCounterLabel.setText("Computer: " + computerCounter);

				winnerImageLabel.setIcon(winner);
			}
			else if (computerChoice == "Rock")
			{
				rockLabelC.setBorder(BorderFactory.createTitledBorder(border, "Rock", TitledBorder.CENTER, TitledBorder.TOP, getFont(), Color.BLACK));
				paperLabelC.setBorder(null);
				scissorsLabelC.setBorder(null);
				winnerLabel.setText("Computer Wins!");
				computerCounter++;

				playerPointCounterLabel.setText("Player: " + playerCounter);
				compPointCounterLabel.setText("Computer: " + computerCounter);

				winnerImageLabel.setIcon(loser);
			}
			else
			{
				scissorsLabelC.setBorder(BorderFactory.createTitledBorder(border, "Scissors", TitledBorder.CENTER, TitledBorder.TOP, getFont(), Color.BLACK));
				rockLabelC.setBorder(null);
				paperLabelC.setBorder(null);
				winnerLabel.setText("Tie!");

				playerPointCounterLabel.setText("Player: " + playerCounter);
				compPointCounterLabel.setText("Computer: " + computerCounter);

				winnerImageLabel.setIcon(tie);
			}
		}
	}



	@Override
	public void mousePressed(MouseEvent e) {

	}



	@Override
	public void mouseReleased(MouseEvent e)
	{
		this.computerSelection();

	}


	@Override
	public void mouseEntered(MouseEvent e)
	{
		Object src = e.getSource();
		border = BorderFactory.createLineBorder(Color.BLUE, 5);

		if (src == rockLabelP)
		{
			rockLabelP.setBorder(BorderFactory.createTitledBorder(border, "Rock", TitledBorder.CENTER, TitledBorder.TOP, getFont(), Color.BLACK));
		}

		if (src == paperLabelP)
		{
			paperLabelP.setBorder(BorderFactory.createTitledBorder(border, "Paper", TitledBorder.CENTER, TitledBorder.TOP, getFont(), Color.BLACK));
		}

		if (src == scissorsLabelP)
		{
			scissorsLabelP.setBorder(BorderFactory.createTitledBorder(border, "Scissors", TitledBorder.CENTER, TitledBorder.TOP, getFont(), Color.BLACK));
		}
	}



	@Override
	public void mouseExited(MouseEvent e)
	{
		Object src = e.getSource();

		if (src == rockLabelP)
		{
			rockLabelP.setBorder(null);
		}

		if (src == paperLabelP)
		{
			paperLabelP.setBorder(null);
		}

		if (src == scissorsLabelP)
		{
			scissorsLabelP.setBorder(null);
		}

	}
}