import java.awt.Color;
import java.util.ArrayList;


public class PawnManager 
	{
	static ArrayList<Pawn> p1Pawns = new ArrayList<Pawn>(); 
	static ArrayList<Pawn> p2Pawns = new ArrayList<Pawn>(); 
	static ArrayList<Pawn> p3Pawns = new ArrayList<Pawn>(); 
	static ArrayList<Pawn> p4Pawns = new ArrayList<Pawn>(); 
	static Color purple = new Color(226, 156, 50); 
	public static void makePawns()
		{
		for(int i=0; i<4; i++)
			{
			p1Pawns.add(new Pawn(1,0, (i+1), true, new NotSafe(), false, Color.red, 177, 67,4));
			p2Pawns.add(new Pawn(2,0, (i+1),true, new NotSafe(), false, Color.yellow, 565,180,19));
			p3Pawns.add(new Pawn(3,0, (i+1),true, new NotSafe(), false, Color.blue,450,565,34));
			p4Pawns.add(new Pawn(4,0, (i+1),true, new NotSafe(), false, Color.green,70,455,48));
			}
		}
	}
