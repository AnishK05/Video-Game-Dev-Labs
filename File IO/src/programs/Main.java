package programs;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main extends JFrame {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("File I/O");
		this.setLocation(200, 100);
		this.setResizable(false);
		ImageIcon icon = new ImageIcon("C:/Users/anish/Documents/VS Code -- Documents/Java/14 Jumping Bunny/src/images/KalraIcon.PNG");
		setIconImage(icon.getImage());
		this.setContentPane(new FilePanel());
		this.pack();
	}

}
