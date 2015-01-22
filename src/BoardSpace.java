public class BoardSpace implements Safety
	{
	private int spot, xC, yC, height, width;
	
	public BoardSpace(int s, int x, int y, int h, int w)
		{
		spot =s;
		xC = x;
		yC =y; 
		height = h; 
		width = w;
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
