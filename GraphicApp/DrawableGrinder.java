package GraphicApp;

import GameLogic.Grinder;

/**
 * A dar�l� k�p�t megjelen�t� oszt�ly.
 */
public class DrawableGrinder extends Drawable
{
	/**
	 * A k�phez tartoz� dar�l�.
	 */
	private Grinder grinder;
	
	/**
	 * A k�p kirajzol�sa az adott dologra.
	 */
	@Override
	public void Draw()
	{

	}
	
	public Grinder Getgrinder() { return grinder; }
	public void Setgrinder(Grinder g) { grinder = g; }
}