import java.awt.BorderLayout;      
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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
	static Object[] pawnChoices = {1,2,3,4};
	ImageIcon pawn = new ImageIcon("pawn.jpg");
		
	public static void startGame() throws InterruptedException, IOException
		{
		PawnManager.makePawns();
		MakeCards.makeCards();
		GameBoard.cardIndex=0;
		GameBoard.makeBoard();
		choosePawn(PawnManager.p1Pawns);
		}
	
	public static void choosePawn(ArrayList<Pawn> x) throws IOException
		{
		Pawn [] pawnsArray = new Pawn [x.size()];
		for(int i=0; i<4; i++)
			{
			pawnsArray[i] = x.get(i);
			}
		BufferedImage pawnImage = ImageIO.read(new File("pawn.jpg"));
		ImageIcon pawn = new ImageIcon(pawnImage);
		int pawnChosen = JOptionPane.showOptionDialog(choosePawn, "Which pawn do you want to move? ", "Initial dealing", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, pawn, pawnsArray, pawnsArray[0].getpNum());
		}
	}
	
