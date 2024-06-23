package program;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Toolkit;


public class MoveFrame extends JFrame
{

    private MovePanel panel;

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    MoveFrame frame = new MoveFrame();
                    frame.setVisible(true);
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }

    public MoveFrame()
    {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:/Users/anish/Documents/VS Code -- Documents/Java/14 Jumping Bunny/src/images/KalraIcon.PNG"));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(200, 0);
        this.setResizable(false);
        this.setLayout(null);
        this.setTitle("Drag and Drop");
        panel = new MovePanel();
        setContentPane(panel);
        pack();
    }

}
