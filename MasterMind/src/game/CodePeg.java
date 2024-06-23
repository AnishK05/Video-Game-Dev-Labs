package game;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CodePeg extends JLabel {
	String pegColor;
	ImageIcon colorIcon;

	CodePeg(String color) {
		colorIcon = new ImageIcon("C:/Users/anish/Documents/VS Code -- Documents/Java/MasterMind/src/images/" + color + ".png");
		pegColor = color;
		setIcon(colorIcon);
	}

	public void setColor(String color) {
		colorIcon = new ImageIcon("C:/Users/anish/Documents/VS Code -- Documents/Java/MasterMind/src/images/" + color + ".png");
		pegColor = color;
		setIcon(colorIcon);
	}
}
