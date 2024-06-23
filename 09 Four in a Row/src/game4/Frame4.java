package game4;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Frame4 extends JFrame 
{

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Frame4 frame = new Frame4();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	
	public Frame4() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(300, 0); //Eclipse is a context sensitive IDE (recommends commands for you)
		this.setTitle("Connect 4");
		this.setResizable(false);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:/Users/anish/Documents/VS Code -- Documents/Java/09 Four in a Row/src/images4/KalraIcon.PNG"));
		this.setContentPane(new Panel4());
		this.pack(); //This should always go last because pack tells the frame to take the size of the panel. 
	}

}
