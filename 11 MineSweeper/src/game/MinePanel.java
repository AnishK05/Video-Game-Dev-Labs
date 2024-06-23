package game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.*;



public class MinePanel extends JPanel implements MouseListener
{

	private int width = 500, height = 525;
	private int unitSize = 25;
	int numRows = (height-unitSize)/unitSize;
	int numCols = width/unitSize;
	private JLabel top;
	private JLabel[][] labels;
	private ImageIcon[][] icons;
	private JPanel centerPanel;
	private Random rand = new Random();
	private int numMines;
	private int difficulty;
	public String choice = "";
	private ImageIcon tile = new ImageIcon("C:/Users/anish/Documents/VS Code -- Documents/Java/11 MineSweeper/src/images/tile.png");
	private ImageIcon mine = new ImageIcon("C:/Users/anish/Documents/VS Code -- Documents/Java/11 MineSweeper/src/images/mine.png");
	private ImageIcon flag = new ImageIcon("C:/Users/anish/Documents/VS Code -- Documents/Java/11 MineSweeper/src/images/flag.png");
	private ImageIcon blank = new ImageIcon("C:/Users/anish/Documents/VS Code -- Documents/Java/11 MineSweeper/src/images/0.png");
	
	Timer timer;
	int second = 0;
	int minute = 0;
	int hour = 0;
	String ddSecond;
	String ddMinute;
	String ddHour;
	DecimalFormat dFormat = new DecimalFormat("00");
	
	int counter = 0;
	
