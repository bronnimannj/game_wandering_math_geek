import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;
/*c'est la classe des objets que l'on ramasse en automne*/

public class Picking extends Objects {

	private int type;
	private Image objet;
	private Player player;
	
	
	public Picking(int row, int column, Labyrinth l, Player p)
	{
		super(row, column, l );
		
		player = p;
		
		this.choices();	
	}

	private void choices()
	{
		Random r = new Random();
		type = r.nextInt() % 2;
	
		if (type == 0)
		{
			objet = new ImageIcon(getClass().getResource("misc/calculator.jpg")).getImage( ); 
		}
		else
		{
			objet = new ImageIcon(getClass().getResource("misc/compas.jpg")).getImage( ); 
		}
	}

	public void draw(Graphics g)
	{
		int[] coords = labyrinth.convert_logic_to_graph(row, column);

		g.drawImage(objet, coords[1], coords[0], coords[2], coords[3], null);

	}
	
	public Elements enter(Gamer m) {
		m.writeRow(row);
		m.writeColumn(column);	
		
		player.writeScorePicking(100);
		
		
		return new Wall(row, column, labyrinth);
	}
}
