public class BoardSpace implements Safety
	{
	private int spot, xC, yC, height, width;
	private boolean occupied; 
	private Pawn pawn; 
	
	public BoardSpace(int s, int x, int y, int h, int w, boolean o, Pawn p)
		{
		spot =s;
		xC = x;
		yC =y; 
		height = h; 
		width = w;
		occupied = o; 
		pawn = p; 
		}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	public Pawn getPawn() {
		return pawn;
	}

	public void setPawn(Pawn pawn) {
		this.pawn = pawn;
	}

	public int getSpot() {
		return spot;
	}

	public void setSpot(int spot) {
		this.spot = spot;
	}

	public int getxC() {
		return xC;
	}

	public void setxC(int xC) {
		this.xC = xC;
	}

	public int getyC() {
		return yC;
	}

	public void setyC(int yC) {
		this.yC = yC;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	
	}
