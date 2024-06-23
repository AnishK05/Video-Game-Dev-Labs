package gameTTT;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;


public class TTTPanel extends JPanel implements MouseListener //We use implements because we can only extend one thing (JPanel). Implements allows us to incorporate multiple classes. When we implement a class, we have to use all the methods inside that class (Eclipse will allow you to add all the methods with that class). 
{
	//VARIABLES
	
	private final int GAME_WIDTH = 500; // private meaning only accessible to this class, final meaning it cannot be changed (we use upper-case for constants). 
	private final int GAME_HEIGHT = 610; //PROPER NAME FOR CLASS VARIABLES IS INSTANCE VARIABLES!
	private Dimension size = new Dimension(GAME_WIDTH, GAME_HEIGHT); //Dimension is a class we use in java to set the size of a panel. In this case, the game width game height are our dimensions. 
	private int turn = 1; 
	
	//ICONS
	
	private ImageIcon board = new ImageIcon("C:/Users/anish/Documents/VS Code -- Documents/Java/02 Tic-Tac-Toe/src/imagesTTT/board.png");
	private ImageIcon bigX = new ImageIcon("C:/Users/anish/Documents/VS Code -- Documents/Java/02 Tic-Tac-Toe/src/imagesTTT/x.png");
	private ImageIcon smallX = new ImageIcon("C:/Users/anish/Documents/VS Code -- Documents/Java/02 Tic-Tac-Toe/src/imagesTTT/small_x.png");
	private ImageIcon bigO = new ImageIcon("C:/Users/anish/Documents/VS Code -- Documents/Java/02 Tic-Tac-Toe/src/imagesTTT/o.png");
	private ImageIcon smallO = new ImageIcon("C:/Users/anish/Documents/VS Code -- Documents/Java/02 Tic-Tac-Toe/src/imagesTTT/small_o.png");
	
	private JLabel titleLBL = new JLabel("Tic-Tac-Toe"); //Need these following variables to be used in the entire class -- moved them outside of the method to increase scope from local to global.  
	private JLabel turnLBL = new JLabel("Whose Turn It Is:");
	private JLabel boardLBL = new JLabel("");
	private JLabel[] nineBoardClickers; //Creating a 3x3 array for when the user clicks a region on the Tic-Tac-Toe board. 
	
	
	public TTTPanel() //Constructor Name has to be the same as the class. Although it looks like a method, it is a CONSTRUCTOR. 
	{
		setPreferredSize(size);
		setLayout(null);
		setLabels(); //Runs method that holds all the labels. 
		
		int startGameChoice = JOptionPane.showConfirmDialog(null, "Do you want to play Tic-Tac-Toe? Click yes to do so! You will see a Tic-Tac-Toe board to begin playing! Simply click where you want to place your piece!", "Tic-Tac-Toe Game!", JOptionPane.YES_NO_OPTION);
		if (startGameChoice != 0)
		{
			System.exit(0);
		}
	}
	
	//Creating a method
	
