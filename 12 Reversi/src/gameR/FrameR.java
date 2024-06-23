package gameR;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class FrameR extends JFrame {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameR frame = new FrameR();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrameR() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Othello");
		ImageIcon icon = new ImageIcon("C:/Users/anish/Documents/VS Code -- Documents/Java/12 Reversi/src/filesR/KalraIcon.PNG");
		this.setIconImage(icon.getImage());
		this.setLocation(300, 20);
		this.setResizable(false);
		this.setContentPane(new PanelR());
		this.pack();
	}

}
