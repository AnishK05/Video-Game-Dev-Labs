package game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;

public class MeteorFrame extends JFrame 
{
	static int panel = 0;
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run()
			{
				try 
				{
					MeteorFrame frame = new MeteorFrame();
					frame.setVisible(true);
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	public MeteorFrame()
	{
		setTitle("Meteors Game");
		
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:/Users/anish/Documents/VS Code -- Documents/Java/13Meteors/src/images/KalraIcon.PNG"));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(300,0);
		setResizable(false);
	
		setContentPane(new MeteorPanel());
		pack();
	}

}