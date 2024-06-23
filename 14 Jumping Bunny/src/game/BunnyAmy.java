package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BunnyAmy
{
    private int xPos, yPos;
    private int xVelocity = 0;
    private int yVelocity = 3;
    private int xSpeed = 10;
    private int ySpeed = 10;
    private int numBunnies = 7;
    private BufferedImage[] bunny;
    private int display = 0;
    private long lastUpdate = 0;
    private char direction;
    private BunnyRocks rock;

    BunnyAmy(int x, int y)
    {
        loadImage();
        this.xPos = x;
        this.yPos = y;
    }
    
    public int getXPos()
    {
        return xPos;
    }

    public int getYPos()
    {
        return yPos;
    }
    
    public void setRock(BunnyRocks rock)
    {
        this.rock = rock;
    }
    
    private void loadImage()
    {
        bunny = new BufferedImage[numBunnies];
        try {
            for(int i = 0; i < numBunnies; i++)
            {
                bunny[i] = ImageIO.read(new File("C:/Users/anish/Documents/VS Code -- Documents/Java/14 Jumping Bunny/src/images/bunny" + i + ".png"));
            }
            
         } catch (IOException ex) {
              System.out.println("File not found.");
         }
    }

    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            direction = 'L';
            setXDirection(-xSpeed);
            move();
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            direction = 'R';
            setXDirection(xSpeed);
            move();
        }
        if(e.getKeyCode() == KeyEvent.VK_UP)
        {
            direction = 'U';
            setYDirection(-ySpeed);
            move();
        }
    }
    
    public void keyReleased(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            direction = 'S';
            setXDirection(0);
            display = 0;
            move();
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            direction = 'S';
            setXDirection(0);
            display = 0;
            move();
        }
        if(e.getKeyCode() == KeyEvent.VK_UP)
        {
            direction = 'S';
            setYDirection(3);
            move();
        }
    }
    
    public void setXDirection(int xDirection)
    {
        xVelocity = xDirection;
    }
    
    public void setYDirection(int yDirection)
    {
        yVelocity = yDirection;
    }
    
    public void move()
    {
        long now = System.currentTimeMillis();
        
        if(direction == 'R')
        {
            if (now - lastUpdate > 100)
            {
                lastUpdate = now;
                if(display != 2)
                    display = 2;
                else
                    display = 3;
            }
            xPos += xVelocity;
            if(xPos > BunnyPanel.WIDTH - BunnyPanel.bunnyWidth)
                xPos = BunnyPanel.WIDTH - BunnyPanel.bunnyWidth;
        }
        
        if(direction == 'L')
        {
            if (now - lastUpdate > 100)
            {
                lastUpdate = now;
                if(display != 4)
                    display = 4;
                else
                    display = 5;
            }
            xPos += xVelocity;
            if(xPos < 0)
                xPos = 0;

        }
        
        if(rock != null)
        {
            yPos = rock.getYPos()-150;
        }
        else
        {
            yPos += yVelocity;
        }
        
        if(direction == 'U')
        {
            yPos += yVelocity;
        }
        
        if(yPos > BunnyPanel.HEIGHT)
            gameOver();

    }
    
    private void gameOver()
    {
        System.out.println("game over");
        System.exit(0);
    }

    public void draw(Graphics g)
    {
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(bunny[display], xPos, yPos, null);
    }
    
}
