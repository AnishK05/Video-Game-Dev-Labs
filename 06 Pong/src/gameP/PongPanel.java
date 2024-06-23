//THIS GAME FOCUSES ON OBJECT ORIENTED PROGRAMMING. LOTS OF CLASSES AND METHODS. 

package gameP;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;
import javax.swing.*;

public class PongPanel extends JPanel implements Runnable //Runnable is a class that we implemented. 
{
	//Keep instance variables at the top -- good programming practice
	private int width = 1000;
    private int height = (int) ((5.0/9.0) * 1000); //Actual dimensions of a ping pong table -- Have to cast value from double to int.  
    private Dimension size = new Dimension(width, height);
    static final int BALLDIAMETER = 20; //static means we can use this variable/element without an object. Final means the value doesn't change (use CAPS).
    static final int PWIDTH = 15; //Paddles Width
    static final int PHEIGHT = 100; // Paddles Height
    
    Thread gameThread; //Need a thread.
    Image image; //Need an image
    
    Graphics graphics; //Java has a class called graphics -- we can use this class to "draw" || There are more advanced graphics class that will be used in future codes.
    Random rand; //Need a random number 
    PongPaddles player1; //Using your PongPaddles class to create player 1.
    PongPaddles player2; //Same thing to create player 2.
    PongBall ball; //Same thing to create the ping pong ball.
    PongScore score; //Same thing to create the score. 
    
	//Keep constructors below instance variables -- good programming practice. 
	public PongPanel() //This is the constructor of any panel. The constructor of any class is the name of that class! A class can have endless constructors, as long as each one is unique (different parameters).
	
	{
		this.setPreferredSize(size);
		setFocusable(true); //This means that whether a component can gain the focus if it is requested to do so. Essentially, helps things move by user decision.
		newPaddles(); //Creating a method called newPaddles -- for the paddles.
		newBall(); //Same thing for the ball. 
		score = new PongScore(width, height);
		addKeyListener(new AL()); //Creating a key listener for the keys. These keys will be used to control the paddles. We are not using action listener because there is no event in which we will press enter. Action listener is only used when we press enter. AL is the name of our sub-class. 
		gameThread = new Thread(this); //Instantiating a new game thread that will move things on the screen. 
		gameThread.start(); //Starts the new thread -- this thread runs from the run() method, which stores our game loop, thus starting our game. 
	}

	//Good programming practice is to create the objects right below the constructor. 
	private void newBall() 
	{
		ball = new PongBall( ((width/2)-(BALLDIAMETER/2)), ((height/2)-(BALLDIAMETER/2)), BALLDIAMETER, BALLDIAMETER ); //INSTANTIATING (Definition: Creating a new object) a new ball, using the ball class we created. 
		//These are specifications for putting the ball at the center. These are the same parameters as those initialized in the PongBall constructor. 
		
	}

	private void newPaddles() 
	{
		player1 = new PongPaddles(3, height/2-PHEIGHT/2, PWIDTH, PHEIGHT, 1); //Creating our object for paddle 1 -- using the parameters assigned with this constructor.
		player2 = new PongPaddles(width-PWIDTH-3, height/2-PHEIGHT/2, PWIDTH, PHEIGHT, 2); //Creating our object for paddle 2 -- using the parameters assigned with this constructor.
		
	}

	//Good programming practice is to keep the game methods below the objects. 
	public void paint(Graphics g) //Passing graphics g as a parameter -- this will draw the image and contents on the screen. 
	{
		image = createImage(getWidth(), getHeight()); //This is a special syntax java uses to make an image that is the size of the width and height of the panel. Syntax.
		graphics = image.getGraphics(); //Special method that says that our graphics variable will equal the graphics of the image we created. 
		draw (graphics); //This is the draw method we created to draw the image. 
		g.drawImage(image, 0, 0, this); //This line says that we will draw the image at the coordinates (0, 0) and put it on this panel (this).
		//the two lines above are different because the first one only adjusts and draws the properties of the image, while the second one puts it to the panel. 

		
	}
	
	public void draw (Graphics g)
	{
		//We are using graphics and the draw method (from each object's respective class (PongBall, PongPaddles)) to draw these elements. 
		
		player1.draw(g);
		player2.draw(g);
		ball.draw(g);
		score.draw(g);
		
	}
	
