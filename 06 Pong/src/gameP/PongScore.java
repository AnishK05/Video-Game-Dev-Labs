package gameP;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class PongScore
{
	int GWIDTH;
	int GHEIGHT;
	int score1;
	int score2;
	
	PongScore(int gWidth, int gHeight)
	{
		this.GWIDTH = gWidth;
		this.GHEIGHT = gHeight;
	}
	
	public void draw(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLACK);
		g2.setFont(new Font("Consolas", Font.BOLD, 60));
		g2.setStroke(new BasicStroke(5));
		g2.drawLine(GWIDTH/2, 0, GWIDTH/2, GHEIGHT);
		g2.drawString(String.valueOf(score1/10) + String.valueOf(score1%10), GWIDTH/2-85, 50);
		g2.drawString(String.valueOf(score2/10) + String.valueOf(score2%10), GWIDTH/2+20, 50);
	}
	
}
