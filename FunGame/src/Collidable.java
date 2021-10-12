
public abstract class Collidable {
	private int xPos;
	private int yPos;
	private int length;
	private int height;
	
	public Collidable(int x, int y, int length, int height) {
		this.xPos = x;
		this.yPos = y;
		this.length = length;
		this.height = height;
	}
	
	public int getX() {
		return xPos;
		
	}
	
	public int getY() {
		return yPos;
	}
	
	public void alterX(int x) {
		xPos = x;
	}
	
	public void alterY(int y) {
		yPos = y;
	}
	
	public int getLength() {
		return length;
	}
	
	public int getHeight() {
		return height;
	}
}
