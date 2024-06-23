package gameP;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class PongPaddles extends Rectangle //Java can only detect collisions of objects through rectangles (weakness). Thus all of our shapes (even our ball) are technically rectangles. That is why we need the Rectangle class and its methods. 
{
	int id; //Variable is created so that we can tell which player we are working with.
	int yVelocity; //Only need y velocity because panel only moves up or down.
	int speed = 10; //Speed of the panels.

	PongPaddles(int x, int y, int width, int height, int id) //PongPaddles constructor with its respective parameters.
	{
		super (x, y, width, height); //super just tells us that we are using the rectangle class. Syntax. It also means that we are creating a rectangle at this coordinate with this width and height. 
		this.id = id; //Taking the parameter and assigning it to this instance variable.
		
	}
	
	public void keyPressed(KeyEvent e)//Has to be public because another class will use this method. No return so use void. Using the keyPressed method to control the paddles.
	{
		//Left Paddle Keys
		if (e.getKeyCode() == KeyEvent.VK_W && id == 1) //This is the syntax to get the key event for a specific key and the specific player.
		{
			setYDirection(-speed); //Negative speed means that the ball is going up.
		}
		
		if (e.getKeyCode() == KeyEvent.VK_S && id == 1)
		{
			setYDirection(speed); //Speed means that the ball is going down.
		}
		
		//Right Paddle Keys
		if (e.getKeyCode() == KeyEvent.VK_UP && id == 2)
		{
			setYDirection(-speed); //Negative speed means that the ball is going up.
		}
		
		if (e.getKeyCode() == KeyEvent.VK_DOWN && id == 2)
		{
			setYDirection(speed); //Speed means that the ball is going down.
		}
	}
	
	public void keyReleased(KeyEvent e) //Same as keyPressed (opposite functionality).
	{
		if (e.getKeyCode() == KeyEvent.VK_W) //This is the syntax to get the key event for a specific key. 
		{
			setYDirection(0); //Speed is zero -- ball not moving.
		}
		
		if (e.getKeyCode() == KeyEvent.VK_S)
		{
			setYDirection(0); //Speed is zero -- ball not moving.
		}
		
		//Right Paddle Keys
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			setYDirection(0); //Speed is zero -- ball not moving.
		}
		
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			setYDirection(0); //Speed is zero -- ball not moving.
		}
		
	}
	
	private void setYDirection (int i) //Direction of Paddles
	{
		yVelocity = i; //Make the velocity the speed that was passed in. 
	}
	
	public void move() //Moving the Paddles
	{
		y+=yVelocity; //Changing the coordinates of y by making it the yVelocity. 
		
	}
	
	public void draw(Graphics g) //Drawing the Paddles
	{
		if (id == 1) //If it is paddle one -- set paddle to black
		{
			g.setColor(Color.BLACK);	
		}
		else //Otherwise, it will be paddle two -- set paddle to grey
		{
			g.setColor(Color.GRAY);
		}
		
		g.fillRect(x, y, width, height); //Drawing and filling the paddles -- using the rectangle method with the specifications. 
	}
}
