package gameRPS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Toolkit;

public class RPSFrame extends JFrame
{

	private JPanel panel;

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					RPSFrame frame = new RPSFrame();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	public RPSFrame()
	{
		this.setTitle("Rock Paper Scissors Game");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:/Users/anish/Documents/VS Code -- Documents/Java/Test2-RockPaperScissors/src/filesRPS/KalraIcon.PNG"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(200,0);
		this.setResizable(false); //Lets user resize window.
		this.setLayout(null);  //Removes default layout.
		panel = new RPSPanel(); //Creating new object of TTTPanel -- When this line runs, it runs the constructor in TTTPanel.
		setContentPane(panel);
		pack(); //Adjusts Frame size to the Panel size.  
	}

}