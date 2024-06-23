package game4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Panel4 extends JPanel 
{
	private int playerX = 0;
	private int playerY = 0;
	private int diameter = 100;
	private int numRows = 6;
	private int numColumns = 7;
	private int turn = 0;
	Circles4[][] circles;
	
	Panel4() //Constructor
	{
		this.setPreferredSize(new Dimension(720, 700));
		this.setBackground(Color.BLUE);
		this.setLayout(null);
		setCircles();
		
		addMouseListener(new MouseAdapter() //Alternative way to use mouse listener -- This is how programmers do it.
				//mouse listener looks for button clicks on the mouse. 
				{
					public void mouseReleased(MouseEvent e) //Can be whatever method you need.
					{
						dropToken(e.getX(), e.getY());
					}
				});
		
		addMouseMotionListener(new MouseAdapter() //Alternative way to use mouse motion listener -- This is how programmers do it.
				//Motion listener looks for drags and movement of the mouse itself. 
				{
					public void mouseDragged(MouseEvent e)  //Can be whatever method you need.
					{
						movePlayer(e.getX(), e.getY());
					}
				});
	}

	void movePlayer(int x, int y) 
	{
		if (playerX == x)
		{
			return;
		}
		repaint();
		playerX = x- 5; //taking off 5 because you need cushion for where the mouse is. 
		playerY = 0; //We are not going to use y for right now. We are only dragging the tokens left or right in the game. 
		
		if (playerX < 0)
		{
			playerX = 0;
		}
		
		if (playerX > 620)
		{
			playerX = 620;
		}
		repaint(0, 0, 720, 700); //Repaint can be repainted in certain regions. This repaint will repaint the coordinates playerX, playerY, and repaint a size consisting of the diameter of the token.
		
	}

	void dropToken(int x, int y) 
	{
		if (y > 100)
		{
			return;
		}
		
		int red, green, blue;
		if (turn % 2 == 0)
		{
			red = 255;
			green = 0;
			blue = 0;
		}
		else 
		{
			red = 254;
			green = 255;
			blue = 0;
		}
		
		//Assigning what column is being correlated with each drop position (based on coordinates)
		
		int column = 0;
		
		if (x > 0 & x < 70)
		{
			column = 0;
		}
		else if (x > 73 && x < 173)
		{
			column = 1;
		}
		else if (x > 173 && x < 273)
		{
			column = 2;
		}
		else if (x > 273 && x < 373)
		{
			column = 3;
		}
		else if (x > 373 && x < 473)
		{
			column = 4;
		}
		else if (x > 473 && x < 573)
		{
			column = 5;
		}
		else if (x > 573 && x < 673)
		{
			column = 6;
		}	
		
		
		for (int row = 0; row < numRows; row++)
		{
			if (circles[row][column].getRedColor() == 0)
			{
				circles[row][column].setRedColor(red);
				circles[row][column].setGreenColor(green);
				circles[row][column].setBlueColor(blue);
				turn++;
				repaint();
				break;
			}
		}
		checkWinner();
	}

	
	private void checkWinner() 
	{
		boolean win = false;
		
		//Check Horizontal Wins
		
		for (int row=0; row<numRows; row++)
		{
			for (int col=0; col<numColumns-3; col++)
			{
				if( (circles[row][col].getRedColor()!= 0) && 
						( circles[row][col].getRedColor() == (circles[row][col+1].getRedColor()) ) && 
						( circles[row][col].getRedColor() == (circles[row][col+2].getRedColor()) ) && 
						( circles[row][col].getRedColor() == (circles[row][col+3].getRedColor()) ) )
				{
					win = true;
				}
			}
		}
		
		//Check Vertical Wins
		
		for (int row=0; row<numRows-3; row++)
		{
			for (int col=0; col<numColumns; col++)
			{
				if( (circles[row][col].getRedColor()!= 0) && 
						( circles[row][col].getRedColor() == (circles[row+1][col].getRedColor()) ) && 
						( circles[row][col].getRedColor() == (circles[row+2][col].getRedColor()) ) && 
						( circles[row][col].getRedColor() == (circles[row+3][col].getRedColor()) ) )
				{
					win = true;
				}
			}
		}
		
		//Check Diagonal Wins -- Positive Sloping Diagonals
		
		for (int row=0; row<numRows-3; row++)
		{
			for (int col=0; col<numColumns-3; col++)
			{
				if( (circles[row][col].getRedColor()!= 0) && 
						( circles[row][col].getRedColor() == (circles[row+1][col+1].getRedColor()) ) && 
						( circles[row][col].getRedColor() == (circles[row+2][col+2].getRedColor()) ) && 
						( circles[row][col].getRedColor() == (circles[row+3][col+3].getRedColor()) ) )
				{
					win = true;
				}
			}
		}
		
		//Check Diagonal Wins -- Negative Sloping Diagonals
		
		for (int row=3; row<numRows; row++)
		{
			for (int col=0; col<numColumns-3; col++)
			{
				if( (circles[row][col].getRedColor()!= 0) && 
						( circles[row][col].getRedColor() == (circles[row-1][col+1].getRedColor()) ) && 
						( circles[row][col].getRedColor() == (circles[row-2][col+2].getRedColor()) ) && 
						( circles[row][col].getRedColor() == (circles[row-3][col+3].getRedColor()) ) )
				{
					win = true;
				}
			}
		}
		
		if (win) //this means if win == true, it is the same thing.
		{
			String winner = "";
			
			if(turn%2 == 1) //This will see if it is red. Even though red goes first, after red's turn, the turn counter is advanced. So thus, if turn is 1, that means red has just gone.
			{
				winner = "Red is the Winner!!!";
			}
			else //If not red, yellow is the winner!
			{
				winner = "Yellow is the Winner!!!";
			}
			
			int restart = JOptionPane.showConfirmDialog(null, "Play Again?", winner, JOptionPane.YES_NO_OPTION);
			
			if (restart == 0)
			{
				startOver();
			}
			else
			{
				System.exit(0);
			}
		}

	}
	
		private void startOver() 
		{
			turn = 0;
			setCircles();
			
			repaint();
		}

		public void paintComponent(Graphics g)
	{
		super.paintComponent(g); //This clears the screen and allows to draw on a blank screen.
		Graphics2D g2D = (Graphics2D)g; //We are converting from the old graphics (g) class to the new one (g2D) by casting. Will allow for better graphics.
		
		if (turn % 2 == 0)
		{
			g2D.setColor(Color.RED); //whatever we draw with graphics will appear red.
		}
		else
		{
			g2D.setColor(Color.YELLOW); //whatever we draw with graphics will appear yellow.
		}
		
		g2D.fillOval(playerX, playerY, diameter, diameter); //Fill the circular area with whatever graphics color, at coordinates x and y of size diameter. 
		
		g2D.setColor(Color.BLUE); //now drawing background of the screen.
		g2D.fillRect(0,  100,  720, 700);
		
		//now redrawing the circle objects.
		for (int row = 0; row < numRows; row++) //need a loop for each object
		{
			for (int column = 0; column < numColumns; column++) //need a loop for each object
			{
				g2D.setPaint(new Color(circles[row][column].getRedColor(), circles[row][column].getGreenColor(), circles[row][column].getBlueColor())); //gets the individual color of each circle object.
				g2D.fillOval(circles[row][column].getxPosition(), circles[row][column].getyPosition(), circles[row][column].getDiameter(), circles[row][column].getDiameter()); //fills each object accordingly.
			}
		}
	}

	private void setCircles() 
	{
		circles = new Circles4[numRows][numColumns];
		int x = 0;
		int y = 0;
		
		for (int rows=0; rows<numRows; rows++)
	
			for (int columns=0; columns<numColumns; columns++)
			{
				y = 600 - (rows * 100);
				x = columns * 100 + 10;
				circles[rows][columns] = new Circles4(x, y);
				circles[rows][columns].setRedColor(0);
				circles[rows][columns].setGreenColor(0);
				circles[rows][columns].setBlueColor(0);
						
			}
	}	
}


