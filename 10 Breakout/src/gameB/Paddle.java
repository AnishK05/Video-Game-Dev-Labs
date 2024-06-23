package gameB;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Paddle 
{

	public int xPos, yPos;
	private int xSpeed = 10;
	private int velocity = 0;
	int id;
	private Random random = new Random();
	private BufferedImage paddle;
	
	public Paddle()
	{
		loadImage();
	}

	private void loadImage() 
	{
		try 
		{
			paddle = ImageIO.read(new File("C:/Users/anish/Documents/VS Code -- Documents/Java/10 Breakout/src/filesB/paddle.png"));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		xPos = random.nextInt(PanelB.WIDTH - paddle.getWidth());
		yPos = PanelB.HEIGHT - paddle.getHeight();
	}
		
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			setXDirection(-xSpeed);
			move();
		}
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			setXDirection(xSpeed);
			move();
		}
	}
	
	public void keyReleased(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            setXDirection(0);
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            setXDirection(0);
        }
	}
	
	public void move()
    {
        xPos += velocity;
        
        if (xPos < 0)
        {
        	xPos = 0;
        }
        else if (xPos > PanelB.WIDTH - paddle.getWidth())
        {
        	xPos = PanelB.WIDTH - paddle.getWidth();
        }
    }
	
	public void setXDirection(int xDirection)
    {
        velocity = xDirection;
    }
	
	public void draw(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(paddle, xPos, yPos, null);
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle(xPos, yPos, paddle.getWidth(), paddle.getHeight());
	}
}