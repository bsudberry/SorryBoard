
public class Card 
	{
	private String fileName;
	private int value;
	private boolean split;
	private boolean moveFromStart;
	private boolean sorry; 
	private boolean drawAgain; 
	private boolean backward; 
	private boolean switchSpots;  
	private boolean isNormal; 
	
	public boolean isNormal()
		{
		return isNormal;
		}
	public void setNormal(boolean isNormal)
		{
		this.isNormal = isNormal;
		}
	public Card(String x, int v, boolean s, boolean mfs, boolean sry, boolean da, boolean b, boolean sS, boolean n)
		{
		fileName = x; 
		value = v; 
		split = s;
		moveFromStart = mfs;
		sorry = sry;
		drawAgain = da; 
		backward = b; 
		switchSpots = sS; 
		isNormal = n; 
		}
	public boolean isDrawAgain() {
		return drawAgain;
	}
	public void setDrawAgain(boolean drawAgain) {
		this.drawAgain = drawAgain;
	}
	public boolean isBackward() {
		return backward;
	}
	public void setBackward(boolean backward) {
		this.backward = backward;
	}
	public boolean isSwitchSpots() {
		return switchSpots;
	}
	public void setSwitchSpots(boolean switchSpots) {
		this.switchSpots = switchSpots;
	}
	public String getFileName() 
		{
		return fileName;
		}
	
	public void setFileName(String fileName) 
		{
		this.fileName = fileName;
		}
	
	public int getValue()
		{
		return value;
		}
	
	public void setValue(int value) 
		{
		this.value = value;
		}
	
	public boolean isSplit() 
		{
		return split;
		}
	
	public void setSplit(boolean split) 
		{
		this.split = split;
		}
	
	public boolean isMoveFromStart() 
		{
		return moveFromStart;
		}
	
	public void setMoveFromStart(boolean moveFromStart) 
		{
		this.moveFromStart = moveFromStart;
		}
	
	public boolean isSorry() 
		{
		return sorry;
		}
	
	public void setSorry(boolean sorry) 
		{
		this.sorry = sorry;
		}
	
	}
