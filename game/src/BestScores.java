import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Vector;

import javax.swing.JOptionPane;


public class BestScores 
{
	private Game game;

	private Vector<Score> list = new Vector<Score>();

	public BestScores(Game g, String s)
	{
		game = g;

		this.charge(s);
	}

	public void charge(String fileName) 
	{
		try {
			BufferedReader in = new BufferedReader(new FileReader(fileName));

			String line;
			while((line=in.readLine())!=null)
			{
				list.add(new Score(line));
			}
			
			in.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}

	public void save(String fileName)
	{
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName));

			for(Score s: list) {
				out.write(s.toString());
				out.write("\n");
			}
			
			out.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}

	public void update(String nom, Integer score)
	{
		//Look at the scores to put it at the correct place
		for(int i = 0; i < list.size(); i++)
		{
			if(list.elementAt(i).readScore() <= score)
			{
				list.add(i, new Score(nom, score));
				break;
			}
		}
		
		list.setSize(5);
	}
	
	public void show() {
		JOptionPane.showMessageDialog(game.readwg(), "The best wandering mathematicians are: "
				+ "\n" + " In first place:   " + list.elementAt(0).readName() + ", with a score of " + list.elementAt(0).readScore() + " points."
				+ "\n" + " In second place:   " + list.elementAt(1).readName() + ", with a score of " + list.elementAt(1).readScore() + " points."
				+ "\n" + " In third place:   " + list.elementAt(2).readName() + ", with a score of " + list.elementAt(2).readScore() + " points."
				+ "\n" + " In fourth place:   " + list.elementAt(3).readName() + ", with a score of " + list.elementAt(3).readScore() + " points."
				+ "\n" + " In fifth place:   " + list.elementAt(4).readName() + ", with a score of " + list.elementAt(4).readScore() + " points."
				, "Best Scores", JOptionPane.INFORMATION_MESSAGE);
	}
}

class Score {
	private String name;
	private int score;

	public Score(String s) {

		String[] gamer = s.split(":");
		name = gamer[0];
		score = Integer.parseInt(gamer[1]);

	}

	public Score(String n, int s) {
		name=n;
		score=s;
	}

	public String readName() 
	{
		return name;
	}

	public void writeName(String n)
	{
		name = n;
	}

	public int readScore() 
	{
		return score;
	}

	public void writeScore(int s)
	{
		score = s;
	}

	public String toString() {
		return name + ":" + score;
	}
}
