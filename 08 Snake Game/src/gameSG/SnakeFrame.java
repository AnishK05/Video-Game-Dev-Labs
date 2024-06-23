package gameSG;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class SnakeFrame extends JFrame 
{
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					SnakeFrame frame = new SnakeFrame();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	public SnakeFrame() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new SnakePanel()); //This is easier to do -- does the same thing as our previous programs in less lines. We are still linking the panel with the frame.
		this.setTitle("Snake Game");
		this.setResizable(false);
		this.setLocation(100,40);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:/Users/anish/Documents/VS Code -- Documents/Java/08 Snake Game/src/filesSG/KalraIcon.png")); //This is another way to change the image icon of the frame.
		this.pack(); //Sets the size of the frame to whatever the panel size is.
		
	}
}
