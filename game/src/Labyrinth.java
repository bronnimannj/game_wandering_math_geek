import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Labyrinth extends JPanel {

	private Game game;
	
	private String season;

	private int nbr_rows, nbr_columns;
	private Elements[][] gaming_grill;

	private Gamer gamer;
	private Player player;
	
	private Image empty_fig;

	private int max_counts, count;
	private int final_score;

	public Labyrinth(Game g)	{	
		game = g;
		
		player = game.readPlayer();
	}

	public String readSeason()
	{
		return season;
	}

	public void writeElement(Elements element, int l, int c) {
		gaming_grill[l][c]=element;
	}

	public Elements readElement(int l, int c)
	{
		return gaming_grill[l][c];
	}

	public void load(String s, int l)
	{
		season = s;

		try{
			BufferedReader in=new BufferedReader(
					new InputStreamReader(
							getClass().getResourceAsStream("texts/" + season + "_" + l + ".txt"))); 

			nbr_rows = Integer.parseInt(in.readLine());
			nbr_columns = Integer.parseInt(in.readLine());
			gaming_grill = new Elements[nbr_rows][nbr_columns];
			this.setPreferredSize(new Dimension(nbr_columns * 35, nbr_rows * 35));

			int gamer_row=Integer.parseInt(in.readLine());
			int gamer_col=Integer.parseInt(in.readLine());
			gamer=new Gamer(gamer_row, gamer_col, this);
			//game.writePlayer(game.readPlayer());
			
			player.score_to_zero();

			count = 0;
			if(season == "summer")
			{
				max_counts = Integer.parseInt(in.readLine());
			}
			
			final_score = Integer.parseInt(in.readLine());
			
			empty_fig = new ImageIcon(getClass().getResource("seasons/" + season + ".jpg")).getImage( ); 

			// lecture labyrinth
			String st;
			st = in.readLine();
			for(int i = 0; st != null; i++)
			{
				String[] elements = st.split("\\s+");

				for(int j = 0; j<elements.length; j++) {

					char char_txt = elements[j].charAt(0);
					if( char_txt == 'm')
						gaming_grill[i][j] = new Wall(i, j, this);
					if( char_txt == 'b')
						gaming_grill[i][j] = new Button(i, j, this, elements[j].substring(1), player);		
					if( char_txt == 'f')
						gaming_grill[i][j] = new Arrow(i, j, this, player);
					if( char_txt == 'r')
						gaming_grill[i][j] = new Picking(i, j, this, player);
					if( char_txt == 'e')
						gaming_grill[i][j] = new Exit(i, j, this);
					if(char_txt == '.' && season.equals("fall"))
						gaming_grill[i][j] = new Empty(i, j, this);
				}

				st = in.readLine();
			}

			gaming_grill[gamer_row][gamer_col] = new Entry(gamer_row, gamer_col, this );
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}

	public boolean moving(int dl, int dc)
	{
		boolean result = false;
		if(season.equals("winter"))
		{
			result = this.gliding(dl, dc);
		}
		else if(season.equals("summer"))
		{
			if(count < max_counts)
			{
				if(this.movegeek(dl, dc))
				{
					count = count + 1;
					result = true;
				}
				else
					result = false;
			}
			else
			{
				game.restart();
				result = false;
			}
		}
		else if(season.equals("fall") && 
				movable(1, 0) == false && 
				movable(-1, 0) == false && 
				movable(0, 1) == false && 
				movable(0, -1) == false)
		{
			game.restart();
			result = false;
		}
		else
		{
			result = this.movegeek(dl, dc);
		}
		
		return result;
	}

	public boolean movable(int dl, int dc) {
		int nl=gamer.readRow()+dl;
		int nc=gamer.readColumn()+dc;

		return nl>=0 && nl<nbr_rows && nc>=0 && nc<nbr_columns && (gaming_grill[nl][nc]==null || gaming_grill[nl][nc].entrable());		
	}

	private boolean movegeek(int dl, int dc) {
		int nl=gamer.readRow()+dl;
		int nc=gamer.readColumn()+dc;
		if(nl>=0 && nl<nbr_rows && nc>=0 && nc<nbr_columns ) {
			if(gaming_grill[nl][nc]!=null && gaming_grill[nl][nc].entrable()) {
				gaming_grill[nl][nc]=gaming_grill[nl][nc].enter(gamer);
				return true;
			}
			else if(gaming_grill[nl][nc]==null) {
				gamer.writeRow(nl);
				gamer.writeColumn(nc);
				return true;
			}

			return false;
		}

		return false;	
	}

	private boolean gliding(int dl, int dc)
	{
		int c=0;
		while(this.movegeek(dl, dc)) {
			c++;
		}

		return c>0;

	}
	
	public void end_level()
	{		
		player.writeScoreEnd(final_score);
		player.count();
		game.next_level();
	}

	public int[] convert_logic_to_graph(int row, int column)
	{
		int[] result = new int[4]; 
		/*1st value 0 contains y= row; 
		 * second value cntains x= colonne;
		 * 3rd the height and last, the width*/

		int unite_v, unite_h, unite;

		unite_v = (9 * getHeight() )/ (nbr_rows * 10) ;

		unite_h = (9 * (getWidth()) / (nbr_columns * 10));

		unite = Math.min(unite_v, unite_h);

		result[0] = (getHeight() - (nbr_rows * unite)) / 2 +  row * unite;
		result[1] = (getWidth() - (nbr_columns * unite)) / 2 + column * unite;
		result[2] = unite;
		result[3] = unite;


		return result;
	}

	public void paintComponent(Graphics g)
	{
		// plot the labyrinth
		for(int i= 0; i < nbr_rows; i++)
		{
			for(int j=0; j < nbr_columns; j++)
			{
				if( gaming_grill[i][j] != null)
				{
					gaming_grill[i][j].draw(g);
				}
				else 
				{
					int[] coords = this.convert_logic_to_graph(i, j);
					g.drawImage(empty_fig, coords[1], coords[0], coords[2], coords[3], null);
				}
			}
		}

		// dessine matheux
		if(gamer!=null)
			gamer.draw(g);
	}

}
