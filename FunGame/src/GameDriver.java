import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameDriver {
	
private JFrame frame;
private JButton start;
private GameComponent game;
private JLabel help, life, score;
	
	public GameDriver() {
		frameCreator();
	}
	
	public void frameCreator() {
		this.frame = new JFrame();
		this.frame.setSize(new Dimension(1000, 800));
		this.frame.getContentPane().setBackground(Color.white);
		
		//start.setPreferredSize(new Dimension(200,100));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setVisible(true);
		
	}

	
	public void showStartPage() {
		this.frame.setLayout(null);
		start = new JButton("start game");
		start.setBounds(frame.getWidth()/2-100,frame.getHeight()/2-50,200,100);
		
		start.addActionListener(new GameStartListener(this));
		frame.add(start);
	}
	
	public void startGame() {
		frame.getContentPane().removeAll();
		//frame.revalidate();
		frame.repaint();
		
		frame.setLayout(new BorderLayout());
		
		GameComponent game = new GameComponent();
		
		JLabel help = new JLabel("Use W A D to move and L to shoot");
		//help.setPreferredSize(new Dimension(200, 25));
		JLabel life = new JLabel("Life: " + game.getHero(0).getLife());
		//life.setPreferredSize(new Dimension(50, 25));
		JLabel score = new JLabel("Score: 0");
		
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(help, BorderLayout.EAST);
		panel.add(life, BorderLayout.CENTER);
		
		panel.setBackground(Color.cyan);
		panel.setPreferredSize(new Dimension(50, 25));
		
		frame.add(game);
		frame.add(panel, BorderLayout.NORTH);
		frame.add(score, BorderLayout.PAGE_END);
		
		
		
		//important line!
		game.setFocusable(true);
		game.requestFocus();
		
		game.addKeyListener(new MovementListener(game));
		
		Timer timer = new Timer();
		Timer alienDirChanger = new Timer();
		
		frame.revalidate();
		
		timer.schedule(new TimerTask() {
			
			public void run() {
				game.updateAlienPos();
				game.updateBullets();
				game.updateAlienKill();
				game.updateHeroLife();
				game.repaint();
				life.setText("Life: " + game.getHero(0).getLife());
				score.setText("Score: " + game.getScore());			
			}
			
			
				
		}, 0, 10);
		
		alienDirChanger.schedule(new TimerTask() {
			
			public void run() {
				game.randomizeAlienDir();
			}
			
		}, 0, 1000);
		
	
	}
}
	
	
