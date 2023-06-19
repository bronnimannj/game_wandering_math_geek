import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;


public class Gamer {

	
	/* character */
	
	protected int row, column;
	
	protected Labyrinth labyrinth;
	
	protected Gamer gamer;

	private Image matheu;
	
	public Gamer(int row1, int column1, Labyrinth l)
	{
		column = column1;
		row = row1;
		labyrinth = l;

	}
	
	public int readRow() {
		return row;
	}
	
	public int readColumn() {
		return column;
	}
	
	public void writeRow(int l) {
		row=l;
	}
	
	public void writeColumn(int c) {
		column=c;
	}
	
	public void writeGamer(Gamer g) {
		gamer=g;
	}
	
	public void draw(Graphics g)
	{
		String season = labyrinth.readSeason();
		
		matheu = new ImageIcon(getClass().getResource("geek/geek_" + season + ".jpg")).getImage( ); 
		
		int[] coords = labyrinth.convert_logic_to_graph(row, column);
		
		g.drawImage(matheu, coords[1], coords[0], coords[2], coords[3], null);		
	}
	
}
