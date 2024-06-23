package game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class BunnyRocks
{
    private BufferedImage image;
    private Random rand = new Random();
    private int xPos;
    private int yPos;
    private int yVelocity;
    
    BunnyRocks(int id)
    {
        createRocks(id);
    }

    public int getXPos()
    {
        return this.xPos;
    }
    
    public int getYPos()
    {
        return this.yPos;
    }
    
    private void createRocks(int id)
    {
      //Load Image
        String name = "C:/Users/anish/Documents/VS Code -- Documents/Java/14 Jumping Bunny/src/images/rock" + id + ".png";
        try 
        {                
            image = ImageIO.read(new File(name));
         } 
        catch (IOException ex) 
        {
              System.out.println("Unable to locate rock file: " + ex);
         }
        
        xPos = rand.nextInt(BunnyPanel.WIDTH - image.getWidth());
        yPos = rand.nextInt(100) + BunnyPanel.HEIGHT;

        yVelocity = (rand.nextInt(3) + 1) * -1;
    }
    
    public void move()
    {
        yPos += yVelocity;
        if(yPos < 0)
        {
            xPos = rand.nextInt(BunnyPanel.WIDTH - image.getWidth());
            yPos = rand.nextInt(100) + BunnyPanel.HEIGHT;
            yVelocity = (rand.nextInt(3) + 1) * -1;
        }
    }
    
    public void draw(Graphics g)
    {
        g.drawImage(image, xPos, yPos, null);
    }
}
