package game;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class BunnyFrame extends JFrame
{

    private BunnyPanel contentPane;

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    BunnyFrame frame = new BunnyFrame();
                    frame.setVisible(true);
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }

    public BunnyFrame()
    {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:/Users/anish/Documents/VS Code -- Documents/Java/14 Jumping Bunny/src/images/KalraIcon.PNG"));
        this.setTitle("Jumping Bunny");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(300,100);
        this.setBackground(new Color(142,217,250));
        this.setResizable(false);
        this.contentPane = new BunnyPanel();
        this.setContentPane(contentPane);
        this.pack();
    }

}
