package game;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Meteors {
	
	public int x, y, xVelocity,  yVelocity;
	public int width, height, rotate;
	private Random rand;
	public BufferedImage asteroid;

	public Meteors(int numImage, int width, int height) {
		loadImage(numImage);
		rand = new Random();
		x = rand.nextInt(width);
		if(rand.nextBoolean()){ xVelocity = rand.nextInt(3) + 1; } else { xVelocity = -(rand.nextInt(3) + 1); }
		y = -(rand.nextInt(asteroid.getHeight()));
		yVelocity = rand.nextInt(3) + 1;
		rotate = 2;	
	}

	private void loadImage(int numImage) {
		try {
			asteroid = ImageIO.read(new File("C:/Users/anish/Documents/VS Code -- Documents/Java/13Meteors/src/images/asteroid" + numImage + ".png"));
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void move() {
		x+= xVelocity;
		y+= yVelocity;
		rotate += 2;
	}
	
	public void draw(Graphics2D g2d) {
		AffineTransform at = AffineTransform.getTranslateInstance(x, y);
		at.rotate(Math.toRadians(rotate), asteroid.getWidth()/2,asteroid.getHeight()/2);
		g2d.drawImage(asteroid, at, null);	
	}
}