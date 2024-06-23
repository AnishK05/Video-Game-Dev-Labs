package gameH;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class HangmanFrame extends JFrame 
{

	private JPanel panel; //rename JPanel for personal preference.

	//Launch the Frame
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HangmanFrame frame = new HangmanFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Set Properties of the Frame
	
	public HangmanFrame() 
	{
		this.setTitle("Hangman");
		ImageIcon icon = new ImageIcon ("C:/Users/anish/Documents/VS Code -- Documents/Java/03 Hangman/src/filesH/KalraIcon.PNG"); 
		setIconImage(icon.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(100,100);
		this.setResizable(false); //Does not want user to resize game window. 
		this.setLayout(null);  //Removes default layout. 
		panel = new HangmanPanel(); //Creating new object of HangmanPanel -- When this line runs, it runs the constructor in HangmanPanel. 
		setContentPane(panel);
		pack(); //Adjusts Frame size to the Panel size.  
	}

}
