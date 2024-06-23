package game;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class BunnyPanel extends JPanel implements Runnable
{
    static final int WIDTH = 700;
    static final int HEIGHT = 800;
    static final Dimension SIZE = new Dimension(WIDTH, HEIGHT);
    
    BunnyAmy bunny;
    static final int bunnyHeight = 150;
    static final int bunnyWidth = 100;
    BunnyClouds[] clouds;
    private int numClouds = 5;
    BunnyRocks[] rocks;
    private int numRocks = 7;
    
    Thread gameThread;
    Image image;
    Graphics graphics;
    Random rand;

    public BunnyPanel()
    {
        bunny = new BunnyAmy(10, -bunnyHeight);
        addClouds();
        addRocks();
        setFocusable(true);
        
        addKeyListener(new AL());
        setPreferredSize(SIZE);
        
        gameThread = new Thread(this);
        gameThread.start();
    }

    private void addClouds()
    {
        clouds = new BunnyClouds[numClouds];
        for(int i = 0; i < numClouds; i++)
        {
            clouds[i] = new BunnyClouds(i);
        }
        
    }

  private void addRocks()
  {
      rocks = new BunnyRocks[numRocks];
      for(int i = 0; i < numRocks; i++)
      {
          rocks[i] = new BunnyRocks(i);
      }
      
  }
    
    public void paint(Graphics g)
    {
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);
    }
    
    public void draw(Graphics g)
    {
        for(int i = 0; i < numClouds; i++)
        {
            clouds[i].draw(g);
        }
        for(int i = 0; i < numRocks; i++)
        {
            rocks[i].draw(g);
        }
        bunny.draw(g);
    }
    
    public void move()
    {
        for(int i = 0; i < numClouds; i++)
        {
            clouds[i].move();
        }
        for(int i = 0; i < numRocks; i++)
        {
            rocks[i].move();
        }
        bunny.move();
    }
    
    public void checkCollision()
    {
        bunny.setRock(null);
        for(int i = 0; i < numRocks; i++)
        {
            if(bunny.getYPos() + 150 < rocks[i].getYPos()+5 &&
                bunny.getYPos() + 150 > rocks[i].getYPos()-5 &&
                bunny.getXPos() > rocks[i].getXPos()-25 &&
                bunny.getXPos() < rocks[i].getXPos() + 100)
            {
                bunny.setRock(rocks[i]);
            }
        }
        
    }
    
    public void run()
    {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        while (true)
        {
            long now = System.nanoTime();
            delta += (now - lastTime)/ns;
            lastTime = now;
            if(delta >= 1)
            {
                move();
                checkCollision();
                repaint();
                delta--;
            }
        }
    }
    
    public class AL extends KeyAdapter
    {
        public void keyPressed(KeyEvent e)
        {
            bunny.keyPressed(e);
        }
        
        public void keyReleased(KeyEvent e)
        {
            bunny.keyReleased(e);
        }
    }
}
