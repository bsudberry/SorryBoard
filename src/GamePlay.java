import java.awt.BorderLayout;      
import java.awt.Container;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;        
import javax.swing.JFrame;
import javax.swing.JLabel;         
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GamePlay 
	{
	static String labelWords; 
	public static void startGame() throws InterruptedException
		{
		labelWords = "killjoy";
		GameBoard.makeBoard();
		Thread.sleep(200); 
		labelWords = "love"; 
		GameBoard.canvas.repaint();
		}
	}
	
