import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;
 /* c'est la classe qui permet de poser les fleches sur le labyrinthe et qu'elles puissent envoyer
  *  aleatoirement le matheux dans l'une ou l'autre des directions */

public class Arrow extends Traps {

	private Image arrow = new ImageIcon(getClass().getResource("misc/roundabout.jpg")).getImage( ); 
	
	private Player player;
	
	private Random r = new Random();

	public Arrow(int row, int column, Labyrinth l, Player j)
	{
		super(row, column, l );
		player = j;
	}

	public void draw(Graphics g)
	{
		int[] coords = labyrinth.convert_logic_to_graph(row, column);

		g.drawImage(arrow, coords[1], coords[0], coords[2], coords[3], null);		
	}
/*verifie si le matheux peut etre envoye dans la direction*/
	public Elements enter(Gamer m) {
		int arriveRow= m.readRow()- row;
		int arriveColumn =m.readColumn()- column;
		
		m.writeRow(row);
		m.writeColumn(column);
		
		int nbdirections=0;
		int[][] directions=new int[3][2];
		if((arriveRow!=-1 || arriveColumn!=0) && labyrinth.movable(-1, 0)) {
			directions[nbdirections][0]=-1;
			directions[nbdirections][1]=0;
			nbdirections++;
		}
		if((arriveRow!=0 || arriveColumn!=1) && labyrinth.movable(0, 1)) {
			directions[nbdirections][0]=0;
			directions[nbdirections][1]=1;
			nbdirections++;
		}
		if((arriveRow!=1 || arriveColumn!=0) && labyrinth.movable(1, 0)) {
			directions[nbdirections][0]=1;
			directions[nbdirections][1]=0;
			nbdirections++;
		}
		if((arriveRow!=0 || arriveColumn!=-1) && labyrinth.movable(0, -1)) {
			directions[nbdirections][0]=0;
			directions[nbdirections][1]=-1;
			nbdirections++;
		}
		
		int dir = r.nextInt(nbdirections);
		labyrinth.moving(directions[dir][0], directions[dir][1]);

		player.writeScoreTrap(50);
		
		return this;
		
	}
}
