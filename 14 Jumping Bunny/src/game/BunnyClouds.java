package game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class BunnyClouds
{
    private BufferedImage image;
    
    private Random rand = new Random();
    private int xPos;
    private int yPos;
    private int xVelocity;
    
    BunnyClouds(int x)
    {
        createCloud(x);
    }
    
    private void createCloud(int id)
    {
        //Load Image
        String name = "C:/Users/anish/Documents/VS Code -- Documents/Java/14 Jumping Bunny/src/images/cloud" + id + ".png";
        try 
        {                
            image = ImageIO.read(new File(name));
         } 
        catch (IOException ex) 
        {
              System.out.println("Unable to locate cloud file: " + ex);
         }
        
        //Set clouds x & y position
        // X is off the screen so the cloud can float across
        // Y is only in the top third
        xPos = (rand.nextInt(100) + image.getWidth()) * -1;
        yPos = rand.nextInt(50);
        
        //Set cloud velocity
        xVelocity = rand.nextInt(3) + 1;
        
    }

    public void move()
    {
        xPos += xVelocity;
        if(xPos > 700)
        {
            xPos = rand.nextInt(100) + image.getWidth() * -1;
            yPos = rand.nextInt(50);
            xVelocity = rand.nextInt(3) + 1;
        }
    }
    
    public void draw(Graphics g)
    {
        g.drawImage(image, xPos, yPos, null);
    }
}
