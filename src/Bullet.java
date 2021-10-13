import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;

public class Bullet extends Collidable {
	public static int length = 100;
	public static int height = 2;
	private int facing;
	
	public Bullet(int x, int y, int i) {
		super(x, y, length, height);
		this.facing = i;
	}
	
	public void drawOn(Graphics2D g2) {
		g2.translate(getX(), getY());
		
		g2.setColor(Color.red);
		Rectangle2D.Double b = new Rectangle2D.Double(0,0,length,height);
		g2.fill(b);
		
		
		g2.translate(-getX(), -getY());
	}
	
	
	public int getFacing() {
		return this.facing;
	}
	
	public void flyRight() {
		alterX(getX() + 8);
	}
	
	public void flyLeft() {
		alterX(getX() - 8);
	}
	
	
	
}
