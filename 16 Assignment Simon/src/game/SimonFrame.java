package game;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class SimonFrame extends JFrame
{

    private SimonPanel contentPane;


    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    SimonFrame frame = new SimonFrame();
                    frame.setVisible(true);
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }

    public SimonFrame()
    {
        setTitle("Simon");
        ImageIcon icon = new ImageIcon("C:/Users/anish/Documents/VS Code -- Documents/Java/16 Assignment Simon/src/images/KalraIcon.PNG");
        setIconImage(icon.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(300, 50);
        contentPane = new SimonPanel();
        setContentPane(contentPane);
        pack();
        setVisible(true);
    }

}
