package GraphicApp;

import GameLogic.Wall;

/**
 * A fal k�p�t megjelen�t� oszt�ly.
 */
public class DrawableWall extends Drawable
{
	/**
	 * A k�phez tartoz� fal.
	 */
	private Wall wall;
	
	/**
	 * A k�p kirajzol�sa az adott dologra.
	 */
	@Override
	public void Draw()
	{

	}
	
	public Wall Getwall() { return wall; }
	public void Setwall(Wall w) { wall = w; }
}