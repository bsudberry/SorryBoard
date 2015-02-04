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
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;        
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;         
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GamePlay 
	{
	static String labelWords; 
	static JFrame choosePawn = new JFrame();
	static boolean gameOver = false;
	static Object[] pawnChoices = {1,2,3,4};
	static ImageIcon pawn = new ImageIcon("pawn.jpg");
	static ArrayList<ArrayList<Pawn>> allPlayers = new ArrayList<ArrayList<Pawn>>();
	
	public static void startGame() throws InterruptedException, IOException
		{
		MakeCards.makeCards();
		PawnManager.makePawns();
		MakeCards.makeCards();
		GameBoard.makeSpots();
		allPlayers.add(PawnManager.p1Pawns);
		allPlayers.add(PawnManager.p2Pawns);
		allPlayers.add(PawnManager.p3Pawns);
		allPlayers.add(PawnManager.p4Pawns);
		GameBoard.makeBoard();
		}
	
	public static void continueGame() throws InterruptedException
		{
		for(int i=0; i<allPlayers.size(); i++)
			{
			Thread.sleep(1000); 
			GameBoard.label.setText("Player " + allPlayers.get(i).get(0).getPlayer() + ": Click Draw!");
			final ArrayList<Pawn> currentPlayer = new ArrayList<Pawn>(allPlayers.get(i)); 
			 GameBoard.button.addActionListener(new ActionListener()
			    	{
			    	public void actionPerformed(ActionEvent e)
			    			{
			    			try
			    				{
								GameBoard.cardIndex = GameBoard.chooseCard();
								GameBoard.canvas.repaint();
								GamePlay.makeMove(currentPlayer, MakeCards.deck.get(GameBoard.cardIndex));
								} catch (IOException e1)
								{
								// TODO Auto-generated catch block
								e1.printStackTrace();
								} catch (InterruptedException e1)
									{
									// TODO Auto-generated catch block
									e1.printStackTrace();
									}
						      }
			    	});
			}
		}
	
	public static void makeMove(ArrayList<Pawn> player, Card x) throws IOException, InterruptedException
			{
			if(x.getFileName().equals("SorryCard.jpg"))
				{
				choosePawn(player, x);
				}
			else if(x.getFileName().equals("One.jpg"))
				{
				choosePawn(player, x);
				}
			else if(x.getFileName().equals("Two.jpg"))
				{
				choosePawn(player, x);
				}
			else if(x.getFileName().equals("Three.jpg"))
				{
				choosePawn(player, x);
				}
			else if(x.getFileName().equals("Four.jpg"))
				{
				choosePawn(player, x);
				}
			else if(x.getFileName().equals("Five.jpg"))
				{
				choosePawn(player, x);
				}
			else if(x.getFileName().equals("Seven.jpg"))
				{
				choosePawn(player, x);
				}
			else if(x.getFileName().equals("Eight.jpg"))
				{
				choosePawn(player, x);
				}
			else if(x.getFileName().equals("Ten.jpg"))
				{
				choosePawn(player, x);
				}
			else if(x.getFileName().equals("Eleven.jpg"))
				{
				choosePawn(player, x);
				}
			else if(x.getFileName().equals("Twelve.jpg"))
				{
				choosePawn(player, x);
				}
			GameBoard.canvas.repaint();
	}
		
	
	public static int choosePawn(ArrayList<Pawn> x, Card card) throws IOException
		{
		Object [] pawnsArray = new Object [x.size()];
		for(int i=0; i<4; i++)
			{
			pawnsArray[i] = x.get(i).getpNum();
			}
		BufferedImage pawnImage = ImageIO.read(new File("pawn.jpg"));
		ImageIcon pawn = new ImageIcon(pawnImage);
		int pawnChosen = JOptionPane.showOptionDialog(choosePawn, "Which pawn do you want to move? ", "Initial dealing", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, pawn, pawnsArray, pawnsArray[0]);
		
		if((x.get(pawnChosen).getLoc() + card.getValue() +x.get(pawnChosen).getStartSpot())>57)
				{
				x.get(pawnChosen).setLoc(x.get(pawnChosen).getLoc() + card.getValue() +x.get(pawnChosen).getStartSpot()-58); 
				}
		else
				{
				x.get(pawnChosen).setLoc(x.get(pawnChosen).getLoc() + card.getValue() +x.get(pawnChosen).getStartSpot()); 
				}
		return pawnChosen;
		}
	public static void splitPawns(ArrayList<Pawn>x) throws IOException
		{
		final ArrayList<Pawn> l = new ArrayList<Pawn>(x);
		Object pawnsChosen [] = new Object[4];
		Object [] pawnsArray = new Object [x.size()];
		String [] spots = {"Move 1", " Move 2", "Move 3", "Move 4", "Move 5", "Move 6","Move 7"}; 
		for(int i=0; i<4; i++)
			{
			pawnsArray[i] ="Pawn " + x.get(i).getpNum();
			}
		BufferedImage pawnImage = ImageIO.read(new File("pawn.jpg"));
		ImageIcon pawn = new ImageIcon(pawnImage);
		final JComboBox<Object> choosePawn1 = new JComboBox<Object>(pawnsArray);
		final JComboBox<String> chooseSpots1 = new JComboBox<String>(spots);
		final JComboBox<Object> choosePawn2 = new JComboBox<Object>(pawnsArray);
		final JComboBox<String> chooseSpots2 = new JComboBox<String>(spots);
		JPanel panel = new JPanel(); 
		JButton button = new JButton("Enter");
		JLabel label = new JLabel("Please choose pawns to split"); 
		panel.add(label);
		panel.add(choosePawn1);
		panel.add(chooseSpots1);
		panel.add(choosePawn2);
		panel.add(chooseSpots2);
		panel.add(button);
		choosePawn.add(panel);
		choosePawn.setSize(200,300);
		choosePawn.setLocationRelativeTo(null); 
		choosePawn.setVisible(true);
		int num=0; 
		button.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent arg0)
					{
					setSplitLocations(choosePawn1.getSelectedIndex(),chooseSpots1.getSelectedIndex(),l);
					setSplitLocations(choosePawn2.getSelectedIndex(),chooseSpots2.getSelectedIndex(),l);
					choosePawn.dispose(); 
					}
			});
		
		}
	
	public static void setSplitLocations(int n,  int y, ArrayList<Pawn> m)
		{
		int location = m.get(n).getLoc();
		m.get(n).setLoc(location + y); 
		if(m.get(0).getPlayer()==1)
			{
			PawnManager.p1Pawns = new ArrayList<Pawn>(m); 
			}
		}
	}
	
