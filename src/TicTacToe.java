
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * Application
 * @author Michael
 *
 */
public class TicTacToe implements ActionListener{
//Determine users turn with random number
	Random random = new Random();
	JFrame frame = new JFrame(); // JFrame
	JPanel title_panel = new JPanel(); // Panel to hold title
	JPanel button_panel = new JPanel(); // Button holder
	JLabel textfield = new JLabel(); // Text Field Display Message
	JButton[] buttons = new JButton[9]; // Array of buttons -> 9
	boolean player1_turn; // True if player 1 or false if player 2 -> determine turn

	/**
	 * Constructor for TicTacToe Game
	 */
	TicTacToe(){
//		Create Frame JFrame 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800); // Frame size
		frame.setTitle("Java TicTacToe Desktop Application"); // Application Title
		frame.setLocationRelativeTo(null); // Center Frame on Display
		frame.getContentPane().setBackground(new Color(50,50,50)); // Light Black -> rgb
		frame.setLayout(new BorderLayout()); // Border layout
		frame.setVisible(true); // Display
		
//		Textfield
		textfield.setBackground(new Color(25,25,25));
		textfield.setForeground(new Color(25,255,0));
		textfield.setFont(new Font("Arial",Font.BOLD,75));
		textfield.setHorizontalAlignment(JLabel.CENTER); // Center Label -> border layout
		textfield.setText("Tic-Tac-Toe");
		textfield.setOpaque(true);
//		Panel
		title_panel.setLayout(new BorderLayout()); // Border Layout
		title_panel.setBounds(0,0,800,100); // 
//		Button Layout
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(new Color(150,150,150));
		
//		Button Interator -> grid of buttons (9)
		for(int i=0;i<9;i++) {
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("Arial",Font.BOLD,120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		
		title_panel.add(textfield); // Add Text Field
		frame.add(title_panel,BorderLayout.NORTH); // Stick to top -> title panel
		frame.add(button_panel); // 
		
//		Determine the first player X/O @ random 
		firstTurn();
	}

	/**
	 * Check 9 buttons for button press at index
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<9;i++) {
			if(e.getSource()==buttons[i]) {
				if(player1_turn) {
//					Check button for text -> unselected available selection
					if(buttons[i].getText()=="") {
//						Set as selected square
						buttons[i].setForeground(new Color(255,0,0)); // Red -> Player 1
						buttons[i].setText("X");
						player1_turn=false; // Swap turn
						textfield.setText("O turn"); // Update Header text
//						Check for winning combinations
						check();
					}
				}
				else {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(0,0,255)); // Blue -> Player 2
						buttons[i].setText("O");
						player1_turn=true;
						textfield.setText("X turn");
//						Check for winning combinations
						check();
					}
				}
			}			
		}
	}
	
	/**
	 * Determine Users Turn with Random Integer
	 * 
	 */
	public void firstTurn() {
//		Sleep for 2s before assigning player turn
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		Generated from 2 Numbers
		if(random.nextInt(2)==0) {
			player1_turn=true; // Player 1 first
			textfield.setText("X turn");
		}
		else {
			player1_turn=false; // Player 2 secondS
			textfield.setText("O turn");
		}
	}
	
	
	/**
	 * Determine Winner combinations of selections
	 */
	public void check() {
		//check X win conditions -> winning combination of selections -> If row has 3 matching x's
		if(
				(buttons[0].getText()=="X") &&
				(buttons[1].getText()=="X") &&
				(buttons[2].getText()=="X")
				) {
//			Send winning combination
			xWins(0,1,2);
		}
		if(
				(buttons[3].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[5].getText()=="X")
				) {
//			Send winning combination
			xWins(3,4,5);
		}
		if(
				(buttons[6].getText()=="X") &&
				(buttons[7].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
//			Send winning combination
			xWins(6,7,8);
		}
		if(
				(buttons[0].getText()=="X") &&
				(buttons[3].getText()=="X") &&
				(buttons[6].getText()=="X")
				) {
//			Send winning combination
			xWins(0,3,6);
		}
		if(
				(buttons[1].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[7].getText()=="X")
				) {
//			Send winning combination
			xWins(1,4,7);
		}
		if(
				(buttons[2].getText()=="X") &&
				(buttons[5].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
//			Send winning combination
			xWins(2,5,8);
		}
		if(
				(buttons[0].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
//			Send winning combination
			xWins(0,4,8);
		}
		if(
				(buttons[2].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[6].getText()=="X")
				) {
//			Send winning combination
			xWins(2,4,6);
		}
		//check O win conditions
		if(
				(buttons[0].getText()=="O") &&
				(buttons[1].getText()=="O") &&
				(buttons[2].getText()=="O")
				) {
//			Send winning combination
			oWins(0,1,2);
		}
		if(
				(buttons[3].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[5].getText()=="O")
				) {
//			Send winning combination
			oWins(3,4,5);
		}
		if(
				(buttons[6].getText()=="O") &&
				(buttons[7].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
//			Send winning combination
			oWins(6,7,8);
		}
		if(
				(buttons[0].getText()=="O") &&
				(buttons[3].getText()=="O") &&
				(buttons[6].getText()=="O")
				) {
//			Send winning combination
			oWins(0,3,6);
		}
		if(
				(buttons[1].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[7].getText()=="O")
				) {
//			Send winning combination
			oWins(1,4,7);
		}
		if(
				(buttons[2].getText()=="O") &&
				(buttons[5].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
//			Send winning combination
			oWins(2,5,8);
		}
		if(
				(buttons[0].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
//			Send winning combination
			oWins(0,4,8);
		}
		if(
				(buttons[2].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[6].getText()=="O")
				) {
//			Send winning combination
			oWins(2,4,6);
		}
	}
	
	/**
	 * Player X winning Combination of Buttons
	 * @param a int
	 * @param b int
	 * @param c int 
	 */
	public void xWins(int a,int b,int c) {
//		Update Background Colours
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
//		Disable all buttons at end of game
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
//		Set winner text field
		textfield.setText("X wins");
	}
	
	/**
	 *  Player O winning Combination of Buttons
	 * @param a
	 * @param b
	 * @param c
	 */
	public void oWins(int a,int b,int c) {
//		Update Background Colours
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
//		Disable all buttons at end of game
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
//		Set winner text field
		textfield.setText("O wins");
	}
}