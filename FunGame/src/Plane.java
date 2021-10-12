import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Plane extends Collidable {
	private int xPos;
	private int yPos;
	public static int length = 300;
	public static int height = 10;
	public static Color PLANE_COLOR = Color.green;
	
	public Plane(int x, int y) {
		super(x, y, length, height);
	}
	
	public void drawOn(Graphics2D g2) {
		g2.translate(getX(), getY());
		
		g2.setColor(PLANE_COLOR);
		g2.fill(new Rectangle2D.Double(0, 0, length, height));
		
		g2.translate(-getX(), -getY());
		
		
	}
	
}
