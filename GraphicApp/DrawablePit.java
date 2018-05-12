package GraphicApp;

import GameLogic.Pit;

/**
 * A lyuk képét megjelenítõ osztály.
 */
public class DrawablePit extends Drawable
{
	/**
	 * A képhez tartozó lyuk.
	 */
	private Pit pit;
	
	/**
	 * A kép kirajzolása az adott dologra.
	 */
	@Override
	public void Draw()
	{

	}
	
	public Pit Getpit() { return pit; }
	public void Setpit(Pit p) { pit = p; }
}