import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/*c'est la classe pour les cases vides, notamment pour l'automne lorsque la case vide devient mur*/
public class Empty extends Fixes {

	private Image empty = new ImageIcon(getClass().getResource("seasons/fall.jpg")).getImage( ); 
	
	public Empty(int row, int column, Labyrinth l)
	{
		super(row, column, l);
	}

	public void draw(Graphics g) 
	{
		int[] coords = labyrinth.convert_logic_to_graph(row, column);
		g.drawImage(empty, coords[1], coords[0], coords[2], coords[3], null);
	}
	
	public Elements enter(Gamer m) {
		m.writeRow(row);
		m.writeColumn(column);
		return new Wall(row, column, labyrinth);
	}
}