	private void setLabels() //This method holds all the labels and its preferences.
	{
		titleLBL.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 45));
		titleLBL.setHorizontalAlignment(SwingConstants.CENTER);
		titleLBL.setBounds(0, 0, 500, 50);
		add(titleLBL);
		
		turnLBL.setHorizontalAlignment(SwingConstants.CENTER);
		turnLBL.setHorizontalTextPosition(JLabel.LEFT); //Moves the text so that it appears before the icon. 
		turnLBL.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 25));
		turnLBL.setBounds(0, 550, 500, 50);
		turnLBL.setIcon(smallX); //add icon to know whose turn it is
		add(turnLBL);
		
		nineBoardClickers = new JLabel[9]; //Creating the array using a for loop -- from 0 through 8 (9 regions)
		for (int i=0; i<9; i++)
		{
			nineBoardClickers[i] = new JLabel(); //Creating a label for each i increment -- 9 regional labels. 
			nineBoardClickers[i].addMouseListener(this); //Creating a MouseListener for each i increment -- 9 MouseListeners. 
			add(nineBoardClickers[i]); //add the 9 labels to the panel.
		}
		// nineBoardClickers[0].setIcon(bigX); //Have to set the location of each of the 9 regional labels. To set these, use the setIcon feature to "track" the label, and adjust its coordinates accordingly. 
		nineBoardClickers[0].setBounds(40, 70, 150, 150); //First coordinate is x, second coordinate is y. Third coordinate and 4 coordinate shifts the icon around. Delete icons when done because we no longer need them. 
		nineBoardClickers[1].setBounds(200, 70, 150, 150);
		nineBoardClickers[2].setBounds(360, 70, 150, 150);
		nineBoardClickers[3].setBounds(40, 230, 150, 150);
		nineBoardClickers[4].setBounds(200, 230, 150, 150);
		nineBoardClickers[5].setBounds(360, 230, 150, 150);
		nineBoardClickers[6].setBounds(40, 390, 150, 150);
		nineBoardClickers[7].setBounds(200, 390, 150, 150);
		nineBoardClickers[8].setBounds(360, 390, 150, 150);
		
		boardLBL.setHorizontalAlignment(SwingConstants.CENTER);
		boardLBL.setBounds(0, 48, 500, 508);
		boardLBL.setIcon(board); //Before we add the label, we want to add the icon of the Tic-Tac-Toe board. -- We have to do this in code, not possible in design feature.
		add(boardLBL);	
	}
	
	//All methods associated with MouseListener Class
	
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) // e holds all the mouse events for this method. //Safest one to use because it includes "clicked" and "released" -- accounts for random user input (too hard, too soft, etc)
	{
		Object src = e.getSource(); //Taken the object "e.getSource()" and set it equal to the object src. Simply for typing purposes. Now "src" holds the mouse events and not "e.getSource()". 
		int idx = -1; //Array starts at zero, so we want a value not in the array. 
		
		for (int i = 0; i < 9; i++) //Loop runs through the array and sees which one was clicked. 
		{
			if (src == nineBoardClickers[i])
			{
				idx = i;
			}
		}
		
		if (turn % 2 == 1)  //Code for when it is X's turn.
		{
			nineBoardClickers[idx].setIcon(bigX);
			turnLBL.setIcon(smallO);
			nineBoardClickers[idx].removeMouseListener(this); //We do this so that someone cannot click the same spot twice. 
			turn++;
		}
		else //Code for when it is O's turn (everyone else).
		{
			nineBoardClickers[idx].setIcon(bigO);
			turnLBL.setIcon(smallX);
			nineBoardClickers[idx].removeMouseListener(this);
			turn++;
		}
		if ( checkWinner() || checkTie() ) //Code for when the game is over -- Win or Tie (Calling methods)
		{
			//Leave blank as game-ending JOptionPane is found in the respective methods -- checkWinner() and checkTie()
			//Using the created xWon() and oWon() methods (method inside method), JOptionPane is executed.
		}
	}
	private void xWon() //Method to call when x wins -- repeated code.
	{
		int answer = JOptionPane.showConfirmDialog(null, "X Won! Do You Want to Play Again?", "Game Over!", JOptionPane.YES_NO_OPTION); //Use null because we want it to appear on the screen, not on some random label. Use variable answer to give the user two options: play again (0) or game over (1). YES NO OPTION gives the user two options.

		if (answer == 0) //If play again
		{
			startOver(); //Call method
		}
	    else //Exit
		{
	    	System.exit(0); //Tells java there was no problem, now it is time to exit and shut off the program -- Syntax for when java needs to exit. 
		}
	}
	private void oWon() //Method to call when o wins -- repeated code.
	{
		int answer = JOptionPane.showConfirmDialog(null, "O Won! Do You Want to Play Again?", "Game Over!", JOptionPane.YES_NO_OPTION);

		if (answer == 0)
		{
			startOver();
		}
		else 
		{
			System.exit(0);
		}
	}	
	private void startOver() //Code for when to restart and play again. 
	{
		for (int i = 0; i < 9; i++)
		{
			nineBoardClickers[i].setIcon(null);  //Clears all the icons. 
			nineBoardClickers[i].removeMouseListener(this); //Remove mouse listeners from random regions -- just in case. 
			nineBoardClickers[i].addMouseListener(this); //Adds back all the mouse listeners because we turned them off. 
		}
	}
	private boolean checkTie() //Method for when it is tie game. 
	{
		for (int i=0; i<9; i++)
		{
			if (nineBoardClickers[i].getIcon() == null) //if region is empty
			{
				return false; //Not all moves have gone yet -- so winner has not been determined. Because this is second in our OR statement, we do not have to worry if the player has won. We only have to check if the game is over and there is no winner. Only then is the game a tie. 
			}
		}
		int answer = JOptionPane.showConfirmDialog(null, "Tie Game! Do You Want to Play Again?", "Game Over!", JOptionPane.YES_NO_OPTION);
			if (answer == 0)
			{
				startOver();
			}
			else 
			{
				System.exit(0);
			}
	 return true;
	}
	private boolean checkWinner() //Method for when there is a winner. 
	{
		//Checking Rows for winner
		if ( (nineBoardClickers[0].getIcon() != null) && ((nineBoardClickers[0].getIcon()).equals(nineBoardClickers[1].getIcon())) && (nineBoardClickers[0].getIcon().equals(nineBoardClickers[2].getIcon())))
		{
			if (nineBoardClickers[0].getIcon().equals(bigX))
			{
				xWon();
			}
			else 
			{
				oWon();
			}
			return true;
		}
		if ( (nineBoardClickers[3].getIcon() != null) && ((nineBoardClickers[3].getIcon()).equals(nineBoardClickers[4].getIcon())) && (nineBoardClickers[3].getIcon().equals(nineBoardClickers[5].getIcon())))
		{
			if (nineBoardClickers[3].getIcon().equals(bigX))
			{
				xWon();
			}
			else 
			{
				oWon();
			}
			return true;
		}
		if ( (nineBoardClickers[6].getIcon() != null) && ((nineBoardClickers[6].getIcon()).equals(nineBoardClickers[7].getIcon())) && (nineBoardClickers[6].getIcon().equals(nineBoardClickers[8].getIcon())))
		{
			if (nineBoardClickers[6].getIcon().equals(bigX))
			{
				xWon();
			}
			else 
			{
				oWon();
			}
			return true;
		}
		//Checking Columns for winner
		if ( (nineBoardClickers[0].getIcon() != null) && ((nineBoardClickers[0].getIcon()).equals(nineBoardClickers[3].getIcon())) && (nineBoardClickers[0].getIcon().equals(nineBoardClickers[6].getIcon())))
		{
			if (nineBoardClickers[0].getIcon().equals(bigX))
			{
				xWon();
			}
			else 
			{
				oWon();
			}
			return true;
		}
		if ( (nineBoardClickers[1].getIcon() != null) && ((nineBoardClickers[1].getIcon()).equals(nineBoardClickers[4].getIcon())) && (nineBoardClickers[1].getIcon().equals(nineBoardClickers[7].getIcon())))
		{
			if (nineBoardClickers[1].getIcon().equals(bigX))
			{
				xWon();
			}
			else 
			{
				oWon();
			}
			return true;
		}
		if ( (nineBoardClickers[2].getIcon() != null) && ((nineBoardClickers[2].getIcon()).equals(nineBoardClickers[5].getIcon())) && (nineBoardClickers[2].getIcon().equals(nineBoardClickers[8].getIcon())))
		{
			if (nineBoardClickers[2].getIcon().equals(bigX))
			{
				xWon();
			}
			else 
			{
				oWon();
			}
			return true;
		}
		//Checking Diagonals for winner
		if ( (nineBoardClickers[0].getIcon() != null) && ((nineBoardClickers[0].getIcon()).equals(nineBoardClickers[4].getIcon())) && (nineBoardClickers[0].getIcon().equals(nineBoardClickers[8].getIcon())))
		{
			if (nineBoardClickers[0].getIcon().equals(bigX))
			{
				xWon();
			}
			else 
			{
				oWon();
			}
			return true;
		}
		if ( (nineBoardClickers[2].getIcon() != null) && ((nineBoardClickers[2].getIcon()).equals(nineBoardClickers[4].getIcon())) && (nineBoardClickers[2].getIcon().equals(nineBoardClickers[6].getIcon())))
		{
			if (nineBoardClickers[2].getIcon().equals(bigX))
			{
				xWon();
			}
			else 
			{
				oWon();
			}
			return true;
		}
	return false;
	}
	
	@Override
	public void mouseReleased(MouseEvent e) 
	{
		
		
	}
	@Override
	public void mouseEntered(MouseEvent e) 
	{
		
		
	}
	@Override
	public void mouseExited(MouseEvent e) 
	{
		
		
	}
}