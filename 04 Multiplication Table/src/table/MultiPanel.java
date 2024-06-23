package table;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

public class MultiPanel extends JPanel implements ActionListener
{	
	private int WIDTH = 800;
    private int HEIGHT = 800;
    private Dimension SIZE = new Dimension(WIDTH, HEIGHT);
    private int requiredSize;
    private JTextField textField;
    private JPanel multiplicationTable;
    private JPanel topPanel = new JPanel();
    private JLabel alterLabel; 

    public MultiPanel() 
    {

        setPreferredSize(SIZE);
        setLayout(new BorderLayout(0, 0));
       
        textField = new JTextField();
        textField.setBounds(207, 5, 283, 20);
        textField.setColumns(10);
        textField.addActionListener(this);
        
        add(topPanel, BorderLayout.NORTH);
        
        JLabel questionLabel = new JLabel("Enter the number of the multiplication table you want (1-39): ");
        questionLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
        topPanel.add(questionLabel);
        topPanel.add(textField);
        topPanel.setBackground(Color.LIGHT_GRAY);
     
        setInitialTable();
    }

    public void actionPerformed(ActionEvent e) 
    {
    	this.remove(multiplicationTable);
    	
        multiplicationTable = new JPanel();
        add(multiplicationTable, BorderLayout.CENTER);
        multiplicationTable.setBackground(SystemColor.activeCaption);
        
        String num = textField.getText();
        
        try 
        {
        	requiredSize = Integer.parseInt(num)+1;
        	
        	 if (requiredSize-1 > 39 ) 
             {
                 JOptionPane.showConfirmDialog(null, "You entered a value that is not valid! Please choose a number between 1-39", "Number out of bounds (1-39)", 
                 JOptionPane.WARNING_MESSAGE);
                 return;
             }
        }
        catch (Exception e1)
        {
        	JOptionPane.showConfirmDialog(null, "You entered a value that is not valid! Please choose a number between 1-39", "Number out of bounds (1-39)", 
            JOptionPane.WARNING_MESSAGE);
            return;
        }
       
        multiplicationTable.setLayout(new GridLayout(requiredSize, requiredSize, 0, 0));
       
        for (int i = requiredSize; i > 0; i--) 
        {
            for (int j = requiredSize; j > 0; j--) 
            {
                if (i == requiredSize && j == requiredSize) 
                {
                	alterLabel = new JLabel("");
                	setJLabelProperties(alterLabel);
                    multiplicationTable.add(alterLabel);
                } 
                else if (i == requiredSize) 
                {
                    alterLabel = new JLabel("" + (j) + "");
                    setJLabelProperties(alterLabel);
                    multiplicationTable.add(alterLabel);
                } 
                else if (j == requiredSize) 
                {
                    alterLabel = new JLabel("" + (i) + "");
                    setJLabelProperties(alterLabel);
                    multiplicationTable.add(alterLabel);
                } 
                else 
                {
                    alterLabel = new JLabel("" + (i*j) + "");
                    setJLabelProperties(alterLabel);
                    multiplicationTable.add(alterLabel);
                }
                
                multiplicationTable.revalidate();
                multiplicationTable.repaint();
            }
        }
    }
    
    private void setJLabelProperties (JLabel label) 
    {
        alterLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        alterLabel.setHorizontalAlignment(JLabel.CENTER);
    }
    
    private void setInitialTable()
    {
    	multiplicationTable = new JPanel();
        add(multiplicationTable, BorderLayout.CENTER);
        multiplicationTable.setBackground(SystemColor.activeCaption);

        requiredSize = 11;
        
        if (requiredSize-1 > 39) 
        {
            JOptionPane.showConfirmDialog(null, "You entered a number that is too big! Please choose a number between 1-39", "Number out of bounds (1-39)", 
            JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        multiplicationTable.setLayout(new GridLayout(requiredSize, requiredSize, 0, 0));
       
        
        for (int i = requiredSize; i > 0; i--) 
        {
            for (int j = requiredSize; j > 0; j--) 
            {
                if (i == requiredSize && j == requiredSize) 
                {
                	alterLabel = new JLabel("");
                	setJLabelProperties(alterLabel);
                    multiplicationTable.add(alterLabel);
                } 
                else if (i == requiredSize) 
                {
                    alterLabel = new JLabel("" + (j) + "");
                    setJLabelProperties(alterLabel);
                    multiplicationTable.add(alterLabel);
                } 
                else if (j == requiredSize) 
                {
                    alterLabel = new JLabel("" + (i) + "");
                    setJLabelProperties(alterLabel);
                    multiplicationTable.add(alterLabel);
                } 
                else 
                {
                    alterLabel = new JLabel("" + (i*j) + "");
                    setJLabelProperties(alterLabel);
                    multiplicationTable.add(alterLabel);
                }
                
                multiplicationTable.revalidate();
                multiplicationTable.repaint();
          }
       }
  }
}