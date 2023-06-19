import java.awt.BorderLayout;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class WanderingGeek extends JFrame {
	private Game game;
	
	public WanderingGeek() {
		super("Wandering geek");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		game = new Game(this);	
		this.getContentPane().add(game, BorderLayout.CENTER);
	}
	
	public void start_game() {
		game.start_game();
	}
	
	public static void main(String args[]) {
		WanderingGeek mav=new WanderingGeek();
		mav.start_game();
	}
}
