package GraphicApp;

import GameLogic.Pit;

/**
 * A lyuk k�p�t megjelen�t� oszt�ly.
 */
public class DrawablePit extends Drawable
{
	/**
	 * A k�phez tartoz� lyuk.
	 */
	private Pit pit;
	
	/**
	 * A k�p kirajzol�sa az adott dologra.
	 */
	@Override
	public void Draw()
	{

	}
	
	public Pit Getpit() { return pit; }
	public void Setpit(Pit p) { pit = p; }
}