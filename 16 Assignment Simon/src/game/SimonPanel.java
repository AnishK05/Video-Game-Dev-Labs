package game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class SimonPanel extends JPanel implements ActionListener, MouseListener
{
    public int width = 600, height = 600, flash, ticks, dark = 0, indexPattern;
    Dimension size = new Dimension(width, height);
    Timer timer;
    int delay = 50;
    public boolean creatingPattern = true;
    public ArrayList<Integer> pattern;
    Random rand = new Random();
    private boolean gameOver;
    
    public SimonPanel()
    {
        setPreferredSize(size);
        setBackground(Color.CYAN);
        setLayout(null);
        addMouseListener(this);
        start();
        timer = new Timer(delay,this);
        timer.start();
    }
    
    public void start()
    {
        pattern = new ArrayList<Integer>();
        indexPattern = 0;
        dark = 2;
        flash = 0;
        ticks = 0;
    }
    
    public void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);
        
        if(flash == 1)
        {
            g2d.setColor(Color.YELLOW);
        }
        else
        {
            g2d.setColor(Color.YELLOW.darker());
        }
        g2d.fillRect(0, 0, width/2, height/2);
        
        if(flash == 2)
        {
            g2d.setColor(Color.BLUE);
        }
        else
        {
            g2d.setColor(Color.BLUE.darker());
        }
        g2d.fillRect(width/2, 0, width/2, height/2);
        
        if(flash == 3)
        {
            g2d.setColor(Color.RED);
        }
        else
        {
            g2d.setColor(Color.RED.darker());
        }
        g2d.fillRect(0, height/2, width/2, height/2);
        
        if(flash == 4)
        {
            g2d.setColor(Color.GREEN);
        }
        else
        {
            g2d.setColor(Color.GREEN.darker());
        }
        g2d.fillRect(width/2, height/2, width/2, height/2);
        
        g2d.setColor(Color.CYAN);
        g2d.setStroke(new BasicStroke(200));
        g2d.drawOval(-100, -100, width+200, height+200);
        
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(5));
        g2d.drawOval(2, 2, width-5, height-5);
        
        g2d.fillOval(height/2 - 100, width/2 - 100, 200, 200);
        g2d.fillRect(290, 0, 20, height);
        g2d.fillRect(0, 290, width, 20);
        
        g2d.setFont(new Font("Arial", 2, 60));
        g2d.setColor(Color.WHITE);
        if(gameOver)
        {
            g2d.drawString("Game Over", width/2 -150, height/2 -20);
        }
        else
        {
            g2d.drawString(indexPattern + "/" + pattern.size(), width/2 - 40, height/2 -20);
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {}

    @Override
    public void mousePressed(MouseEvent e)
    {
        int x = e.getX(), y = e.getY();
        
        if(!creatingPattern)
        {
            if(x > 0 && x < width/2 && y > 0 && y < height/2)
            {
                flash = 1;
                ticks = 1;
            }
            else if(x > width/2 && x < width && y > 0 && y < height/2)
            {
                flash = 2;
                ticks = 1;
            }
            else if(x > 0 && x < width/2 && y > height/2 && y < height)
            {
                flash = 3;
                ticks = 1;
            }
            else if(x > width/2 && x < width && y > height/2 && y < height)
            {
                flash = 4;
                ticks = 1;
            }
        }
        
        if(flash != 0)
        {
            if(pattern.get(indexPattern) == flash)
            {
                indexPattern++;
            }
            else
            {
                gameOver = true;
            }
        }
        
    }

    @Override
    public void mouseReleased(MouseEvent e)
    { }

    @Override
    public void mouseEntered(MouseEvent e)
    { }

    @Override
    public void mouseExited(MouseEvent e)
    { }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        ticks++;

        if(ticks % 10 == 0)
        {
            flash = 0;
            if(dark >= 0)
            {
                dark--;
            }
        }
        if(creatingPattern)
        {
            if(dark <= 0)
            {
                if (indexPattern >= pattern.size())
                {
                    flash = rand.nextInt(40) % 4 + 1;
                    pattern.add(flash);
                    indexPattern = 0;
                    creatingPattern = false;
                }
                else
                {
                    flash = pattern.get(indexPattern);
                    indexPattern++;
                }
                dark = 2;
            }
        }
        else if(indexPattern >= pattern.size())
        {
            creatingPattern = true;
            indexPattern = 0;
            dark = 2;
        }

        repaint();
        
    }
}