	public void move() 
	{
		//We are using the move method (from each object's respective class (PongBall, PongPaddles)) to move these elements. 
		player1.move();
		player2.move();
		ball.move();
	}
	
	public void checkCollison()
	{
		//Paddle and Wall Collision
		if (player1.y <=0) //If the paddle of player 1 tries to go off the top of the screen
		{
			player1.y = 0; //Sets the paddle height to zero -- does not allow to go off the board
		}
		if (player1.y >= height-PHEIGHT) //Same pattern for all of the if statements with paddles. 
		{
			player1.y = height - PHEIGHT;
		}
		if (player2.y <=0)
		{
			player2.y = 0;
		}
		if (player2.y >= height-PHEIGHT)
		{
			player2.y = height - PHEIGHT;
		}
		
		//Ball and Wall Collision
		if (ball.y<=0 || ball.y>=height-BALLDIAMETER) //If the ball hits the top or bottom
		{
			ball.setyDirection(-ball.yVelocity); //Call the method we created in the PongBall class and set the speed to the opposite of the yVelocity, because we want the ball to move the opposite upward or downward direction.
		}
		
		//Ball and Paddle Collision
		if (ball.intersects(player1) || ball.intersects(player2)) //Using a special rectangle method that states if two rectangles intersect (collision)
		{
			ball.setxDirection(-ball.xVelocity);
		}
		if (ball.x <= -BALLDIAMETER) //Ball goes off the left side -- player 2 wins.
		{
			score.score2++;
			newBall();
		}
		if (ball.x>=width) //Ball goes off the right side -- player 1 wins.
		{
			score.score1++;
			newBall();
		}
		
	}
	
	//Good programming practice is to keep the game thread above a new class that you create.
	@Override
	public void run() //Anything that runs in this method is part of a new/different thread. The GAME LOOP runs in here!
	{
		long lastTime = System.nanoTime(); //Check how much time has passed in nano-seconds (billionth of a second). 
		double fps = 60; //Set our frames per second to 60 by storing it in a double variable. 
		double ns = 1000000000/fps; //ns represents that 1/60 of a second has passed. This is 16 million nanoseconds. We use this value because this is the amount of time we want to pass before we update our screen. 60 frames per second means that we need 1 frame (update screen) for every 1/60 of a second.  
		double delta = 0; //Change in time.
		while (true) //Make an infinite loop so that the game is always running. 
		{
			long now = System.nanoTime(); //Check how much time has passed now. 
			delta += (now - lastTime) / ns; //Check if the change in time has passed 16 million seconds. If so, delta should be one or higher and we need to update the screen. 
			lastTime = now; //Change the time passed now to the lastTime (basically original time), so that the time of our game is continuing. We do not want our time to keep resetting. Essentially, the now time becomes the old time (lastTime), and when the game continues, that time is stored in the now time. This pattern repeats. 
			if (delta >= 1) //if the change in time has passed 1/60 of a second -- update the screen. 
			{
				move(); //move the item.
				checkCollison(); //check if there has been a collision.
				repaint(); //repaint the contents (update the screen). Never call your paint method by paint. Always call it by repaint. That is how java works. Also, even though you created a parameter for paint, java knows that you are using graphics, so you do not have to pass an argument (just how java works).
				delta--; //Only subtract one from delta because we want time to carry over. For example, if the time is 16 million plus 37 nanoseconds, then those 37 nanoseconds contribute to the next time event. If we do not account for these 37 nanoseconds, then we are no longer updating every 16 million nanoseconds and our program is lagging. 
			}
		}
	}
	
	//Good programming practice is to place new classes at the bottom. 
	public class AL extends KeyAdapter //Creating a sub-class because we can only extend one class in java. Our sub-class AL extends the KeyAdapter
	{
		public void keyPressed(KeyEvent e) //Method when key is pressed. 
		{
			player1.keyPressed(e); //Calling our keyPressed method (from PongPaddles class) on the objects we created. 
			player2.keyPressed(e); //Calling our keyPressed method (from PongPaddles class) on the objects we created. 
		}
		public void keyReleased(KeyEvent e) //Method when key is released. 
		{
			player1.keyReleased(e); //Calling our keyReleased method (from PongPaddles class) on the objects we created. 
			player2.keyReleased(e); //Calling our keyReleased method (from PongPaddles class) on the objects we created. 
		}
	}
}
