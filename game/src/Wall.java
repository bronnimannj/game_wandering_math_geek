import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;


public class Wall extends Fixes {
	
	private Image wall = new ImageIcon(getClass().getResource("misc/wall.jpg")).getImage( ); 
	
	public Wall(int r, int c, Labyrinth l)
	{
		super(r, c, l);
	}
	
	public void draw(Graphics g)
	{
		int[] coords = labyrinth.convert_logic_to_graph(row, column);
		
		g.drawImage(wall, coords[1], coords[0], coords[2], coords[3], null);
				
	}
	
	public boolean entrable() {
		return false;
	}
}
