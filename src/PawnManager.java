import java.awt.Color;
import java.util.ArrayList;


public class PawnManager 
	{
	static ArrayList<Pawn> p1Pawns = new ArrayList<Pawn>(); 
	static ArrayList<Pawn> p2Pawns = new ArrayList<Pawn>(); 
	static ArrayList<Pawn> p3Pawns = new ArrayList<Pawn>(); 
	static ArrayList<Pawn> p4Pawns = new ArrayList<Pawn>(); 
	static Color purple = new Color(125, 38, 205); 
	
	public static void makePawns() 
		{
		int [] p1 ={57,58,59,60,61};
		int [] p2 ={62,63,64,65,66}; 
		int [] p3 ={67,68,69,70,71};
		int [] p4 ={72,73,74,75,76};
		
		for(int i=0; i<4; i++)
			{
			p1Pawns.add(new Pawn(1, 0, (i+1), false, new NotSafe(), false, Color.red, 177, 67,4, p1));
			p2Pawns.add(new Pawn(2, 0, (i+1),true, new NotSafe(), false, Color.yellow, 565,180,19,p2));
			p3Pawns.add(new Pawn(3, 0, (i+1),true, new NotSafe(), false, purple,450,565,34,p3));
			p4Pawns.add(new Pawn(4, 0, (i+1),true, new NotSafe(), false, Color.green,70,455,48,p4));
			}

		} 
	
	}
