package gameB;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class FrameB extends JFrame 
{
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					FrameB frame = new FrameB();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	public FrameB() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(300, 0);
		this.setTitle("Brick Breaker!");
		this.setResizable(false);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:/Users/anish/Documents/VS Code -- Documents/Java/10 Breakout/src/filesB/KalraIcon.PNG"));
		this.setContentPane(new PanelB());
		this.pack(); // Always needs to be last, so takes size of the panel
	}

}