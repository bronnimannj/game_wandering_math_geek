import java.awt.Graphics;
import java.awt.Image;
/*c'est la classe de la case entree*/

import javax.swing.ImageIcon;


public class Entry extends Objects {


	public Entry(int row, int column, Labyrinth l)
	{
		super(row, column, l);
	}
	
	private Image entree = new ImageIcon(getClass().getResource("Images/Entry.jpg")).getImage( ); 
	
	public void draw(Graphics g) 
	{
		
		int[] coords = labyrinth.convert_logic_to_graph(row, column);
		g.drawImage(entree, coords[1], coords[0], coords[2], coords[3], null);

	}
	
	public Elements enter(Gamer g) {
		g.writeRow(row);
		g.writeColumn(column);
		
		return this;
	}

}
