package codeOM;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class OMPanel extends JPanel  implements Runnable
{
	private int width = 600;
	private int height = 600;
	private Dimension SIZE = new Dimension(width, height);
	final static int SHIPLENGTH = 100;

	Thread gameThread;
	Image image;
	Graphics graphics;
	SpaceShips[] ship = new SpaceShips[4];

	public OMPanel()
	{
		this.setPreferredSize(SIZE);
		this.setLayout(null);
		newShips();
		this.setFocusable(true);
		gameThread = new Thread(this);
		gameThread.start();
	}

	private void newShips()
	{
		for (int i=0; i<4; i++)
		{
			ship[i] = new SpaceShips(i);
		}

	}

	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);
		draw(g);
	}

	public void draw (Graphics g)
	{
		for (int i=0; i<4; i++)
		{
			ship[i].shipIcon.paintIcon(this, g, ship[i].x, ship[i].y);
		}
	}

	public void checkCollision()
	{
		for (int i=0; i<4; i++)
		{
			if (ship[i].y <= 0 || ship[i].y >= height - SHIPLENGTH)
			{
				ship[i].setYDirection(-ship[i].yVelocity);
			}
			if (ship[i].x <= 0 || ship[i].x >= height - SHIPLENGTH)
			{
				ship[i].setXDirection(-ship[i].xVelocity);
			}
		}
	}

	public void run()
	{
		long lastTime = System.nanoTime();
		int fps = 60;
		double ns = 1000000000 / fps;
		double delta = 0;
		while (true)
		{
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if (delta >= 1)
			{
				move();
				checkCollision();
				repaint();
				delta--;
			}
		}
	}

	public void move()
	{
		for (int i=0; i<4; i++)
		{
			ship[i].move();
		}
	}

}