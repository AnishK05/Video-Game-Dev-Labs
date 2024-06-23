package table;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class MultiplicationTableFrame extends JFrame 
{
	private MultiPanel panel;
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater (new Runnable()
		{
			public void run()
			{
				try
				{
					MultiplicationTableFrame frame = new MultiplicationTableFrame();
					frame.setVisible(true);
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	public MultiplicationTableFrame()
	{
		this.setTitle("Multiplication Table");
		ImageIcon icon = new ImageIcon ("C:/Users/anish/Documents/VS Code -- Documents/Java/04 Multiplication Table/src/filesMT/KalraIcon.png");
		setIconImage(icon.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(200,0);
		this.setResizable(true); //Lets user resize window. 
		this.setLayout(null);  //Removes default layout.
		panel = new MultiPanel(); //Creating new object of TTTPanel -- When this line runs, it runs the constructor in TTTPanel.
		setContentPane(panel);
		pack(); //Adjusts Frame size to the Panel size.  
	}
}