package gameSG;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SnakePanel extends JPanel implements ActionListener//Snake panel has all the properties of JPanel -- it is a JPanel, essentially (can do everything a JPanel does)
{
	//Instance Variables -- Scope is the entire class. We make the variables private so that they can only be used in this class. 
	private final int SCREEN_WIDTH = 600;
	private final int SCREEN_HEIGHT = 600;
	private final int UNIT_SIZE = 25;
	private final int GAME_UNITS = (SCREEN_WIDTH/UNIT_SIZE) * (SCREEN_HEIGHT/UNIT_SIZE);
	private int[] x = new int[GAME_UNITS]; //this array will store the horizontal length of the snake. we are using array because it is faster than array list. Because arrays cannot change size, we must set the size first. We set the size to game units, since the snake cannot be bigger than the board.
	private int[] y = new int[GAME_UNITS]; //this array will store the vertical length of the snake.
	private int bodyParts = 3;
	private int fruitX, fruitY;
	private int fruitEaten = 0;
	private char direction = 'R'; //This is the initial direction the snake will go. only x-values will change during this direction.
	private boolean running = false; //boolean that will tell us if the program is running. 
	private String fileName = "C:/Users/anish/Documents/VS Code -- Documents/Java/08 Snake Game/src/filesSG/highScore.txt";
	public String getFileName() {
		return fileName;
	}

	private int delay = 175; //This will become 0.175 of a second. It will update the screen every 0.175 of a second.
	private Timer timer;
	private Random rand = new Random();
	private int highScore = 0;
	public int getHighScore() {
		return highScore;
	}

	private String name;
	
	
	public String getName() {
		return name;
	}

	public SnakePanel() //This is a constructor. Constructors help instantiate your object. You need a constructor no matter what, but you do not have to manually write your constructor because java will do it automatically for you.
	{
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT)); //setting the size of the panel.
		this.setBackground(Color.BLACK); //change background color
		this.setFocusable(true); //Makes the panel the focus of the program, so that the code knows that the commands refer to that panel and its actions.
		this.addKeyListener(new MyKeyAdapter()); //adding the key listener to the program -- it uses the sub-class we created below.
		startGame();
		
	}

	//Methods

	private void startGame() 
	{
		difficulty();
		newFruit();
		running = true;
		timer = new Timer(delay, this); //This means that timer waits 175 milliseconds (delay), then it runs action listener (this). Every 175 milliseconds, this repeats. //The whole game runs on this one timer -- every 175 milliseconds, everything on the game runs.
		timer.start();
	}
	

	private void difficulty() 
	{
		String[] options = {"Easy", "Medium", "Hard"};
		String choice = (String)JOptionPane.showInputDialog(null, 
				"What difficulty would you like?", "Difficulty Settings", JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
		if (choice == "Hard")
		{
			delay = 50;
		}
		else if (choice == "Medium")
		{
			delay = 100;
		}
		else
		{
			delay = 175;
		}
		
	}

	public void paintComponent (Graphics g) //this has to be public because it is a special method (runs in different class). 
	{
		super.paintComponent(g); //This line erases the screen and sets it up to be drawn upon. 
		draw(g); //Think of g as your screen that will be drawn upon. It is the same g used throughout the program. g will be drawn upon.
		
	}
	
	public void draw (Graphics g) //this has to be public because it is a special method (runs in different class). g is an object of graphics class, so it can use all the properties of the graphics class. 
	{
		g.setColor(Color.ORANGE); //This will make everything drawing blue.
		g.setFont(new Font("Ink Free", Font.BOLD, 35)); //Creating a font.
		g.drawString("Score: " + fruitEaten, (SCREEN_WIDTH/2 - 45) - (g.getFont().getSize()/2), 45); //This is drawing "Score: " + fruitEaten (variable) to the screen, and then centering it along the x-axis (middle of horizontal), and then putting it 5 pixels down. 
		
		if (running)
		{
			g.setColor(Color.RED); //This is will make everything drawing red now. Allows for more flexibility.
			g.fillOval(fruitX, fruitY, UNIT_SIZE, UNIT_SIZE); //fruit x and fruit y are the x and y locations of the initial apple that will be printed. It will be an oval that has a horizontal diameter of unit size and a vertical diameter of unit size (circle basically). the fill method will color in the circle to make it look like an apple.
			
			for (int i=0; i<bodyParts; i++) //start at zero, and go until body parts (which has a value of 3). we are creating the first part of our snake (as soon as game starts). 
			{
				if (i==0) //if we are at 0, that means this is only the head of the snake.
				{
					g.setColor(Color.WHITE); //make the color of the snake head white.
				}
				else  //if we are not at 0, we are not at the head of the snake. this sets the color of the snake body
				{
					g.setColor(new Color (rand.nextInt(256), rand.nextInt(256), rand.nextInt(256))); //we are going to make the new body parts random colors. 
				}
				g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE); //we now make the snake. it will be a rectangle with unit size. we are using our x and y arrays that we created in the beginning to assign the snake body parts to the x,y coordinates.
				 
			}
		}
		else //When game is not running.
		{
			gameOver(g); //Our game over method will use graphics to display a text that says "Game Over." That is why we need g. 
		}	
	}
	
	private void move()
	{
		for (int i = bodyParts; i > 0; i--) //We are creating a for loop that goes backward. This is because when the snake moves, we are going to set the body parts to a new position based on the movement (right, left, above, down)
		{
			x[i] = x[i-1];
			y[i] = y[i-1];
		}
		
		switch(direction) //Switch statement
		{
		case 'U': //When direction is up
			y[0] -= UNIT_SIZE; //make the head of the snake go up by unit size. 
			break;
		case 'D': //When direct is down
			y[0] += UNIT_SIZE; //make the head of the snake go down by unit size. 
			break;
		case 'R': //When is direction is right
			x[0] += UNIT_SIZE; //make the head of the snake go to the right by unit size. 
			break; 
		case 'L':
			x[0] -= UNIT_SIZE; //make the head of the snake go to the left by unit size. 
			break; 
		}
	}
	
	private void newFruit()
	{
		fruitX = rand.nextInt(SCREEN_WIDTH/UNIT_SIZE) * UNIT_SIZE; //The reason we divide screen width by unit size is so that the coordinates of the pixels are multiples of the unit size, thus making sure the snake hits the fruit dead center. We re-multiply to scale the chosen coordinates along with the unit size.
		fruitY = rand.nextInt(SCREEN_HEIGHT/UNIT_SIZE) * UNIT_SIZE; //Same logic.
		
	}
	
	private void checkCollision()
	{
		for (int i = bodyParts; i > 0; i--) //checking if any of the body parts collide with the head. 
		{
			if (x[0] == x[i] && y[0] == y[i]) //if the coordinates of the head and the coordinates of a body part are equal (collision)
			{
				running = false; //end game.
			}
		}
			
			if (x[0] > SCREEN_WIDTH || x[0] < 0) //if the x values of the head go off the screen (right or left).
			{
				running = false; //end game. 
			}
			
			if (y[0] > SCREEN_HEIGHT || y[0] < 0) //if the y values of the head go off the screen (up or down).
			{
				running = false; //end game. 
			}
			
			if (x[0] == fruitX && y[0] == fruitY) //if the head collides with a fruit (eats apple)
			{
				bodyParts++; //increase body parts
				fruitEaten++; //increase fruit eaten
				newFruit(); //call method again to print new fruit
			}
			if (!running) //if not running
			{
				timer.stop(); //stop the timer
			}
	}
	
	private void gameOver(Graphics g)
	{
		int restart = JOptionPane.showConfirmDialog(null, "Game Over! Would you like to Play Again?", "Game Over", JOptionPane.YES_NO_OPTION); //Hover your mouse over the showConfirmDialog to see the syntax of this piece of code. 
		if (restart == 0)
		{
			fruitEaten = 0;
			bodyParts = 3;
			direction = 'R';
			x[0] = 0;
			y[0] = 0;
			startGame();
		}
		else 
		{
			System.exit(0);  
		}
	}
	
	public void actionPerformed(ActionEvent e) //This is a part of another class, so the method must be public.
	{
		if (running)
		{
			move();
			checkCollision();
			repaint(); //Never call the paintComponenet directly, always call repaint. This is java convention.
		}
		
		
	}
	
	public class MyKeyAdapter extends KeyAdapter //sub-class that extends KeyAdapter. An API is an "advanced programming interface" that you can download and add to your program.
	{
		@Override //Good programming practice to do this.
		
		public void keyPressed(KeyEvent e) //Creating the keyPressed method for when the user presses keys -- we only care about the up, down, left, and right keys.
		{
			switch (e.getKeyCode()) //Making a switch statement 
			{
			case KeyEvent.VK_UP: //If key pressed is up
				if (direction!='D') //As long as direction is not down. 
				{
					direction = 'U'; //Change direction 
				}
				break;
			case KeyEvent.VK_DOWN: //SAME LOGIC FOR NEXT 3. 
				if (direction!='U')
				{
					direction = 'D';
				}
				break;
			case KeyEvent.VK_RIGHT:
				if (direction!='L')
				{
					direction = 'R';
				}
				break;
			case KeyEvent.VK_LEFT:
				if (direction!='R')
				{
					direction = 'L';
				}
				break;
			}
		}
	}

}
