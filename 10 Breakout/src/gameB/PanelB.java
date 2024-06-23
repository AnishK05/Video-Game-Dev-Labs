package gameB;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class PanelB extends JPanel implements Runnable {
	static int WIDTH = 700;
	static final int HEIGHT = 650;
	private final int numRows = 7, numCols = 7;
	private Image image;
	private Thread thread;
	// private Thread music;
	private Graphics graphics;
	private Brick[][] bricks;
	private Paddle paddle;
	private Ball ball, ball2;
	private int specialCol, specialRow;
	private Boolean brickHit = false;
	private Random rand = new Random();
	private int counter = 0;
	public int getCounter() {
		return counter;
	}

	private final Dimension SIZE = new Dimension(WIDTH, HEIGHT);

	public PanelB() {
		gameSetup();
		this.setPreferredSize(SIZE);
		addKeyListener(new MyKey());
		this.setFocusable(true);
		Music music = new Music();
		music.start();
		this.thread = new Thread(this);
		specialBrick();
		thread.start();
	}

	private void specialBrick() {
		specialCol = rand.nextInt(8);
		specialRow = rand.nextInt(8);
		System.out.println("Column: " + (specialCol+1) + " Row: " + (specialRow+1));
		try {
			bricks[specialRow][specialCol].bricks = ImageIO.read(new File("C:/Users/anish/Documents/VS Code -- Documents/Java/10 Breakout/src/filesB/b9.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void gameSetup() {
		paddle = new Paddle();
		ball = new Ball();

		bricks = new Brick[numRows][numCols];
		for (int rows = 0; rows < numRows; rows++) {
			for (int cols = 0; cols < numCols; cols++) {
				bricks[rows][cols] = new Brick(rows, cols);
			}
		}
	}

	public void move() {
		paddle.move();
		ball.move();
		if (brickHit) {
			ball2.move();
		}
	}

	private void checkCollision() {
		Rectangle ballRect = ball.getBounds();
		Rectangle pRect = paddle.getBounds();
		if (brickHit) {
			Rectangle ballRect2 = ball2.getBounds();

			if (ballRect2.y + ballRect2.height >= pRect.y && ballRect2.getCenterX() > pRect.x
					&& ballRect2.getCenterX() < pRect.x + pRect.width) {
				ball2.ySpeed *= -1;
			}

			for (int row = 0; row < numRows; row++) {
				for (int col = 0; col < numCols; col++) {
					if (bricks[row][col].visible) {
						Rectangle brickRect = bricks[row][col].getBounds();
						if (ballRect2.intersects(brickRect)) {
							ball2.ySpeed *= -1;
							bricks[row][col].visible = false;
							counter++;
						}
					}
				}
			}
		}

		if (ballRect.y + ballRect.height >= pRect.y && ballRect.getCenterX() > pRect.x
				&& ballRect.getCenterX() < pRect.x + pRect.width) {
			ball.ySpeed *= -1;
		}


		for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < numCols; col++) {
				if (bricks[row][col].visible) {
					Rectangle brickRect = bricks[row][col].getBounds();
					if (ballRect.intersects(brickRect)) {
						if (row == specialRow && col == specialCol) {
							ball2 = new Ball();
							brickHit = true;
						}
						ball.ySpeed *= -1;

						bricks[row][col].visible = false;
						
						ball.ySpeed +=0.5;
					}
				}
			}
		}
		
		
		if (ball.yPos > HEIGHT - ball.getHeight()) {
			int restart = JOptionPane.showConfirmDialog(null, "Respawn the ball and try again?", "Game Over",
					JOptionPane.YES_NO_OPTION);
			if (restart == 0) {
				restartGame();
			} else {
				System.exit(0);
			}
		}
	}

	public void paint(Graphics g) {
		image = createImage(getWidth(), getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image, 0, 0, this);
	}

	private void draw(Graphics g) {
		for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < numCols; col++) {
				bricks[row][col].draw(g);
			}
		}
		ball.draw(g);
		paddle.draw(g);
		if (brickHit) {
			ball2.draw(g);
		}
	}

	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double fps = 90;
		double ns = 1000000000 / fps;
		double delta = 0;
		while (true) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if (delta >= 1) {
				move();
				checkCollision();
				repaint();
				checkWin();
				delta--;
			}
		}
	}

	private void checkWin() {
		Boolean win = true;
		for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < numCols; col++) {
				if (bricks[row][col].visible) {
					win = false;
				}
			}
		}

		if (win) {
			int restart = JOptionPane.showConfirmDialog(null, "Respawn the ball and try again?", "You Won!",
					JOptionPane.YES_NO_OPTION);
			if (restart == 0) {
				restartGame();
			} else {
				System.exit(0);
			}
		}

	}

	public class MyKey extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			paddle.keyPressed(e);
		}

		public void keyReleased(KeyEvent e) {
			paddle.keyReleased(e);
		}
	}

	public void restartGame() {
		ball.xSpeed = 2;
		ball.ySpeed = -2;
		ball.xPos = 300;
		ball.yPos = 600;
		counter = 0;
		paddle.xPos = HEIGHT / 2;
		for (int rows = 0; rows < numRows; rows++) {
			for (int cols = 0; cols < numCols; cols++) {
				bricks[rows][cols].visible = true;
			}
		}
		repaint();
	}

}