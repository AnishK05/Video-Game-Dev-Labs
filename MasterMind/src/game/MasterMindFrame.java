package game;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Toolkit;

public class MasterMindFrame extends JFrame {

	private MasterMindPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MasterMindFrame frame = new MasterMindFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MasterMindFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Master Mind");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:/Users/anish/Documents/VS Code -- Documents/Java/MasterMind/src/images/KalraIcon.PNG"));
		setLocation(500, 25);
		contentPane = new MasterMindPanel();
		setContentPane(contentPane);
		pack();
	}

}
