package gameP;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.*;

public class PongBall extends Rectangle //Java can only detect collisions of objects through rectangles (weakness). Thus all of our shapes (even our ball) are technically rectangles. 
{
	Random rand = new Random(); 
	int xVelocity; //Because the ball is always moving, and must have a direction, we use velocity (magnitude and direction). We need x and y velocity because the ball is moving in both directions at all times! It's like a vector. 
	int yVelocity;
	int speed = 2; //The speed at which our ball is moving. 
	
	
	
	PongBall(int x, int y, int width, int height) //Constructor of PongBall -- Need to pass these parameters. 
	{
		super(x, y, width, height); //super just tells us that we are using the rectangle class. Syntax. It also means that we are creating a rectangle at this coordinate with this width and height. 
		
		int x1 = rand.nextInt(2); //Deciding which way the ball will go at the beginning of each game (Horizontal).
		if (x1 == 0) //Want ball to go the left. 
		{
			setxDirection(-speed); //Negative speed will result in the ball going left. CREATING ANOTHER METHOD.
		}
		else //Want ball to go right. 
		{
			setxDirection(speed); //Positive speed will result in the ball going right. CREATING ANOTHER METHOD.
		}
		
		int y1 = rand.nextInt(2); //Deciding which way the ball will go at the beginning of each game (Vertical). 
		if(y1 == 0) //Want ball to go up. 
		{
			setyDirection(-speed); //Negative speed will result in the ball going up. CREATING ANOTHER METHOD.
		}
		else //Want ball to go down. 
		{
			setyDirection(speed); //Positive speed will result in the ball going down. CREATING ANOTHER METHOD.
		}
	}


	public void setyDirection(int i) 
	{
		yVelocity = i; //Setting the yVelocity with direction (by adding a negative or positive sign)
		
	}


	public void setxDirection(int i) 
	{
		xVelocity = i; //Setting the xVelocity with direction (by adding a negative or positive sign)
	}
	
	
	public void move() //This method is to change the location of the ball (rectangle)
	{
		x+= xVelocity; //Changing the coordinates of the ball (rectangle)
		y+= yVelocity;
	}
	
	public void draw(Graphics g) //Method to draw the ball to the screen. Have to use graphics class as a parameter. 
	{
		g.setColor(Color.RED); //Making the ball red. 
		g.fillOval(x, y, width, height); //Making the ball an oval inside of the rectangle class. Because the width and height are the same, the ball is technically a circle. We use fill so that our ball can be red. The parameters are instance variables from the rectangle class. 
	}
}
