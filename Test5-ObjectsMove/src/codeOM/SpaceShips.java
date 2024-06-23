package codeOM;

import java.util.Random;

import javax.swing.ImageIcon;

public class SpaceShips
{
	Random rand = new Random();
	int xVelocity;
	int yVelocity;
	int velocity = rand.nextInt(3) + 2;
	int x = rand.nextInt(250) + 100;
	int y = rand.nextInt(250) + 100;
	public int shipNum = 0;
	public ImageIcon shipIcon;

	SpaceShips (int shipNum)
	{
		shipIcon = new ImageIcon("C:/Users/anish/Documents/VS Code -- Documents/Java/Test5-ObjectsMove/src/filesOM/ship" + shipNum + ".png");
		setYDirection(velocity);
		setXDirection(velocity);
	}

	public void setYDirection(int i)
	{
		yVelocity = i;
	}

	public void setXDirection (int i)
	{
		xVelocity = i;
	}

	public void move()
	{
		x += xVelocity;
		y += yVelocity;
	}
}