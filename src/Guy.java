import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Guy extends Collidable{
	
	public static int length = 25;
	public static int height = 50;
	public static Color HERO_COLOR = Color.blue;
	private int x = 100;
	private int y = 100;
	private int facing;
	private int life;
	
	public Guy() {
		super(100, 100, length, height);
		this.facing = 1;
		life = 3;
	}
	
	public Guy(int x, int y) {
		super(x, y, length, height);
		this.facing = 1;
		life = 3;
		
	}
	
	public void drawOn(Graphics2D g2) {
		
		ImageIcon img = new ImageIcon("C:\\Users\\localmgr\\eclipse-workspace\\FunGame\\hero.png");
		g2.translate(getX(), getY());
		try {
			Image image = ImageIO.read(new FileInputStream("C:\\Users\\localmgr\\eclipse-workspace\\FunGame\\hero2.png"));
			g2.drawImage(image, 0, 0, Color.cyan, null);
			
		} catch (IOException e) {
			System.out.println("io error");
		}
		
		
		g2.translate(-getX(), -getY());
	}
	
	public void changeFacing(int i) {
		this.facing = i;
	}
	
	public int getFacing() {
		return this.facing;
	}
	
	
	public void moveRight() {
		alterX(getX() + 5);
	}
	
	public void moveLeft() {
		alterX(getX() - 5);
	}
	
	public void moveUp() {
		alterY(getY() - 5);
	}
	
	public void fall() {
		alterY(getY() + 5);
	}
	
	public void die() {
		this.life--;
		this.alterX(50);
		this.alterY(50);
	}
	
	public int getLife() {
		return this.life;
	}
	
	
}
