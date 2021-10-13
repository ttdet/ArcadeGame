import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.awt.geom.Line2D.Double;
import java.io.FileInputStream;
import java.io.IOException;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import java.util.Timer;
import java.util.TimerTask;

public class GameComponent extends JComponent {
	
	private ArrayList<Guy> hero = new ArrayList<Guy>();
	private ArrayList<Alien> aliens = new ArrayList<Alien>();
	private ArrayList<Plane> planes = new ArrayList<Plane>();
	private ArrayList<Bullet> heroBullets = new ArrayList<Bullet>();
	private int score;
	//private Timer timer;
	
	public GameComponent() {
		hero.add(new Guy());
		aliens.add(new Alien(300,300));
		aliens.add(new Alien(300,400));
		aliens.add(new Alien(300,500));
		aliens.add(new Alien(300,600));
		aliens.add(new Alien(400,400));
		aliens.add(new Alien(400,500));
		aliens.add(new Alien(400,600));
		aliens.add(new Alien(500,500));
		aliens.add(new Alien(500,600));
		planes.add(new Plane(100, 300));
		planes.add(new Plane(300, 500));
		this.score = 0;
	}
	
	
	
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		try {
			Image image = ImageIO.read(new FileInputStream("C:\\Users\\localmgr\\eclipse-workspace\\FunGame\\bg.png"));
			g2.drawImage(image, 0, 0, null);
			
		} catch (IOException e) {
			System.out.println("io error");
		}
		
		this.drawGuy(g2);
		this.drawAliens(g2);
		this.drawPlanes(g2);
		this.drawHeroBullets(g2);
		
		
	}
	
	public void drawGuy(Graphics2D g2) {
		for (int i = 0; i < hero.size(); i++)
			hero.get(i).drawOn(g2);
	}
	
	public void drawAliens(Graphics2D g2) {
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).drawOn(g2);
		}
			
		
	}
	
	public boolean ifCollide(Collidable a, Collidable b) {
		for (int x = a.getX(); x < a.getX() + a.getLength(); x++) {
			if (x >= b.getX() && x <= b.getX() + b.getLength()) {
				for (int y = a.getY(); y < a.getY() + a.getHeight(); y++) {
					if (y >= b.getY() && y <= b.getY() + b.getHeight()) {
							return true;
					}
				}
				return false;
			}
			
		}
		return false;
	}
	
	public void drawPlanes(Graphics2D g2) {
		for (int i = 0; i < planes.size(); i++) {
			planes.get(i).drawOn(g2);
		}
	}
	
	public void drawHeroBullets(Graphics2D g2) {
		for (int i = 0; i < heroBullets.size(); i++) {
			heroBullets.get(i).drawOn(g2);
		}
	}
	
	public void randomizeAlienDir() {
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).randomizeDir();
		}
	}
	
	public void updateAlienPos() {
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).moveOnDir();
		}
	}
	
	public int getScore() {
		return this.score;
	}
	
	
	public void updateBullets() {
		for (int i = 0; i < heroBullets.size(); i++) {
			if(heroBullets.get(i).getFacing() == 1) {
				heroBullets.get(i).flyRight();
			} else {
				heroBullets.get(i).flyLeft();
			}
		}
	}
	
	public void updateAlienKill() {
		for (int i = 0; i < heroBullets.size(); i++) {
			Bullet bullet = heroBullets.get(i); 
			for (int j = 0; j < aliens.size();) {
				if (ifCollide(bullet, aliens.get(j))) {
					aliens.remove(j);
					this.score += 10;
				} else {
					j++;
				}
			}
		}
	}
	
	public void updateHeroLife() {
		for (int i = 0; i < hero.size(); i++) {
			Guy h = hero.get(i);
			for (int j = 0; j < aliens.size(); j++) {
				if (ifCollide(h, aliens.get(j))) {
					h.die();
				}
			}
		}
	}
	
	
	
	public ArrayList<Plane> getPlanes() {
		return this.planes;
	}
	
	public ArrayList<Bullet> getHeroBullets() {
		return this.heroBullets;
	}
	
	public Guy getHero(int i) {
		return hero.get(i);
	}
	 
}