	public MinePanel() 
	{
		this.setPreferredSize(new Dimension(width, height));
		this.setFocusable(true);
		this.setLayout(new BorderLayout());
		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(numRows, numCols));
		this.top = new JLabel("Game");
		this.add(top, BorderLayout.NORTH);
		this.add(centerPanel, BorderLayout.CENTER);
		startScreen();
		setBoard();
		addMines();
		addCount();
		simpleTimer();
		timer.start();
	
	}
	
	public void simpleTimer()
	{
		timer = new Timer(1000, new ActionListener()  //update the timer every "one" second.
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				second++;
				ddSecond = dFormat.format(second);
				ddMinute = dFormat.format(minute);
				ddHour = dFormat.format(hour);
				
				if (second == 60)
				{
					minute++;
					ddMinute = dFormat.format(minute);
					second = 0;
				}
				
				if (minute == 60)
				{
					hour++;
					ddHour = dFormat.format(hour);
					minute = 0;
				}
				
				top.setText("Mines Left: " + numMines + "                                                        "
						+ "                                                    " + ddHour + ":" + ddMinute + ":" + ddSecond);
			}
		}
		);
			
	}
	
	public void playSound(String soundName)
	{
		try 
		{
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		}
		catch (Exception e)
		{
			System.out.println("Error in playing sound");
			e.printStackTrace();
		}
	}
	
	private void startScreen()
	{
		String[] options = {"Easy", "Medium", "Hard"};
		String choice = (String)JOptionPane.showInputDialog(null, "What difficulty would you like?", 
				"Difficulty Settings", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		
		if (choice.equals("Easy"))
		{
			numMines = 25;
			difficulty = 25;
		}
		else if (choice.equals("Medium"))
		{
			numMines = 50;
			difficulty = 50;
		}
		else if (choice.equals("Hard"))
		{
			numMines = 100;
			difficulty = 100;
		}
		
	}
	
	private void setBoard() 
	{
		labels = new JLabel[numRows][numCols];
		for (int row = 0; row < numRows; row++) 
		{
			for (int col = 0; col < numCols; col++) 
			{
				labels[row][col] = new JLabel();
				labels[row][col].setIcon(tile);
				labels[row][col].addMouseListener(this);
				centerPanel.add(labels[row][col]);
			}
		}
	}

	private void addMines() 
	{
		int minesLeft = numMines;
		icons = new ImageIcon[numRows][numCols];
		for (int row = 0; row < numRows; row++)
		{
			for (int col = 0; col < numCols; col++)
			{
				icons[row][col] = new ImageIcon();
				
					if (rand.nextInt(10) < 1 && minesLeft > 0)
					{
						icons[row][col] = mine;
						minesLeft--;
					}
			}
		}
		
		top.setText("Mines Left: " + numMines + "                                                    "
				+ "                                                    " + "00:00:00");
	}
	
	private void addCount()
	{
		for (int row = 0; row < numRows; row ++) 
		{
			for (int col = 0; col < numCols; col++) 
			{
				if (icons[row][col].equals(mine)) 
				{
					continue;
				}
				int count = 0;
				
				//check top left
				if (col - 1 >= 0 && row - 1 >= 0) 
				{
					if (icons[row-1][col-1].equals(mine)) 
					{
						count++;
					}
				}
				
				//check top middle
				if (row - 1 >= 0) 
				{
					if (icons[row-1][col].equals(mine)) 
					{
						count++;
					}
				}
				
				//check top right
				if (col + 1 < numCols && row - 1 >= 0) 
				{
					if (icons[row-1][col+1].equals(mine)) 
					{
						count++;
					}
				}
				
				//check left
				if (col - 1 >= 0) 
				{
					if (icons[row][col-1].equals(mine)) 
					{
						count++;
					}
				}
				
				//check right
				if (col + 1 < numCols) {
					if (icons[row][col+1].equals(mine)) 
					{
						count++;
					}
				}
				
				//check bottom left
				if (col - 1 >= 0 && row + 1 < numRows) 
				{
					if (icons[row+1][col-1].equals(mine)) 
					{
						count++;
					}
				}
				
				//check bottom middle
				if (row + 1 < numRows) 
				{
					if (icons[row+1][col].equals(mine)) 
					{
						count++;
					}
				}
				
				//check bottom right
				if (col + 1 < numCols && row + 1 < numRows) 
				{
					if (icons[row+1][col+1].equals(mine)) 
					{
						count++;
					}
				}
				
				//set the tile
				if (count > 0 ) 
				{
					icons[row][col] = new ImageIcon("C:/Users/anish/Documents/VS Code -- Documents/Java/11 MineSweeper/src/images/" + count + ".png");
				} 
				else
				{
					icons[row][col] = blank;
				}
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) 
	{
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		Object src = e.getSource();
		
		//if the user clicks the left mouse button
		if (e.getButton() == MouseEvent.BUTTON1) 
		{
			for (int row = 0; row < numRows; row++) 
			{
				for (int col = 0; col < numCols; col++) 
				{
					if (src == labels[row][col] && labels[row][col].getIcon().equals(tile))
					{
						labels[row][col].setIcon(icons[row][col]);
						labels[row][col].removeMouseListener(this);
						if (icons[row][col].equals(mine)) 
						{
							timer.stop();
							playSound("C:/Users/anish/Documents/VS Code -- Documents/Java/11 MineSweeper/src/images/Boom.wav");
							gameLost();
						}
						else if (icons[row][col].equals(blank))
						{
							showBlanks(row, col);
						}
					}
				}
			}
		}
		
		//if the user clicks the middle button on the mouse
		else if (e.getButton() == MouseEvent.BUTTON2) 
		{
			System.out.println("Middle button clicked");
		}

		//if the user clicks the right button on the mouse
		else if (e.getButton() == MouseEvent.BUTTON3) 
		{
			for (int row = 0; row < numRows; row++) 
			{
				for (int col = 0;col < numCols; col++) 
				{
					if (src == labels[row][col]) 
					{
						if (labels[row][col].getIcon().equals(flag)) 
						{
							labels[row][col].setIcon(tile);
							numMines++;
							top.setText("Mines Left: " + numMines);
						}
						else if (labels[row][col].getIcon().equals(tile))
						{
							labels[row][col].setIcon(flag);
							numMines--;
							top.setText("Mines Left: " + numMines);
						}
						if (numMines == 0)
						{
							for (row = 0; row < numRows; row++) 
							{
								for (col = 0; col < numCols; col++) 
								{
									if (icons[row][col].equals(mine) && labels[row][col].getIcon().equals(flag))
									{
										counter++;
										if (difficulty == 25 && counter == 25)
										{
											gameWon();
										}
										if (difficulty == 50 && counter == 50)
										{
											gameWon();
										}
										if (difficulty == 100 && counter == 100)
										{
											gameWon();
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}

	private void showBlanks(int row, int col) 
	{
		if (!icons[row][col].equals(blank)) 
		{
			labels[row][col].setIcon(icons[row][col]);
			labels[row][col].removeMouseListener(this);
			return;
		}
		if (icons[row][col].equals(blank)) 
		{
			labels[row][col].setIcon(blank);
			labels[row][col].removeMouseListener(this);
			if (row-1 >= 0 && col-1 >= 0 && labels[row-1][col-1].getMouseListeners().length > 0) 
			{
				showBlanks(row-1, col-1);
			}
			if (col-1 >= 0 && labels[row][col-1].getMouseListeners().length > 0) 
			{
				showBlanks(row, col-1);
			}
			if (row+1 < numRows && col-1 >= 0 && labels[row+1][col-1].getMouseListeners().length > 0) 
			{
				showBlanks(row+1, col-1);
			}
			if (row-1 >= 0 && labels[row-1][col].getMouseListeners().length > 0)
			{
				showBlanks(row-1, col);
			}
			if (row+1 < numRows && labels[row+1][col].getMouseListeners().length > 0) 
			{
				showBlanks(row+1, col);
			}
			if (row-1 >= 0 && col+1 < numCols && 
					labels[row-1][col+1].getMouseListeners().length > 0) 
			{
				showBlanks(row-1, col+1);
			}
			if (col+1 < numCols && labels[row][col+1].getMouseListeners().length > 0) 
			{
				showBlanks(row, col+1);
			}
			if (row+1 < numRows && col+1 < numCols && labels[row+1][col+1].getMouseListeners().length > 0) 
			{
				showBlanks(row+1, col+1);
			}
		}
	}

	private void gameLost() 
	{
		int restart = JOptionPane.showConfirmDialog(null, "You Lost! Would You Like To Play Again?", "You Lost!", JOptionPane.YES_NO_OPTION);
		if (restart == 0)
		{
			restartGame();
		}
		else
		{
			System.exit(0);
		}
	}
	
	private void gameWon()
	{
		int restart = JOptionPane.showConfirmDialog(null, "You Won! Would You Like To Play Again?", "You Won!", JOptionPane.YES_NO_OPTION);
		if (restart == 0)
		{
			restartGame();
		}
		else
		{
			System.exit(0);
		}
	}
	
	private void restartGame() 
	{
		centerPanel.removeAll();
		centerPanel.revalidate();
		centerPanel.repaint();
		
		top.setText("");
		second = 0;
		minute = 0;
		hour = 0;
		numMines = 0;
		counter = 0;
		
		startScreen();
		setBoard();
		addMines();
		addCount();
		timer.start();
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
	}

	@Override
	public void mouseEntered(MouseEvent e) 
	{
	}

	@Override
	public void mouseExited(MouseEvent e) 
	{
	}

}


