package gameR;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.Font;
import javax.swing.SwingConstants;

public class PanelR extends JPanel implements MouseListener {
	
	private final int WIDTH = 600, HEIGHT = 675;
	public int unit_size = 75;
	int numRows = (HEIGHT-75) / unit_size;
	int numCols = (WIDTH) / unit_size;
	int tempW = 2, tempB = 2;
	private JLabel top;
	private JLabel[][] labels = new JLabel[numRows][numCols];
	private String[][] tiles = new String[numRows][numCols];
	private ImageIcon black = new ImageIcon("C:/Users/anish/Documents/VS Code -- Documents/Java/12 Reversi/src/filesR/blackDisc.png");
	private ImageIcon white = new ImageIcon("C:/Users/anish/Documents/VS Code -- Documents/Java/12 Reversi/src/filesR/whiteDisc.png");
	int turn; // 0 = black, 1 = white
	private JPanel centerPanel;
	private Border border = BorderFactory.createLineBorder(new Color(71, 33, 11), 2);
	
	public PanelR() {
		setBackground(new Color(34,139,34));
		
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setLayout(new BorderLayout());
		
		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(numRows, numCols));
		centerPanel.setOpaque(false);
		
		this.top = new JLabel();
		top.setHorizontalAlignment(SwingConstants.LEFT);
		top.setVerticalAlignment(SwingConstants.BOTTOM);
		top.setFont(new Font("Arial", Font.ITALIC, 20));
		top.setText("Othello" + "                    Current Turn: white"
				+ "            " + " Black: " + tempB + " White: " + tempW);
		top.setForeground(new Color(71, 33, 11));
		
		this.add(top, BorderLayout.NORTH);
		this.add(centerPanel, BorderLayout.CENTER);

