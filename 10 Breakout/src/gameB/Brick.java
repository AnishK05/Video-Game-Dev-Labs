package gameB;
import java.awt.image.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;

public class Brick
{
	public int xPos, yPos;
	public BufferedImage bricks;
	public boolean visible = true;
	private Random rand = new Random();
	
	Brick(int row, int col)
	{
		createBrick(row, col);
	}
	private void createBrick(int y, int x)
	{
		
		try
		{
			int i = rand.nextInt(9);
			bricks = ImageIO.read(new File("C:/Users/anish/Documents/VS Code -- Documents/Java/10 Breakout/src/filesB/b" + i + ".png"));
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		xPos = x * bricks.getWidth();
		yPos = y * bricks.getHeight();
	}
	
	public void draw(Graphics g)
	{
		if(visible)
		{
			Graphics2D g2d = (Graphics2D) g;
			g2d.drawImage(bricks, xPos, yPos, null);
		}
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle(xPos, yPos, bricks.getWidth(), bricks.getHeight());
	}
}

