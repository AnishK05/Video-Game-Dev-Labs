package gameP;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class PongFrame extends JFrame 
{

	private PongPanel panel;

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					PongFrame frame = new PongFrame();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	public PongFrame() 
	{
		this.setTitle("Pong Game");
		ImageIcon icon = new ImageIcon ("C:/Users/anish/Documents/VS Code -- Documents/Java/06 Pong/src/imagesP/KalraIcon.png");
		setIconImage(icon.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(100,0);
		this.setResizable(false); 
		this.setLayout(null);  
		panel = new PongPanel();
		setContentPane(panel);
		pack();
	}

}
