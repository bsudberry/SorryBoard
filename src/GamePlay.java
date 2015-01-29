import java.awt.BorderLayout;      
import java.awt.Container;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;        
import javax.swing.JFrame;
import javax.swing.JLabel;         
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GamePlay 
	{
	static String labelWords; 
	static JFrame choosePawn = new JFrame();
	static int [] pawnChoices = {1,2,3,4};
	public static void startGame() throws InterruptedException
		{
		int uselessVariable  = JOptionPane.showOptionDialog(choosePawn, "Which pawn do you want to move? ", "Initial dealing", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, useless, useless[0]);
		MakeCards.makeCards();
		GameBoard.cardIndex=0;
		GameBoard.makeBoard();
		}
	}
	
