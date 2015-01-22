import java.awt.Color;


public class Pawn implements Safety
	{
	private int player;
	private int loc; 
	private boolean start; 
	protected Safety protection; 
	private boolean home; 
	private Color color;
	private int xHome; 
	private int yHome; 
	private int startSpot; 
	private int pNum;
	
	public Pawn(int p, int l, int n, boolean s, Safety pr, boolean h, Color c, int xH, int yH, int ss)
		{
		player = p;
		loc = l; 
		start = s;
		protection = pr; 
		home = h;
		color = c; 
		xHome = xH; 
		yHome = yH;
		startSpot=ss;
		pNum = n; 
		}

	public int getpNum() {
		return pNum;
	}

	public void setpNum(int pNum) {
		this.pNum = pNum;
	}

	public int getStartSpot() {
		return startSpot;
	}

	public void setStartSpot(int startSpot) {
		this.startSpot = startSpot;
	}

	public int getxHome() {
		return xHome;
	}

	public void setxHome(int xHome) {
		this.xHome = xHome;
	}

	public int getyHome() {
		return yHome;
	}

	public void setyHome(int yHome) {
		this.yHome = yHome;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getPlayer() {
		return player;
	}

	public void setPlayer(int player) {
		this.player = player;
	}

	public int getLoc() {
		return loc;
	}

	public void setLoc(int loc) {
		this.loc = loc;
	}

	public boolean isStart() {
		return start;
	}

	public void setStart(boolean start) {
		this.start = start;
	}

	public Safety getProtection() {
		return protection;
	}

	public void setProtection(Safety protection) {
		this.protection = protection;
	}

	public boolean isHome() {
		return home;
	}

	public void setHome(boolean home) {
		this.home = home;
	}

	
	}
