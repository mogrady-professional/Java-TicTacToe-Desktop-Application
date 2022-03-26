
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
		
//		Button Interator
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
		
		firstTurn();
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<9;i++) {
			if(e.getSource()==buttons[i]) {
				if(player1_turn) {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(255,0,0));
						buttons[i].setText("X");
						player1_turn=false;
						textfield.setText("O turn");
						check();
					}
				}
				else {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(0,0,255));
						buttons[i].setText("O");
						player1_turn=true;
						textfield.setText("X turn");
						check();
					}
				}
			}			
		}
	}
	
	/**
	 * Determine Initial Users Turn
	 * 
	 */
	public void firstTurn() {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(random.nextInt(2)==0) {
			player1_turn=true;
			textfield.setText("X turn");
		}
		else {
			player1_turn=false;
			textfield.setText("O turn");
		}
	}
	
	
	/**
	 * Determine Winner using check method
	 */
	public void check() {
 
	}
	
	public void xWins(int a,int b,int c) {
 
	}
	public void oWins(int a,int b,int c) {
 
	}
}