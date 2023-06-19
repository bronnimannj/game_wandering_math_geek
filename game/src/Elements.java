import java.awt.Graphics;


public abstract class Elements {

	/*
	 * C'est une classe qui prend en constructeur une position
	 * Elle sera constituée de fonctions, telles que
	 * entrer_dans_une_case(qui vérifie si le matheux peux aller dnas une case X)
	 * dessiner(Elle dessine un élément quelconque)
	 * Elle devra vérifier que dans chaque case il y a un unique élément
	 *  
	 */
	protected int row, column;
	protected Labyrinth labyrinth;

	public Elements(int r1, int c1, Labyrinth l)
	{	
		column = c1;
		row = r1;
		labyrinth = l;
		
	}
	
	public int readRow() {
		return row;
	}
	
	public int readColumn() {
		return column;
	}
	
	
	
	public boolean entrable() {
		return true;
	}
	
	public Elements enter(Gamer m) {
		m.writeRow(row);
		m.writeColumn(column);
		
		return this;
	}
	
	public abstract void draw(Graphics g);
}
