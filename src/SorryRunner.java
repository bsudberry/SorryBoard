
public class SorryRunner 
	{
	public static boolean gameIsOver = false; 
	public static void main(String[] args) 
		{
		PawnManager.makePawns();
		GameBoard.makeSpots();
		GameBoard.acceptPawns(PawnManager.p1Pawns, PawnManager.p2Pawns, PawnManager.p3Pawns, PawnManager.p4Pawns);
		GameBoard.makeBoard();
	
		}	
	}
