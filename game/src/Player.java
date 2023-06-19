
public class Player {

	/*
	 * Il aura plusieurs champs: nom, prenom, sexe.
	 * la classe se liée au scores, car celui-ci sera comptabilisé pour ce joueur.
	 * la classe sera liée au matheux car il dépendra du sexe.
	 */

	private String firstname;
	
	private int total_score;
	private int end_level_score, picking_score, trap_score;

	public Player(String prenom1)
	{
		firstname = prenom1;		
		total_score=0;
	}

	public String readName()
	{
		return firstname;
	}

	public void writeName(String prenom1)
	{
		firstname = prenom1;

	}
	
	public void score_to_zero()
	{
		end_level_score = 0;
		trap_score = 0;
		end_level_score = 0;
	}
	
	public int count()
	{
		total_score += end_level_score + end_level_score +trap_score;
		return total_score;
	}
	
	public int readScore() {
		return total_score;
	}
	
	public void writeScore(int n) {
		total_score = total_score + n;
	}

	public void writeScoreEnd(int n)
	{
		end_level_score = end_level_score + n;
	}
	
	public int readScoreEnd()
	{
		return end_level_score;
	}

	public void writeScorePicking(int n)
	{
		picking_score = picking_score + n;
	}
	
	public int readScorePicking()
	{
		return picking_score;
	}

	public void writeScoreTrap(int n)
	{
		trap_score = trap_score + n;
	}
	
	public int readScoreTrap()
	{
		return trap_score;
	}
	
	


}
