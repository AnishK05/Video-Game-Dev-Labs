package game4;

public class Circles4 
{
	private int xPosition;
	private int yPosition;
	private int redColor;
	private int greenColor;
	private int blueColor;
	private int diameter = 100;
	
	Circles4(int xPos, int yPos) //Constructor
	{
		this.xPosition = xPos;
		this.yPosition = yPos;
	}


	public int getxPosition() {
		return xPosition;
	}


	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}


	public int getyPosition() {
		return yPosition;
	}

	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	public int getRedColor() {
		return redColor;
	}

	public void setRedColor(int redColor) {
		this.redColor = redColor;
	}

	public int getGreenColor() {
		return greenColor;
	}

	public void setGreenColor(int greenColor) {
		this.greenColor = greenColor;
	}

	public int getBlueColor() {
		return blueColor;
	}

	public void setBlueColor(int blueColor) {
		this.blueColor = blueColor;
	}
	
	public int getDiameter() {
		return diameter;
	}

	
}
