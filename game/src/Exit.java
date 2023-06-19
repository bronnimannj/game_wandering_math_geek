import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
 /*c'est la classe de la case sortie*/

public class Exit extends Fixes {

	private Image the_end = new ImageIcon(getClass().getResource("misc/exit.jpg")).getImage( ); 
	
	
	public Exit(int row, int column, Labyrinth l)
	{
		super(row, column, l);
	}

	public void draw(Graphics g) 
	{
		int[] coords = labyrinth.convert_logic_to_graph(row, column);
		g.drawImage(the_end, coords[1], coords[0], coords[2], coords[3], null);
	}
	
	
	public Elements enter(Gamer g) {
		g.writeRow(row);
		g.writeColumn(column);
		
		labyrinth.end_level();
		
		return this;
	}
}
