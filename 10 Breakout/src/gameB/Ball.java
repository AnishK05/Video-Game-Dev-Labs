package gameB;

import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO;

public class Ball extends Rectangle {
	int xPos, yPos;
	int xSpeed = 2, ySpeed = -2;
	private BufferedImage ball;
	Random rand = new Random();

	Ball() {
		xPos = 300;
		yPos = 600;
		loadImage();
	}

	private void loadImage() {
		try {
			ball = ImageIO.read(new File("C:/Users/anish/Documents/VS Code -- Documents/Java/10 Breakout/src/filesB/redball.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void move() {
		xPos += xSpeed;
		if (xPos < 0) {
			xPos = 0;
			xSpeed *= -1;
		}
		if (xPos > PanelB.WIDTH - ball.getWidth()) {
			xPos = PanelB.WIDTH - ball.getWidth();
			xSpeed *= -1;
		}

		yPos += ySpeed;
		if (yPos < 0) {
			yPos = 0;
			ySpeed *= -1;
		}
	}

	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(ball, xPos, yPos, null);
	}

	public Rectangle getBounds() {
		return new Rectangle(xPos, yPos, ball.getWidth(), ball.getHeight());

	}
}
