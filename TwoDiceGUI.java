// This app needs the class Die.java in the root directory

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TwoDiceGUI extends JFrame implements ActionListener
{
	
	Font mainFont = new Font("Impact", Font.PLAIN, 32);
	JLabel title = new JLabel("Two Dice Game");
	JLabel playerLabel = new JLabel("The players roll is: ");
	JLabel comLabel = new JLabel("The computers roll is: ");
	JLabel result = new JLabel("");
	JTextField pRoll = new JTextField(4);
	JTextField cRoll = new JTextField(4);
	JButton button = new JButton("Click to play");
	
	// Create a custom constructor for this class
	public TwoDiceGUI()
	{
		super("Two Dice Game");
		setBounds(450, 450, 300, 240);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new FlowLayout());
		
		title.setFont(mainFont);
		result.setFont(mainFont);
		button.setBackground(Color.BLACK);
		button.setForeground(Color.WHITE);
		
		add(title);
		add(playerLabel);
		add(pRoll);
		add(comLabel);
		add(cRoll);
		add(button);
		add(result);
		
		button.addActionListener(this);
	}
	
	// Event handling method
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// Create two objects from the Die class
		Die playerDie = new Die();
		Die computerDie = new Die();
		String outcome;
		
		// Decide what the outcome of the game will be based on the values of the two Die objects
		if(playerDie.getDieValue() > computerDie.getDieValue())
		{
			outcome = "The player wins!";
			result.setForeground(Color.GREEN);
		}
		else if(computerDie.getDieValue() > playerDie.getDieValue())
		{
			outcome = "The computer wins!";
			result.setForeground(Color.RED);
		}
		else
		{
			outcome = "It's a tie!";
			result.setForeground(Color.BLUE);
		}
		
		// Output to the GUI
		pRoll.setText("" + playerDie.getDieValue());
		cRoll.setText("" + computerDie.getDieValue());
		result.setText(outcome);
		button.setText("Play Again?");
	}
	
	public static void main(String[] args)
	{
		TwoDiceGUI frame = new TwoDiceGUI();
	}
}