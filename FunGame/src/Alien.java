import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Alien extends Collidable{
	public static int height = 25;
	public static int length = 10;
	public static Color ALIEN_COLOR = Color.magenta;
	private int moveDir; // 0:Right 1:Left 2:Up 3:Down
	
	
	public Alien(int x, int y) {
		super(x, y, length, height);
		this.moveDir = (new Random().nextInt(4));
		
	}
	
	public int getMoveDir() {
		return this.moveDir;
	}
	
	public void drawOn(Graphics2D g2) {
		g2.translate(getX(), getY());
		
		Rectangle2D.Double a = new Rectangle2D.Double(0,0,length,height);
		g2.setColor(ALIEN_COLOR);
		g2.fill(a);
		
		g2.translate(-getX(), -getY());
	}
	
	public void moveRight() {
		alterX(getX() + 3);
	}
	
	public void moveLeft() {
		alterX(getX() - 3);
	}
	
	public void moveUp() {
		alterY(getY() - 3);
	}
	
	public void fall() {
		alterY(getY() + 3);
	}
	
	public void moveOnDir() {
		switch(this.moveDir) {
		case(0):
			if(this.getX() >= 925) {
				this.randomizeDir();
				break;
			} else {
				this.moveRight(); 
				break;
			}
			
		case(1):
			if(this.getX() <= 10) {
				this.randomizeDir();
				break;
			} else {
				this.moveLeft(); 
				break;
			}
		case(2):
			if(this.getY() <= 30) {
				this.randomizeDir();
				break;
			} else {
				this.moveUp(); 
				break;
			}
		case(3):
			if(this.getY() >= 700) {
				this.randomizeDir();
				break;
			} else {
				this.fall(); 
				break;
			}
		}
	}
	
	public void randomizeDir() {
		int ranD = new Random().nextInt(4);
		while(true) {
			if (this.moveDir != ranD) {
				this.moveDir = ranD;
				break;
			} else {
				ranD = new Random().nextInt(4);
			}
		}
		
	}
	
	

}
