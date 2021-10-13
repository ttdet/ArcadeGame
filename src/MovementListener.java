import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JComponent;
import javax.swing.Timer;

public class MovementListener implements KeyListener {
	
	private GameComponent JC;
	
	private HashSet<Character> commands = new HashSet<Character>();
	
	//private ArrayList<Character> attackCommands = new ArrayList<Character>();
	
	private Timer timer;
	public MovementListener (GameComponent JC) {
		this.JC = JC;
		this.timer =  new Timer(40, new ActionListener() {
			
			 public void actionPerformed(ActionEvent e){
				 if (( commands.isEmpty() || (commands.size() == 1 && commands.contains('l')) ) 
						 && !isOnPlane(JC.getHero(0)) ) {
		        	 JC.getHero(0).fall();
		         }
				 
				 
		         if(commands.contains('d')) {
		        	 JC.getHero(0).moveRight();
		        	 JC.getHero(0).changeFacing(1);
		         } 
		         if(commands.contains('a')) {
		        	 JC.getHero(0).moveLeft();
		        	 JC.getHero(0).changeFacing(-1);
		         } 
		         if(commands.contains('w')) {
		        	 JC.getHero(0).moveUp();
		         } 
				 
				 if(commands.contains('l')) {
					 if (JC.getHero(0).getFacing() == 1) {
						 JC.getHeroBullets().add(new Bullet(JC.getHero(0).getX() + Guy.length + 10,
								 JC.getHero(0).getY() + Guy.height / 2,
								 1));
					 } else {
						 JC.getHeroBullets().add(new Bullet(JC.getHero(0).getX() - Bullet.length - 10, 
								 JC.getHero(0).getY() + Guy.height / 2,
								 -1));
					 }
					 
					 commands.remove('l');
					 
				 }
				
		         
		     }
			
		});
		
		this.timer.start();
	}
	
	public boolean isOnPlane(Guy hero) {
		
		for (int i = 0; i < JC.getPlanes().size(); i++) {
			if (hero.getY() + Guy.height == JC.getPlanes().get(i).getY()
					&& hero.getX() + Guy.length >= JC.getPlanes().get(i).getX()
					&& hero.getX() <= JC.getPlanes().get(i).getX() + Plane.length) {
				return true;
			}
				
		}
		
		return false;
	}

	public void keyTyped(KeyEvent e) {
		if (e.getKeyChar() == 'l') {
			commands.add('l');
		}
		

	}

	@Override
	public void keyPressed(KeyEvent e) {
		//pressed.add(e.getKeyCode());
		 if (e.getKeyChar() == 'w' || 
			 e.getKeyChar() == 'a' || 
			 e.getKeyChar() == 'd') {
			 
			commands.add(e.getKeyChar());
		 }
		

	}

	@Override
	public void keyReleased(KeyEvent e) {
		//pressed.remove(e.getKeyCode());
		if (e.getKeyChar() == 'w' ||
			e.getKeyChar() == 'a' || 
			e.getKeyChar() == 'd') {
			commands.remove(e.getKeyChar());
		}
	}
	
	

}
