package gameTTT;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class TTTFrame extends JFrame 
{

	private TTTPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					TTTFrame frame = new TTTFrame();
					frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TTTFrame() 
	{
		this.setTitle("Tic-Tac-Toe");
		ImageIcon icon = new ImageIcon ("C:/Users/anish/Documents/VS Code -- Documents/Java/02 Tic-Tac-Toe/src/imagesTTT/KalraIcon.png"); 
		setIconImage(icon.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(100,100);
		this.setResizable(false); //Does not want user to resize game window. 
		this.setLayout(null);  //Removes default layout. 
		panel = new TTTPanel(); //Creating new object of TTTPanel -- When this line runs, it runs the constructor in TTTPanel. 
		setContentPane(panel);
		pack(); //Adjusts Frame size to the Panel size.  
	}
}

