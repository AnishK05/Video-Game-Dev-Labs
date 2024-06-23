package codeOM;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class OMFrame extends JFrame
{

	private JPanel panel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OMFrame frame = new OMFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public OMFrame()
	{
		this.setTitle("Spaceships Move!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 650);
		this.setLocation(200,0);
		this.setResizable(false);
		this.setLayout(null);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:/Users/anish/Documents/VS Code -- Documents/Java/Test5-ObjectsMove/src/filesOM/KalraIcon.PNG"));
		panel = new OMPanel();
		setContentPane(panel);
	}

}