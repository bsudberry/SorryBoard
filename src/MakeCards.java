import java.util.ArrayList;

public class MakeCards 
	{
	static ArrayList<Card> deck = new ArrayList<Card>(); 
	
	public static void makeCards()
		{
		for(int i=0; i<1; i++)
			{
			deck.add(new Card("logo.jpg", 0, false, true, false, false, false, false));
			}
		for(int i=0; i<1; i++)
			{
			deck.add(new Card("SorryCard.jpg", 0, false, true, true, false, false, false));
			}
		for(int i=0; i<1; i++)
			{
			deck.add(new Card("One.jpg", 1, false, true, false, false,false, false));
			}
		for(int i=0; i<1; i++)
			{
			deck.add(new Card("Two.jpg", 2, false, true, false, true, false, false));
			}
		for(int i=0; i<1; i++)
			{
			deck.add(new Card("Three.jpg", 3, false, false, false, false, false, false));
			}
		for(int i=0; i<1; i++)
			{
			deck.add(new Card("Four.jpg", 4, false, false, false, false, true, false ));
			}
		for(int i=0; i<1; i++)
			{
			deck.add(new Card("Five.jpg", 5, false, false, false , false, false, false));
			}
		for(int i=0; i<1; i++)
			{
			deck.add(new Card("Seven.jpg", 7, true, false, false , false, false, false ));
			}
		for(int i=0; i<1; i++)
			{
			deck.add(new Card("Eight.jpg", 8, false, false, false , false, false, false));
			}
		for(int i=0; i<1; i++)
			{
			deck.add(new Card("Ten.jpg", 10, false, false, false , false, true, false));
			}
		for(int i=0; i<1; i++)
			{
			deck.add(new Card("Eleven.jpg", 11, false, false, false , false, false, true));
			}
		for(int i=0; i<1; i++)
			{
			deck.add(new Card("Twelve.jpg", 5, false, false, false , false, false, false));
			}
		}
	}
