import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameStartListener implements ActionListener {

	private GameDriver gs;
	
	
	
	public GameStartListener(GameDriver gs) {
		this.gs = gs;
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		System.out.println("yes");
		gs.startGame();
	}
	
	
		
}