		this.add(centerPanel, BorderLayout.CENTER);
		setTiles();
		turn = 0;
	}
	
	private void setTiles() {
		for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < numCols; col++) {
				labels[row][col] = new JLabel();
				labels[row][col].setBorder(border);
				labels[row][col].addMouseListener(this);
				centerPanel.add(labels[row][col]);
				if ((row == 3 && col == 3) || (row == 4 && col == 4)) {
					tiles[row][col] = "white";
					labels[row][col].removeMouseListener(this);	
				} else if ((row == 3 && col == 4) || (row == 4 && col == 3)) {
					tiles[row][col] = "black";
					labels[row][col].removeMouseListener(this);	
				} else {
					tiles[row][col] = "nothing";
				}
			}
		}
		setIcons();
	}
	
	public void setIcons(){		
		for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < numCols; col++) {
				if (tiles[row][col].equals("black")) {
					labels[row][col].setIcon(black);
				} else if (tiles[row][col].equals("white")) {
					labels[row][col].setIcon(white);
				} 
			}
		}
		updateScore();
		gameOver();
	}
	
	private void updateScore() {
		tempB = 0;
		tempW = 0;
		for (int row = 0; row < numRows; row++ ) {
			for (int col = 0; col < numCols; col++ ) {
				if (labels[row][col].getIcon() == white) {
					tempW++;
				}
				else if (labels[row][col].getIcon() == black) {
					tempB++;
				}
			}
		}
		if (this.turn%2 == 0) {
			this.top.setText("Othello" + "                    Current Turn: white" +
		"          Black: " + tempB + " White: " + tempW);
		} else {
			this.top.setText("Othello" + "                    Current Turn: black" +
					"          Black: " + tempB + " White: " + tempW);
		}

		
	}
	
	private void turnOver(int row, int col) {
		this.turn++;
		String notTurn;
		if (this.turn%2 == 0) {
			notTurn= "white";
		} else {
			notTurn = "black";
		}

		tiles[row][col] = "temp";
		//checking if possible flipping pieces are on the edge of the board
		// Check top left
		if (col-2 >= 0 && row-2 >= 0) {
			if (tiles[row-1][col-1].equals(notTurn)) {
				outwardDirectionLimit(row-1, col-1, 1);
			}
		}
		// Check top
		if (row-2 >= 0) {
			if (tiles[row-1][col].equals(notTurn)) {
				outwardDirectionLimit(row-1, col, 2);
			}
		}
		// Check top right
		if (col+2 < numCols && row-2 >= 0) {
			if (tiles[row-1][col+1].equals(notTurn)) {
				outwardDirectionLimit(row-1, col+1, 3);
			}
		}
		// Check left
		if (col-2 >= 0) {
			if (tiles[row][col-1].equals(notTurn)) {
				outwardDirectionLimit(row, col-1, 4);
			}
		}
		// Check right
		if (col+2 < numCols) {
			if (tiles[row][col+1].equals(notTurn)) {
				outwardDirectionLimit(row, col+1, 5);
			}
		}
		// Check bottom left
		if (col-2 >= 0 && row+2 < numRows) {
			if (tiles[row+1][col-1].equals(notTurn)) {
				outwardDirectionLimit(row+1, col-1, 6);
			}
		}
		// Check bottom
		if (row+2 < numRows) {
			if (tiles[row+1][col].equals(notTurn)) {
				outwardDirectionLimit(row+1, col, 7);
			}
		}
		// Check bottom right
		if (col+2 < numCols && row+2 < numRows) {
			if (tiles[row+1][col+1].equals(notTurn)) {
				outwardDirectionLimit(row+1, col+1, 8);
			}
		}
		if (this.turn%2 == 0) {
			tiles[row][col] = "black";
		} else {
			tiles[row][col] = "white";
		}
		labels[row][col].removeMouseListener(this);	
		
		
		
	}

	private void reset() {

		turn = 0;
		for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < numCols; col++) {
				labels[row][col].removeAll();
				labels[row][col].setBorder(border);
				if ((row == 3 && col == 3) || (row == 4 && col == 4)) {
					labels[row][col].setIcon(white);
					tiles[row][col] = "white";
				} else if ((row == 3 && col == 4) || (row == 4 && col == 3)) {
					labels[row][col].setIcon(black);
					tiles[row][col] = "black";
				} else {
					labels[row][col].setIcon(null);
					tiles[row][col] = "nothing";
				}
				labels[row][col].addMouseListener(this);
				 if ((row == 3 && col == 3) || (row == 4 && col == 4) || (row == 3 && col == 4) || (row == 4 && col == 3)) {
						labels[row][col].removeMouseListener(this);
					}
			}
		}
		setIcons();
		
	}
	
	private void gameOver() {
		int tempW = 0, tempB = 0, tempN = 0;
		for (int row = 0; row < numRows; row++ ) {
			for (int col = 0; col < numCols; col++ ) {
				if (labels[row][col].getIcon() == white) {
					tempW++;
				}
				else if (labels[row][col].getIcon() == black) {
					tempB++;
				}
				else if (labels[row][col].getIcon() == null) {
					tempN++;
				}
			}	
		}
		//white wins
		if (tempW == 0) {
			int answer = JOptionPane.showConfirmDialog(null, "Play Again?", "Black Wins!", JOptionPane.YES_NO_OPTION);
			if (answer == 0) {
				reset();
			}
			else {
				System.exit(0);
			}
		}
		//black wins
		else if (tempB == 0) {
			int answer = JOptionPane.showConfirmDialog(null, "Play Again?", "White Wins!", JOptionPane.YES_NO_OPTION);
			if (answer == 0) {
				reset();
			}
			else {
				System.exit(0);
			}
		}
		//all are full and black wins
		else if (tempN == 0) {
			if (tempB > tempW) {
				int answer = JOptionPane.showConfirmDialog(null, "Play Again?", "Black Wins!", JOptionPane.YES_NO_OPTION);
				if (answer == 0) {
					reset();
				}
				else {
					System.exit(0);
				}
			}
			//all are full and white wins
			else if (tempW > tempB) {
				int answer = JOptionPane.showConfirmDialog(null, "Play Again?", "White Wins!", JOptionPane.YES_NO_OPTION);
				if (answer == 0) {
					reset();
				}
				else {
					System.exit(0);
				}
			}
			else {
				int answer = JOptionPane.showConfirmDialog(null, "Play Again?", "Draw", JOptionPane.YES_NO_OPTION);
				if (answer == 0) {
					reset();
				}
				else {
					System.exit(0);
				}
			}
			
		}
			
	}
	
	private void outwardDirectionLimit(int row, int col, int direction) {
		
		String turn;
		if (this.turn%2 == 0) {
			turn = "black";
		} else {
			turn = "white";
		}
		
		int dist = 0;
		// FOR DIRECTION : 1 = top left, 2 = top middle, 3 = top right, 4 = left, 5 = right, 6 = bottom left, 7 = bottom middle, 8 = bottom right 
				switch(direction) {
					
					case 1:
						// Check top left
						if (row < col) {
							dist = row;
						} else if (col <= row){
							dist = col;
						}
						for (int i = 0; i <= dist; i++) {
							if (row - i < 0 || col - i < 0) {
								return;
							}
							if (tiles[row-i][col-i].equals("nothing")) {
								return;
							}
							if (tiles[row-i][col-i].equals(turn)) {
								turnAround(row-i+1, col-i+1, 1, i);
								return;
							}
						}
						break;
					case 2:
						// Check top
						dist = row;
						for (int i = 0; i <= dist; i++) {
							if (row - i < 0) {
								return;
							}
							if (tiles[row-i][col].equals("nothing")) {
								return;
							}
							if (tiles[row-i][col].equals(turn)) {
								turnAround(row-i+1, col, 2, i);
								return;
							}
						}
						break;
					case 3:
						// Check top right
						if (row < numCols-1 - col) {
							dist = row;
						} else if (numCols-1 - col <= row) {
							dist = numCols-1 - col;
						}
						for (int i = 0; i <= dist; i++) {
							if (row - i < 0 || col + i >= numCols) {
								return;
							}
							if (tiles[row-i][col+i].equals("nothing")) {
								return;
							}
							if (tiles[row-i][col+i].equals(turn)) {
								turnAround(row-i+1, col+i-1, 3, i);
								return;
							}
						}
						break;
					case 4:
						// Check left
						dist = col;
						for (int i = 0; i <= dist; i++) {
							if (col - i < 0) {
								return;
							}
							if (tiles[row][col-i].equals("nothing")) {
								return;
							}
							if (tiles[row][col-i].equals(turn)) {
								turnAround(row, col-i+1, 4, i);
								return;
							}
						}
						break;
					case 5:
						// Check right
						dist = numCols-1 - col;
						for (int i = 0; i <= dist; i++) {
							if (col + i >= numCols) {
								return;
							}
							if (tiles[row][col+i].equals("nothing")) {
								return;
							}
							if (tiles[row][col+i].equals(turn)) {
								turnAround(row, col+i-1, 5, i);
								return;
							}
						}
						break;
					case 6:
						// Check bottom left
						if (numRows-1 - row < col) {
							
							// reaches bottom before left
							dist = numRows-1 - row;
						} else if (numRows-1 - row >= col) {
							// reaches left before bottom
							dist = col;
						}
						for (int i = 0; i <= dist; i++) {
							if (col - i < 0 || row + i >= numRows) {
								return;
							}
							if (tiles[row+i][col-i].equals("nothing")) {
								return;
							}
							if (tiles[row+i][col-i].equals(turn)) {
								turnAround(row+i-1, col-i+1, 6, i);
								return;
							}
						}
						break;
					case 7:
						// Check bottom
						dist = numRows-1 - row;
						for (int i = 0; i <= dist; i++) {
							if (row + i >= numRows) {
								return;
							}
							if (tiles[row+i][col].equals("nothing")) {
								return;
							}
							if (tiles[row+i][col].equals(turn)) {
								turnAround(row+i-1, col, 7, i);
								return;
							}
						}
						break;
					case 8:
						// Check bottom right
						if (row > col) {
							dist = numRows-1 - row;
						} else if (col >= row){
							dist = numCols-1 - col;
						}
						for (int i = 0; i <= dist; i++) {
							if (row + i >= numRows|| col + i >= numCols) {
								return;
							}
							if (tiles[row+i][col+i].equals("nothing")) {
								return;
							}
							if (tiles[row+i][col+i].equals(turn)) {
								turnAround(row+i-1, col+i-1, 8, i);
								return;
							}
						}
						break;
				}
		
	}

	private void turnAround(int row, int col, int direction, int dist) {

		String turn;
		String notTurn;
		if (this.turn%2 == 0) {
			turn = "black";
			notTurn= "white";
		} else {
			turn = "white";
			notTurn = "black";
		}
		// FOR DIRECTION : 1 = bottom right, 2 = down, 3 = bottom left, 4 = right, 5 = left, 6 = top right, 7 = up, 8 = top left
			switch(direction) {
					
					case 1:
						if (tiles[row][col].equals("temp")) {
							return;
						} else if (tiles[row][col].equals(notTurn)) {
							tiles[row][col] = turn;
							turnAround(row+1, col+1, 1, dist-1);
						}
						break;
					case 2:
						if (tiles[row][col].equals("temp")) {
							return;
						} else if (tiles[row][col].equals(notTurn)) {
							tiles[row][col] = turn;
							turnAround(row+1, col, 2, dist-1);
						}
						break;
					case 3:
						if (tiles[row][col].equals("temp")) {
							return;
						} else if (tiles[row][col].equals(notTurn)) {
							tiles[row][col] = turn;
							turnAround(row+1, col-1, 3, dist-1);
						}
						break;
					case 4:
						if (tiles[row][col].equals("temp")) {
							return;
						} else if (tiles[row][col].equals(notTurn)) {
							tiles[row][col] = turn;
							turnAround(row, col+1, 4, dist-1);
						}
						break;
					case 5:
						if (tiles[row][col].equals("temp")) {
							return;
						} else if (tiles[row][col].equals(notTurn)) {
							tiles[row][col] = turn;
							turnAround(row, col-1, 5, dist-1);
						}
						break;
					case 6:
						if (tiles[row][col].equals("temp")) {
							return;
						} else if (tiles[row][col].equals(notTurn)) {
							tiles[row][col] = turn;
							turnAround(row-1, col+1, 6, dist-1);
						}
						break;
					case 7:
						if (tiles[row][col].equals("temp")) {
							return;
						} else if (tiles[row][col].equals(notTurn)) {
							tiles[row][col] = turn;
							turnAround(row-1, col, 7, dist-1);
						}
						break;
					case 8:
						if (tiles[row][col].equals("temp")) {
							return;
						} else if (tiles[row][col].equals(notTurn)) {
							tiles[row][col] = turn;
							turnAround(row-1, col-1, 8, dist-1);
						}
						break;
				}
	}
	
	public void playSound() {
		File file;
		AudioInputStream audioStream;
		Clip clip;		
		try {
			file = new File("C:/Users/anish/Documents/VS Code -- Documents/Java/12 Reversi/src/filesR//DPWC4DA-object-table-game-chess-piece-handle-01.wav");
			audioStream = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.open(audioStream);
			clip.start();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}	
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {

		Object src = e.getSource();
		for (int row = 0; row < numRows; row++) {
			for(int col = 0; col < numCols; col++){
				
				if (src == labels[row][col]) {
					turnOver(row, col);
					setIcons();
					updateScore();
					playSound();
				}
				
			}
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
}
