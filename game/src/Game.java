import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Game extends JPanel {
	/*
	 * Elle relie toutes les classes.
	 * Elle aura une longue methode jeu, qui fera appelle aux autres classes.
	 *
	 */

	private WanderingGeek wg;

	private Player player;

	private Labyrinth labyrinth;

	private BestScores ms;

	private String season;
	private int level;


	public Game(WanderingGeek m) {

		wg = m;

		player = new Player(
				JOptionPane.showInputDialog(
						wg,
						"What is your name?", "Name",
						JOptionPane.QUESTION_MESSAGE));

		labyrinth = new Labyrinth(this);
		this.add(labyrinth);

		ms = new BestScores(this, "BestScores.txt");

		/* save the impacts of each key */
		this.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
				switch(e.getKeyCode())
				{
				case KeyEvent.VK_LEFT:
					labyrinth.moving(0, -1);
					repaint();
					break;
				case KeyEvent.VK_UP:
					labyrinth.moving(-1, 0);
					repaint();
					break;
				case KeyEvent.VK_RIGHT:
					labyrinth.moving(0, 1);
					repaint();
					break;
				case KeyEvent.VK_DOWN:
					labyrinth.moving(1, 0);
					repaint();
					break;
				}
			}
		});


	}

	public Player readPlayer() {
		return player;
	}

	public void writePlayer(Player p) {
		player=p;
	}
	
	public WanderingGeek readwg()
	{
		return wg;
	}

	public void start_game()
	{		
		// The method will open a first window with the rules.
		// The second window asks the player its name & gender
		// The thirs window will ask for a season
		
		ImageIcon geek = new ImageIcon(getClass().getResource("misc/light.jpg"));

		JOptionPane.showMessageDialog(
			wg,
			"Game's rules:" + "\n" +
			"You are a Mathematician. A very rare and intelligent breed." + "\n" + 
			"Sadly, your breed is quite fragile and may die of diverse reasons."  + "\n" + 
			"During spring, hunters have trapped your area. You will have to go around them" + "\n" + 
			"During summer, you will die of heat if you are not careful! Be fast to find the exit!" + "\n" + 
			"During fall, you will have to save as much food as possible for the next winter. But be careful, as you won't be able to come back" + "\n" + 
			"During winter, the ground iced over, and you will not be able to stop before you are at the end of the line" + "\n" + 
			"\n" + 
			"Good luck, and be the Math Force be with you",
			"Rules", 
			JOptionPane.INFORMATION_MESSAGE, geek );

		season="spring";
		level = 1;


		labyrinth.load(season, level);

		wg.setVisible(false);
		wg.pack();
		this.requestFocusInWindow();
		wg.setVisible(true);
	}

	public void next_level()
	{
		// when you're at the last level
		if( season.equals("winter") && level == 3)
		{
			JOptionPane.showMessageDialog(wg,
					"Congratulations you finished the game!",
					"Congrats", JOptionPane.INFORMATION_MESSAGE);

		}
		else
		{
			JOptionPane.showMessageDialog(wg,
					"Yay you finished this season! To the next!",
					"Congrats", JOptionPane.INFORMATION_MESSAGE);
		}


		if(season.equals("spring")) {
			season="summer";
			labyrinth.load(season, level);
		}
		else if(season.equals("summer")) {
			season="fall";
			labyrinth.load(season, level);
		}
		else if(season.equals("fall")) {
			season="winter";
			labyrinth.load(season, level);
		}
		else if(season.equals("winter") && level<3) {
			season="spring";
			level++;
			labyrinth.load(season, level);
		}
		else
			this.end_game();

		wg.setVisible(false);
		wg.pack();
		this.requestFocusInWindow();
		wg.setVisible(true);
	}
	
	public void restart()
	{
		ImageIcon dead;	
		if(season.equals("summer"))
		{
			dead  = new ImageIcon(getClass().getResource("misc/sunburn.jpg"));
		}
		else
		{
			dead = new ImageIcon(getClass().getResource("misc/hurt.jpg"));
		}

		JOptionPane.showMessageDialog(wg,
				"Never abandon, restart!",
				"Restart??", JOptionPane.INFORMATION_MESSAGE, dead);
		
		player.writeScore(-500);
		labyrinth.load(season, level);

		wg.setVisible(false);
		wg.pack();
		this.requestFocusInWindow();
		wg.setVisible(true);
	}

	public void end_game()
	{
		ImageIcon end = new ImageIcon(getClass().getResource("misc/end.jpg"));

		wg.setVisible(false);

		JOptionPane.showMessageDialog(
			wg, ("\n" + "Your picking score is :" + player.readScorePicking() +
				"\n" + "Your trap score is : " + player.readScoreTrap() +
				"\n" + "Your level score is : " + player.readScoreEnd() +
				"\n" + "Your total score is : " + player.readScore() + "\n" +
		"\n" ), "Scores", JOptionPane.INFORMATION_MESSAGE, end);

		ms.update(player.readName(), player.readScore());
		ms.save("BestScores.txt");
		ms.show();

		System.exit(0);	
	}
}
