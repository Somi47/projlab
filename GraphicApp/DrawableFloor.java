package GraphicApp;

import GameLogic.Floor;

/**
 * A padl� k�p�t megjelen�t� oszt�ly.
 */
public class DrawableFloor extends Drawable
{
	/**
	 * A k�phez tartoz� padl�.
	 */
	private Floor floor;
	
	/**
	 * A k�p kirajzol�sa az adott dologra.
	 */
	@Override
	public void Draw()
	{

	}
	
	public Floor Getfloor() { return floor; }
	public void Setfloor(Floor f) { floor = f; }
}