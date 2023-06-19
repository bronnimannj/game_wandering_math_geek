/*classe pour poser et utiliser les boutons du labyrinthe au printemps*/

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;


public class Button extends Traps {
	
	private Image button =new ImageIcon(getClass().getResource("misc/button.jpg")).getImage( ); 
	
	private int targetRow;
	private int targetColumn;
	private Player player;
	
	public Button(int row, int column, Labyrinth l, String parameters, Player j)
	{
		super(row, column, l );
		
		player = j;
		
		String[] params=parameters.split(",");
		
		targetRow=Integer.parseInt(params[0]);
		targetColumn=Integer.parseInt(params[1]);
	}
	
	public Elements enter(Gamer m) {
		m.writeRow(targetRow);
		m.writeColumn(targetColumn);
		
		labyrinth.writeElement(null, targetRow, targetColumn);
		
		player.writeScoreTrap(300);
		
		return null;
	}
	
	public void draw(Graphics g)
	{
		int[] coords = labyrinth.convert_logic_to_graph(row, column);
		g.drawImage(button, coords[1], coords[0], coords[2], coords[3], null);		
	}
}
