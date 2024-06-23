package game;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MineFrame extends JFrame 
{
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					MineFrame frame = new MineFrame();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	public MineFrame() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(500, 200);
		this.setTitle("Minesweeper!");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:/Users/anish/Documents/VS Code -- Documents/Java/11 MineSweeper/src/images/KalraIcon.PNG"));
		this.setResizable(false);
		this.setContentPane(new MinePanel());
		this.pack(); // Always needs to be last, so takes size of the panel
	}

}