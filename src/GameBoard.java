import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.*; 
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
 
public class GameBoard extends Canvas
	{
	static GameBoard canvas = new GameBoard();
	
	public static ArrayList<BoardSpace> spaces = new ArrayList<BoardSpace>(); 
	private static final long	serialVersionUID	= 1L;
	static int u, b, k; 
	static ArrayList<Pawn> p1Pawns = new ArrayList<Pawn>(); 
	static ArrayList<Pawn> p2Pawns = new ArrayList<Pawn>(); 
	static ArrayList<Pawn> p3Pawns = new ArrayList<Pawn>(); 
	static ArrayList<Pawn> p4Pawns = new ArrayList<Pawn>();
	static Color purple = new Color(125, 38, 205); 
	static ArrayList<Pawn> x = new ArrayList<Pawn>();
	static ArrayList<String> cardsArray = new ArrayList<String>(); 
	
	public static void makeBoard()
		{
		
	    JFrame frame = new JFrame();
	    JPanel panel = new JPanel(); 
	    JLabel label = new JLabel(" "); 
	    JButton button = new JButton("Draw Card");
	    
	    frame.setSize(700, 900);
	    frame.setLayout(new BorderLayout());
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    panel.add(label, BorderLayout.NORTH);
	    panel.add(button, BorderLayout.SOUTH);
	    frame.getContentPane().add(panel, BorderLayout.SOUTH);
	    button.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	      canvas.repaint(); 
	      }
	    });
	    frame.getContentPane().add(canvas, BorderLayout.CENTER);
	    frame.setResizable(true);
	    frame.setVisible(true);
		}

	public static int chooseCard()
	{
	int x = (int)(Math.random()*MakeCards.deck.size());
	return x;
	}
	
	public static void acceptPawns(ArrayList<Pawn> one, ArrayList<Pawn> two, ArrayList<Pawn> three, ArrayList<Pawn> four)
		{
		p1Pawns.clear();
		p2Pawns.clear();
		p3Pawns.clear();
		p4Pawns.clear();
		p1Pawns = one; 
		p2Pawns = two; 
		p3Pawns = three; 
		p4Pawns = four;
		}

	public void paint(Graphics graphics) 
	{
	setBackground(Color.black);
	MakeCards.makeCards();
	chooseCard();
		graphics.setColor(Color.black);
		graphics.fillRect(45, 45, 585, 585);
		graphics.setColor(Color.red);
		graphics.fillRect(90, 45, 45, 225); 
		graphics.setColor(Color.green);
		graphics.fillRect(45, 540, 225, 45);
		graphics.setColor(Color.yellow);
		graphics.fillRect(405, 90, 225, 45);
		graphics.setColor(purple);
		graphics.fillRect(540, 405, 45, 225);
		graphics.setColor(Color.red);
		graphics.fillOval(155, 45, 90, 90);
		graphics.setColor(Color.green);
		graphics.fillOval(45, 430, 90, 90);
		graphics.setColor(Color.yellow);
		graphics.fillOval(540, 155, 90, 90);
		graphics.setColor(purple);
		graphics.fillOval(425, 540, 90, 90); 
		for(int j=0; j<15; j++)
    		{
			u=0;
    		switch(j)
        		{
        		case 0: case 2: case 4: case 6: case 8: case 10: case 12: case 14:
	        		{
	        		b = (j*45); 
	        		graphics.setColor(Color.darkGray); 
	        		graphics.fillRect(b, u, 45, 45);
	        		break;
	        		}
        		case 1: case 3: case 5: case 7: case 9: case 11: case 13:
        			{
    				k = (j *45); 
    				graphics.setColor(Color.lightGray); 
	        		graphics.fillRect(k, u, 45, 45);
	        		break;
        			}
        		}
    		}
		for(int j=0; j<15; j++)
			{
			u=630;
			switch(j)
	    		{
	    		case 0: case 2: case 4: case 6: case 8: case 10: case 12: case 14:
	        		{
	        		b = (j*45); 
	        		graphics.setColor(Color.darkGray); 
	        		graphics.fillRect(b, u, 45, 45);
	        		break;
	        		}
	    		case 1: case 3: case 5: case 7: case 9: case 11: case 13:
	    			{
					k = (j *45); 
					graphics.setColor(Color.lightGray); 
	        		graphics.fillRect(k, u, 45, 45);
	        		break;
	    			}
	    		}
			}
		
		for(int j=0; j<14; j++)
			{
			u=0;
			switch(j)
	    		{
	    		case 0: case 2: case 4: case 6: case 8: case 10: case 12: case 14:
	        		{
	        		b = (j*45); 
	        		graphics.setColor(Color.darkGray); 
	        		graphics.fillRect(u, b, 45, 45);
	        		break;
	        		}
	    		case 1: case 3: case 5: case 7: case 9: case 11: case 13:
	    			{
					k = (j *45); 
					graphics.setColor(Color.lightGray); 
	        		graphics.fillRect(u, k, 45, 45);
	        		break;
	    			}
	    		}
			}
		
		for(int j=0; j<14; j++)
			{
			u=630;
			switch(j)
	    		{
	    		case 0: case 2: case 4: case 6: case 8: case 10: case 12: case 14:
	        		{
	        		b = (j*45); 
	        		graphics.setColor(Color.darkGray); 
	        		graphics.fillRect(u, b, 45, 45);
	        		break;
	        		}
	    		case 1: case 3: case 5: case 7: case 9: case 11: case 13:
	    			{
					k = (j *45); 
					graphics.setColor(Color.lightGray); 
	        		graphics.fillRect(u, k, 45, 45);
	        		break;
	    			}
	    		}
			}
		
		for(int i=0; i<4; i++)
			{
			if(i==0)
				{
				x.clear();
				 x = (p1Pawns);
				}
			else if(i==1)
				{
				x.clear();
				 x = (p2Pawns);
				}
			else if(i==2)
				{
				x.clear();
				 x = (p3Pawns);
				}
			else if(i==3)
				{
				x.clear();
				 x = (p4Pawns);
				}
//			for(int z=0; z<4; z++)
//				{
//				Pawn p = x.get(z);
//				if(p.getLoc() >0)
//					{
//					graphics.setColor(p.getColor());
//					graphics.fillOval(spaces.get(p.getLoc()).getxC(), spaces.get(p.getLoc()).getyC(), 45, 45);
//					graphics.setColor(Color.black); 
//					graphics.drawString(String.valueOf(p.getpNum()), spaces.get(p.getLoc()).getxC()+19, spaces.get(p.getLoc()).getyC()+27); 
//					}
//				else
//					{
//					graphics.setColor(Color.blue);
//					graphics.fillOval(p.getxHome(), p.getyHome(), 45, 45);
//					}
//				}
			}
		
		graphics.setColor(Color.black); 
		graphics.drawLine(90,90,135,90);
		graphics.drawLine(90,135,135,135);
		graphics.drawLine(90,180,135,180);
		graphics.drawLine(90,225,135,225);
		
		graphics.drawLine(450,90,450,135);
		graphics.drawLine(495,90,495,135);
		graphics.drawLine(540,90,540,135);
		graphics.drawLine(585,90,585,135);
		
		graphics.drawLine(90,540,90,585);
		graphics.drawLine(135,540,135,585);
		graphics.drawLine(180,540,180,585);
		graphics.drawLine(225,540,225,585);
		
		graphics.drawLine(540,450,585,450);
		graphics.drawLine(540,495,585,495);
		graphics.drawLine(540,540,585,540);
		graphics.drawLine(540,585,585,585);
		
		BufferedImage one = null;
		try {
		    one = ImageIO.read(new File(MakeCards.deck.get(chooseCard()).getFileName()));
		} catch (IOException e) {
		}
		graphics.drawImage(one, 240, 200, 200, 300, null);
		}
	
	public static void makeSpots()

		{
		for(int i=1; i<58; i++)
			{
			spaces.add(new BoardSpace(i, 0, 0, 45, 45));
			}
		
		for(int i=0; i<15; i++)
			{
			spaces.get(i).setxC(i*45); 
			spaces.get(i).setyC(0);
			}
		
		for(int i=15; i<30; i++)
			{
			spaces.get(i).setxC(630); 
			spaces.get(i).setyC((i-15)*45);
			}
		
		for(int i=30; i<44; i++)
			{
			spaces.get(i).setxC(675-((i-29)*45)); 
			spaces.get(i).setyC(630);
			}
		
		for(int i=44; i<57; i++)
			{
			spaces.get(i).setxC(0); 
			spaces.get(i).setyC(675-((i-43)*45));
			}
		}
	}
