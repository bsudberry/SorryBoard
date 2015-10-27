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
	static Object[] pawnChoices = {1,2,3,4,"No move possible"};
	static ImageIcon pawn = new ImageIcon("pawn.jpg");
	static ArrayList<ArrayList<Pawn>> allPlayers = new ArrayList<ArrayList<Pawn>>();
	
	public static void startGame() throws InterruptedException, IOException
		{
		MakeCards.makeCards();
		PawnManager.makePawns();
		GameBoard.makeSpots();
		allPlayers.add(PawnManager.p1Pawns);
		allPlayers.add(PawnManager.p2Pawns);
		allPlayers.add(PawnManager.p3Pawns);
		allPlayers.add(PawnManager.p4Pawns);
		GameBoard.makeBoard();
		}
	
	public static void makeMove(int counter, Card x) throws IOException, InterruptedException
			{
			int index=0; 
			ArrayList<Pawn> player = new ArrayList<Pawn>(); 
			player.clear(); 
			if((double) counter%4==0)
				{
				GameBoard.label.setText("Player 1: ");
				player = allPlayers.get(3);
				index = 3;
				}
			else if((double) counter%4==3)
				{
				GameBoard.label.setText("Player 4: ");
				player = allPlayers.get(2);
				index = 2;
				}
			else if((double) counter%4==2)
				{
				GameBoard.label.setText("Player 3: ");
				player = allPlayers.get(1);
				 index = 1;
				}
			else if((double)counter%4==1)
				{
				GameBoard.label.setText("Player 2: ");
				player = allPlayers.get(0);
				index=0;
				}
			else
				{
				}
			
			if(x.getFileName().equals("SorryCard.jpg"))
				{
				int playerChosen = JOptionPane.showOptionDialog(choosePawn, "Which player would you like to bump back to start?", "Player "+ player.get(0).getPlayer(), JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, pawn, pawnChoices, pawnChoices[0]);
				switch(playerChosen)
					{
					case 0: 
						{
						sorryMove(player, allPlayers.get(0)); 
						break;
						}
					case 1:
						{
						sorryMove(player, allPlayers.get(1));
						break;
						}
					case 2:
						{
						sorryMove(player, allPlayers.get(2)); 
						break;
						}
					case 3: 
						{
						sorryMove(player, allPlayers.get(3)); 
						}
					}
				}
			else if(x.getFileName().equals("One.jpg"))
				{
				String [] choices = {"Move from Start!", "No I will just move foward"}; 
				int pawnChosen = JOptionPane.showOptionDialog(choosePawn, "This card will move you from start. Would you like to move from start?", "Player "+ player.get(0).getPlayer(), JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, pawn, choices, choices[0]);
				if(pawnChosen == 0)
					{
					moveFromStart(player, x);
					}
				else
					{
					choosePawn(player, x);
					}
				}
			else if(x.getFileName().equals("Two.jpg"))
				{
				GameBoard.playerCounter--; 
				String [] choices = {"Move from Start!", "No I will just move foward"}; 
				int pawnChosen = JOptionPane.showOptionDialog(choosePawn, "This card will move you from start. Would you like to move from start?", "Player "+ player.get(0).getPlayer(), JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, pawn, choices, choices[0]);
				if(pawnChosen == 0)
					{
					moveFromStart(player, x);
					}
				else
					{
					choosePawn(player, x);
					}
				GameBoard.canvas.repaint(); 
				}
			else
			{
			for(int i=0; i<4; i++)
				{
				int counterTimes = 0;
				
				if(player.get(i).isStart()==false)
					{
					if(x.getFileName().equals("Three.jpg"))
						{
						choosePawn(player, x);
						break;
						}
					else if(x.getFileName().equals("Four.jpg"))
						{
						moveBackward(4, player); 
						break;
						}
					else if(x.getFileName().equals("Five.jpg"))
						{
						choosePawn(player, x);
						break;
						}
					else if(x.getFileName().equals("Seven.jpg"))
						{
						splitPawns(player, index);
						break;
						}
					else if(x.getFileName().equals("Eight.jpg"))
						{
						choosePawn(player, x);
						break;
						}
					else if(x.getFileName().equals("Ten.jpg"))
						{
						String[] choices = {"Move backward 1", "Move foward ten"}; 
						int pawnChosen = JOptionPane.showOptionDialog(choosePawn, "Which pawn do you want to move? ", "Player "+ player.get(0).getPlayer(), JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, pawn, choices, choices[0]);
						if(pawnChosen == 0)
							{
							moveBackward(1, player);
							}
						else
							{
							choosePawn(player, x);
							}
						break;
						}
					else if(x.getFileName().equals("Eleven.jpg"))
						{
						Object[] stuff = {1,2,3,4,"None, move forward 11"};  
						int playerChosen = JOptionPane.showOptionDialog(choosePawn, "Which player would you like to switch pawns with?", "Player "+ player.get(0).getPlayer(), JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, pawn, stuff, stuff[0]);
						switch(playerChosen)
							{
							case 0: 
								{
								switchSpots(player, allPlayers.get(0)); 
								break;
								}
							case 1:
								{
								switchSpots(player, allPlayers.get(1));
								break;
								}
							case 2:
								{
								switchSpots(player, allPlayers.get(2)); 
								break;
								}
							case 3: 
								{
								switchSpots(player, allPlayers.get(3)); 
								break;
								}
							case 4:
								{
								choosePawn(player,x); 
								}
							}
						break;
						}
					else if(x.getFileName().equals("Twelve.jpg"))
						{
						choosePawn(player, x);
						break;
						}
					else
						{
						
						} 
					}
				else if(counterTimes==3)
					{
					String [] okay = {"Okay"}; 
					BufferedImage pawnImage = ImageIO.read(new File("pawn.jpg"));
					ImageIcon pawn = new ImageIcon(pawnImage);
					int pawnChosen = JOptionPane.showOptionDialog(choosePawn, "Which pawn do you want to move? ", "Player "+ player.get(0).getPlayer(), JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, pawn, okay, okay[0]);
					}
				else
					{
					counterTimes++;
					}
				}
			}
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
		int pawnChosen = JOptionPane.showOptionDialog(choosePawn, "Which pawn do you want to move? ", "Player "+ x.get(0).getPlayer(), JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, pawn, pawnsArray, pawnsArray[0]);
		GameBoard.spaces.get(x.get(pawnChosen).getLoc()).setOccupied(false);
		GameBoard.spaces.get(x.get(pawnChosen).getLoc()).setPawn(null);
		for(int i=1; i<card.getValue(); i++)
			{
			if((x.get(pawnChosen).getLoc()<(x.get(pawnChosen).getStartSpot() -2)) && ((x.get(pawnChosen).getLoc() + i)  ==( x.get(pawnChosen).getStartSpot() -2)))
				{
				int spotsLeft = Math.abs(card.getValue()-i)-1; 
				if(spotsLeft<5)
					{
					x.get(pawnChosen).setLoc(x.get(pawnChosen).getHomeSpots()[spotsLeft]);
					}
				else
					{
					x.get(pawnChosen).setLoc(x.get(pawnChosen).getHomeSpots()[4]);
					}
				GameBoard.canvas.repaint(); 
				return 0;
				}
			}
		if((x.get(pawnChosen).getLoc() + card.getValue()) >57)
				{
				x.get(pawnChosen).setStart(false);
				x.get(pawnChosen).setLoc(x.get(pawnChosen).getLoc() + card.getValue() -58);
				if(GameBoard.spaces.get(x.get(pawnChosen).getLoc()).isOccupied() == false)
					{
					GameBoard.spaces.get(x.get(pawnChosen).getLoc()).setOccupied(true);
					GameBoard.spaces.get(x.get(pawnChosen).getLoc()).setPawn(x.get(pawnChosen)); 
					}
				else
					{
					GameBoard.spaces.get(x.get(pawnChosen).getLoc()).getPawn().setStart(true);
					GameBoard.spaces.get(x.get(pawnChosen).getLoc()).setPawn(x.get(pawnChosen)); 
					}
				}
		else
				{
				x.get(pawnChosen).setStart(false);
				x.get(pawnChosen).setLoc(x.get(pawnChosen).getLoc() + card.getValue()); 
				if(GameBoard.spaces.get(x.get(pawnChosen).getLoc()).isOccupied() == false)
					{
					GameBoard.spaces.get(x.get(pawnChosen).getLoc()).setOccupied(true);
					GameBoard.spaces.get(x.get(pawnChosen).getLoc()).setPawn(x.get(pawnChosen)); 
					}
				else
					{
					GameBoard.spaces.get(x.get(pawnChosen).getLoc()).getPawn().setStart(true);
					GameBoard.spaces.get(x.get(pawnChosen).getLoc()).setPawn(x.get(pawnChosen)); 
					}
				}
		GameBoard.canvas.repaint(); 
		return pawnChosen;
		}
	 
	public static void moveBackward(int value, ArrayList<Pawn> player) throws IOException
		{
		Object [] pawnsArray = new Object [player.size()];
		for(int i=0; i<4; i++)
			{
			pawnsArray[i] = player.get(i).getpNum();
			}
		BufferedImage pawnImage = ImageIO.read(new File("pawn.jpg"));
		ImageIcon pawn = new ImageIcon(pawnImage);
		int pawnChosen = JOptionPane.showOptionDialog(choosePawn, "Which pawn do you want to move backward " + value + "?", "Player "+ player.get(0).getPlayer(), JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, pawn, pawnsArray, pawnsArray[0]);
		GameBoard.spaces.get(player.get(pawnChosen).getLoc()).setOccupied(false);
		GameBoard.spaces.get(player.get(pawnChosen).getLoc()).setPawn(null);
		if((player.get(pawnChosen).getLoc() - value) < 0)
			{
			player.get(pawnChosen).setStart(false);
			player.get(pawnChosen).setLoc((player.get(pawnChosen).getLoc() - value) + 58); 
			if(GameBoard.spaces.get(player.get(pawnChosen).getLoc()).isOccupied() == false)
					{
					GameBoard.spaces.get(player.get(pawnChosen).getLoc()).setOccupied(true);
					GameBoard.spaces.get(player.get(pawnChosen).getLoc()).setPawn(player.get(pawnChosen)); 
					}
			else
					{
					GameBoard.spaces.get(player.get(pawnChosen).getLoc()).getPawn().setStart(true);
					GameBoard.spaces.get(player.get(pawnChosen).getLoc()).setPawn(player.get(pawnChosen)); 
					}
			}
		else
			{
			player.get(pawnChosen).setLoc(player.get(pawnChosen).getLoc() - value); 
			if(GameBoard.spaces.get(player.get(pawnChosen).getLoc()).isOccupied() == false)
					{
					GameBoard.spaces.get(player.get(pawnChosen).getLoc()).setOccupied(true);
					GameBoard.spaces.get(player.get(pawnChosen).getLoc()).setPawn(player.get(pawnChosen)); 
					}
			else
					{
					GameBoard.spaces.get(player.get(pawnChosen).getLoc()).getPawn().setStart(true);
					GameBoard.spaces.get(player.get(pawnChosen).getLoc()).setPawn(player.get(pawnChosen)); 
					}
			}
		GameBoard.canvas.repaint(); 
		}
	
	public static void moveFromStart(ArrayList<Pawn> x, Card card) throws IOException
		{
		Object [] pawnsArray = new Object [x.size()];
		for(int i=0; i<4; i++)
			{
			pawnsArray[i] = x.get(i).getpNum();
			}
		BufferedImage pawnImage = ImageIO.read(new File("pawn.jpg"));
		ImageIcon pawn = new ImageIcon(pawnImage);
		int pawnChosen = JOptionPane.showOptionDialog(choosePawn, "Which pawn do you want to move? ", "Player "+ x.get(0).getPlayer(), JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, pawn, pawnsArray, pawnsArray[0]);
		x.get(pawnChosen).setStart(false);
		if(GameBoard.spaces.get(x.get(pawnChosen).getStartSpot()).isOccupied() == false)
			{
			x.get(pawnChosen).setLoc(x.get(pawnChosen).getStartSpot());
			GameBoard.spaces.get(x.get(pawnChosen).getStartSpot()).setOccupied(true);
			GameBoard.spaces.get(x.get(pawnChosen).getStartSpot()).setPawn(x.get(pawnChosen)); 
			}
		else
			{
			GameBoard.spaces.get(x.get(pawnChosen).getStartSpot()).getPawn().setStart(true);
			GameBoard.spaces.get(x.get(pawnChosen).getStartSpot()).getPawn().setLoc(GameBoard.spaces.get(x.get(pawnChosen).getStartSpot()).getPawn().getStartSpot());
			GameBoard.spaces.get(x.get(pawnChosen).getLoc()).setPawn(x.get(pawnChosen)); 
			}
		GameBoard.canvas.repaint(); 
		}
	
	public static void sorryMove(ArrayList<Pawn> player, ArrayList<Pawn> pawnToBump)
		{
		Object[] pawnChoices1 = {1,2,3,4, "No Move Possible"};
		int pawnChosen = JOptionPane.showOptionDialog(choosePawn, "Which pawn do you want to bump back to start?", "Player "+ player.get(0).getPlayer(), JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, pawn, pawnChoices1, pawnChoices1[0]);
		if(pawnChosen==4)
			{
			return;
			}
		int location = pawnToBump.get(pawnChosen).getLoc(); 
		int yourPawn = JOptionPane.showOptionDialog(choosePawn, "Which pawn do you want to move from start?", "Player "+ player.get(0).getPlayer(), JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, pawn, pawnChoices, pawnChoices[0]);
		GameBoard.spaces.get(location).setPawn(player.get(yourPawn));
		pawnToBump.get(pawnChosen).setLoc(pawnToBump.get(pawnChosen).getStartSpot());
		pawnToBump.get(pawnChosen).setStart(true);
		player.get(yourPawn).setStart(false);
		player.get(yourPawn).setLoc(location);
		GameBoard.canvas.repaint(); 
		}
	
	public static void splitPawns(ArrayList<Pawn>player, int index) throws IOException
		{
		final int iN = index;
		final ArrayList<Pawn> l = new ArrayList<Pawn>(player); 
		Object [] pawnsArray = new Object [player.size()];
		String [] spots = {"Move 0", "Move 1", " Move 2", "Move 3", "Move 4", "Move 5", "Move 6","Move 7"}; 
		for(int i=0; i<4; i++)
			{
			pawnsArray[i] ="Pawn " + player.get(i).getpNum();
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
		choosePawn.setSize(200,200);
		choosePawn.setLocationRelativeTo(null); 
		choosePawn.setVisible(true);
		button.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent arg0)
					{
					setSplitLocations(choosePawn1.getSelectedIndex(),chooseSpots1.getSelectedIndex(),l,iN);
					setSplitLocations(choosePawn2.getSelectedIndex(),chooseSpots2.getSelectedIndex(),l,iN);
					choosePawn.dispose();
					}
			});
		return;
		}
	
	public static void setSplitLocations(int n,  int y, ArrayList<Pawn> m, int index1)
		{
		
		int location = m.get(n).getLoc();
		m.get(n).setLoc(location+(y-1)); 
		if((m.get(n).getLoc() +y) >57)
			{
			m.get(n).setStart(false);
			m.get(n).setLoc(m.get(n).getLoc() + y -58); 
			}
		else
			{
			m.get(n).setStart(false);
			m.get(n).setLoc(m.get(n).getLoc() +y); 
			}
		allPlayers.set(index1,m);
		GameBoard.canvas.repaint();
		return; 
		}

	public static void switchSpots(ArrayList<Pawn> player, ArrayList<Pawn> pawnToBump)
		{
		Object[] pawnChoices1 = {1,2,3,4, "No Move Possible"};
		int pawnChosen = JOptionPane.showOptionDialog(choosePawn, "Which pawn do you want to switch with?", "Player "+ player.get(0).getPlayer(), JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, pawn, pawnChoices1, pawnChoices1[0]);
		if(pawnChosen==4)
			{
			return;
			}
		int locationofBump = pawnToBump.get(pawnChosen).getLoc(); 
		int yourPawn = JOptionPane.showOptionDialog(choosePawn, "Which pawn of YOURS do you want to switch with?", "Player "+ player.get(0).getPlayer(), JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, pawn, pawnChoices, pawnChoices[0]);
		int locationofP = player.get(yourPawn).getLoc();
		GameBoard.spaces.get(locationofP).setPawn(player.get(yourPawn));
		GameBoard.spaces.get(locationofBump).setPawn(pawnToBump.get(pawnChosen)); 
		player.get(yourPawn).setLoc(locationofBump); 
		pawnToBump.get(pawnChosen).setLoc(locationofP); 
		GameBoard.canvas.repaint();
		}
	}
	
