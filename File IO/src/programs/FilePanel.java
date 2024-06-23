package programs;

import java.awt.Dimension;

import javax.swing.JPanel;

public class FilePanel extends JPanel {
	private int WIDTH = 600, HEIGHT = 600;
	private String fileName = "C:/Users/anish/Documents/VS Code -- Documents/Java/14 Jumping Bunny/src/images/mydata.txt";
	FileWrite writing;
	FileRead reading;

	public FilePanel() {
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		writing = new FileWrite(fileName);
		reading = new FileRead(fileName);
		addToFile();
		readFromFile();
	}

	private void readFromFile() {
		reading.readFile();
		for (String output : reading.in) {
			System.out.println(output);
		}

	}

	//setData takes a string in and adds it to an ArrayList.
	private void addToFile() {
		writing.setData("Mike" + "\n");
		writing.setData("Christopher" + "\n");
		writing.setData("Amy" + "\n");
		writing.setData("Bryan" + "\n");
		writing.setData("Gavin" + "\n");
		writing.setData("Liam" + "\n");
		writing.setData("Aven" + "\n");
//		writing.writeAppend(); //This will show the names we added plus the original names. 
		writing.writeOver(); //This will only show the original names.
		} 

}
